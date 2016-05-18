package com.X.biz.aggregation.impl;

import com.X.biz.admin.manager.IAdminDBManager;
import com.X.biz.aggregation.CommentAgg;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.bbs.vo.CommentVO;
import com.X.biz.common.IPictureManager;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.dal.domain.CommentDO;
import com.X.dal.domain.PictureDO;
import com.X.dal.domain.Role;
import com.X.dal.domain.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 8:47 PM
 **/
public class CommentAggImpl implements CommentAgg {

    @Autowired
    private ICommentManager commentManager;
    @Autowired
    private IStudentDBManager studentDBManager;
    @Autowired
    private IAdminDBManager adminDBManager;
    @Autowired
    private IPictureManager pictureManager;


    @Override
    public CommentVO queryCommentVOByID(@NotNull Long commentID) throws XException {
        CommentVO commentVO = new CommentVO();

        CommentDO commentDO = commentManager.queryCommentByID(commentID);
        Long userID = commentDO.getUserID();
        String userRole = commentDO.getUserRole();
        if (userRole.equals(Role.STUDENT.value())) {
            StudentDO studentDO = studentDBManager.queryStudentByID(userID);
            commentVO.setUser(studentDO.getStudentName());
            PictureDO pictureDO = pictureManager.queryPicturesByID(studentDO.getAvatarID());
            if (pictureDO != null) {
                commentVO.setUserAvatar(pictureDO.getUrl());
            }
            commentVO.setUserID(studentDO.getId());
        }
        return null;
    }
}
