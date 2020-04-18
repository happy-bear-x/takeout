package userajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Address;
import com.model.User;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class InfoUpdate
 */
@WebServlet("/InfoUpdate")
public class InfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<String> list=new ArrayList<>();
		List<String> info=new ArrayList<>();
		if(request.getParameter("sex").equals("男")){
			info.add("0");
		}else{
			info.add("1");
		}
		System.out.println(request.getParameter("nicname"));
		info.add(request.getParameter("tel"));
		info.add(request.getParameter("nicname"));
		info.add(request.getParameter("birth"));
		String type="0";
		if (request.getSession().getAttribute("type").equals("1")) {
			type="1";
		}
		String user=(String) request.getSession().getAttribute("user");
		list.add(user);
		list.add(request.getParameter("city"));
		list.add(request.getParameter("area"));
		list.add(request.getParameter("street"));
		list.add(request.getParameter("detail"));
		list.add(type);
		list.add(request.getParameter("tel"));
		JSONArray jsonArray=new JSONArray();
		jsonArray.addAll(list);
		String orvalues= jsonArray.toString();
		String addrval=orvalues.substring(1, orvalues.length()-1);
		String infocondition="name='"+user+"';";
		if (Address.newAddr(addrval)&&User.updateInfo(info, infocondition)) {
			response.getWriter().print("succeed");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
