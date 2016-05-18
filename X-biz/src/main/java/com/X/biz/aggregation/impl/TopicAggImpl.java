package com.X.biz.aggregation.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.IAdminDBManager;
import com.X.biz.aggregation.TopicAgg;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.bbs.manager.ITopicFavoriteManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.bbs.vo.TopicDetails;
import com.X.biz.bbs.vo.TopicStat;
import com.X.biz.bbs.vo.TopicVO;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.dal.domain.AdminDO;
import com.X.dal.domain.Role;
import com.X.dal.domain.StudentDO;
import com.X.dal.domain.TopicDO;
import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ITopicFavoriteManager topicFavoriteManager;


    @Override
    public TopicDetails queryTopicDetailsByID(Long topicID) throws XException {
        return null;
    }

    @Override
    public TopicStat queryTopicStat(Long topicID) throws XException {
        long comments = commentManager.countCommentsByTopicID(topicID);
        long favorites = topicFavoriteManager.countFavoritesByTopicID(topicID);
        return new TopicStat().setFavorites(favorites).setComments(comments);
    }

    @Override
    public TopicVO queryTopicVOByTopic(TopicDO topic) throws XException {
        TopicVO topicVO = new TopicVO();
        topicVO.setCreateTime(topic.getGmtCreate());
        topicVO.setId(topic.getId());
        topicVO.setUserID(topic.getUserID());
        topicVO.setTitle(topic.getTitle());
        String userRole = topic.getUserRole();
        Long userID = topic.getUserID();
        if (Role.STUDENT.value().equals(userRole)) {
            StudentDO studentDO = studentDBManager.queryStudentByID(userID);
            topicVO.setUser(studentDO.getStudentName());
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
                List<TopicDO> topicDOs = safeList(topicManager.queryTopicsWithPage(category, pageNO, pageSize));
                List<TopicVO> topicVOs = Lists.newArrayList();
                for (TopicDO topicDO : topicDOs) {
                    TopicVO vo = queryTopicVOByTopic(topicDO);
                    topicVOs.add(vo);
                }
                return topicVOs;
            }

        });
    }
}
