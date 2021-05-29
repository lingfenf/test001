package controller;

import dao.studentDao;
import entity.message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id =Integer.valueOf(request.getParameter("id"));
        Integer sno =Integer.valueOf(request.getParameter("sno"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        message ma = new message(id,sno,name,sex,province,city);
        studentDao std = new studentDao();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        int result =  std.studentUpdate(ma);
        if(result==1){
            request.getRequestDispatcher("/studentQuery.jsp").forward(request,response);
        }else{
            printWriter.print("<font style='color:red;font-size:40'>用户信息更改失败</font>");
        }
    }
}
