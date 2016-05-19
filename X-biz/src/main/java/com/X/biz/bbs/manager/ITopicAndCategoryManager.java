package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.TopicAndCategoryDO;
import com.X.dal.domain.TopicCategoryDO;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 8:56 AM
 **/
public interface ITopicAndCategoryManager {
    long save(TopicAndCategoryDO topicAndCategory)throws XException;

}
