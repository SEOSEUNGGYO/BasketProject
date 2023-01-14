package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.GameDAO;
import schedule.ScheduleDAO;


@WebServlet("/MyJoinGameDeleteAction.do")
public class MyJoinGameDeleteAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String schedule_game = request.getParameter("schedule_game");
		
		GameDAO gameDAO = new GameDAO();
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		
		gameDAO.matchReUpdate(schedule_game);
		scheduleDAO.scheduleDelete(schedule_game);
		
		request.setAttribute("msg","Delete");
		RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
		dis.forward(request, response);
		return;
		
	}
}
