package com.X.biz.mail;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 1:11 PM
 **/
public interface MailService {
    void signup(String username, String email, final String code);

    void forgot(String login_name, String email, String code);

}
