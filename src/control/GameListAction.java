package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.GameDAO;
import game.GameDTO;


@SuppressWarnings("serial")
@WebServlet("/GameListAction.do")
public class GameListAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String game_region = request.getParameter("game_region");
		String game_date = request.getParameter("game_date");
		
//		session.setAttribute("game_region", game_region);
//		session.setAttribute("game_date", game_date);
		
		//String game_region = (String)session.getAttribute("game_region");
		//String game_date = (String)session.getAttribute("game_date");
		
		
		
		if(game_region==null||game_region.equals("")) {
			request.setAttribute("msg"," 입력하지않은 정보가 있습니다. ");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/gameListError.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_date==null||game_date.equals("")) {
			request.setAttribute("msg","입력하지않은 정보가 있습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/gameListError.jsp");
			dis.forward(request, response);
			return;
		}
		
		
		
		int pageSize=10;
		
		//현재 보여지고 있는 페이지의 넘버 값을 읽어드림 
		String pageNum = request.getParameter("pageNum");
		
		//null 처리
		if(pageNum==null){
			pageNum="1";
		}
		//전체 게시글의 갯수 
		int count = 0;
				
		//jsp페이지 내에서 보여질 넘버링 숫자값을 저장하는 변수
		int number = 0;
				
		//현재 보여지고 있는 페이지 문자를 숫자로 변환 
		int currentPage =Integer.parseInt(pageNum);
				
		
				
		//현재 보여질 페이지 시작 번호를 설정 
		int start = (currentPage-1)*pageSize+1;
		int end =currentPage * pageSize;
		
		//전체 게시글의 갯수를 가져와야 하기에 데이터 베이스 객체 생성
		GameDAO gameDAO = new GameDAO();
		count = gameDAO.getGameCount(game_region,game_date);
		//최신글 10개를 기준으로 게시글 리턴 받아주는 메소드 호출 
		ArrayList<GameDTO> gameList = gameDAO.getgGmeList(game_region, game_date, start, end);
		number = count - (currentPage -1)*pageSize;
		
		String msg =request.getParameter("msg");
		////////////////////////////////////////////BoardList.jsp쪽으로 request객체에 담아서 넘겨줌

		request.setAttribute("gameList", gameList );
		request.setAttribute("number",number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("msg", msg);
		
		System.out.println(gameList);
		
		RequestDispatcher dis = request.getRequestDispatcher("/gameList.jsp");
		dis.forward(request, response);
		return;
	}

}
