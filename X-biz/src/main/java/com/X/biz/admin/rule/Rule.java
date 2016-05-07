package com.X.biz.admin.rule;

import com.X.dal.domain.StudentDO;

/**
 * Created by donahue on 5/7/16.
 */
public interface Rule {
    String name();
    void setData(StudentDO student);
    int run(StudentDO student);

}
