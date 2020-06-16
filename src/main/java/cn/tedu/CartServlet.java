package cn.tedu;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "CartServlet", urlPatterns = "/CartServlet")
public class CartServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
/* 负责将商品加入购物车 */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //----------------------------------------------------------
        //1.获取要加入购物车的商品信息
        String prod = request.getParameter("prod");
        //2.创建一个cookie对象，将商品信息保存到cookie中
        Cookie cookie = new Cookie("cart",prod);
        //设置cookie最大生存时间(s)
        cookie.setMaxAge(60*60*24*30);
        //3.将cookie添加到响应中，发送到浏览器保存
        response.addCookie(cookie);
        out.write("成功将【"+prod+"】加入了购物车");
    }
}
