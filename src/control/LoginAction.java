package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;


@SuppressWarnings("serial")
@WebServlet("/LoginAction.do")
public class LoginAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rePro(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rePro(request, response);
	}
	
	protected void rePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		
		
		
		if(user_id==null||user_id.equals("")) {
			request.setAttribute("msg","�Է��������� ������ �ֽ��ϴ�.");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/LoginError.jsp");
			dis.forward(request, response);
			return;
		}
		if(user_password==null||user_password.equals("")) {
			request.setAttribute("msg","�н����尡 ��ġ���� �ʽ��ϴ�");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/LoginError.jsp");
			dis.forward(request, response);
			return;
		}
		
		
		
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(user_id,user_password);
		
		if(result==1) {
			request.setAttribute("msg","�α��� �Ǿ����ϴ�!");
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			RequestDispatcher dis = request.getRequestDispatcher("/soe/LoginSuccess.jsp");
			dis.forward(request, response);
			return;
		}else if(result==-1) {
			request.setAttribute("msg","��й�ȣ Ʋ�Ƚ��ϴ�!");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/LoginError.jsp");
			dis.forward(request, response);
			return;
		}else if(result==0) {
			request.setAttribute("msg","���� ID�Դϴ� ȸ�������� ���� �����ϼ���!!");
			RequestDispatcher dis = request.getRequestDispatcher("/soe/LoginError.jsp");
			dis.forward(request, response);
			return;
		}
		
	}

}
