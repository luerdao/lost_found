package com.luerdao.controller;

import com.google.code.kaptcha.Producer;
import com.luerdao.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class CommonController {
    @Autowired
    private Producer kaptchaProduce;
    @Autowired
    private UserServiceImpl userService;

//    @RequestMapping("/tologin")
//    public String login(){
//        return "common/login";
//    }



    @RequestMapping("/t1")
    public String test1(){
        //classpath:/templates/test.html
        return "test";
    }


//    @RequestMapping("/login")
//    public String toLogin(@RequestParam("username")String username, @RequestParam("password")String password){
//        System.out.println("用户名是"+username);
//        System.out.println("密码是"+password);
//        if (userService.getPassword(username, password))
//            {System.out.println("登陆成功");
//            return "index";}
//        else System.out.println("登陆失败");return "/error";
//    }


    //生成验证码
    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    public void getKaptcha(HttpServletResponse response, HttpSession session){ //返回给浏览器的是图片，不是html，需要用response
        //生成验证码
        String text = kaptchaProduce.createText();
        BufferedImage image = kaptchaProduce.createImage(text);

        //将验证码存入session
        session.setAttribute("kaptcha",text);

        //将图片输出给浏览器
        response.setContentType("image/png");
        try{
            OutputStream os = response.getOutputStream();
            ImageIO.write(image,"png",os);
        }catch(IOException e){
            System.out.println("相应验证码失败"+e.getMessage());
        }

    }

}
