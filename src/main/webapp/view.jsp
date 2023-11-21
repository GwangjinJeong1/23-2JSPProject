<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.jspproject.dao.MemberDAO, com.example.jspproject.bean.MemberVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Member</title>
</head>
<body>
<%
    MemberDAO memberDAO = new MemberDAO();
    String id = request.getParameter("id");
    MemberVO u = memberDAO.getMember(Integer.parseInt(id));
    request.setAttribute("vo", u);
%>
<h1>학생 정보</h1>
<table id="edit">
    <tr>
        <td>Name</td><td>${vo.name}</td>
    </tr>
    <tr>
        <td>Photo</td><td><c:if test="${vo.photo ne ''}"><br/>
        <img src="${pageContext.request.contextPath}/upload/${vo.photo}" class="photo" width="100" height="100"></c:if></td>
    </tr>
    <tr>
        <td>Email</td><td>${vo.email}</td>
    </tr>
    <tr>
        <td>Phone</td><td>${vo.phone}</td>
    </tr>
    <tr>
        <td>RC</td><td>${vo.rc}</td>
    </tr>
    <tr>
        <td>Detail</td><td>${vo.detail}</td>
    </tr>
</table>
<button type="button" onclick="history.back()">Back</button>
<button type="submit" onclick="location.href='editform.jsp?id=${vo.sid}'">Edit</button>
</body>
</html>
