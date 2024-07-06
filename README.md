#Mail学习demo1

这是对SpringBoot结合Mail发送的一个小demo
使用比较简单，仅需配置以及定义邮件即可完成邮件的发送。
这仅仅是本地邮件的发送学习，对于学生可以尝试学习。
后续作者也会持续扩充该项目的功能


##使用步骤
使用前需读者会创建SpringBoot的项目。
###第一步 添加SpringBoot-mail的依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
        
###第二步 配置对于的属性
        spring:
          mail:
            #指定邮箱服务器地址
            host: smtp.qq.com
            #登录账号
            username: 516643429@qq.com
            #密钥
            password: hawtultqauqybgfg
            #端口
            port: 587
            #默认编码
            default-encoding: utf-8
            #使用的协议
            protocol: smtp
            #其他属性
            properties:
              "mail.smtp.timeout": 3000


###第三步 生成邮件并发送

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