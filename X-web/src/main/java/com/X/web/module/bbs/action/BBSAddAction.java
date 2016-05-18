package com.X.web.module.bbs.action;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.common.Void;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicCategoryDO;
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
    @Autowired
    private ITopicCategoryManager topicCategoryManager;


    public void execute(TurbineRunData rundata,
                        @Param("category") String category,
                        @Param("title") String title,
                        @Param("content") String content) throws Exception {


        TopicCategoryDO topicCategory = topicCategoryManager.queryTopicCategoryByName(category);

        if (topicCategory == null) throw new XException("分类不存在...");
        TopicDO topicDO = new TopicDO();
        topicDO.setUserID(getUser().ID()).setUserRole(getUser().role().value());
        topicDO.setTitle(title).setContent(content).setGmtCreate(new Date());
        topicManager.save(topicDO);
    }
}
