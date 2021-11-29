package view;

import controller.InstrumentController;
import repo.Repo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class dispatcherHTML extends HttpServlet {
    private final InstrumentController instrumentController = new InstrumentController(new Repo());

    protected void procReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int actiune = 0;
        String actiuneView = "";
        int addFlag = 0;
        int updateFlag = 0;
        int deleteFlag = 0;
        String nume = "";
        String type = "";
        double pret = 0.0;
        int index = 0;

        try {
            if (req.getParameter("deleteBtn").equals("Delete")) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/delete");
                rd.forward(req, resp);
                return;
            }
        }
        catch (Exception e) {
            System.out.println("Eroare la trimiterea cererii catre stergere!" + "\n" + e.getMessage());
            actiuneView = "";
        }

        try {
            if (req.getParameter("addBtn").equals("Add")) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/add");
                rd.forward(req, resp);
                return;
            }
        }
        catch (Exception e) {
            System.out.println("Eroare la trimiterea cererii catre adaugare!" + "\n" + e.getMessage());
            actiuneView = "";
        }


            try {

            if (req.getParameter("updateBtn").equals("Update")) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/update");
                rd.forward(req, resp);
                return;
            }
        } catch (Exception e) {
            System.out.println("Eroare la trimiterea cererii catre actualizare!" + "\n" + e.getMessage());
            actiuneView = "";
        }

        try {
            actiune = Integer.parseInt(req.getParameter("actiune"));
        }
        catch (Exception e) {
            System.out.println("Eroare la receptionarea raspunsului catre dispatcher!\n" + e.getMessage());
        }
        switch (actiune) {
            case 1:
                addFlag = 1;
                break;
            case 2:
                updateFlag = 1;
                break;
            case 3:
                deleteFlag = 1;
                break;
            default:
                break;
        }
        if (addFlag == 1) {
            try {
                nume = req.getParameter("nume");
                type = req.getParameter("tip");
                pret = Double.parseDouble(req.getParameter("pret"));
                instrumentController.add(nume, type, pret);
            }
            catch (Exception e) {
                System.out.println("Eroare la adaugare!\n" + e.getMessage());
            }
        }

        if (updateFlag == 1) {
            try {
                nume = req.getParameter("nume");
                type = req.getParameter("type");
                pret = Double.parseDouble(req.getParameter("pret"));
                index = Integer.parseInt(req.getParameter("id"));
                instrumentController.update(index, nume, type, pret);
            }
            catch (Exception e) {
                System.out.println("Eroare la update!\n" + e.getMessage());
            }
        }

        if (deleteFlag == 1) {
            try {
                index = Integer.parseInt(req.getParameter("id"));
                instrumentController.delete(index);
            }
            catch (Exception e) {
                System.out.println("Eroare la stergere!\n" + e.getMessage());
            }
        }

        req.setAttribute("controller", instrumentController);

        System.out.println("actiuneView: " + actiuneView);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view");
        requestDispatcher.forward(req, resp);
        return;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        procReq(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        procReq(req, resp);
    }
}
