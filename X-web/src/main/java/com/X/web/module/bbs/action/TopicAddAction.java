package com.X.web.module.bbs.action;

import com.X.biz.bbs.manager.ITopicManager;
import com.X.dal.domain.TopicDO;
import com.X.dal.domain.User;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Author zhong.zhou
 * Date 5/15/16
 * Email qnarcup@gmail.com
 */
public class TopicAddAction extends BaseAction {
    @Autowired
    private ITopicManager topicManager;

    public void execute(TurbineRunData rundata,
                        @Param("category") String category,
                        @Param("title") String title,
                        @Param("content") String content) throws Exception {
        TopicDO topicDO = new TopicDO();
        User user = getUser();
        if (user == null) rundata.setRedirectLocation("/form/loginAndRegister.htm");

        topicDO.setUserID(getUser().ID()).setUserRole(getUser().role().SQLValue());
        topicDO.setTitle(title).setContent(content).setGmtCreate(new Date());
        topicManager.save(topicDO, category);
    }
}
