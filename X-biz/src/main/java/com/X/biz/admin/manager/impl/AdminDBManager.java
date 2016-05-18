package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.IAdminDBManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.AdminDO;
import com.X.dal.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 3:23 PM
 **/
@Service("adminDBManager")
public class AdminDBManager implements IAdminDBManager {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public long save(final AdminDO admin) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                AdminDO adminDB = queryAdminByEmail(admin.getEmail());
                if(adminDB==null){
                    adminMapper.save(admin);
                    return admin.getId();
                }
                throw new XException("管理员存在...");
            }
        },admin);
    }

    @Override
    public AdminDO queryAdminByEmail(final String email) throws XException {
        return RunWrapper.run(new Callable<AdminDO>() {
            @Override
            public AdminDO call() throws Exception {
                return adminMapper.queryAdminByEmail(email);
            }
        });
    }

    @Override
    public AdminDO queryAdminByID(final Long id) throws XException {
        return RunWrapper.run(new Callable<AdminDO>() {
            @Override
            public AdminDO call() throws Exception {
                return adminMapper.queryAdminByID(id);
            }
        });
    }

    @Override
    public List<AdminDO> queryAllAdmins() throws XException {
        return RunWrapper.run(new Callable<List<AdminDO>>() {
            @Override
            public List<AdminDO> call() throws Exception {
                return adminMapper.queryAllAdmins();
            }
        });
    }
}
