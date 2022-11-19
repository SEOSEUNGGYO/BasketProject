<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/join.css">
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
	<div class="container" id="main">
		<form class="row border" action="JoinAction.do" method="post" id="row">
					
				<div class="col-6" id="col">
				 	<label for="user_id" class="form-label">ID</label>
				 	<input type="text" class="form-control" name = "user_id" id="user_id">
				</div>
				<div class="col-6" id="col">
				 	<label for="user_password" class="form-label">PASSWORD</label>
				 	<input type="password" class="form-control" name = "user_password" id="user_password">
				</div>
				<div class="col-6" id="col">
					<label for="user_email" class="form-label">Email</label>
    				<input type="email" class="form-control" name = "user_email" id="user_email">
				</div>
				<div class="col-6" id="col">
					<label for="user_phone" class="form-label">Phone</label>
    				<input type="text" class="form-control" name = "user_phone"id="user_user_phone">
				</div>
				<div class="col-6" id="col">
				 	<label for="user_name" class="form-label">이름</label>
				 	<input type="text" class="form-control" name = "user_name" id="user_name">
				</div>
				<div class="col-6" id="col">
				 	<label for="user_birth" class="form-label">생년월일</label>
				 	<input type="text" class="form-control" name = "user_birth" id="user_birth" placeholder="Example)210101">
				</div>
				<div class="col-12 text-center" id="col">
					<button type="submit" class="btn btn-light">가입</button>
				</div>
			
		</form>
		
		
	</div>
</div>



<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</body>
</html>