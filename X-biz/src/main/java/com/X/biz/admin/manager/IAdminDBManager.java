package com.X.biz.admin.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.AdminDO;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 3:18 PM
 **/
public interface IAdminDBManager {
    long save(AdminDO admin) throws XException;
    AdminDO queryAdminByEmail(String email) throws XException;
    List<AdminDO> queryAllAdmins()throws XException;
}
