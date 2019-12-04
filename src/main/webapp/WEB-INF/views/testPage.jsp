<%@page import="com.testServer.domain.FoldVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<FoldVO> testList = (List<FoldVO>)request.getSession().getAttribute("testList"); %>
	<% String test = testList.get(0).getFolder_name(); %>	
	<%=test %>
	
	<%
		for(int i=0; i<testList.size(); i++){
			out.println(testList.get(i).getFolder_no()+testList.get(i).getFolder_name());
		}
	%>
</body>
</html>