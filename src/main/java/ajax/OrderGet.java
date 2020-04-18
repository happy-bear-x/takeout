package ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Food;
import com.model.Order;
import com.model.Shop;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderGet
 */
@WebServlet("/OrderGet")
public class OrderGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start="0";
		Map<String, String> shopinfo;
		String foodname;
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("user");
		if (request.getParameter("start")!=null) {
			start=request.getParameter("start");
		}
		List<Map<String, String>> orderlist= Order.getAllOrder(user,start);
		for (int i = 0; i < orderlist.size(); i++) {
			shopinfo=Shop.getOneShop(orderlist.get(i).get("shop"));
			foodname=Food.getFoodNameById(orderlist.get(i).get("foodid"));
			orderlist.get(i).put("shopname", shopinfo.get("nicname"));
			orderlist.get(i).put("shoppic", shopinfo.get("headpic"));
			orderlist.get(i).put("foodname", foodname);
		}
		
		JSONArray jlist=new JSONArray();
		jlist.addAll(orderlist);
		response.getWriter().print(jlist);
	}

}
