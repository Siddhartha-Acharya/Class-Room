<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success massage</title>
<style>
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.left {
  transform: rotate(135deg);
  -webkit-transform: rotate(135deg);
}
</style>
</head>
<body>
<center>
  <div class="alert alert-success">
   <strong><%=request.getAttribute("message1")%></strong></br>
  <button class="button" class="arrow left"><a href="studentprofile.jsp">Back to home</a></button>
  </div>
 </center>
 </body>
 </html>