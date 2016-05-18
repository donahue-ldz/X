package com.X.biz.aggregation;

import com.X.biz.bbs.vo.CommentVO;
import com.X.biz.exception.XException;

import javax.validation.constraints.NotNull;

/**
 * Created by donahue on 5/18/16.
 */
public interface CommentAgg {
    CommentVO queryCommentVOByID(@NotNull Long commentID)throws XException;
}
