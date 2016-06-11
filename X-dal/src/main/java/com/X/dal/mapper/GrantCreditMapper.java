package com.X.dal.mapper;

import com.X.dal.domain.CreditReportDO;
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
    List<GrantCreditDO> queryGrantsByStudentID(@Param("studentID") String studentID);
    List<GrantCreditDO> queryAllGrants();
    GrantCreditDO queryGrantByID(@Param("id") Long id);

    List<CreditReportDO> yearReport(@Param("studentID")String studentID);
    List<CreditReportDO> monthReport(@Param("studentID")String studentID,
                                     @Param("fromMonth") String fromMonth,@Param("toMonth")String toMonth);
    List<CreditReportDO> dayReport(@Param("studentID")String studentID,
                                   @Param("fromDay")String fromDays,@Param("toDay")String toDay);




}
