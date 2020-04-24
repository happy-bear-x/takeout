package com.takeout.controller;

import com.takeout.tool.AjaxJson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/food")
public class FoodController {

    @RequestMapping(method = RequestMethod.POST)
    public AjaxJson food(){
        AjaxJson j=new AjaxJson();
        return j;
    }

/*	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HtmlFilterRequest filterRequest=new HtmlFilterRequest(request);
		// 上传图片需要SmartUpload，并设置保存路径。
		HttpSession hs = filterRequest.getSession();
		String abspath = config.getServletContext().getRealPath("/") + "img" + java.io.File.separator;
		String dir = "foods";
		SmartUpload su = new SmartUpload();
		//限制上传文件类型
		su.setAllowedFilesList("jpg,png,jpeg");
		su.initialize(config, request, response);
		try {
			su.upload();
		} catch (Exception e) {
			request.getSession().setAttribute("uperr", "uperr");
			response.sendRedirect("manage.jsp");
			return;
		}
		//获取前端数据，并调用服务类方法保存至数据库
		String shop = (String) hs.getAttribute("user");
		String name = su.getRequest().getParameter("name");
		String price = su.getRequest().getParameter("price");
		String des = su.getRequest().getParameter("des");
		String picturepath = PicTool.renamePic(su, abspath, dir);
		if (name.equals(" ")&&Food.newFood(shop, name, price, picturepath, des)) {
			hs.setAttribute("food", "succeed");
		} else {
			hs.setAttribute("newfooderr", "error");
		}
		response.sendRedirect("manage.jsp");
	}*/

    /* 修改商品（食物）
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
    }*/
}
