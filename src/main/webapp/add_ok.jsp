<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.jspproject.dao.MemberDAO"%>
<%@ page import="com.example.jspproject.common.FileUpload" %>
<%@ page import="com.example.jspproject.bean.MemberVO" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDAO memberDAO = new MemberDAO();
	FileUpload upload = new FileUpload();
	MemberVO u = upload.uploadPhoto(request);
	int i = memberDAO.insertMember(u);
	String msg = "데이터 추가 성공 !";
	if(i == 0) msg = "[에러] 데이터 추가 실패 !";
%>

<script>
	alert('<%=msg%>');
	location.href='posts.jsp';
</script>