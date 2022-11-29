/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import pl.polsl.lab.model.OrderNotFoundException;
import pl.polsl.lab.model.OrdersList;

/**
 * Servlet class of the application responsible for deleting orders.
 *
 * @author Oliwia Gowor
 * @version 4.0
 */
@WebServlet("/deleteOrder")
public class deleteOrderServlet extends HttpServlet {

    /**
     * Parameter repsresenting list of orders.
     */
    private OrdersList ordersList;

    @Override
    public void init() {
        ordersList = (OrdersList) getServletContext().getAttribute("ordersList");
        if (ordersList == null) {
            getServletContext().setAttribute("ordersList", new OrdersList());
            ordersList = (OrdersList) getServletContext().getAttribute("ordersList");
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();

        Object reqAtr = request.getSession().getAttribute("logged");
        if (reqAtr == null) {
            response.sendRedirect("login.html");
        }
        String orderNumber = request.getParameter("orderNumber");

        try {
            ordersList.deleteOrder(orderNumber);
        } catch (OrderNotFoundException ex) {
            response.sendError(response.SC_BAD_REQUEST, ex.getMessage());
        }

        out.println("<head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <link rel=\"stylesheet\" href=\"css/main.css\"> \n"
                + "        <title>Deleted order</title>\n"
                + "        <script type=\"text/javascript\" src=\"js/ajax.js\"></script> \n"
                + "\n"
                + "    </head>");
        out.println("<body>\n"
                + "        <div class = \"navbar\"> \n"
                + "        <a href=\"/WebLab3/showAllOrders.html\"><button>Back</button></a> \n"
                + "        </div> \n"
                + "        <main> \n"
                + "        <h1>Successfully deleted order!</h1> \n"
                + "        </main> \n"
                + "        </body>\n"
                + "</html>");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
