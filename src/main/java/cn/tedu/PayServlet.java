package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PayServlet", urlPatterns = "/PayServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //----------------------------------------------------------
        //1.获取请求中的所有cookie组成的数组
        Cookie[] cs = request.getCookies();
        //2.遍历cookie数组，判断cookie的名字是不是cookie中的值
        String prod=null;
        if(cs!=null){
            for (Cookie c:cs) {
                if (c.getName().equals("cart")){
                    //如果有名字为cart的cookie，则获取cookie中的值
                    prod=c.getValue();
                }
            }
        }
        //3.做出响应
        if(prod==null){
            out.write("未选择任何商品");
        }else {
            out.write("成功为【"+prod+"】完成支付");
        }
    }
}
