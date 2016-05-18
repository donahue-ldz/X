package com.X.dal.mapper;

import com.X.dal.domain.TopicAndCategoryDO;
import org.springframework.stereotype.Repository;

/**
 * Created by donahue on 5/17/16.
 */
@Repository
public interface TopicAndCategoryMapper {
    void save(TopicAndCategoryDO topicAndCategory);

}
