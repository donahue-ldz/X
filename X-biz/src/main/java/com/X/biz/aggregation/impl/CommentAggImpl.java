package com.X.biz.aggregation.impl;

import com.X.biz.admin.manager.IAdminDBManager;
import com.X.biz.aggregation.CommentAgg;
import com.X.biz.bbs.manager.ICommentFavoriteManager;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.bbs.vo.CommentVO;
import com.X.biz.common.IPictureManager;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.dal.domain.CommentDO;
import com.X.dal.domain.PictureDO;
import com.X.dal.domain.Role;
import com.X.dal.domain.StudentDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 8:47 PM
 **/
@Service("commentAgg")
public class CommentAggImpl implements CommentAgg {

    @Autowired
    private ICommentManager commentManager;
    @Autowired
    private IStudentDBManager studentDBManager;
    @Autowired
    private IAdminDBManager adminDBManager;
    @Autowired
    private IPictureManager pictureManager;
    @Autowired
    private ICommentFavoriteManager commentFavoriteManager;

    private static final Logger log = LoggerFactory.getLogger(CommentAgg.class);

    @Override
    public CommentVO queryCommentVOByID(@NotNull Long commentID) throws XException {
        CommentDO commentDO = commentManager.queryCommentByID(commentID);
        return queryCommentVOByCommentDO(commentDO);
    }

    @Override
    public CommentVO queryCommentVOByCommentDO(@NotNull CommentDO commentDO) throws XException {
        CommentVO commentVO = new CommentVO();
        Long userID = commentDO.getUserID();
        String userRole = commentDO.getUserRole();
        if (userRole.equals(Role.STUDENT.SQLValue())) {
            StudentDO studentDO = studentDBManager.queryStudentByID(userID);
            commentVO.setUser(studentDO.getStudentName());
            PictureDO pictureDO = pictureManager.queryPicturesByID(studentDO.getAvatarID());
            if (pictureDO != null) {
                commentVO.setUserAvatar(pictureDO.getUrl());
            }
            commentVO.setUserID(studentDO.getId());
        } else {
            //简化
            log.error("不支持管理员评价");
        }

        Long favorites = commentFavoriteManager.countFavoritesByCommentID(commentDO.getId());
        commentVO.setId(commentDO.getId());
        commentVO.setContent(commentDO.getContent());
        commentVO.setGmtCreate(commentDO.getGmtCreate());
        commentVO.setFavorites(favorites);

        return commentVO;
    }
}
