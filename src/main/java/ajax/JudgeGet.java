package ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Judgment;
import com.model.User;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class JudgeGet
 */
@WebServlet("/JudgeGet")
public class JudgeGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JudgeGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start=request.getParameter("start");
		String shop=request.getParameter("shop");
		System.out.println(start);
		List<Map<String, String>> list=Judgment.getJudgment(shop, start);
		for(int i=0;i<list.size();i++){
			String nicname=User.getNicName(list.get(i).get("user"));
			list.get(i).put("nicname", nicname);
		}
		JSONArray jsonArray=new JSONArray();
		jsonArray.addAll(list);
		response.getWriter().print(jsonArray);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
