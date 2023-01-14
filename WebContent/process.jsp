<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
%>


<%
	if(msg=="NotInsert"){
		%>
		<script type="text/javascript">
		window.alert("입력하지 않은 정보가 있습니다!");
		history.back();
		</script>
		<%
		
	}else if(msg=="JoinSuccess"){
		%>
		<script type="text/javascript">
		window.alert("회원가입 성공! 로그인해주세요.");
		location.href = 'login.jsp';
		</script>
		<% 
	}else if(msg=="JoinFail"){
		%>
		<script type="text/javascript">
		window.alert("회원가입 실패! 다시 한번 확인해주세요.");
		history.back();
		</script>
		<%
	}else if(msg=="PWIncorrect"){
		%>
		<script type="text/javascript">
		window.alert("비밀번호가 틀렸습니다!.");
		history.back();
		</script>
		<%
	}else if(msg=="NoID"){
		%>
		<script type="text/javascript">
		window.alert("아이디를 확인할 수 없습니다!.");
		history.back();
		</script>
		<%
	}else if(msg=="LoginSuccess"){
		%>
		<script type="text/javascript">
		window.alert("로그인되었습니다!.");
		location.href = 'index.jsp';
		</script>
		<%
	}else if(msg=="NoMyGame"){
		%>
		<script type="text/javascript">
		window.alert("내가 만든 게임에는 참여할 수 없습니다!.");
		history.back();
		</script>
		<%
	}else if(msg=="MyGameExist"){
		%>
		<script type="text/javascript">
		window.alert("해당 날짜에 이미 생성중인 게임이 있습니다!.");
		history.back();
		</script>
		<%
	}else if(msg=="GameJoinSucess"){
		%>
		<script type="text/javascript">
		window.alert("일정에 참여되었습니다!.");
		history.back();
		</script>
		<%
	}else if(msg=="MyScheduleExist"){
		%>
		<script type="text/javascript">
		window.alert("해당 날짜에 이미 다른 게임에 참여중입니다!.");
		history.back();
		</script>
		<%
	}else if(msg=="GameRegistSuccess"){
		%>
		<script type="text/javascript">
		window.alert("게임 생성에 성공하였습니다!.");
		location.href='gameList.jsp'
		</script>
		<%
	}else if(msg=="Delete"){
		%>
		<script type="text/javascript">
		window.alert("일정을 삭제하였습니다!.");
		location.href='myGame.jsp'
		</script>
		<%
	}



%>
	
</body>
</html>