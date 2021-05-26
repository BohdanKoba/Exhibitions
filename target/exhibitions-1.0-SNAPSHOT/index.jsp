<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<form action="controller" method="get">
    <input type="hidden" name="command" value="hello"/>
</form>
<h1><%= "Hello World!" %>
</body>
</html>
