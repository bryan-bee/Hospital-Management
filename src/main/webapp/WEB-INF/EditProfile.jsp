<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
</head>
<body>
<div style="display: flex; flex-direction: column; justify-content: center; height: 100vh;">
  <form method="POST">
    <table style="margin: 0 auto;">
      <tr>
        <td style="text-align: right;">New Name:</td>
        <td><input name="name" id="name" type="text"></td>
      </tr>
      <tr>
        <td style="text-align: right;">New Password:</td>
        <td><input name="oldpassword" id="oldpassword" type="text">
        	<input type='hidden' name='id' value="${user.id}">
        </td>
      </tr>
      <tr>
      <td><button>Save Changes</button></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>