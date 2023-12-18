<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>파일업로드</title>
</head>
<body>
<%--이미지는 이진파일--%>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/><br>
    <input type="submit" value="파일전송"/>
</form>
</body>
</html>