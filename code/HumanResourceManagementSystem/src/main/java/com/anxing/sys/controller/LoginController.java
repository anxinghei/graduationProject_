/**
 * 
 */
package com.anxing.sys.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anxing.sys.mapper.PermissionMapper;
import com.anxing.sys.mapper.RoleMapper;
import com.anxing.sys.mapper.SysuserMapper;
import com.anxing.sys.session.MySessionContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anxing.sys.entity.Sysuser;
import com.anxing.sys.response.ResultCode;
import com.anxing.sys.response.ResultVO;
import com.anxing.sys.vo.LoginVo;
import com.anxing.sys.vo.MemberVo;
import com.google.code.kaptcha.impl.DefaultKaptcha;

/**
 * @author 锡
 *
 */
@RestController
public class LoginController {

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
	public ResultVO toLogin() {
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
            return new ResultVO<>(ResultCode.SUCCESS, "success");
        }
		return new ResultVO<>(ResultCode.NONUSER, "failed");
	}

	// 0成功 	1验证码错误		2用户名不存在	3密码错误
	@RequestMapping(value="logining",method = RequestMethod.POST)
	public ResultVO login(@RequestBody LoginVo LoginVo, HttpServletRequest request)  {
		
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
		String verCode = LoginVo.getCode();
//        System.out.println("【登录】时的验证码"+verCode);

		//取得客户端请求头里带来的token
		String sessionId = request.getHeader("Access-Token");
		System.out.println("【登录】时的Access-Token: "+sessionId);
		//从自定义的监听代码中取得之前的session对象
		MySessionContext myc = MySessionContext.getInstance();
		System.out.println(myc);
		HttpSession session = myc.getSession(sessionId);
		System.out.println(session);
		//取得当时存入的验证码
		String correctCode = session.getAttribute("code").toString();
		System.out.println("【登录】时的验证码: "+correctCode);

        if("".equals(LoginVo.getIdentify())||(!verCode.equals(LoginVo.getIdentify()))){
        	// 登录失败:验证码错误
            return new ResultVO<>(ResultCode.VERIFY_SESSION_ERROR, 1);
        }
		try {
//			token.setRememberMe(LoginVo.getRememberMe());
			subject.login(token);
			Sysuser sysuser=new Sysuser(LoginVo.getUsername(),LoginVo.getPassword());
			sysuser=sysuserMapper.selectOne(sysuser);
			MemberVo.setSysuser(sysuser);
			System.out.println("登录用户"+MemberVo.getSysuser());
			//登录成功，跳转到主页面
			return new ResultVO<>(ResultCode.SUCCESS, 0);
		} catch (UnknownAccountException e) {
			//登录失败:用户名不存在
			return new ResultVO<>(ResultCode.NONEXIT, 2);
		}catch (IncorrectCredentialsException e) {
			//登录失败:密码错误
			return new ResultVO<>(ResultCode.PWD_ERROR, 3);
		}catch(Exception e) {
			// 其他原因导致登录失败
			return new ResultVO<>(ResultCode.ERROR, 5);
		}
	}
	
	
	/**
     * 获取验证码
     * @param response
     */
    @GetMapping("/api/code")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        byte[] verByte = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		//生产验证码字符串并保存到session中
		String createText = defaultKaptcha.createText();
        try {
            LoginVo.setCode(createText);
//            request.getSession().setAttribute(SHIRO_VERIFY_SESSION, createText);

            System.out.println("【生成】的验证码："+createText);

            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        } catch (IllegalArgumentException e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        } catch (IOException e){
            e.printStackTrace();
        }


		//存入session
		HttpSession session = request.getSession();
		System.out.println("生成验证码时取得的session: "+session);
		session.setAttribute("code", createText);

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        verByte = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
		//允许客户端请求头携带
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type,Access-Token");
		//允许给客户端响应头携带
		response.setHeader("Access-Control-Expose-Headers", "Access-Token");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		//将sessionId通过响应头传回客户端
		response.setHeader("Access-Token",session.getId());
		System.out.println("【验证码时】Access-Token: "+session.getId());

        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(verByte);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
    
}
