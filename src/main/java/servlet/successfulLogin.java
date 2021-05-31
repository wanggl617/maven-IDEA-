package servlet; /**
 * @title 阳光正好，微风不燥
 * @data 2021/5/31
 */

import Domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/successfulLogin")
public class successfulLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = (User)request.getAttribute("User");
        if(user!=null) {
            response.getWriter().write("登录成功! " + user.getUsername() + " 欢迎！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
