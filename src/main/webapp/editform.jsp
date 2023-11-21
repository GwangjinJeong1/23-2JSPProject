<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.jspproject.dao.MemberDAO, com.example.jspproject.bean.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Member</title>
</head>
<body>
<%
	MemberDAO memberDAO = new MemberDAO();
	String id = request.getParameter("id");
	MemberVO u = memberDAO.getMember(Integer.parseInt(id));
	request.setAttribute("vo", u);
%>
<h1>학생 정보 수정</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="${vo.sid}"/>
<table>
<tr><td>Name:</td><td><input type="text" name="name" value="${vo.name}"/></td></tr>
<tr><td>Photo:</td><td><input type="file" name="photo" value="${vo.photo}"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email" value="${vo.email}"/></td></tr>
<tr><td>Phone:</td><td><input type="text" name="phone" value="${vo.phone}"/></td></tr>
<tr><td>RC:</td><td><input type="text" name="rc" value="${vo.rc}"/></td></tr>
<tr><td>Detail:</td><td><textarea cols="50" rows="5" name="detail">${vo.detail}</textarea></td></tr>
</table>
	<button type="button" onclick="history.back()">Back</button><button type="submit">Save</button>
</form>

</body>
</html>