package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.GameDAO;


@WebServlet("/MyRegistGameDeleteAction.do")
public class MyRegistGameDeleteAction extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String game_id = request.getParameter("game_id");
		GameDAO gameDAO = new GameDAO();
		gameDAO.matchDelete(game_id);
		
		request.setAttribute("msg","Delete");
		RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
		dis.forward(request, response);
		return;
		
	}
}
