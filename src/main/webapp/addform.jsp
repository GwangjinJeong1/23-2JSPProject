<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Member</title>
</head>
<body>
<h1>신규 학생 추가</h1>
<form action="add_ok.jsp" method="post" enctype="multipart/form-data">
<table id="edit">
    <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>Photo</td><td><input type="file" name="photo"/></td></tr>
    <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
    <tr><td>Phone:</td><td><input type="text" name="phone"/></td></tr>
    <tr><td>RC:</td><td><input type="text" name="rc"/></td></tr>
    <tr><td>Detail:</td><td><textarea cols="50" rows="5" name="detail"></textarea></td></tr>
</table>
    <button type="button" onclick="location.href='posts.jsp'">Back</button><button type="submit">Add</button>
</form>

</body>
</html>