package com.example.ctsjlogin.web;

import com.example.ctsjlogin.vo.LoginProperties;
import com.example.ctsjlogin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping
public class LoginDo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    LoginProperties properties;

    Class userClass = null;

    // 初始化方法
    @PostConstruct
    void init(){
        if(userClass == null){
            try {
                userClass = Class.forName(properties.getEntityClass());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("用户类加载失败!",e);
            }
        }
    }

    @RequestMapping("login")
    public Result login(String name, String pwd, HttpSession session){
        if(name==null || name.trim().isEmpty()){
            return new Result(0,"请输入用户名", null);
        }
        if(pwd==null || pwd.trim().isEmpty()){
            return new Result(0,"请输入密码", null);
        }

        // 查询用户
        String sql = "select * from %s where %s=? and %s=?";
        sql = String.format(sql, properties.getUserTable(),
                properties.getNameColumn(),
                properties.getPwdColumn());
        System.out.println("hte:"+sql);
        // 查询用户对象
        Object user = null;

        // 初始化用户类
//        init();
        try{
            user = jdbcTemplate.queryForObject(
                    sql, new BeanPropertyRowMapper(userClass), name, pwd);
            session.setAttribute("loginedUser", user);
            System.out.println("the user:"+user);
        }catch (DataAccessException e){
            e.printStackTrace();
            return new Result(0,"用户名或密码错误", null);
        }
        return new Result(1,"登录成功", user);
    }

    @GetMapping("myInfo")
    public Result myinfo(
            @SessionAttribute(required = false) Object loginedUser){
        if(loginedUser == null){
            return new Result(0, "未登录", null);
        } else {
            return new Result(1, "已登录", loginedUser);
        }
    }

    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mav,
                               HttpSession session,
                               @RequestParam(defaultValue = "/login/index.html") String toPage){
        session.invalidate();
        mav.setViewName("redirect:"+toPage);
        return mav;
    }

    @GetMapping("props")
    public LoginProperties properties(){
        return properties;
    }

//    @Resource
//    private JavaMailSender mailSender;
//    @GetMapping("sendTestMail")
//    public void sendSimpleMail(String to, String subject, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(properties.getSendEmail());
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(content);
//        mailSender.send(message);
//    }
//
//    // 根据用户名发送验证码邮件
//    @RequestMapping("sendForgetMail")
//    public Result sendForgetMail(
//            String name,
//            HttpSession session,
//            // 1 简单邮件, 2. html 邮件
//            @RequestParam(defaultValue = "1") int type){
//        if(name==null || name.trim().isEmpty()){
//            return new Result(0,"请输入用户名", null);
//        }
//        String sql = "select * from %s where %s=?";
//        sql = String.format(sql, properties.getUserTable(),
//                properties.getNameColumn());
//        // 查询用户对象
//        Object user = null;
//        try{
//            user = jdbcTemplate.queryForObject(
//                    sql, new BeanPropertyRowMapper(userClass), name);
//            // 反射获取邮箱地址
//            Field field = user.getClass().getDeclaredField(properties.getEmailColumn());
//            field.setAccessible(true);
//            String email = (String) field.get(user);
//            // 生产验证码
//            String vcode = System.currentTimeMillis()+"";
//            vcode = vcode.substring(vcode.length()-6);
//            session.setAttribute("forgetVcode", vcode);
//
//            if(type == 1){
//                sendSimpleMail(email,"XXX平台验证码", "忘记密码的验证码: " + vcode );
//            } else {
//                // 如果 从 QQ 短信中点击邮件链接是在另外的浏览器打开重置密码的页面
//                // 那么一会回出错, 原因是 不同的浏览器有不同会话
//                // 思考如何解决这个问题
//                // Redis 保存验证码
//                sendHTMLMail(email,"XXX平台验证码",
//                        "忘记密码, 请点击<a href='http://127.0.0.1:8081/openResetHtml/"+vcode+"'>链接</a>" +
//                                ", 重置密码 " );
//            }
//            return new Result(1,"验证码发送成功!", null);
//        }catch (DataAccessException e){
//            e.printStackTrace();
//            return new Result(0,"用户名错误", null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 发送邮件给管理员
//            return new Result(0,"系统繁忙,请稍后再试", null);
//        }
//
//    }
//
//    // 提交新密码, 携带验证码
//    @RequestMapping("resetForgetPwd")
//    public Result resetForgetPwd(@SessionAttribute String forgetVcode,
//                                 String name,
//                                 String vcode,
//                                 String pwd){
//        if(name==null || name.trim().isEmpty()){
//            return new Result(0,"请输入用户名", null);
//        }
//        if(pwd==null || name.trim().isEmpty()){
//            return new Result(0,"请输入密码", null);
//        }
//        if(vcode==null || vcode.trim().isEmpty()){
//            return new Result(0,"请输入验证码", null);
//        }
//        if(vcode.equalsIgnoreCase(forgetVcode) ==  false){
//            return new Result(0,"验证码错误", null);
//        }
//        String sql = "update %s set %s=? where %s=?";
//        sql = String.format(sql, properties.getUserTable(),
//                properties.getPwdColumn(),
//                properties.getNameColumn());
//        jdbcTemplate.update(sql, pwd, name);
//        return new Result(1,"密码更新成功!", null);
//    }
//
//    @GetMapping("/openResetHtml/{vcode}")
//    public ModelAndView openResetHtml(
//            ModelAndView mav,
//            @PathVariable String vcode,
//            @SessionAttribute String forgetVcode){
//        if(forgetVcode.equalsIgnoreCase(vcode)){
//            mav.setViewName("redirect:/login/reset.html");
//        } else {
//            mav.setViewName("redirect:/提示错误的页面(验证码错误).html");
//        }
//        return mav;
//    }
//
//    private void sendHTMLMail(String email, String subject, String content) {
//        MimeMessage message = mailSender.createMimeMessage();
//        try {
//            //true表示需要创建一个multipart message
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(properties.getSendEmail());
//            helper.setTo(email);
//            helper.setSubject(subject);
//            helper.setText(content, true);
//            mailSender.send(message);
//            System.out.println("html格式邮件发送成功");
//        } catch (Exception e) {
//            System.out.println("html格式邮件发送失败");
//        }
//    }

}