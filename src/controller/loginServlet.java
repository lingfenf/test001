package controller;

import dao.studentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer sno=Integer.valueOf(request.getParameter("sno"));
        String name=request.getParameter("name");
        System.out.println(sno+"---"+name);
        studentDao studentDao = new studentDao();
        boolean bol = studentDao.login(sno,name);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        if (bol){
            printWriter.print(true);
        }
        else {
            printWriter.print(false);
        }
    }
}
