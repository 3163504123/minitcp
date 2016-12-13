<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/upload">
    <ph>文件：<input type="file" name="file" /></ph>
    <input type="text" name="xxxx">
    <ph><input type="submit" value="上传" /></ph>
</form>
</body>
</html>