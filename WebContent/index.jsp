<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/game.css">
</head>

<!-- index페이지와 gameList페이지는 동일한 페이지 -->
<body>
<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp">
		<img src="./image/ball_img.png" width="30" height="24">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	    	<div class="collapse navbar-collapse" id="navbarSupportedContent">
      			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
        			
        			<li class="nav-item dropdown">
          				<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            				game
          				</a>
          				<ul class="dropdown-menu">
            				<li><a class="dropdown-item" href="gameRegist.jsp">game 등록</a></li>
            				<li><a class="dropdown-item" href="gameList.jsp">game 찾기</a></li>
            				<li><a class="dropdown-item" href="myGame.jsp">내 Game</a></li>
          				</ul>
        			</li>
        			<li class="nav-item dropdown">
          				<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            				More
          				</a>
          				<ul class="dropdown-menu">
            				<li><a class="dropdown-item" href="join.jsp">회원가입</a></li>
            				<c:if test="${user_id==null }">
            				<li><a class="dropdown-item" href="login.jsp">로그인</a></li>
            				</c:if>
            				<c:if test="${user_id!=null }">
            				<li><a class="dropdown-item" href="LogoutAction.do">로그아웃</a></li>
            				</c:if>
          				</ul>
        			</li>
      			</ul>
    		</div>
  	</div>
</nav>

<div class="wrap" id="wrap">
	<div class="container-fluid" id="main">
		<form action="GameListAction.do" method="post">
			<div class="row border" id="row">
				<div class="col" id="col">
					<label for="game_region" class="form-label">지역 선택</label>
    					<select id="game_region" name="game_region" class="form-select">
      						<option value="seoul">서울</option>
      						<option value="busan">부산</option>
      						<option value="daegu">대구</option>
      						<option value="inceon">부산</option>
      						<option value="gwangju">광주</option>
      						<option value="daejeon">대전</option>
      						<option value="ulsan">울산</option>
      						<option value="sejong">세종</option>
      						<option value="gyeonggi">경기도</option>
      						<option value="gangwon">강원도</option>
      						<option value="chungcheong">충청도</option>
      						<option value="jeolla">전라도</option>
      						<option value="gyeongsang">경상도</option>
      						
    					</select>
    			</div>
    			<div class="col" id="col">
    				<label for="game_date" class="form-label">날짜 선택</label><br>
    				<input type="date" class="form-control" id="game_date" name="game_date">
    			</div>
    		</div>
    		<div class="row" id="row">
    			<div class="col" style="text-align: center;" id="col">
    				<button type="submit" class="btn btn-outline-primary btn-lg btn-block">찾기</button>
    			</div>
    		</div>
   		</form>
   		
   		<c:forEach var="gameList" items="${gameList}">
   		<c:set var="game_region" value="${gameList.game_region}" />
   		<c:set var="game_date" value="${gameList.game_date}" />
   			<form action="GameJoinAction.do" method="post">	
   				<div class="row border" id="row">
   					<div class="col" id="col">
   						<label for="game_id" class="form-label">매치번호</label>
   						<input type="text" class="form-control" name="game_id" id="game_id" value="${gameList.game_id}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_region" class="form-label">지역</label>
   						<input type="text" class="form-control" name="game_region" id="game_region" value="${gameList.game_region}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_date" class="form-label">날짜</label>
   						<input type="text" class="form-control" name="game_date" id="game_date" value="${gameList.game_date}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_time" class="form-label">시간</label>
						<input type="text" class="form-control" name="game_time" id="game_time" value="${gameList.game_time}" readonly>   					</div>
   					<div class="col-12" id="col">
   						<label for="game_rule" class="form-label">방식</label>
   						<p id="game_rule">${gameList.game_rule}</p>
   					</div>
   					<div class="col-12" id="col">			
   						<label for="game_address" class="form-label">주소</label>
   						<p id="game_address">${gameList.game_address}</p>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_court" class="form-label">코트</label>
   						<p id="game_court">${gameList.game_court}</p>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_information" class="form-label">기타</label>
   						<p id="game_information">${gameList.game_information}</p>
   						<p id="game_information">${gameList.game_writer}</p>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_writer" class="form-label">작성자</label>
   						<input type="text" class="form-control" name="game_writer" id="game_writer" value="${gameList.game_writer}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<button type="submit" class="btn btn-outline-primary btn-lg btn-block">참여</button>
   					</div>
   				</div>	
   			</form>
   		</c:forEach>
   		<!-- 페이지 카운터링 소스 작성  -->
		<c:if test="${count>0}">
			<c:set var="pageCount" value="${count /pageSize + (count%pageSize == 0 ? 0 : 1 )}" />
			<c:set var="startPage" value="${1}" />
			
			<c:if test="${currentPage%10 != 0}">
				<!--결과를 정수형으로 리턴 받아야 하기에 fmt  -->
				<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true"/>
				<c:set var="startPage" value="${result*10+1}" />
			</c:if>
			
			<c:if test="${currentPage%10 == 0}">
				<!--결과를 정수형으로 리턴 받아야 하기에 fmt  -->
				<c:set var="startPage" value="${(result-1)*10+1}" />
			</c:if>
			
			<!-- 화면에 보여질 페이지 처리 숫자를 표현 -->
			<c:set var="pageBlock" value="${10}" />
			<c:set var="endPage" value="${startPage+pageBlock-1}" />
			
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			
			<!--이전 링크를 결지 파악 -->
			<c:if test="${startPage > 10}">
				<<a href="GameListAction.do?pageNum=${startPage-10}">[이전]</a>
			</c:if>
			
			<!-- 페이징 처리-->
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="GameListAction.do?pageNum=${i}&game_region=${game_region}&game_date=${game_date}" style ="text-decoration:none">[${i}]</a>
			</c:forEach>
			
			<!-- 다음  -->
			<c:if test="${endPage < pageCount}">
				<a href="GameListAction.do?pageNum=${startPage+10}&game_region=${game_region}&game_date=${game_date}">[다음]</a>
			</c:if>
		</c:if>
	</div>		
</div>
		




<script>
  document.getElementById('game_date').value = new Date().toISOString().substring(0, 10);;
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js" integrity="sha512-L4qpL1ZotXZLLe8Oo0ZyHrj/SweV7CieswUODAAPN/tnqN3PA1P+4qPu5vIryNor6HQ5o22NujIcAZIfyVXwbQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</body>
</html>