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
    String address = request.getParameter("address");
    String address2 = request.getParameter("address2");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String zip = request.getParameter("zip");
    String isCheck = request.getParameter("isCheck");
    String isCheckMSG = "";
    if(isCheck.equals("1")) isCheckMSG = "Check me out 체크됨!";
    else isCheckMSG = "Check me out 체크 안됨!";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Email: <%=email%> <br />
Password: <%=password%> <br />
Address: <%=address%> <br />
Address2: <%=address2%> <br />
City: <%=city%> <br />
State: <%=state%> <br />
Zip: <%=zip%> <br />
isCheck: <%=isCheck%> <br />
</body>
</html>
