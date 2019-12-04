<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.Enumeration" %>
<%@page import="java.io.IOException" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//이미지를 저장할 경로 입력.
		String folderTypePath = "http://18.216.244.70:8080/testServer/resources/image";
		//String folderTypePath = "C:/spring/testServer/src/main/webapp/resources/image";
								///C:/spring/testServer/src/main/webapp/resources/image/1482170421035-1.jpg
		String name = new String();
		String fileName = new String();
		int sizeLimit = 10 * 1024 * 1024; // 10메가까지 제한 넘어서면 예외발생
		try {
			MultipartRequest multi = new MultipartRequest(request, folderTypePath, sizeLimit,
					new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			//파일 정보가 있다면
			if (files.hasMoreElements()) {
				name = (String) files.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			System.out.println("이미지를 저장하였습니다. : " + fileName);
		} catch (IOException e) {
			out.println("안드로이드 부터 이미지를 받아옵니다.");
		}
	%>
	
	<%-- <%
		String dir = application.getRealPath("/프로젝트이름/실제 파일을 저장할 디렉토리");
		// 저는 "/altong/mon" 밑에 이미지를 저장했습니다.
		int max = 10 * 1024 * 1024;
		//최대크기, dir 디렉토리에 파일을 업로드하는 multipartRequest
		MultipartRequest mr = new MultipartRequest(request, dir, max, "UTF-8");
		String orgFileName = mr.getOriginalFileName("uploaded_file");
		String saveFileName = mr.getFilesystemName("uploaded_file");
		out.println(orgFileName + "이 저장되었습니다.");
	%> --%>

</body>
</html>