package view;

import controller.InstrumentController;
import domain.Instrument;
import repo.Repo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class viewHTML extends HttpServlet {
    private InstrumentController instrumentController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            instrumentController = (InstrumentController) req.getAttribute("controller");
        }
        catch (Exception e) {
            System.out.println("Eroare la receptionarea controllerului");
        }
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<style = 'text/css'>" +
                "table, th, td {" +
                "   border: 1px solid black;" +
                "}" +
                "table {" +
                "   width: 10%;" +
                "   margin-left: 100px;" +
                "   margin-bottom: 15px;" +
                "}" +
                "#add {" +
                "   margin-left: 100px;" +
                "}" +
                "</style>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>" + "Name" + "</th>");
        out.println("<th>" + "Type" + "</th>");
        out.println("<th>" + "Price" + "</th>");
        out.println("</tr>");
        for (Instrument ins: instrumentController.getAll()) {
            out.println("<form method='GET' action='/dispatcher'>");
            out.println("<tr>");
            out.println("<input type='hidden' name='index' value='" + ins.getId() + "'>");
            out.println("<td>" + "<input type='text' name='nume' value='"+ins.getName() +"'>" + "</td>");
            out.println("<td>" + "<input type='text' name='type' value='"+ins.getType() +"'>" + "</td>");
            out.println("<td>" + "<input type='text' name='pret' value='"+ins.getPrice() +"'>" + "</td>");
            out.println("<td>" + "<input type='submit' name='updateBtn' value='Update'>" + "</td>");
            out.println("<td>" + "<input type='submit' name='deleteBtn' value='Delete'>" + "</td>");
            out.println("</tr>");
            out.println("</form>");
        }
        out.println("</table>");
        out.println("<form method='GET' action='/add'>");
        out.println("<input id='add' type='submit' value='Add an Instrument'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
