package com.X.biz.admin.rule.impl;

import com.X.biz.admin.rule.Rule;
import com.X.dal.domain.StudentDO;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 12:51 PM
 **/
public class CourseRule implements Rule {


    @Override
    public String name() {
        return null;
    }

    @Override
    public void setData(StudentDO student) {

    }

    @Override
    public int run(StudentDO student) {
        return 0;
    }
}
