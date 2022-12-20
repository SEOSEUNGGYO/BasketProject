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

/**
 * Servlet implementation class MyJoinGameListAction
 */
@WebServlet("/MyRegistGameListAction.do")
public class MyRegistGameListAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String game_writer = (String)session.getAttribute("user_id");
		
		
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
		int start = (currentPage-1)*pageSize+1;
		int end =currentPage * pageSize;
		
		GameDAO gameDAO = new GameDAO();
		ArrayList<GameDTO> myRegistGameList = gameDAO.getMyGameList(game_writer, start, end);
		count = gameDAO.getMyGameCount(game_writer);
		number = count - (currentPage -1)*pageSize;
		System.out.println(myRegistGameList);
		
		request.setAttribute("myRegistGameList", myRegistGameList );
		request.setAttribute("number",number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("game_writer", game_writer);
		RequestDispatcher dis = request.getRequestDispatcher("/myGame.jsp");
		dis.forward(request, response);
		return;
	}

}
