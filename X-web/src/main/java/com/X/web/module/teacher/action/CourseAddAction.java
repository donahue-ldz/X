package com.X.web.module.teacher.action;

import com.X.biz.common.IImageCourseManager;
import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.ICourseManager;
import com.X.dal.domain.CourseDO;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 9:43 AM
 **/
public class CourseAddAction extends BaseAction {
    @Autowired
    private ICourseManager courseManager;
    @Autowired
    private IImageCourseManager imageCourseManager;



    public void execute(TurbineRunData runData,
                        @Param("course[name]") final String name,
                        @Param("course[description]") final String description,
                        @Param("course[shortDesc]") final String shortDesc,
                        @Param("course[courseCredit]") final int courseCredit,
                        @Param("course[hours]") final int courseHours,
                        @Param("course[categoryIDs]") final String categoryIDs) throws Exception {

        Preconditions.checkArgument(!StringUtils.isEmpty(categoryIDs),"请选择分类");
        FileItem file = runData.getParameters().getFileItem("file");
        if (file == null) throw new RuntimeException("请选择文件...");
        if (file.getSize() == 0) throw new XException("文件大小为0...");
        long picID = imageCourseManager.save(file.get(), request);
        CourseDO course = new CourseDO();
        course.setName(name).setDescription(description).setShortDesc(shortDesc);
        course.setCourseCredit(courseCredit).setCourseHours(courseHours).setPictureID(picID);
        courseManager.save(course);
        List<String > categories= Splitter.on(":").splitToList(categoryIDs);

    }
}
