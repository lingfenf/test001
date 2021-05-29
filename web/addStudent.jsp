<%--
  Created by IntelliJ IDEA.
  User: 泠风
  Date: 2021/5/16
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/StudentSystem/addStudentServlet">
        学号：<input type="text" id="sno" name="sno"><br>
        姓名：<input type="text" id="name" name="name"><br>
        性别：<input type="text" id="sex" name="sex"><br>
        省份：<input type="text" id="province" name="province"><br>
        城市：<input type="text" id="city" name="city"><br>
        <input type="submit" id="ensure" value="添加">
        <input type="reset" id="reset" value="重置">
    </form>
</center>
</body>
</html>
