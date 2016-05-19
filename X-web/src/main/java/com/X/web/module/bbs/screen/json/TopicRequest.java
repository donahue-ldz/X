package com.X.web.module.bbs.screen.json;

import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.bbs.manager.ITopicRateManager;
import com.X.dal.domain.CommentDO;
import com.X.dal.domain.TopicRateDO;
import com.X.dal.domain.User;
import com.X.web.common.BaseAction;
import com.X.web.common.ErrorCode;
import com.X.web.common.WebJsonResult;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 11:20 PM
 **/
public class TopicRequest extends BaseAction {
    @Autowired
    private ICommentManager commentManager;
    @Autowired
    private ITopicRateManager topicFavoriteManager;

    public WebJsonResult doAddComment(@Param("topicID") final Long topicID,
                                           @Param("content") final String content) {
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                WebJsonResult result = new WebJsonResult();
                Preconditions.checkArgument(!StringUtils.isEmpty(content), "评论内容不能为空...");
                User user = getUser();
                if(user==null)  return result.setErrorCode(ErrorCode.NO_SIGIN);
                CommentDO comment = new CommentDO();
                comment.setContent(content);
                comment.setTopicID(topicID);
                comment.setGmtCreate(new Date());
                comment.setUserID(user.ID());
                comment.setUserRole(user.role().SQLValue());
                commentManager.save(comment);
                return result;
            }
        });
    }
    public WebJsonResult doFavorite(@Param("topicID") final Long topicID) {
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                WebJsonResult result = new WebJsonResult();
                User user = getUser();
                if(user==null)  return result.setErrorCode(ErrorCode.NO_SIGIN);
                TopicRateDO topicFavoriteDO = new TopicRateDO();
                topicFavoriteDO.setTopicID(topicID);
                topicFavoriteDO.setUserID(user.ID());
                topicFavoriteDO.setGmtCreate(new Date());
                topicFavoriteDO.setUserRole(user.role().SQLValue());
                topicFavoriteManager.save(topicFavoriteDO);
                return result;
            }
        });
    }

}
