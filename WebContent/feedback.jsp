<%@page import="cn.techtutorial.connection.DbCon"%>
<%@page import="cn.techtutorial.dao.ProductDao"%>
<%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Shop</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

<form action="feedback" method="post" class="form-inline">
<div class="container">
		<div class="card-header my-3">Feedback</div>
		<div class="row">
		<select name="select" class="form-control">
		<option value="1">Order problem</option>
		<option value="2">Paying problem</option>
		<option value="3">Other problem</option>
				</select> 
				<div class="form-group">
    <label for="exampleInputEmail1"></label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name= "inputText" placeholder="Explain your problem">
    
  </div>
  <button type="submit" class="btn btn-primary">Send</button>
  </div>
	</div>
  
</form>

	<%@include file="/includes/footer.jsp"%>
	
</body>
</html>