package com.X.web.module.student.action;

import com.X.biz.common.IImageAvatarManager;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.biz.student.wrapper.StudentWrapper;
import com.X.dal.domain.StudentDO;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-13 8:52 PM
 **/
public class ImageAvatarUploadAction extends BaseAction {
    @Autowired
    private IImageAvatarManager avatarManager;
    @Autowired
    private IStudentDBManager studentDBManager;


    public void execute(TurbineRunData rundata, Context context) throws Exception {
        FileItem file = rundata.getParameters().getFileItem("file");
        if (file == null) throw new RuntimeException("请选择文件...");
        if (file.getSize() == 0) throw new XException("文件大小为0...");
        long avatarID = avatarManager.save(file.get(), request);
        StudentWrapper studentWrapper = (StudentWrapper) getUser();
        StudentDO studentDO = studentWrapper.getStudent();
        studentDO.setAvatarID(avatarID);
        studentDBManager.updateStudentByID(studentDO.getId(), studentDO);
    }
}
