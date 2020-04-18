package ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Judgment;
import com.model.Order;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderJudge
 */
@WebServlet("/OrderJudge")
public class OrderJudge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderJudge() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> list=new ArrayList<>();
		String ordernum=request.getParameter("ordernum");
		String user=(String) request.getSession().getAttribute("user");
		list.add(ordernum);
		list.add(user);
		list.add(request.getParameter("shop"));
		list.add(request.getParameter("score"));
		list.add(request.getParameter("judgment"));
		JSONArray jsonArray=new JSONArray();
		jsonArray.addAll(list);
		String orvalues=jsonArray.toString();
		String values=orvalues.substring(1, orvalues.length()-1);
		if (Judgment.newJudge(values)) {
			Order.finishOrder(ordernum); 
		}
	}

}
