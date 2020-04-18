package filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.model.User;
import com.takeout.tool.HtmlFilterRequest;

/**
 * Servlet Filter implementation class SetCharterEncoding
 */
@WebFilter(urlPatterns = { "/*" })
public class GlobalCheck implements Filter {

	/**
	 * Default constructor.
	 */
	public GlobalCheck() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest hrequest=new HtmlFilterRequest((HttpServletRequest) request);
		HttpSession session = hrequest.getSession();
		if (session.getAttribute("user") == null) {
			try {
				Cookie[] cookies = hrequest.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("user")) {
							String user = cookie.getValue();
							Map<String, String> map=User.login(user);
							session.setAttribute("user", user);
							session.setAttribute("nicname", map.get("nicname"));
							session.setAttribute("type", map.get("type"));
							session.setAttribute("headpic", map.get("headpic"));
						}
					}
				}
			} catch (Exception e) {
			}
		}
		chain.doFilter(hrequest, response);
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	

}
