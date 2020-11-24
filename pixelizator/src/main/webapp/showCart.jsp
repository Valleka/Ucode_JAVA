<%--
  Created by IntelliJ IDEA.
  User: vynchuk
  Date: 11/21/20
  Time: 2:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Cart</title>
</head>
<body>
    <%@ page import="world.ucode.CartPackage.Cart" %>
    <% Cart cart = (Cart) session.getAttribute("cart"); %>

    <p>Наименование <%= cart.getName()%> </p>
    <p>Количество <%= cart.getQuantity()%> </p>

</body>
</html>
