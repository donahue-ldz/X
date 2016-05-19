package com.X.web.module.bbs.screen.list;

import com.X.biz.bbs.manager.ITopicAndCategoryManager;
import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicDO;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 8:45 PM
 **/
public class TopicEdit extends BaseScreen {
    @Autowired
    private ITopicManager topicManager;
    @Autowired
    private ITopicCategoryManager topicCategoryManager;
    @Autowired
    private ITopicAndCategoryManager topicAndCategoryManager;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setTopic(context);
        setAvaiCategories(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setTopic(Context context) throws XException {
        long topicID = reqContext.getParameters().getLong("topicID", 0);
        if (topicID == 0) getRunData().setRedirectLocation("/bbs/");
        TopicDO topicDO = topicManager.queryTopicByID(topicID);
        context.put("topic", topicDO);
    }

    private void setAvaiCategories(Context context) throws XException {
        context.put("avaiCategories", topicCategoryManager.avaiCategories());

    }

}
