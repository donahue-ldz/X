package com.X.web.module.common.action;

import com.X.biz.common.IFileManager;
import com.X.biz.system.Config;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:06 PM
 **/
public class FileUploadAction extends BaseAction {
    @Autowired
    private IFileManager fileManager;

    public void execute(TurbineRunData rundata, Context context) throws Exception {
        FileItem file = rundata.getParameters().getFileItem("file");
        if(file==null) throw new RuntimeException("请选择文件...");
        String fileName = file.getName();
        String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
        String configDirectory = Config.FILE_UPLOAD_DIRECTORY;
        String directory = request.getSession().getServletContext().getRealPath(configDirectory);
        fileManager.save(file.get(),directory,"test"+"."+fileExt);
    }
}
