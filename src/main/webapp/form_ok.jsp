<%--
  Created by IntelliJ IDEA.
  User: jeong-gwangjin
  Date: 11/11/23
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String stdId = request.getParameter("stdId");
    String sex = request.getParameter("sex");
    String grade = request.getParameter("grade");
    String dorm = request.getParameter("dorm");
    int room = Integer.parseInt(request.getParameter("room"));
    String major = request.getParameter("major");
    String home = request.getParameter("home");
    String isCheck = request.getParameter("isCheck");
    String isCheckMSG = "";
    if(isCheck.equals("1")) isCheckMSG = "Check me out 체크됨!";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Email: <%=email%> <br />
Password: <%=password%> <br />
Name: <%=name%> <br />
Student Id: <%=stdId%> <br />
Sex: <%=sex%> <br />
Grade: <%=grade%> <br />
Dormitory: <%=dorm%> <br />
Room: <%=room%> <br />
Major: <%=major%> <br />
Hometown: <%=home%> <br />
<%=isCheckMSG%> <br />
</body>
</html>
