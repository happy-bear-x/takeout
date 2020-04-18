package userajax;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload;
import com.model.User;
import com.takeout.tool.PicTool;

/**
 * Servlet implementation class UserHeadPic
 */
@WebServlet("/UserHeadPic")
public class UserHeadPic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHeadPic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		SmartUpload su = new SmartUpload();
		String headpic = null;
		ServletConfig config=this.getServletConfig();
		String orabspath=config.getServletContext().getRealPath("/");
		String abspath = orabspath + "img" + java.io.File.separator;
		String dir = "headpic";
		String user;
		user=(String) hs.getAttribute("user");
		//设置可上传的文件后缀
		su.setAllowedFilesList("jpg,png,jpeg");
		su.initialize(config, request, response);
		try {
			su.upload();
		} catch (Exception e) {
			//用户上传错误格式文件，向前端发送错误，并跳转到注册页面。
			response.getWriter().print("错误！");
		}
		headpic = PicTool.renamePic(su, abspath, dir);
		if (User.updateheadpic(user, headpic)) {
			response.getWriter().print("succeed");
			PicTool.delPic(orabspath+hs.getAttribute("headpic").toString().substring(1));
			hs.setAttribute("headpic", headpic);
		}
		
	}

}
