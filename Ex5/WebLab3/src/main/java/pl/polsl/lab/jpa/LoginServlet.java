/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.lab.jpa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import entities.User;
import entities.UsersList;

/**
 * Servlet class of the application responsible for controlling log in
 * operation.
 *
 * @author Oliwia Gowor
 * @version 5.0
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    /**
     * Parameter repsresenting list of users.
     */
    private UsersList usersList;

    /**
     * Method initalizes servlet.
     */
    @Override
    public void init() {
        usersList = (UsersList) getServletContext().getAttribute("usersList");
        if (usersList == null) {
            getServletContext().setAttribute("usersList", new UsersList());
            usersList = (UsersList) getServletContext().getAttribute("usersList");
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (request.getSession().getAttribute("logged") == null) {
            for (User user : usersList.getUsersList()) {
                if (username.equals(user.getUsername())) {
                    if (password.equals(user.getPassword())) {
                        request.getSession().setAttribute("logged", "true");
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
                                + "        <h1>Successfully logged in!</h1> \n"
                                + "        </main> \n"
                                + "        </body>\n"
                                + "</html>");
                        return;

                    } else {
                        response.sendError(response.SC_BAD_REQUEST, "Wrong password!");
                    }
                }
            }
            response.sendError(response.SC_BAD_REQUEST, "Wrong username!");

        } else {
            response.sendError(response.SC_BAD_REQUEST, "You are already logged in!");
        }
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
    }// </editor-fold>

}
