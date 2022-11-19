<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            				<li><a class="dropdown-item" href="gameRegist.jsp">game 등록</a></li>
            				<li><a class="dropdown-item" href="gameList.jsp">game 찾기</a></li>
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
		<form action="gameListAction.do" method="post">
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