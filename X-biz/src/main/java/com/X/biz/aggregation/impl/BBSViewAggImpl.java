package com.X.biz.aggregation.impl;

import com.X.biz.RunWrapper;
import com.X.biz.aggregation.BBSViewAgg;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.bbs.vo.BBSView;
import com.X.biz.exception.XException;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 10:22 PM
 **/
@Service("BBSViewAgg")
public class BBSViewAggImpl implements BBSViewAgg {
    @Autowired
    private ITopicManager topicManager;

    @Autowired
    private ICommentManager commentManager;

    @Override
    public BBSView view() throws XException {

        return RunWrapper.run(new Callable<BBSView>() {
            @Override
            public BBSView call() throws Exception {
                BBSView view = new BBSView();
                view.setTopics(topicManager.countAllTopics());
                /**
                 * 发帖人
                 * 评论人
                 * 点赞
                 * 收藏
                 * 分享
                 */
                Set<Long> members = Sets.newHashSet();
                members.addAll(topicManager.queryUsers());


                view.setMembers(members.size());
                return view;
            }
        });
    }
}
