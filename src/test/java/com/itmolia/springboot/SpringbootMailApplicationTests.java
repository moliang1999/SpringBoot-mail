package com.itmolia.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class SpringbootMailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() throws MessagingException, UnsupportedEncodingException {

        System.out.println("发送邮件开始。。。。");
        //创建一个邮件消息
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //创建一个mimeMessageHelper
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);


        //发件人的邮箱和名称
        helper.setFrom("516643429@qq.com","testProject");
        //收件人的邮箱
        helper.setTo("1045748165@qq.com");
        //邮件标题
        helper.setSubject("TEST MAIL PROJECT");
        //邮件正文
        String msg = "Hello, <Strong> world </Strong>";
        helper.setText(msg,true);

        //发送
        javaMailSender.send(mimeMessage);
        System.out.println("发送邮件完成...");
    }

}
