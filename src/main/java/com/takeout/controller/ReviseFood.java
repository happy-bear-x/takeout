package com.takeout.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.takeout.tool.PicTool;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.model.Food;

/**
 * Servlet implementation class ReviseFood
 */
@WebServlet("/ReviseFood")
public class ReviseFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviseFood() {
		super();
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
		HttpSession hs = request.getSession();
		ServletConfig config = this.getServletConfig();
		String abspath = config.getServletContext().getRealPath("/") + "img" + java.io.File.separator;
		String dir = "foods";
		SmartUpload su = new SmartUpload();
		su.setAllowedFilesList("jpg,png,jpeg");
		su.initialize(config, request, response);
		try {
			su.upload();
		} catch (Exception e) {
			request.getSession().setAttribute("uperr", "uperr");
			response.sendRedirect("manage.jsp");
			return;
		}
		String foodid = su.getRequest().getParameter("foodid");
		String name = su.getRequest().getParameter("rename");
		String price = su.getRequest().getParameter("reprice");
		String des = su.getRequest().getParameter("redes");
		String picturepath = PicTool.renamePic(su, abspath, dir);
		System.out.println(foodid + name);
		if (picturepath != null) {
			Map<String, String> map = Food.findFoodById(foodid);
			PicTool.delPic(abspath + map.get("pic"));
			Food.updateFood(foodid, name, price, picturepath, des);
		} else {
			if (Food.updateFood(foodid, name, price, des)) {
				System.out.println("succ");
			}
		}
		response.sendRedirect("manage.jsp");
	}

}
