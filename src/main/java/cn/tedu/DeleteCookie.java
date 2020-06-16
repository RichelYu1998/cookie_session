package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteCookie", urlPatterns = "/DeleteCookie")
public class DeleteCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //----------------------------------------------------------
        /*
        * 删除名称为cart的cookie
        * 向浏览器发送一个同名的cookie(名称也是cart),并设置cookie
        * 最大生存时间为零，再将cookie添加到响应中，发送到浏览器即可
        * 由于浏览器是根据cookie的名字来区分cookie的，如果前后两次发送了
        * 同名的cookie后发送二点cookie就会覆盖之前发送的cookie，而后发送
        * 的cookie又设置了生存时间为零，因此浏览器会收到后会立即删除
        * */
        Cookie cookie = new Cookie("cart", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        out.write("成功删除了名称为cart的cookie");
    }
}
