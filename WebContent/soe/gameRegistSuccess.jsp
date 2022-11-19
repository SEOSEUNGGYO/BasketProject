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
%>
	<script type="text/javascript">
		var message = "<%=msg%>";
		alert(message);
		location.href = 'gameList.jsp';
	</script>
</body>
</html>