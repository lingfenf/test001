<%@ page import="dao.studentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="entity.message" %><%--
  Created by IntelliJ IDEA.
  User: 泠风
  Date: 2021/5/15
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            <% studentDao student = new studentDao();
    List<message> list = student.studentQuery();
        Iterator<message> iterator = list.iterator();
        while(iterator.hasNext()){
             message mes = iterator.next();
             %>
            $("#table1").append("<tr>\n" +
                "            <th><%=mes.getSno()%></th>\n" +
                "            <th><%=mes.getName()%></th>\n" +
                "            <th><%=mes.getSex()%></th>\n" +
                "            <th><%=mes.getProvince()%></th>\n" +
                "            <th><%=mes.getCity()%></th>\n" +
                "           <th><a href=\"update.jsp?id=<%=mes.getId()%>\">修改</a></th></br>" +
                "        </tr>")
            <%
        }
    %>
        });
    </script>
</head>
<body>
<center>
    <table id="table1" border="1px black soild" style="width: 400px">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>省份</th>
            <th>城市</th>
            <th>操作</th>
        </tr>
    </table>
</center>
</body>
</html>
