package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CommentFavoriteDO;

/**
 * Created by donahue on 5/18/16.
 */
public interface ICommentFavoriteManager {
    long save(CommentFavoriteDO commentFavoriteDO)throws XException;
    long countFavoritesByCommentID(Long commentID) throws XException;
}
