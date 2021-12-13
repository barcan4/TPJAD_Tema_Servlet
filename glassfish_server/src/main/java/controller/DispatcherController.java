package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        System.out.println(action);

        if ((action != null) && action.equals("add")) {
            resp.sendRedirect("add.jsp");
        }

        if ((action != null) && action.equals("update")) {
            int index = Integer.parseInt(req.getParameter("index"));
            String name = req.getParameter("name");
            String type = req.getParameter("type");
            double price = Double.parseDouble(req.getParameter("price"));
            resp.sendRedirect(req.getContextPath() + "/update.jsp?index=" + index
                + "&name=" + name + "&type=" + type + "&price=" + price);
        }

        if ((action != null) && action.equals("delete")) {
            int index = Integer.parseInt(req.getParameter("index"));
            System.out.println(index);
            resp.sendRedirect(req.getContextPath() + "/delete.jsp?index=" + index);
        }

        if ((action != null) && action.equals("addIns")) {
            InstrumentController instrumentController = (InstrumentController) req.getSession().getAttribute("insController");
            instrumentController.add(req.getParameter("nume"),
                    req.getParameter("tip"),
                    Double.parseDouble(req.getParameter("pret")));
            resp.sendRedirect(req.getContextPath() + "");
        }

        if ((action != null) && action.equals("cancelDelete")) {
            resp.sendRedirect(req.getContextPath() + "");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ((action != null) && action.equals("deleteIns")) {
            int index = Integer.parseInt(req.getParameter("id"));

            InstrumentController instrumentController = (InstrumentController) req.getSession().getAttribute("insController");
            instrumentController.delete(index);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(req, resp);
        }

        if ((action != null) && action.equals("updateIns")) {
            int index = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("nume");
            String type = req.getParameter("tip");
            double price = Double.parseDouble(req.getParameter("pret"));

            InstrumentController instrumentController = (InstrumentController) req.getSession().getAttribute("insController");
            instrumentController.update(index, name, type, price);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(req, resp);
        }
    }
}
