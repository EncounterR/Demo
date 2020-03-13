package com.oranth.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oranth.bean.ActiveUser;
import com.oranth.bean.Loginers;
import com.oranth.service.LoginersService;
/**
 * 用户登陆登出控制层
 * @author WU
 *
 */
@Controller
public class LoginController {
	@Autowired
	private LoginersService loginersService;
	
	/**
	 * 跳转到登陆页面
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * 用户登陆
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(String username, String password, HttpSession session) {
		// 从SecurityUtils里边创建一个 subject
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 执行认证登陆
		try {
			subject.login(token);
			System.out.println("认证成功");
			// 在认证成功后将activeUser存入session
			subject = SecurityUtils.getSubject();
			// 身份
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			if(session.getAttribute("activeUser")==null) {
				Date date=new Date();
				Loginers loginer=new Loginers(activeUser.getUsername(),date,activeUser.getUserRoleId());
				loginersService.addLoginer(loginer);
			}
			session.setAttribute("activeUser", activeUser);
			return new ModelAndView("first");
		} catch (UnknownAccountException ex) {
			String message ="用户名密码错误";
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("message", message);
			return mv;
		} catch (IncorrectCredentialsException ex) {
			String message ="用户名密码错误";
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("message", message);
			return mv;
		}
	}
	/**
	 * 用户退出
	 * @param httpSession
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) throws Exception {
		// 清空session里的值
		httpSession.removeAttribute("activeUser");
		return "redirect:login.action";
	}
	
	/**
	 * 显示main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(HttpSession session) {
		ModelAndView mv=new ModelAndView("firstMain");
		//显示用户活动
		ActiveUser activeUser=(ActiveUser) session.getAttribute("activeUser");
		if(activeUser.getUserRoleId()==106) {
			//当管理员登陆时，获取全部用户活动信息
			List<Loginers> llist=loginersService.getLoginersByNew();
			mv.addObject("loginers", llist);
		}else {
			//当非管理员登陆时，只获取该用户的用户活动信息
			List<Loginers> llist=loginersService.getLoginersByNewAndUsername(activeUser.getUsername());
			mv.addObject("loginers", llist);
		}
		return mv;
	}
	/**
	 * 跳转到聊天界面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/websocket")
	public String webSocket(HttpSession session,Model model) {
		try{
            //logger.info("跳转到websocket的页面上");
			ActiveUser activeUser=(ActiveUser) session.getAttribute("activeUser");
			String name =activeUser.getUsername();
			System.out.println("--------------"+name);
            model.addAttribute("username",name);
            return "Webscoket";
        }
        catch (Exception e){
            //logger.info("跳转到websocket的页面上发生异常，异常信息是："+e.getMessage());
            return "404";
        }
	}
}
