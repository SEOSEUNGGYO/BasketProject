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
import schedule.ScheduleDAO;

/**
 * Servlet implementation class MyJoinGameListAction
 */
@WebServlet("/MyJoinGameListAction.do")
public class MyJoinGameListAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String schedule_opponent = (String)session.getAttribute("user_id");
		
		
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
		
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		count = scheduleDAO.getMyJoinGameCount(schedule_opponent);
		ArrayList<GameDTO> myJoinGameList = scheduleDAO.getMyJoinGameList(schedule_opponent, start, end);
		number = count - (currentPage -1)*pageSize;
		
		request.setAttribute("myJoinGameList", myJoinGameList );
		request.setAttribute("number",number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("schedule_opponent", schedule_opponent);
		RequestDispatcher dis = request.getRequestDispatcher("/myGame.jsp");
		dis.forward(request, response);
		return;
	}

}
