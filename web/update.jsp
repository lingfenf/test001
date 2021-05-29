<%@ page import="entity.message" %>
<%@ page import="dao.studentDao" %><%--
  Created by IntelliJ IDEA.
  User: 泠风
  Date: 2021/5/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        Integer id = Integer.valueOf(request.getParameter("id"));
        studentDao std = new studentDao();
        message ma = std.studentIdQuery(id);
    %>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(":text").each(function (i,n) {
                if (i==1) {
                    n.value=<%=ma.getSno()%>
                }if (i==2) {
                    n.value="<%=ma.getName()%>"
                }if (i==3) {
                    n.value="<%=ma.getSex()%>"
                }if (i==4) {
                    n.value="<%=ma.getProvince()%>"
                }if (i==5) {
                    n.value="<%=ma.getCity()%>"
                }

            });
            $("#abolish").click(function(){
                window.history.back();
            })
            $("#delete1").click(function(){
                    window.location.href = "/StudentSystem/deleteStudentServlet?id="+<%=id%>;
            })
        })

    </script>
</head>
<body>
<center>
    <form action="/StudentSystem/updateServlet">
id：<input type="text" id="id" name="id" value="<%=id%>" readonly><br>
学号：<input type="text" id="sno" name="sno"><br>
姓名：<input type="text" id="name" name="name"><br>
性别：<input type="text" id="sex" name="sex"><br>
省份：<input type="text" id="province" name="province"><br>
城市：<input type="text" id="city" name="city"><br>
        <input type="submit" id="ensure" value="修改">
        <input type="button" id="abolish" value="取消">
        <input type="button" id="delete1" value="删除">
    </form>
</center>
</body>
</html>
