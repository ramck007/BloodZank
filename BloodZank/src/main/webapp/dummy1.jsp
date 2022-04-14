<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="logindiv">
        <form action="">
            <h2>Never feel weak, you have the ability to save a life. Just donate blood</h2>
            <h3>Blood donation will cost you nothing, but it will save a life!</h3>
            <h4>Thanks ! for Donating Blood!</h4>
             <a href="#default" class="logo"><img class="logo" src="img/Logo1.png" style="height: 200px; width: 200px;"></a>
             
            <table align="center">
                <tr><td align="right"><strong>Blood Group : </strong></td><td>
                    <label for="Blood Group" placeholder="blood group"  ></label>
                        <select name="bloodgroup" id="BloodGroup" >
                            <option value="0">Select</option>
                            <option value="A+">A+</option>
                            <option value="B+">B+_</option>
                            <option value="O+">O+</option>
                            <option value="AB+">AB+</option>
                            <option value="O-">O-</option>
                            <option value="A-">A-</option>
                            <option value="AB-">AB-</option>
                            <option value="B-">B-</option>
                        </select>
                </td></tr>
                <tr><td align="right"><strong>Location : </strong></td><td>
                	<!--<input type="text" name="location" required="required">-->
                	<label for="location" placeholder="district"  ></label>
                        <select name="district" id="location">
                            <option value="0">Select</option>
                            <option value="tirunelveli">Tirunelveli</option>
                            <option value="tenkasi">Tenkasi</option>
                            <option value="tuticorin">Tuticorin</option>
                            <option value="madurai">Madurai</option>
                    	</select>
                </td></tr>

            </table>
        
            
        </form>
        <button onclick="GetDonor()">Get Donor</button>
    </div>
<div id="tab" style="display:none ">
<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "bloodzank";
String userId = "root";
String password = "1234";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Name</b></td>
<td><b>Aadhar_id</b></td>
<td><b>Email</b></td>
<td><b>BloodGroup</b></td>
<td><b>Date</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM bloodzank";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("uname") %></td>
<td><%=resultSet.getString("aadhar") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("bloodgrp") %></td>
<td><%=resultSet.getString("date") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</div>
<script>
        function GetDonor(){
        	//e.preventDefault();
            var x= document.getElementById("tab");
            let bg=document.getElementById("BloodGroup").value;
            let loc=document.getElementById("location").value;
            console.log(bg);
            console.log(loc);
            if(x.style.display==="none"){
                x.style.display="block";
            }
            else{
                x.style.display="none";
            }
        }
        
    </script>
</body>
</html>