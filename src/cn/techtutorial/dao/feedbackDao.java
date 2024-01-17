package cn.techtutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.techtutorial.model.Order;

public class feedbackDao {
		
		private Connection con;

		private String query;
	    private PreparedStatement pst;
	    private ResultSet rs;

		public feedbackDao(Connection con) {
			super();
			this.con = con;
		}
		
		public boolean insertContent(String text, int user_id, int problem_id) {
	        boolean result = false;
	        try {
	            query = "insert into feedback (text, user_id, problem_id) values(?,?,?)";
	            pst = this.con.prepareStatement(query);
	            pst.setString(1, text);
	            pst.setInt(2, user_id);
	            pst.setInt(3, problem_id);
	            
	            pst.executeUpdate();
	            result = true;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return result;
	    }
}
