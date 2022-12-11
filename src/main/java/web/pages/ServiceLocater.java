package web.pages;

import web.ejb.StudentStateless;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocater {
    public static StudentStateless getStudentStatelessService() {
        Context ctx = null;
        StudentStateless studentBean = null;
        try {
            ctx = new InitialContext();
            String name="java:global/StudentH2-1.0-SNAPSHOT/StudentStatelessBean!web.ejb.StudentStateless";
            studentBean = (StudentStateless) ctx.lookup(name);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return studentBean;
    }
}
