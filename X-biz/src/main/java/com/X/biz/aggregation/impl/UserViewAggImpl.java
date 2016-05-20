package com.X.biz.aggregation.impl;

import com.X.biz.RunWrapper;
import com.X.biz.aggregation.UserViewAgg;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.bbs.manager.ITopicRateManager;
import com.X.biz.bbs.vo.UserView;
import com.X.biz.exception.XException;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 10:20 PM
 **/
@Service("userViewAgg")
public class UserViewAggImpl implements UserViewAgg {

    @Autowired
    private ITopicRateManager topicRateManager;
    @Autowired
    private ICommentManager commentManager;
    @Autowired
    private ITopicManager topicManager;


    @Override
    public UserView view(@NotNull final Long userID, @NotEmpty final String userRole) throws XException {

        return RunWrapper.run(new Callable<UserView>() {
            @Override
            public UserView call() throws Exception {

                UserView view = new UserView();
                view.setBookmarks(topicRateManager.countBookmarksByUserID(userID));
                view.setFavorites(topicRateManager.countFavoritesByUserID(userID));
                view.setTopics(topicManager.countTopicsByUser(userID, userRole));
                view.setComments(commentManager.countCommentsByUser(userID, userRole));
                return view;
            }
        });
    }
}
