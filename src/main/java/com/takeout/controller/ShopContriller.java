package com.takeout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopContriller {
   /*
   评论
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

    }*/


}
