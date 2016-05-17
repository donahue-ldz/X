package com.X.web.module.admin.screen.json;

import com.X.biz.teacher.manager.ICourseCategoryManager;
import com.X.biz.teacher.vo.CourseCategoryVO;
import com.X.dal.domain.CourseCategoryDO;
import com.X.web.common.BaseAction;
import com.X.web.common.WebJsonResult;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-13 11:30 PM
 **/
public class CourseCategoryRequest extends BaseAction {
    @Autowired
    private ICourseCategoryManager courseCategoryManager;

    public WebJsonResult doQueryAllCourseCategories(){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                WebJsonResult result = new WebJsonResult();
                return result.setObjList(courseCategoryManager.queryAllCourseCategories());
            }
        });
    }

    /**
     * 用于同步的ZTree渲染
     * @return
     */
    public WebJsonResult doQueryAllCourseCategoryVOs(){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                WebJsonResult result = new WebJsonResult();
                List<CourseCategoryDO> courseCategories = courseCategoryManager.queryAllCourseCategories();
                List<CourseCategoryVO> vos = Lists.newArrayList();
                for(CourseCategoryDO courseCategoryDO:courseCategories){
                    vos.add(CourseCategoryVO.DO2VO(courseCategoryDO));
                }

                return result.setObjList(vos);
            }
        });
    }

    public WebJsonResult doAddCourseCategory(@Param("name") final String name,
                                             @Param("parentID") final long parentID,
                                             @Param("desc")final String desc){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                 courseCategoryManager.save(name,parentID,desc);
                return new WebJsonResult();
            }
        });
    }
}
