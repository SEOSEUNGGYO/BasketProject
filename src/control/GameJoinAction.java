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


@SuppressWarnings("serial")
@WebServlet("/GameJoinAction.do")
public class GameJoinAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		int schedule_game= Integer.parseInt(request.getParameter("game_id"));
		String schedule_writer = request.getParameter("game_writer");
		
		if(schedule_game==0) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(schedule_writer==null||schedule_writer.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		
		String schedule_opponent = null;
		HttpSession session = request.getSession();
		schedule_opponent = (String)session.getAttribute("user_id");
		
		if(schedule_opponent==null || schedule_opponent.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		GameDAO gameDAO = new GameDAO();
		String schedule_date = request.getParameter("game_date");
		
		ArrayList<String> scheduleCheck = scheduleDAO.scheduleCheck(schedule_opponent);
		ArrayList<String> registCheck = gameDAO.registCheck(schedule_opponent);
		
		
		if(scheduleCheck.isEmpty()) {
			for(String i : registCheck) {
				if(schedule_writer.equals(schedule_opponent)){
					request.setAttribute("msg","NoMyGame");//내가만든일정에는참여불가
					RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
					dis.forward(request, response);
					return;
				}
				if(i.equals(schedule_date)) {
					request.setAttribute("msg","MyGameExist");//해당날짜에이미생성중인게임이있음
					RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
					dis.forward(request, response);
					return;
				}
			}
			gameDAO.matchUpdate(schedule_game);
			scheduleDAO.match(schedule_game, schedule_writer, schedule_opponent);
			request.setAttribute("msg","GameJoinSucess!");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}else {
			for(String i : registCheck) {
				System.out.println(i);
				System.out.println(registCheck);
				if(schedule_writer.equals(schedule_opponent)){
					request.setAttribute("msg","NoMyGame");//내가만든일정에는참여불가
					RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
					dis.forward(request, response);
					return;
				}
				if(i.equals(schedule_date)) {
					request.setAttribute("msg","MyGameExist");//해당날짜에이미생성중인게임이있음
					RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
					dis.forward(request, response);
					return;
				}
			}
			for(String i : scheduleCheck) {
				if(i.equals(schedule_date)) {
					request.setAttribute("msg","MyScheduleExist");//해당날짜에참옂우인일정있음
					RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
					dis.forward(request, response);
					return;
				}
			}
			
			gameDAO.matchUpdate(schedule_game);
			scheduleDAO.match(schedule_game, schedule_writer, schedule_opponent);
			request.setAttribute("msg","GameJoinSucess");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
			
		}
		
		
		
	}

}
