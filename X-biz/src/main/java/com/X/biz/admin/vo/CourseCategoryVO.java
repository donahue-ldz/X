package com.X.biz.admin.vo;

import com.X.dal.domain.CourseCategoryDO;
import com.google.common.base.Preconditions;

/**
 * 用于Ztree 展示
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 9:21 AM
 **/
public class CourseCategoryVO {
    private long id;
    private long pId;
    private String name;

    public long getId() {
        return id;
    }

    public CourseCategoryVO setId(long id) {
        this.id = id;
        return this;
    }

    public long getpId() {
        return pId;
    }

    public CourseCategoryVO setpId(long pId) {
        this.pId = pId;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseCategoryVO setName(String name) {
        this.name = name;
        return this;
    }

    public static CourseCategoryVO DO2VO(CourseCategoryDO courseCategoryDO){
        Preconditions.checkNotNull(courseCategoryDO);
        CourseCategoryVO vo = new CourseCategoryVO();
        vo.setId(courseCategoryDO.getId());
        vo.setpId(courseCategoryDO.getParentID());
        vo.setName(courseCategoryDO.getName());
        return vo;
    }
}
