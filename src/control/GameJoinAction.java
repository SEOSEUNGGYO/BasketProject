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
			request.setAttribute("msg"," �Է��������� ������ �ֽ��ϴ�. ");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/gameRegistError.jsp");
			dis.forward(request, response);
			return;
		}
		if(schedule_writer==null||schedule_writer.equals("")) {
			request.setAttribute("msg"," �Է��������� ������ �ֽ��ϴ�. ");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/gameRegistError.jsp");
			dis.forward(request, response);
			return;
		}
		
		String schedule_opponent = null;
		HttpSession session = request.getSession();
		schedule_opponent = (String)session.getAttribute("user_id");
		
		if(schedule_opponent==null || schedule_opponent.equals("")) {
			request.setAttribute("msg","�Է��������� ������ �ֽ��ϴ�.");
			RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
			dis.forward(request, response);
			return;
		}
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		GameDAO gameDAO = new GameDAO();
		String schedule_date = request.getParameter("game_date");
		String schedule_time = request.getParameter("game_time");
		
		ArrayList<String> check = scheduleDAO.dupCheck(schedule_opponent);
		System.out.println(check);
		
		if(check.isEmpty()) {
			if(schedule_writer.equals(schedule_opponent)){
				request.setAttribute("msg","������ ���� �������� ������ �� �����ϴ�!!");
				RequestDispatcher dis = request.getRequestDispatcher("/soe/gameRegistSuccess.jsp");
				dis.forward(request, response);
				return;
			}else {
				scheduleDAO.match(schedule_game, schedule_writer, schedule_opponent, schedule_date, schedule_time);
				request.setAttribute("msg","����� �Ϸ�Ǿ����ϴ�. ����Ʈ�� Ȯ���ϼ���!");
				RequestDispatcher dis = request.getRequestDispatcher("/soe/gameRegistSuccess.jsp");
				dis.forward(request, response);
				return;
			}
		}
		for(String i : check) {
			System.out.println(i);
			System.out.println(schedule_date+schedule_time);
			if(i.equals(schedule_date+schedule_time)) {
				request.setAttribute("msg","�ش� ��¥�� �ð��� �̹� ������ ������ �ֽ��ϴ�!!!");
				RequestDispatcher dis = request.getRequestDispatcher("/soe/gameRegistSuccess.jsp");
				dis.forward(request, response);
				return;
			}else if(schedule_writer.equals(schedule_opponent)){
				request.setAttribute("msg","������ ���� �������� ������ �� �����ϴ�!!");
				RequestDispatcher dis = request.getRequestDispatcher("/soe/gameRegistSuccess.jsp");
				dis.forward(request, response);
				return;
			}else {
				gameDAO.matchUpdate(schedule_game);
				scheduleDAO.match(schedule_game, schedule_writer, schedule_opponent, schedule_date, schedule_time);
				request.setAttribute("msg","����� �Ϸ�Ǿ����ϴ�. ����Ʈ�� Ȯ���ϼ���!");
				RequestDispatcher dis = request.getRequestDispatcher("/soe/gameRegistSuccess.jsp");
				dis.forward(request, response);
				return;
			}
		}
	
		
		
		
	}

}
