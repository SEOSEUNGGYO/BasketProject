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
	String game_region = (String)request.getAttribute("game_region");
	String game_date = (String)request.getAttribute("game_date");
	//System.out.println(game_region+" " + game_date);
%>

	<script type="text/javascript">
		var message = "<%=msg%>";
		alert(message);
		history.back();
	</script>
</body>
</html>