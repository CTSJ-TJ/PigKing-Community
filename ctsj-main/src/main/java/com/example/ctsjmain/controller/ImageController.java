package com.example.ctsjmain.controller;

import com.example.ctsjmain.util.CreateVerificationCodeImageUtil;
import com.example.ctsjmain.util.CreateVerificationCodeUtil;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class ImageController {
    @GetMapping("/image")
    public Mono<Void> getImage(ServerWebExchange exchange) {
        String vericode = CreateVerificationCodeUtil.getSecurityCode();
        //获取session
        Mono<WebSession> session = exchange.getSession();
        return session.doOnNext(webSession -> {
            webSession.getAttributes().put("verityCode", vericode);
        }).then(exchange.getResponse().writeWith(Mono.fromSupplier(() -> {
            //设置返回的内容
            exchange.getResponse().getHeaders().setContentType(MediaType.IMAGE_JPEG);
            //浏览器不缓存响应内容--验证码图片，点一次就要刷新一次，所以不能有缓存出现
            exchange.getResponse().getHeaders().set("Pragma", "No-cache");
            exchange.getResponse().getHeaders().set("Cache-Control", "no-cache");
            //设置验证码失效时间
            exchange.getResponse().getHeaders().setExpires(0);
            //以字节流发过去，交给img的src属性去解析即可
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                ImageIO.write(new CreateVerificationCodeImageUtil(vericode).createImage(), "JPEG", bos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new DefaultDataBufferFactory().wrap(bos.toByteArray());
        })));
    }
}