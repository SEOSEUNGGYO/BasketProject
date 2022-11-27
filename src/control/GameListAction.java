package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String game_region= request.getParameter("game_region");
		String game_date = request.getParameter("game_date");
		if(game_region==null||game_region.equals("")) {
			request.setAttribute("msg"," �Է��������� ������ �ֽ��ϴ�. ");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/gameListError.jsp");
			dis.forward(request, response);
			return;
		}
		if(game_date==null||game_date.equals("")) {
			request.setAttribute("msg","�Է��������� ������ �ֽ��ϴ�.");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/gameListError.jsp");
			dis.forward(request, response);
			return;
		}
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
				
		//��ü �Խñ��� ������ �����;� �ϱ⿡ ������ ���̽� ��ü ����
		GameDAO gameDAO = new GameDAO();
		count = gameDAO.getGameCount(game_region,game_date);
				
		//���� ������ ������ ���� ��ȣ�� ���� 
		int start = (currentPage-1)*pageSize+1;
		int end =currentPage * pageSize;
				
		//�ֽű� 10���� �������� �Խñ� ���� �޾��ִ� �޼ҵ� ȣ�� 
		ArrayList<GameDTO> gameList = gameDAO.getgGmeList(game_region, game_date, start, end);
		number = count - (currentPage -1)*pageSize;
		/////////////////////////////////////////���� ������ ��й�ȣ�� Ʋ�ȴٸ� 
		String msg =request.getParameter("msg");
		////////////////////////////////////////////BoardList.jsp������ request��ü�� ��Ƽ� �Ѱ���

		request.setAttribute("gameList", gameList );
		request.setAttribute("number",number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("msg", msg);
		RequestDispatcher dis = request.getRequestDispatcher("gameList.jsp");
		dis.forward(request ,response);
		
	}

}
