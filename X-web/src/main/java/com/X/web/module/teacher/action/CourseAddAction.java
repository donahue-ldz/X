package com.X.web.module.teacher.action;

import com.X.biz.system.Config;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.apache.commons.fileupload.FileItem;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 9:43 AM
 **/
public class CourseAddAction extends BaseAction{
    public void execute(TurbineRunData rundata, Context context, @Param("product[name]") final String name) throws Exception {
        FileItem file = rundata.getParameters().getFileItem("file");
        if(file==null) throw new RuntimeException("请选择文件...");
        String fileName = file.getName();
        String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
        String configDirectory = Config.FILE_UPLOAD_DIRECTORY;
        String directory = request.getSession().getServletContext().getRealPath(configDirectory);
    }
}
