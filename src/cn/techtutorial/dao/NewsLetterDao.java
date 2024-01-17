package cn.techtutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.techtutorial.model.Order;

public class NewsLetterDao {
		
		private Connection con;

		private String query;
	    private PreparedStatement pst;
	    private ResultSet rs;

		public NewsLetterDao(Connection con) {
			super();
			this.con = con;
		}
		
		public boolean insertContent(String letter_text, String user_mail, int user_id) {
	        boolean result = false;
	        try {
	            query = "insert into newsletter (letter_text, user_mail, user_id) values(?,?,?)";
	            pst = this.con.prepareStatement(query);
	            pst.setString(1, letter_text);
	            pst.setString(2, user_mail);
	            pst.setInt(3, user_id);
	            
	            pst.executeUpdate();
	            result = true;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return result;
	    }
}
