package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.feedbackDao;
import cn.techtutorial.model.Cart;
import cn.techtutorial.model.User;

/**
 * Servlet implementation class feedbackServlet
 */
@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {
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
					 int typeOfProblem = Integer.parseInt(request.getParameter("select"));
					 String Text = request.getParameter("inputText");
					 int user_id = auth.getId();
					 feedbackDao fDao =new feedbackDao(DbCon.getConnection());
					 fDao.insertContent(Text, user_id, typeOfProblem);
					 response.sendRedirect("index.jsp");
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
