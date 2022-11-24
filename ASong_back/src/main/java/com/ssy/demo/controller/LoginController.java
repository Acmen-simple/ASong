package com.ssy.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.code.kaptcha.Producer;
import com.ssy.demo.common.CommonUtil;
import com.ssy.demo.common.Const;
import com.ssy.demo.common.Responseresult;
import com.ssy.demo.entity.Login;
import com.ssy.demo.entity.Moto;
import com.ssy.demo.service.LoginService;
import com.ssy.demo.service.iml.LoginServiceIml;
import com.ssy.demo.util.CodeUtils;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/logincontroller")
public class LoginController  extends BaseController{
    @Autowired
    Responseresult result;

    @Autowired
    LoginServiceIml loginServiceIml;

    @Autowired
    Producer producer;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 获取全部信息
     */
    @PostMapping("/login")
    public Responseresult login(String search, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Login> page = loginServiceIml.find(pageNum, pageSize, search);
        result = CommonUtil.setResult("0", "查询成功", page);
        return result;
    }

    /**
     * 验证码z
     *
     */
     @GetMapping("/captcha")
     public Responseresult captcha() throws IOException {

         String key = UUID.randomUUID().toString();
         String code = producer.createText();

         BufferedImage image = producer.createImage(code);
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         ImageIO.write(image,"jpg",outputStream);

         BASE64Encoder encoder = new BASE64Encoder();
         String str = "data:image/jpeg;base64,";

         String base64Img = str + encoder.encode(outputStream.toByteArray());

         redisUtil.hset(Const.CAPTCHA_KEY, key, code,120);

         return result.succ(
                 MapUtil.builder()
                         .put("token",key)
                         .put("captchaImg",base64Img)
                         .put("code",code)
                         .build()
         );
     }



/**
 * 测试前端传递数据
 */
//        @GetMapping("/test")
//        public Responseresult test(HttpServletRequest request){
//            String code = request.getParameter("code");
//            System.out.println(code);
//            return  result;
//
//        }




    /**
     * 查询功能
     * @param oneaccount
     * @return
     */
    @RequestMapping(value = "/findone",method = RequestMethod.POST)
    public Responseresult findone(@RequestParam(defaultValue = "") String oneaccount){
       List<Login> list = loginServiceIml.findone(oneaccount);
       result = CommonUtil.setResult("0","查询成功",list);
       return  result;
    }

    /**
     * 判断账号密码是否对应
     */
    @RequestMapping(value = "/judge", method = RequestMethod.POST)
    public Responseresult judge(String account, String password, String newcode) {
//        Set<String> keys = redisTemplate.keys("*");
//        HashMap<Object,Object> map = new HashMap<>();
//        for (String key : keys){
//            Object value = redisTemplate.opsForValue().get(redisUtil.hasKey(Const.CAPTCHA_KEY));
//            map.put(key,value);
//        }
        try {
            String pwd = loginServiceIml.judge(account).getPassword();
            if (pwd.equals(password)) {
                result = CommonUtil.setResult("0", "登陆成功", "");
            } else {
                result = CommonUtil.setResult("1", "密码输入错误，请重新输入", "");
            }
        } catch (Exception e) {
            result = CommonUtil.setResult("1", "失败", e.getMessage());
        }
        return result;
    }

    /**
     * 登陆请求
     *
     */






    /**添加账号*/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Responseresult add(@RequestBody Login login) {
        try {
            List<Login> list =  loginServiceIml.findsame(login.getAccount());
            if(list.size() > 0){
                result = CommonUtil.setResult("1","该账号已存在，请重新输入","");
            } else {
                login.setState(0);
                loginServiceIml.add(login);
                result = CommonUtil.setResult("0", "注册成功", "");
            }
        } catch (Exception e) {
            result = CommonUtil.setResult("1", "注册失败", e.getMessage());
        }
        return result;
    }
//编辑
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public Responseresult edit(@RequestBody Login login){
        try {
            loginServiceIml.editUser(login);
            result = CommonUtil.setResult("0","修改成功","");
        } catch (Exception e) {
            result = CommonUtil.setResult("1","修改失败",e.getMessage());
        }
        return  result;
    }

    /**删除*/
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Responseresult del(@PathVariable int id){
        loginServiceIml.del(id);
        result = CommonUtil.setResult("0","删除成功","");
        return  result;
    }
}
