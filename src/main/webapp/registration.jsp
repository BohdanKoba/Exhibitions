<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
    <form action="app" method="post">
        <input type="hidden" name="command" value="register"/>
        <div>Login</div>
        <input name="login" type="text" pattern="^[^\s$/()]+$" minlength="5" maxlength="25" required/><br/>
        <div>Password</div>
        <input name="password" type="password" pattern="^[^\s]+$" minlength="6" maxlength="20" required/><br/>
        <div>First name</div>
        <input name = "first_name" type="text" pattern="^\p{Lu}\p{Ll}+$" minlength="2" maxlength="50" required/><br>
        <div>Last name</div>
        <input name = "last_name" type="text" pattern="^\p{Lu}\p{Ll}+$" minlength="2" maxlength="50" required/><br>
        <div>Email</div>
        <input name = "email" type="email" required/><br>

        <input type="submit" value="Register"/>
    </form>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
