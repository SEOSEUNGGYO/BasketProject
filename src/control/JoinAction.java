package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDAO;
import user.UserDTO;


@SuppressWarnings("serial")
@WebServlet("/JoinAction.do")
public class JoinAction extends HttpServlet {
	
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
		String user_email = request.getParameter("user_email");
		String user_phone = request.getParameter("user_phone");
		String user_name = request.getParameter("user_name");
		String user_birth = request.getParameter("user_birth");
		
		
		if(user_id==null||user_id.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(user_password==null||user_password.equals("")) {
			request.setAttribute("msg"," NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(user_email==null||user_email.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(user_phone==null||user_phone.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(user_name==null||user_name.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		if(user_birth==null||user_birth.equals("")) {
			request.setAttribute("msg","NotInsert");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		
		UserDTO userDTO = new UserDTO(user_id,user_password,user_email,user_phone,user_name,user_birth);
		UserDAO userDAO = new UserDAO();
		
		int result = userDAO.join(userDTO);
		
		if(result==1) {
			request.setAttribute("msg","JoinSuccess");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}else {
			request.setAttribute("msg","JoinFail");
			RequestDispatcher dis = request.getRequestDispatcher("process.jsp");
			dis.forward(request, response);
			return;
		}
		
	}

}
