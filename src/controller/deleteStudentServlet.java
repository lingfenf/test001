package controller;

import dao.studentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class deleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        studentDao std = new studentDao();
         int result = std.deleteStudent(id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
         if(result==1){
             request.getRequestDispatcher("/studentQuery.jsp").forward(request,response);
         }else{
             printWriter.print("<font style='color:red;font-size:40'>删除失败</font>");
         }
    }
}
