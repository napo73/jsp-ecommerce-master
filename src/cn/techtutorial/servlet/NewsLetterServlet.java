package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.NewsLetterDao;
import cn.techtutorial.dao.feedbackDao;
import cn.techtutorial.model.User;

/**
 * Servlet implementation class NewsLetterServlet
 */
@WebServlet("/newsletter")
public class NewsLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		 try (PrintWriter out = response.getWriter()) {
			 HttpSession session = request.getSession();
			 User auth = (User) session.getAttribute("auth");
					 if(auth!=null) {
						 String isOn = request.getParameter("notification");
						 if (isOn.equals("on")) {
							 String letter_text = "Here we are!";
							 String user_mail = auth.getEmail();
							 int user_id = auth.getId();
							 NewsLetterDao NLDao =new NewsLetterDao(DbCon.getConnection());
							 NLDao.insertContent(letter_text, user_mail, user_id);
							 response.sendRedirect("index.jsp");
						 }
						 
					 }
					 else {
						 response.sendRedirect("login.jsp");
					 }
			 		} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	}

}
