# BasketProject
길거리 농구, 동호회 농구 등 일반인들을 위한 농구 매칭 페이지 입니다.



## 소스 파일 설명


### WebContent(**view**)


* gameList.jsp : 메인페이지와 동일한 페이지이며 날짜, 지역별로 등록된 매치를 탐색하는 페이지


* gameRegist.jsp : 원하는 지역, 날짜, 시간 등을 입력하고 게임을 등록하는 페이지


* index.jsp : 메인 페이지(gameList.jsp와 동일)


* join.jsp : 회원가입 페이지


* login.jsp : 로그인 페이지


* myGame.jsp : 내가 등록한 매치 일정이나 내가 참여중인 매치 일정을 확인할 수 있는 페이지


* process.jsp : 사용자가 확인하는 페이지는 아니지만 에러나 옳지 않은 방법으로 접근했을 때 메시지를 띄우거나 이동시키는 페이지


### src(**controller,model**)


* control(**controller**)
  * GameJoinAction.java : 등록되어있는 게임에 참여하는 Controller
  * GameListAction.java : 등록되어있는 게임의 리스트를 찾는 Controller
  * GameRegistAction.java : 게임을 등록하는 Controller
  * JoinAction.java : 회원가입 Controller
  * LoginAction.java : 로그인 Contrller
  * LogoutAction.java : 로그아웃 Controller
  * MyJoinGameDeleteAction.java : 내가 참여중인 게임의 일정을 삭제하는 Controller
  * MyJoinGameListAction.java : 내가 참여중인 게임의 리스트를 찾는 Controller
  * MyRegistGameDeleteAction.java : 내가 등록한 게임을 삭제하는 Controller
  * MyRegistGameListAction.java : 내가 등록한 게임의 리스트를 확인하는 Controller


* game(**model**)
  * GameDAO.java : 게임 등록에 관한 DAO
  * GameDTO.java : 게임 등록에 관한 DTO
  

* schedule(**model**)
  * ScheduleDAO.java : 일정(게임 참여)에 관한 DAO
  * ScheduleDTO.java : 일정(게임 참여)에 관한 DTO


* user(**model**)
  * UserDAO.java : 회원에 관한 DAO
  * UserDTO.java : 회원에 관한 DTO
  

* util
  * DatabaseUtil.java : 데이터베이스와 연동
