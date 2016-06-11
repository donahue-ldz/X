package com.X.biz.admin.vo;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-11 AM9:48
 **/
public class StudentCreditVO implements Serializable {
    private String studentID;
    private String studentName;
    private long sumScores;

    public String getStudentID() {
        return studentID;
    }

    public StudentCreditVO setStudentID(String studentID) {
        this.studentID = studentID;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public StudentCreditVO setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public long getSumScores() {
        return sumScores;
    }

    public StudentCreditVO setSumScores(long sumScores) {
        this.sumScores = sumScores;
        return this;
    }
}
