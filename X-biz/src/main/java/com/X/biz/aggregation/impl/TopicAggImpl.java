package com.X.biz.aggregation.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.IAdminDBManager;
import com.X.biz.aggregation.CommentAgg;
import com.X.biz.aggregation.TopicAgg;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.bbs.manager.ITopicRateManager;
import com.X.biz.bbs.vo.CommentVO;
import com.X.biz.bbs.vo.TopicDetails;
import com.X.biz.bbs.vo.TopicStat;
import com.X.biz.bbs.vo.TopicVO;
import com.X.biz.common.IPictureManager;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.common.cache.LightCache;
import com.X.common.cache.LocalLightCache;
import com.X.dal.domain.*;
import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.Callable;

import static com.X.common.utils.Tool.safeList;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 10:18 AM
 **/
@Service("topicAgg")
public class TopicAggImpl implements TopicAgg {

    @Autowired
    private ITopicManager topicManager;
    @Autowired
    private IStudentDBManager studentDBManager;
    @Autowired
    private IAdminDBManager adminDBManager;

    @Autowired
    private ICommentManager commentManager;
    @Autowired
    private ITopicRateManager topicRateManager;

    @Autowired
    private CommentAgg commentAgg;
    @Autowired
    private IPictureManager pictureManager;

    private List<String> cacheCategories = Lists.newArrayList("hot");
    private LightCache lightCache = LocalLightCache.createDefault("hotCategory");

    @Override
    public TopicDetails queryTopicDetailsByID(@NotNull Long topicID, String topicCategory) throws XException {
        TopicDO topicDO = topicManager.queryTopicByID(topicID);
        if (topicDO == null) throw new XException(String.format("id = %s topic not exist", topicID));
        TopicDetails details = new TopicDetails();
        details.setTopicVO(queryTopicVOByTopic(topicDO, topicCategory));
        details.setContent(topicDO.getContent());
        details.setTitle(topicDO.getTitle());
        List<CommentDO> commentDOs = safeList(commentManager.queryCommentsByTopicID(topicID));
        List<CommentVO> commentVOs = Lists.newArrayList();
        for (CommentDO commentDO : commentDOs) {
            commentVOs.add(commentAgg.queryCommentVOByCommentDO(commentDO));
        }
        details.setComments(commentVOs);
        return details;
    }

    @Override
    public TopicStat queryTopicStat(Long topicID) throws XException {
        long comments = commentManager.countCommentsByTopicID(topicID);
        long favorites = topicRateManager.countFavoritesByTopicID(topicID);
        long views = topicRateManager.countViewsByTopicID(topicID);
        long bookmarks = topicRateManager.countBookmarksByTopicID(topicID);
        return new TopicStat()
                .setFavorites(favorites)
                .setComments(comments)
                .setViews(views)
                .setBookmarks(bookmarks);
    }

    @Override
    public TopicVO queryTopicVOByTopic(TopicDO topic, String topicCategory) throws XException {
        TopicVO topicVO = new TopicVO();
        topicVO.setCreateTime(topic.getGmtCreate());
        topicVO.setId(topic.getId());
        topicVO.setUserID(topic.getUserID());
        topicVO.setTitle(topic.getTitle());
        topicVO.setTopicCategory(topicCategory);
        String userRole = topic.getUserRole();
        Long userID = topic.getUserID();
        if (Role.STUDENT.SQLValue().equals(userRole)) {
            StudentDO studentDO = studentDBManager.queryStudentByID(userID);
            topicVO.setUser(studentDO.getStudentName());
            PictureDO pictureDO = pictureManager.queryPicturesByID(studentDO.getAvatarID());
            if (pictureDO != null)
                topicVO.setUserAvatar(pictureDO.getUrl());
        } else {
            AdminDO adminDO = adminDBManager.queryAdminByID(userID);
            topicVO.setUser(adminDO.getAdminName());
        }
        TopicStat topicStat = queryTopicStat(topic.getId());
        topicVO.setTopicStat(topicStat);


        return topicVO;
    }

    @Override
    public List<TopicVO> queryTopicVOsByCategoryWithPage(@NotEmpty final String category,
                                                         final int pageNO,
                                                         final int pageSize) throws XException {
        return RunWrapper.run(new Callable<List<TopicVO>>() {
            @Override
            public List<TopicVO> call() throws Exception {
                if (cacheCategories.contains(category)) {

                    return lightCache.get("hotCategory", new Callable<List<TopicVO>>() {
                        @Override
                        public List<TopicVO> call() throws Exception {
                            return queryHotTopicVOs();
                        }
                    });
                } else {
                    List<TopicDO> topicDOs = safeList(topicManager.queryTopicsWithPage(category, pageNO, pageSize));
                    List<TopicVO> topicVOs = Lists.newArrayList();
                    for (TopicDO topicDO : topicDOs) {
                        TopicVO vo = queryTopicVOByTopic(topicDO, category);
                        topicVOs.add(vo);
                    }
                    return topicVOs;
                }
            }

        });
    }

    @Override
    public List<TopicVO> queryHotTopicVOs() throws XException {
        List<Long> hotTopicIDs = topicRateManager.topNHotTopicIDs();
        List<TopicDO> topicDOs = Lists.newArrayList();
        for (Long topicID : hotTopicIDs)
            topicDOs.add(topicManager.queryTopicByID(topicID));
        List<TopicVO> topicVOs = Lists.newArrayList();
        for (TopicDO topicDO : topicDOs) {
            TopicVO vo = queryTopicVOByTopic(topicDO, "hot");
            topicVOs.add(vo);
        }
        return topicVOs;
    }
}
