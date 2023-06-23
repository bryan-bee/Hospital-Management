<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div style="display: flex; flex-direction: column; justify-content: center; height: 100vh;">
  <form method="POST">
    <div style="text-align: center;">Login:</div>
    <table style="margin: 0 auto;">
      <tr>
        <td style="text-align: right;">Username:</td>
        <td><input name="username" id="username" type="text"></td>
      </tr>
      <tr>
        <td style="text-align: right;">Password:</td>
        <td><input name="password" id="password" type="text"></td>
      </tr>
      <tr>
      <td><button>Login</button></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>