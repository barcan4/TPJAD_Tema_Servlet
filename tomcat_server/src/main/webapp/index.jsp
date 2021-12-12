<%@ page import="controller.InstrumentController" %>
<%@ page import="repo.Repo" %>
<%@ page import="domain.Instrument" %><%--
  Created by IntelliJ IDEA.
  User: Barcoaie
  Date: 29.11.2021
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% final InstrumentController instrumentController = new InstrumentController(new Repo());%>
<!DOCTYPE html>
<html>
  <head>
    <title>View Page</title>
  </head>
  <body>
  <style type='text/css'>
    table, th, td {
      border: 1px solid black;
    }
    table {
      width: 10%;
      margin-left: 100px;
      margin-bottom: 15px;
    }
    #add {
      margin-left: 100px;
    }
  </style>
  <table>
    <tr>
      <th>Name</th>
      <th>Type</th>
      <th>Price</th>
    </tr>
    <%
      for (Instrument ins : instrumentController.getAll()) {
        %>
    <form action="DispatcherController" method="POST">
      <tr>
        <input type="hidden" name="index" value="<%=ins.getId()%>">
        <td><input type="text" name="name" value="<%=ins.getName()%>" readonly></td>
        <td><input type="text" name="type" value="<%=ins.getType()%>" readonly></td>
        <td><input type="text" name="price" value="<%=ins.getPrice()%>" readonly></td>
        <td><input type="submit" name="updateBtn" value="Update"></td>
        <td><input type="submit" name="deleteBtn" value="Delete"></td>
      </tr>
    </form>
    <%
      }
    %>
  </table>
  <form method="GET" action="DispatcherController">
    <input id="add" type="submit" value="Add an Instrument">
  </form>
  </body>
</html>
