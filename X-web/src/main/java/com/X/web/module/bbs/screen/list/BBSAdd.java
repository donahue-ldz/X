package com.X.web.module.bbs.screen.list;

import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicCategoryDO;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;
import java.util.List;

import static com.X.common.utils.Tool.safeList;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 9:09 PM
 **/
public class BBSAdd extends BaseScreen {
    @Autowired
    private ITopicCategoryManager topicCategoryManager;

    public static List<String> AGG_CATEGORIES = Lists.newArrayList(
            "hot",
            "recently"
    );

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setAvaiCategories(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setAvaiCategories(Context context) throws XException {
        List<TopicCategoryDO> topicCategoryDOs = safeList(topicCategoryManager.queryAllTopicCategories());
        List<TopicCategoryDO> avaiCategories = Lists.newArrayList(Iterables.filter(topicCategoryDOs, new Predicate<TopicCategoryDO>() {
            @Override
            public boolean apply(@Nullable TopicCategoryDO topicCategoryDO) {
                return !AGG_CATEGORIES.contains(topicCategoryDO.getNameEn());
            }
        }));
        context.put("avaiCategories", avaiCategories);
    }
}
