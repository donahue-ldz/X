package com.X.web.module.bbs.screen.list;

import com.X.biz.aggregation.TopicAgg;
import com.X.biz.bbs.manager.ITopicRateManager;
import com.X.biz.bbs.vo.TopicDetails;
import com.X.biz.constant.status.RateType;
import com.X.biz.exception.XException;
import com.X.dal.domain.Role;
import com.X.dal.domain.TopicRateDO;
import com.X.dal.domain.User;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 4:39 PM
 **/
public class Topic extends BaseScreen {
    @Autowired
    private TopicAgg topicAgg;
    @Autowired
    private ITopicRateManager topicRateManager;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setTopicDetails(context);
        setView(context);
        logViews();
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
        TopicDetails details = topicAgg.queryTopicDetailsByID(topicID, topicCategory);
        context.put("topicDetails", details);
    }

    private void setView(Context context) throws XException {
        Object o = session.getAttribute("user");
        boolean login = o != null;
        context.put("user", o);
        if (login) {
            User user = getUser();
            long topicID = reqContext.getParameters().getInt("topicID", 0);
            List<TopicRateDO> rateDOs = topicRateManager.queryTopicRatesByUser(topicID, user.ID());
            for (TopicRateDO rateDO : rateDOs) {
                if (rateDO.getRateType().equals(RateType.FAVORITE.SQLValue()))
                    context.put("favorite", true);
                if (rateDO.getRateType().equals(RateType.BOOKMARK.SQLValue()))
                    context.put("bookmark", true);
            }
        }
    }

    private void logViews() throws XException {
        long topicID = reqContext.getParameters().getInt("topicID", 0);
        TopicRateDO rate = new TopicRateDO();
        rate.setTopicID(topicID);
        rate.setRateType(RateType.View.SQLValue());
        rate.setGmtCreate(new Date());
        Object o = session.getAttribute("user");
        if (o != null) {
            User user = getUser();
            rate.setUserRole(user.role().SQLValue());
            rate.setUserID(user.ID());
        } else {
            rate.setUserRole(Role.ANONYMOUS.SQLValue());
            /**
             * -1 是匿名访问
             */
            rate.setUserID(-1);
        }
        topicRateManager.save(rate);
    }

}
