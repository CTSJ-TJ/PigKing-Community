package com.example.ctsjmain.controller;

import com.example.ctsjmain.util.CreateVerificationCodeImageUtil;
import com.example.ctsjmain.util.CreateVerificationCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class ImageController {

    @GetMapping("/image")
    public void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String vericode = CreateVerificationCodeUtil.getSecurityCode();
        HttpSession session = req.getSession();
        session.setAttribute("verityCode", vericode);
//        System.out.println(vericode);

        //设置返回的内容
        resp.setContentType("img/jpeg");
        //浏览器不缓存响应内容--验证码图片，点一次就要刷新一次，所以不能有缓存出现
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        //设置验证码失效时间
        resp.setDateHeader("Expires", 0);
        //以字节流发过去，交给img的src属性去解析即可
        ImageIO.write(new CreateVerificationCodeImageUtil(vericode).createImage(), "JPEG", resp.getOutputStream());
    }
}