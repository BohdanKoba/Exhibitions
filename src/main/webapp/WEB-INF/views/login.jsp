<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="login"/>
        <input name="login" value="admin"/><br/>
        <input type="password" name="password"/><br/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
