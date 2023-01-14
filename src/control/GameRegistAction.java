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
import schedule.ScheduleDAO;


@SuppressWarnings("serial")
@WebServlet("/GameRegistAction.do")
public class GameRegistAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String game_region= request.getParameter("game_region");
		String game_date = request.getParameter("game_date");
		String game_time = request.getParameter("game_time");
		String game_rule = request.getParameter("game_rule");
		String game_address = request.getParameter("game_address");
		String game_court = request.getParameter("game_court");
		String game_information = request.getParameter("game_information");
		

		if(game_region==null||game_region.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_date==null||game_date.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_time==null||game_time.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_rule==null||game_rule.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_address==null||game_address.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_court==null||game_court.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_information==null||game_information.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		
		
		String game_writer = null;
		HttpSession session = request.getSession();
		game_writer = (String)session.getAttribute("user_id");
		if(game_writer==null || game_writer.equals("")) {
			RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
			dis.forward(request, response);
			return;
		}
		GameDAO gameDAO = new GameDAO();
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		
		ArrayList<String> registCheck = gameDAO.registCheck(game_writer);
		ArrayList<String> scheduleCheck = scheduleDAO.scheduleCheck(game_writer); 
		
		
		if(registCheck.isEmpty()) {
			int result = gameDAO.regist(game_region, game_date, game_time, game_rule, game_address, game_court, game_information, game_writer);
			if(result==1) {
				request.setAttribute("msg","GameRegistSuccess");
				RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
				dis.forward(request, response);
				return;
			}
		}else {
			for(String i : registCheck) {
				if(i.equals(game_date)) {
					request.setAttribute("msg","MyGameExist");//해당날짜에이미생성중인게임이있음
					RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
					dis.forward(request, response);
					return;
				}
			}
			for(String i : scheduleCheck) {
				if(i.equals(game_date)) {
					request.setAttribute("msg","MyScheduleExist");//해당날짜에참옂우인일정있음
					RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
					dis.forward(request, response);
					return;
				}
			}
			int result = gameDAO.regist(game_region, game_date, game_time, game_rule, game_address, game_court, game_information, game_writer);
			if(result==1) {
				request.setAttribute("msg","GameRegistSuccess");
				RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
				dis.forward(request, response);
				return;
			}
		}
	}

}
