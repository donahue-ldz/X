package com.X.dal.mapper;

import com.X.dal.domain.GrantCreditDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donahue on 5/21/16.
 */
@Repository
public interface GrantCreditMapper {
    void save(GrantCreditDO grantCredit);
    List<GrantCreditDO> queryGrantsByStudentID(@Param("studentID") Long studentID);
    List<GrantCreditDO> queryAllGrants();
    GrantCreditDO queryGrantByID(@Param("id") Long id);


}
