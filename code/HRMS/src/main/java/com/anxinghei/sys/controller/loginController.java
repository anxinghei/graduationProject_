package com.anxinghei.sys.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anxinghei.sys.entity.Permission;
import com.anxinghei.sys.entity.Role;
import com.anxinghei.sys.entity.Sysuser;
import com.anxinghei.sys.mapper.PermissionMapper;
import com.anxinghei.sys.mapper.RoleMapper;
import com.anxinghei.sys.mapper.SysuserMapper;
import com.anxinghei.sys.util.baiscData;
import com.anxinghei.sys.vo.LoginVo;
import com.anxinghei.sys.vo.MemberVo;
import com.google.code.kaptcha.impl.DefaultKaptcha;

@RestController
public class loginController {

	private String SHIRO_VERIFY_SESSION = "verifySessionCode";
	@Autowired
    private DefaultKaptcha defaultKaptcha;
	@Autowired
	private RoleMapper authGroupService;
	@Autowired
	private PermissionMapper ruleService;
	@Autowired
	private SysuserMapper sysuserMapper;
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String toLogin() {
//		Subject subject = SecurityUtils.getSubject();	
//		System.out.println(subject);
//		if(subject.isAuthenticated()){
//			System.out.println(subject.getPrincipal());
//            System.out.println("认证成功");
////            Sysuser member = (Sysuser)subject.getPrincipal();
////            model.addAttribute("member",member);
//            return "success";
//        }
//		return "failed";
		Sysuser sysuser=MemberVo.getSysuser();
		if(sysuser!=null){
            System.out.println("认证成功");
            return "success";
        }
		return "failed";
	}

	// 0成功 	1验证码错误		2用户名不存在	3密码错误
	@RequestMapping(value="logining",method = RequestMethod.POST)
	public int login(@RequestBody LoginVo LoginVo)  {
		
		System.out.println(LoginVo);
		/**
		 * 使用Shiro编写认证操作
		 */
//1.获取Subject
		Subject subject = SecurityUtils.getSubject();	
//2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(LoginVo.getUsername(),LoginVo.getPassword(),LoginVo.getRememberMe());
		System.out.println("login里的token:"+token .getUsername()+"--"+token.getPassword());
//3.执行登录方法
		// 获取session中的验证码
//        String verCode = (String) subject.getSession().getAttribute(SHIRO_VERIFY_SESSION);
		String verCode = LoginVo.getCode();
        System.out.println(verCode);
        if("".equals(LoginVo.getIdentify())||(!verCode.equals(LoginVo.getIdentify()))){
        	// 登录失败:验证码错误
            return 1;
        }
		try {
//			token.setRememberMe(LoginVo.getRememberMe());
			subject.login(token);
			Sysuser sysuser=new Sysuser(LoginVo.getUsername(),LoginVo.getPassword());
			sysuser=sysuserMapper.selectOne(sysuser);
			MemberVo.setSysuser(sysuser);
			System.out.println("登录用户"+MemberVo.getSysuser());
			//登录成功，跳转到主页面
			return 0;
		} catch (UnknownAccountException e) {
			//登录失败:用户名不存在
			return 2;
		}catch (IncorrectCredentialsException e) {
			//登录失败:密码错误
			return 3;
		}
	}
	
	
	
	
	
	/**
     * 获取验证码
     * @param response
     */
    @GetMapping("/getCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        byte[] verByte = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            LoginVo.setCode(createText);
//            request.getSession().setAttribute(SHIRO_VERIFY_SESSION,createText);
//            Subject subject = SecurityUtils.getSubject();	
//            Session session = subject.getSession();
//            session.setAttribute(SHIRO_VERIFY_SESSION,createText);
            System.out.println("生成的验证码："+createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        } catch (IllegalArgumentException e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        } catch (IOException e){
            e.printStackTrace();
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        verByte = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(verByte);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
    
}
