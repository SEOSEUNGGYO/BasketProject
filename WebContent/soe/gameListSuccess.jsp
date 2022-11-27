<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
	String game_region=(String)request.getParameter("game_region");
	String game_date=(String)request.getParameter("game_date");
	request.setAttribute("game_region", game_region);
	request.setAttribute("game_date", game_date);
	System.out.println(game_date);
%>
	<script type="text/javascript">
		location.href = 'gameList.jsp';
	</script>
</body>
</html>