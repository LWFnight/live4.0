package com.example.live.utils;

import org.apache.commons.mail.HtmlEmail;

public class SendEmail {
    public void sendEmail(String userEmail,StringBuffer randomCode){
        try {
        //发送验证邮件
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.qq.com");
        email.setCharset("utf-8");
        email.addTo(userEmail);//测试收件人邮箱："wo319039695@163.com"
        email.setFrom("319039695@qq.com");
        email.setAuthentication("319039695@qq.com","");
        email.setSubject("宜居注册验证邮件");
        email.setMsg("尊敬的用户，您此次注册的验证码为："+randomCode);
        email.send();
        }catch (Exception e){
            System.out.println("catch a exception.");
        }
    }
}
