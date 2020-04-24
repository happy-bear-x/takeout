package com.takeout.controller;

import com.takeout.tool.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {


	@RequestMapping(method = RequestMethod.GET)
	public AjaxJson add(){
		AjaxJson j=new AjaxJson();
		return  j;
	}
 /*
   获取用户/商家的订单
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String start = "0";
		Map<String, String> shopinfo;
		String foodname;
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if (request.getParameter("start") != null) {
			start = request.getParameter("start");
		}
		List<Map<String, String>> orderlist = Order.getShopOrder(user, start);
		for (int i = 0; i < orderlist.size(); i++) {
			shopinfo = Shop.getOneShop(orderlist.get(i).get("shop"));
			foodname = Food.getFoodNameById(orderlist.get(i).get("foodid"));
			orderlist.get(i).put("shopname", shopinfo.get("nicname"));
			orderlist.get(i).put("shoppic", shopinfo.get("headpic"));
			orderlist.get(i).put("foodname", foodname);
		}

		JSONArray jlist = new JSONArray();

		jlist.addAll(orderlist);
		System.out.println(jlist.size());
		response.getWriter().print(jlist);
	}*/
 /*
 	注册
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 //包含图片上传，所以需要使用SmartUpload组件
	 SmartUpload su = new SmartUpload();
	 String headpic = null;
	 ServletConfig config=this.getServletConfig();
	 String abspath = config.getServletContext().getRealPath("/") + "img" + java.io.File.separator;
	 String dir = "headpic";
	 //设置可上传的文件后缀
	 su.setAllowedFilesList("jpg,png,jpeg");
	 su.initialize(config, request, response);
	 try {
		 su.upload();
	 } catch (Exception e) {
		 //用户上传错误格式文件，向前端发送错误，并跳转到注册页面。
		 request.getSession().setAttribute("uperr", "uperr");
		 response.sendRedirect("./register.jsp");
		 return;
	 }
	 HttpSession hs = request.getSession();
	 List<String> list = new ArrayList<>();
	 //获取前端发送的数据
	 String name = su.getRequest().getParameter("username");
	 String password = su.getRequest().getParameter("password");
	 String repassword = su.getRequest().getParameter("repassword");
	 if (password.equals(repassword)) {
		 headpic = PicTool.renamePic(su, abspath, dir);
		 list.add(name);
		 list.add(password);
		 list.add(su.getRequest().getParameter("birth"));
		 list.add(headpic);
		 list.add(su.getRequest().getParameter("type"));
		 list.add(su.getRequest().getParameter("sex"));
		 list.add(su.getRequest().getParameter("nicname"));
		 //判断用户是否存在，若不存在，则保存到数据，若存在则返回页面并给出提示已存在。
		 if (!User.isexist(name)) {
			 if (User.insert(list)) {
				 response.getWriter().write("用户“"+name+"”注册成功！3s后跳转到登录页面。");
				 response.setHeader("refresh", "3;url=Login");
			 } else {
				 hs.setAttribute("error", "error");
				 request.getRequestDispatcher("register.jsp").forward(request, response);
			 }
		 } else {
			 hs.setAttribute("exist", name);
			 response.sendRedirect("register.jsp");

		 }
	 }
 }*/

	/*
	更新资料
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
	}*/
}
