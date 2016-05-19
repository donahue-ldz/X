package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.TopicCategoryDO;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:38 PM
 **/
public interface ITopicCategoryManager {
    long save(TopicCategoryDO topicCategory) throws XException;

    TopicCategoryDO queryTopicCategoryByName(String titleEn) throws XException;

    List<TopicCategoryDO> queryAllTopicCategories() throws XException;

    List<TopicCategoryDO> avaiCategories() throws XException;

}
