package com.X.web.module.bbs.screen.list;

import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.constant.PageConstant;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicCategoryDO;
import com.X.dal.domain.TopicDO;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author zhong.zhou
 * Date 5/15/16.
 * Email qnarcup@gmail.com
 */
public class Profile extends BaseScreen {
    @Autowired
    private ITopicCategoryManager topicCategoryManager;
    @Autowired
    private ITopicManager topicManager;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        WebResult result = new WebResult();
        setTopicCategories(context);
        setTopics(context);
        return result;
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setTopicCategories(Context context) throws Exception {
        String tab = reqContext.getParameters().getString("tab");
        List<TopicCategoryDO> allTopicCategories = topicCategoryManager.queryAllTopicCategories();
        if (allTopicCategories.size() > 0) {
            context.put("activeTab", Objects.firstNonNull(tab, allTopicCategories.get(0).getNameEn()));
        }
        context.put("topicCategories", allTopicCategories);

    }

    private void setTopics(Context context) throws Exception {
        String activeTab = context.get("activeTab") == null ? null : (String) context.get("activeTab");
        int pageNO = reqContext.getParameters().getInt("pageNO");
        int pageNum = reqContext.getParameters().getInt("pageNum");
        pageNum = pageNum == 0 ? PageConstant.PAGE_NUM : pageNum;
        List<TopicDO> topics = null;
        if (!Strings.isNullOrEmpty(activeTab)) {
            topics = topicManager.queryTopicsWithPage(activeTab, pageNO, pageNum);
        }
        context.put("topics", Objects.firstNonNull(topics, Lists.newArrayList()));
    }

}
