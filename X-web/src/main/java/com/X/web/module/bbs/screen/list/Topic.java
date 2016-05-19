package com.X.web.module.bbs.screen.list;

import com.X.biz.aggregation.TopicAgg;
import com.X.biz.bbs.vo.TopicDetails;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 4:39 PM
 **/
public class Topic extends BaseScreen {
    @Autowired
    private TopicAgg topicAgg;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setTopicDetails(context);
        setLogin(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setTopicDetails(Context context) throws XException {
        long topicID = reqContext.getParameters().getInt("topicID", 0);
        String topicCategory = reqContext.getParameters().getString("topicCategory");
        if (topicID == 0 || StringUtils.isEmpty(topicCategory)) getRunData().setRedirectLocation("/bbs/");
        TopicDetails details = topicAgg.queryTopicDetailsByID(topicID,topicCategory);
        context.put("topicDetails", details);
    }
    private void setLogin(Context context) throws XException{
        Object o = session.getAttribute("user");
        context.put("login",o!=null);
    }
}
