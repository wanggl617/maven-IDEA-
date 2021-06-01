package servlet; /**
 * @title 阳光正好，微风不燥
 * @data 2021/5/31
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "test", value = "/test")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test!!!!!!!!!!11");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }
}
