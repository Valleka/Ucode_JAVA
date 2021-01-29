<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pixelizator</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
    <h1>Pixelizator</h1>
    <h3>Загрузите ваше фото</h3>

    <div class="box">
        <label class="headers">Load image</label>
        <input id="file" class="buttons" type="file">
        <label>Pixel scale</label>
        <input type="range" id="volume" name="volume" min="1" max="50" onchange="setLblValue()">
        <label id="lblValue" for="volume"></label>
        <input id="fileClear" class="buttons" type="button" value="send" onclick="send()">
    </div>

    <script src="js/form.js"></script>
    <img id="imgAltered" alt="" src="" style="transform: rotateZ(90deg) scale(1,-1);">
    <div id="info">
        <label id="size"></label> <br>
        <label id="sizePicture"></label>
    </div>

    <div id="dowload">
        <a id="linkDownload" href="" download="pixel.jpeg">.jpeg</a>
    </div>




<%--    <form id="image-form" metod="post" enctype="multipart/form-data" action="#">&lt;%&ndash; enctype="multipart/form-data" указывает серверу, что отправлять будем файл &ndash;%&gt;
        <input type="file" name="file" />
        <input type="submit" onchange="show()" />
    </form>--%>
<%--    <%--%>
<%--        request.setCharacterEncoding("UTF-8");--%>
<%--        String name,password;--%>

<%--        try {--%>
<%--            name = (request.getParameter("file") != null) ? request.getParameter("file") : "null";--%>
<%--    %>--%>

<%--    <h3>File name:<%=name%></h3>--%>

<%--    <%--%>
<%--        }catch (NullPointerException ex){--%>
<%--            ex.printStackTrace();--%>
<%--        }--%>
<%--    %>--%>
</body>
</html>