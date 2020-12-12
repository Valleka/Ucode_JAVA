<%--
  Created by IntelliJ IDEA.
  User: vynchuk
  Date: 11/17/20
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pixelizator</title>
</head>
<body>
    <h1>Pixelizator</h1>
    <h3>Загрузите ваше фото</h3>
    <form id="image-form" metod="post" enctype="multipart/form-data" action="#"><%-- enctype="multipart/form-data" указывает серверу, что отправлять будем файл --%>
        <input type="file" name="file" />
        <input type="submit" onchange="show()" />
    </form>
    <%
        request.setCharacterEncoding("UTF-8");
        String name,password;

        try {
            name = (request.getParameter("file") != null) ? request.getParameter("file") : "null";
    %>

    <h3>namefile:<%=name%></h3>

    <%
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    %>
</body>
</html>