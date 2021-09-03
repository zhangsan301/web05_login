<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/2
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>get提交方式</h1>
<form action="${ pageContext.request.contextPath }/ServletDemo1" method="get">
    姓名:<input type="text" name="name"/><br/>
    <input type="submit" value="提交">
</form>
<form action="${ pageContext.request.contextPath }/ServletDemo1" method="post">
    姓名:<input type="text" name="name"/><br/>
    <input type="submit" value="提交">
</form>
<h1>post提交方式</h1>
</body>
</html>
