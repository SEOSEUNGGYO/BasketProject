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
		<form action="GameRegistAction.do" method="post">
			<div class="row border" id="row">
				<div class="col" id="col">
					<label for="game_region" class="form-label">지역</label>
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
    				<label for="game_date" class="form-label">날짜</label><br>
    				<input type="date" class="form-control" id="game_date" name="game_date">
    			</div>
    			<div class="col" id="col">
					<label for="game_time" class="form-label">시간</label>
    					<select id="game_time" name="game_time" class="form-select">
      						<option value="8">08:00</option>
      						<option value="9">09:00</option>
      						<option value="10">10:00</option>
      						<option value="11">11:00</option>
      						<option value="12">12:00</option>
      						<option value="13">13:00</option>
      						<option value="14">14:00</option>
      						<option value="15">15:00</option>
      						<option value="16">16:00</option>
      						<option value="17">18:00</option>
      						<option value="18">18:00</option>
      						<option value="19">19:00</option>
      						<option value="20">20:00</option>
      						<option value="21">21:00</option>
      						<option value="22">22:00</option>
    					</select>
    			</div>
    		</div>
    		<div class="row border" id="row">
    			<div class="col" id="col">
	    			<label for="game_rule" class="form-label">경기 방식</label>
    					<select id="game_rule" name="game_rule" class="form-select">
      						<option value="3">3vs3</option>
      						<option value="5">5vs5</option>
    					</select>
    			</div>
    			
    		</div>
    		<div class="row border" id="row">
    			<div class="col" id="col">
	    			<label for="game_address" class="form-label">상세 주소</label><br>
    				<input type="text" class="form-control" id="game_address" name="game_address">
    			</div>
    			<div class="col" id="col">
    				<label for="form-check-inline" class="form-label">코트 정보</label><br>
    				<div class="form-check-inline" id="form-check-inline">
  						<input class="form-check-input" type="radio" name="game_court" id="game_court" value="game_indoor">
  						<label class="form-check-label" for="game_court">
    						실내
  						</label>
					</div>
					<div class="form-check-inline">
  						<input class="form-check-input" type="radio" name="game_court" id="game_court" value="game_outdoor">
  						<label class="form-check-label" for="game_court">
    						야외
  						</label>
					</div>
    			</div>
    		</div>
    		<div class="row border" id="row">
    			<div class="col" id="col">
	    			<label for="game_information">기타 정보</label>
    				<textarea rows="4"  cols="20" class="form-control" style="resize:none;" id="game_information" name="game_information"  wrap="hard" placeholder="대표전화,인원,경기시간 등">대표전화:&#10;인원:&#10;경기시간:&#10;기타:</textarea>
    			</div>
    		</div>
    		<div class="row" id="row">
    			<div class="col" style="text-align: center;" id="col">
    				<button type="submit" class="btn btn-outline-primary btn-lg btn-block">등록</button>
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