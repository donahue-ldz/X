package com.X.dal.mapper;

import com.X.dal.domain.TopicCategoryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:30 PM
 **/
@Repository
public interface TopicCategoryMapper {
    /**
     * 查询所有贴子的类别
     *
     * @return List<TopicCategoryDO>
     */
    List<TopicCategoryDO> queryAllTopicCategories();
}
