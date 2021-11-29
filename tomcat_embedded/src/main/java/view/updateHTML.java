package view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class updateHTML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String nume = "";
        String type = "";
        double pret = 0.0;
        int index = 0;

        try {
            nume = req.getParameter("nume");
            type = req.getParameter("type");
            pret = Double.parseDouble(req.getParameter("pret"));
            index = Integer.parseInt(req.getParameter("index"));
        }
        catch (Exception e) {
            System.out.println("Eroare la receptionare date la actualizare");
        }


        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form method='GET' action='/dispatcher'>");
        out.println("<input type='hidden' name='actiune' value='2'>");
        out.println("<input type='hidden' name='id' value='" + index + "'>");
        out.println("Name of the Instrument: <input type='text' name='nume' value='" + nume + "'>");
        out.println("Type of the Instrument: <input type='text' name='type' value='" + type + "'>");
        out.println("Price of the Instrument: <input type='text' name='pret' value='" + pret + "'>");
        out.println("<input type='submit' value='Actualizeaza'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
