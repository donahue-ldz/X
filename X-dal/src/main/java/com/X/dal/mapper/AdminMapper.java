package com.X.dal.mapper;

import com.X.dal.domain.AdminDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donahue on 5/6/16.
 */
@Repository
public interface AdminMapper {
    long save(AdminDO admin);
    AdminDO queryAdminByEmail(@Param("email") String email);
    List<AdminDO> queryAllAdmins();
}
