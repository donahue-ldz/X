package com.X.biz.bbs.manager.impl;

import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicCategoryDO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:38 PM
 **/
@Service("topicCategoryManager")
public class TopicCategoryManager implements ITopicCategoryManager{
    @Override
    public long save(TopicCategoryDO topicCategory) throws XException {
        return 0;
    }


    @Override
    public TopicCategoryDO queryTopicCategoriesByName(String titleEn) throws XException {
        return null;
    }

    @Override
    public List<TopicCategoryDO> queryAllTopicCategories() throws XException {
        return Lists.newArrayList(
                new TopicCategoryDO().setNameEn("hot").setNameCn("热门"),
                new TopicCategoryDO().setNameEn("recent").setNameCn("最近")
        );
    }
}
