package com.X.web.module.common.action;

import com.X.biz.common.IImageManager;
import com.X.biz.exception.XException;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-13 8:52 PM
 **/
public class ImageUploadAction extends BaseAction {
    @Autowired
    private IImageManager imageManager;

    public void execute(TurbineRunData rundata, Context context) throws Exception {
        FileItem file = rundata.getParameters().getFileItem("file");
        if(file.getSize()==0) throw new XException("文件大小为0...");
        imageManager.save(file.get(),request);
    }
}
