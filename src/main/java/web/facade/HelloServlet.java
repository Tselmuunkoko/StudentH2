package web.facade;

import web.ejb.SimpleStateless;
import web.ejb.SimpleStatelessBean;

import java.io.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Context ctx = null;
        SimpleStateless hello=null;
        try {
            ctx = new InitialContext();
            String name="java:global/StudentH2-1.0-SNAPSHOT/SimpleStatelessBean!web.ejb.SimpleStateless";
            hello= (SimpleStateless) ctx.lookup(name);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + hello.getValue(1) + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}