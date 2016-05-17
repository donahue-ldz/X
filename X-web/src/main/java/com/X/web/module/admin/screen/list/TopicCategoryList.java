package com.X.web.module.admin.screen.list;

import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 8:22 PM
 **/
public class TopicCategoryList extends BaseScreen {
    @Autowired
    private ITopicCategoryManager topicCategoryManager;
    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        return null;
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }
    private void setTopicCategories(Context context) throws XException{
        context.put("topicCategories",topicCategoryManager.queryAllTopicCategories());
    }
}
