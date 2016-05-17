package com.X.web.module.admin.action;

import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.dal.domain.TopicCategoryDO;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 8:31 PM
 **/
public class TopicCategoryAddAction extends BaseAction {
    @Autowired
    private ITopicCategoryManager topicCategoryManager;

    public void execute(TurbineRunData runData, @Param("categoryNameCn") final String categoryNameCn,
                        @Param("categoryNameEn") final String categoryNameEn,
                        @Param("categoryDesc") final String categoryDesc) throws Exception {

        TopicCategoryDO topicCategory = new TopicCategoryDO();
        topicCategory.setNameCn(categoryNameCn).setNameEn(categoryNameEn);
        topicCategory.setDesc(categoryDesc).setGmtCreate(new Date());
        topicCategoryManager.save(topicCategory);

    }
}
