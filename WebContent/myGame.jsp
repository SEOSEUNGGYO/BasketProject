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
	<link rel="stylesheet" href="./css/myGame.css">
</head>


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
        		<li class="nav-item">
          			<a class="nav-link" href="notice.jsp">Notice</a>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link" href="kbl.jsp">KBL-Talk</a>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link" href="nba.jsp">NBA-Talk</a>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link" href="free.jsp">Free-Talk</a>
        		</li>
        		<li class="nav-item dropdown">
          			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            			Court-Info
          			</a>
          			<ul class="dropdown-menu">
            			<li><a class="dropdown-item" href="outdoor.jsp">Outdoor court</a></li>
            			<li><a class="dropdown-item" href="indoor.jsp">Indoor Court</a></li>
          			</ul>
        		</li>
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
            			<li><a class="dropdown-item" href="login.jsp">로그인</a></li>
            			<li><a class="dropdown-item" href="logout.jsp">로그아웃</a></li>
          			</ul>
        		</li>
      		</ul>
    	</div>
  	</div>
</nav>


<div class="wrap" id="wrap">
	<div class="container-fluid" id="main">
		<div class="row" id="row">
			<div class="col" id="col">
				<div class="row border" id="row">
					<form action="MyRegistGameListAction.do" method="post">
						<div class="col text-center" id="col">
							<label for="game_writer" class="form-label" style="text-align: center;">내가 생성한 일정</label><br>
							<input type="hidden" class="form-control" id="game_writer" name="game_writer" value="${session.session}">
    					</div>
    					<div class="col" style="text-align: center;" id="col">
    						<button type="submit" class="btn btn-outline-primary btn-lg btn-block">찾기</button>
    					</div>
    				</form>		
    			</div>
			
			<c:forEach var="myRegistGameList" items="${myRegistGameList}">
   				<form action="MyRegistGameDeleteAction.do" method="post">	
   					<div class="row border" id="row">
   						<div class="col" id="col">
   							<label for="game_id" class="form-label">매치번호</label>
   							<input type="text" class="form-control" name="game_id" id="game_id" value="${myRegistGameList.game_id}" readonly>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									지역
   								</div>
   								<div class="col">
   									${myRegistGameList.game_region}
   								</div>
   							</div>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									날짜
   								</div>
   								<div class="col">
   									${myRegistGameList.game_date}
   								</div>
   							</div>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									시간
   								</div>
   								<div class="col">
   									${myRegistGameList.game_time}
   								</div>
   							</div>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									매치 상태
   								</div>
   								<div class="col">
   									${myRegistGameList.game_reservation}
   								</div>
   							</div>
   						</div>
						<div class="col-12" id="col">
   							<button type="submit" class="btn btn-outline-danger btn-lg btn-block">삭제</button>
   						</div>	
   					</div>	
   				</form>
   			</c:forEach>
   			<!-- 페이지 카운터링 소스 작성  -->
   			<c:if test="${game_writer!=null}">
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
						<<a href="MyRegistGameListAction.do?pageNum=${startPage-10}">[이전]</a>
					</c:if>
			
					<!-- 페이징 처리-->
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="MyRegistGameListAction.do?pageNum=${i}" style ="text-decoration:none">[${i}]</a>
					</c:forEach>
			
					<!-- 다음  -->
					<c:if test="${endPage < pageCount}">
						<a href="MyRegistGameListAction.do?pageNum=${startPage+10}">[다음]</a>
					</c:if>
				</c:if>
			</c:if>
			</div>
			<div class="col" id="col">
				<div class="row border" id="row">
					<form action="MyJoinGameListAction.do" method="post">
						<div class="col text-center" id="col">
							<label for="schedule_opponent" class="form-label" style="text-align: center;">내가 참여한 일정</label><br>
							<input type="hidden" class="form-control" id="schedule_opponent" name="schedule_opponent" value="${session.session}">
    					</div>
    					<div class="col" style="text-align: center;" id="col">
    						<button type="submit" class="btn btn-outline-primary btn-lg btn-block">찾기</button>
    					</div>
    				</form>		
    			</div>
			
			<c:forEach var="myJoinGameList" items="${myJoinGameList}">
   				<form action="MyJoinGameDeleteAction.do" method="post">	
   					<div class="row border" id="row">
   						<div class="col" id="col">
   							<label for="schedule_game" class="form-label">매치번호</label>
   							<input type="text" class="form-control" name="schedule_game" id="schedule_game" value="${myJoinGameList.game_id}" readonly>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									지역
   								</div>
   								<div class="col">
   									${myJoinGameList.game_region}
   								</div>
   							</div>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									날짜
   								</div>
   								<div class="col">
   									${myJoinGameList.game_date}
   								</div>
   							</div>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									시간
   								</div>
   								<div class="col">
   									${myJoinGameList.game_time}
   								</div>
   							</div>
   						</div>
   						<div class="col-12 border-bottom">
   							<div class="row">
   								<div class="col">
   									매치 상태
   								</div>
   								<div class="col">
   									${myJoinGameList.game_reservation}
   								</div>
   							</div>
   						</div>
						<div class="col-12" id="col">
   							<button type="submit" class="btn btn-outline-danger btn-lg btn-block">삭제</button>
   						</div>	
   					</div>	
   				</form>
   			</c:forEach>
   			<!-- 페이지 카운터링 소스 작성  -->
   			<c:if test="${schedule_opponent!=null}">
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
						<<a href="MyJoinGameListAction.do?pageNum=${startPage-10}">[이전]</a>
					</c:if>
				
					<!-- 페이징 처리-->
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="MyJoinGameListAction.do?pageNum=${i}" style ="text-decoration:none">[${i}]</a>
					</c:forEach>
				
					<!-- 다음  -->
					<c:if test="${endPage < pageCount}">
						<a href="MyJoinGameListAction.do?pageNum=${startPage+10}">[다음]</a>
					</c:if>
				</c:if>
			</c:if>
			</div>
		</div>
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