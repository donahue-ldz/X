package com.X.web.module.bbs.action;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.common.Void;
import com.X.dal.domain.TopicDO;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Author zhong.zhou
 * Date 5/15/16
 * Email qnarcup@gmail.com
 */
public class BBSAddAction extends BaseAction {
    @Autowired
    private ITopicManager topicManager;

    public void execute(TurbineRunData rundata,
                        @Param("categoryId") Long categoryId,
                        @Param("title") String title,
                        @Param("content") String content) throws Exception {
        final TopicDO topicDO = new TopicDO();
        topicDO.setUserID(getUser().ID())
                .setUserRole(getUser().role().value())
                .setTitle(title)
                .setContent(content)
                .setGmtCreate(new Date());
        RunWrapper.run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                topicManager.save(topicDO);
                return Void.instance;
            }
        });
    }
}
