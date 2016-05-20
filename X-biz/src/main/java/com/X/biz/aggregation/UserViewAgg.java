package com.X.biz.aggregation;

import com.X.biz.bbs.vo.UserView;
import com.X.biz.exception.XException;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 10:19 PM
 **/
public interface UserViewAgg {
    UserView view(@NotNull  Long userID, @NotEmpty String userRole) throws XException;
}
