package com.X.web.module.bbs.action;

import com.X.biz.bbs.manager.ITopicManager;
import com.X.dal.domain.TopicDO;
import com.X.dal.domain.User;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 8:59 PM
 **/
public class TopicEditAction extends BaseAction {
    @Autowired
    private ITopicManager topicManager;


    public void execute(TurbineRunData rundata,
                        @Param("oldTopicID") long oldTopicID,
                        @Param("category") String category,
                        @Param("title") String title,
                        @Param("content") String content) throws Exception {
        Preconditions.checkArgument(!StringUtils.isEmpty(category), "请选择分类...");
        TopicDO topicDO = new TopicDO();
        User user = getUser();
        if(user==null) rundata.setRedirectLocation("/form/loginAndRegister.htm");
        topicDO.setUserID(getUser().ID()).setUserRole(getUser().role().SQLValue());
        topicDO.setTitle(title).setContent(content).setGmtCreate(new Date());
        topicManager.editTopic(oldTopicID, topicDO, category);
    }
}
