
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body style="background: bisque;">
<h1>Pixelizator</h1>
<h3>Загрузите ваше изображение</h3>
<div class="box" style="box-shadow: 0px 0px 0px 10px rgba(0,0,0, 0.05); background: bisque; border: 2px solid crimson; border-radius: 10px; padding: 40px 10px">
    <label class="headers">Загрузить изображение: </label>
    <input id="file" class="buttons" type="file">
    <label>Уровень пикселизации: </label>
    <input style="padding-top: 0px;" type="range" id="volume" name="volume"
           min="1" max="50" onchange="setLblValue()">
    <label id="lblValue" for="volume"></label>
    <input style="font-size: 15px; background: crimson; color: #ffffff; padding: 10px 10px 10px 10px;" id="fileClear" class="buttons" type="button" value="Пикселизировать" onclick="send()">
</div>

<script src="js/form.js"></script>
<img id="imgAltered" alt="" src="" style="padding-top: 20px; transform: rotateZ(90deg) scale(1,-1);">
<div id="info">
    <label id="size"></label> <br>
    <label id="sizePicture"> </label>
</div>

<div id = "download">
    <a id="linkDownload" href="" download="pixel.jpeg">Скачать файл jpeg</a>
</div>
</body>
</html>