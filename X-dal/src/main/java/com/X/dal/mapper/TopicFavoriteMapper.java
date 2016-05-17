package com.X.dal.mapper;

import com.X.dal.domain.TopicFavoriteDO;
import org.springframework.stereotype.Repository;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 8:44 PM
 **/
@Repository

public interface TopicFavoriteMapper {
    void save(TopicFavoriteDO topicFavorite) ;

}
