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
            				<li><a class="dropdown-item" href="gameRegist.jsp">game ??????</a></li>
            				<li><a class="dropdown-item" href="gameList.jsp">game ??????</a></li>
            				<li><a class="dropdown-item" href="myGame.jsp">??? Game</a></li>
          				</ul>
        			</li>
        			<li class="nav-item dropdown">
          				<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            				More
          				</a>
          				<ul class="dropdown-menu">
            				<li><a class="dropdown-item" href="join.jsp">????????????</a></li>
            				<li><a class="dropdown-item" href="login.jsp">?????????</a></li>
            				<li><a class="dropdown-item" href="logout.jsp">????????????</a></li>
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
					<label for="game_region" class="form-label">?????? ??????</label>
    					<select id="game_region" name="game_region" class="form-select">
      						<option value="seoul">??????</option>
      						<option value="busan">??????</option>
      						<option value="daegu">??????</option>
      						<option value="inceon">??????</option>
      						<option value="gwangju">??????</option>
      						<option value="daejeon">??????</option>
      						<option value="ulsan">??????</option>
      						<option value="sejong">??????</option>
      						<option value="gyeonggi">?????????</option>
      						<option value="gangwon">?????????</option>
      						<option value="chungcheong">?????????</option>
      						<option value="jeolla">?????????</option>
      						<option value="gyeongsang">?????????</option>
      						
    					</select>
    			</div>
    			<div class="col" id="col">
    				<label for="game_date" class="form-label">?????? ??????</label><br>
    				<input type="date" class="form-control" id="game_date" name="game_date">
    			</div>
    		</div>
    		<div class="row" id="row">
    			<div class="col" style="text-align: center;" id="col">
    				<button type="submit" class="btn btn-outline-primary btn-lg btn-block">??????</button>
    			</div>
    		</div>
   		</form>
   		
   		<c:forEach var="gameList" items="${gameList}">
   		<c:set var="game_region" value="${gameList.game_region}" />
   		<c:set var="game_date" value="${gameList.game_date}" />
   			<form action="GameJoinAction.do" method="post">	
   				<div class="row border" id="row">
   					<div class="col" id="col">
   						<label for="game_id" class="form-label">????????????</label>
   						<input type="text" class="form-control" name="game_id" id="game_id" value="${gameList.game_id}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_region" class="form-label">??????</label>
   						<input type="text" class="form-control" name="game_region" id="game_region" value="${gameList.game_region}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_date" class="form-label">??????</label>
   						<input type="text" class="form-control" name="game_date" id="game_date" value="${gameList.game_date}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_time" class="form-label">??????</label>
						<input type="text" class="form-control" name="game_time" id="game_time" value="${gameList.game_time}" readonly>   					</div>
   					<div class="col-12" id="col">
   						<label for="game_rule" class="form-label">??????</label>
   						<p id="game_rule">${gameList.game_rule}</p>
   					</div>
   					<div class="col-12" id="col">			
   						<label for="game_address" class="form-label">??????</label>
   						<p id="game_address">${gameList.game_address}</p>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_court" class="form-label">??????</label>
   						<p id="game_court">${gameList.game_court}</p>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_information" class="form-label">??????</label>
   						<p id="game_information">${gameList.game_information}</p>
   					</div>
   					<div class="col-12" id="col">
   						<label for="game_writer" class="form-label">?????????</label>
   						<input type="text" class="form-control" name="game_writer" id="game_writer" value="${gameList.game_writer}" readonly>
   					</div>
   					<div class="col-12" id="col">
   						<button type="submit" class="btn btn-outline-primary btn-lg btn-block">??????</button>
   					</div>
   				</div>	
   			</form>
   		</c:forEach>
   		<!-- ????????? ???????????? ?????? ??????  -->
		<c:if test="${count>0}">
			<c:set var="pageCount" value="${count /pageSize + (count%pageSize == 0 ? 0 : 1 )}" />
			<c:set var="startPage" value="${1}" />
			
			<c:if test="${currentPage%10 != 0}">
				<!--????????? ??????????????? ?????? ????????? ????????? fmt  -->
				<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true"/>
				<c:set var="startPage" value="${result*10+1}" />
			</c:if>
			
			<c:if test="${currentPage%10 == 0}">
				<!--????????? ??????????????? ?????? ????????? ????????? fmt  -->
				<c:set var="startPage" value="${(result-1)*10+1}" />
			</c:if>
			
			<!-- ????????? ????????? ????????? ?????? ????????? ?????? -->
			<c:set var="pageBlock" value="${10}" />
			<c:set var="endPage" value="${startPage+pageBlock-1}" />
			
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			
			<!--?????? ????????? ?????? ?????? -->
			<c:if test="${startPage > 10}">
				<<a href="GameListAction.do?pageNum=${startPage-10}">[??????]</a>
			</c:if>
			
			<!-- ????????? ??????-->
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="GameListAction.do?pageNum=${i}&game_region=${game_region}&game_date=${game_date}" style ="text-decoration:none">[${i}]</a>
			</c:forEach>
			
			<!-- ??????  -->
			<c:if test="${endPage < pageCount}">
				<a href="GameListAction.do?pageNum=${startPage+10}&game_region=${game_region}&game_date=${game_date}">[??????]</a>
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