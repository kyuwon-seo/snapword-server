<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<%

  // 데이터를 안드로이드에서 받음

	String recvMessage = request.getParameter("userId");
	String result = "goodgood";
	out.println(result);
	
%>
<h2><%=recvMessage %></h2>

</body>
</html>
  --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  // 데이터를 안드로이드에서 받음
	String recvMessage = request.getParameter("userId");
	String result = "goodgood";

  // 안드로이드에 보낼 데이터를 출력
	out.println(recvMessage);
%>

