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
		
		//���� �������� �ִ� �������� �ѹ� ���� �о�帲 
		String pageNum = request.getParameter("pageNum");
		
		//null ó��
		if(pageNum==null){
			pageNum="1";
		}
		//��ü �Խñ��� ���� 
		int count = 0;
				
		//jsp������ ������ ������ �ѹ��� ���ڰ��� �����ϴ� ����
		int number = 0;
				
		//���� �������� �ִ� ������ ���ڸ� ���ڷ� ��ȯ 
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
