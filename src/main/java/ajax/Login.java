package ajax;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;

@Controller
public class Login {
	
	@ResponseBody
	@PostMapping("/AjaxLogin")
	public Map<String, String> login(HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("user")!=null) {
			return null;
		}
		if (request.getParameter("check") != null) {
			if (request.getParameter("check").equals(session.getAttribute("yzm"))) {
				String user = request.getParameter("username");
				String password = request.getParameter("password");
				Map<String,String> map;
				session.setAttribute("password", password);
				if (!(map = User.login(user, password)).isEmpty()) {
					//登录成功，设置用户session信息
					session.setAttribute("user", user);
					session.setAttribute("nicname", map.get("nicname"));
					session.setAttribute("type", map.get("type"));
					session.setAttribute("headpic", map.get("headpic"));
					//判断用户是否选择七天免登陆，若选择，则将部分信息放入cookie中
					if (request.getParameter("autologin")!=null) {
						Cookie cookie=new Cookie("user", user);
						cookie.setMaxAge(60*60*24*7);
						response.addCookie(cookie);
					}
					session.removeAttribute("yzm");
					return;
			}
		}
		
		
		return null;
		
	}
}
