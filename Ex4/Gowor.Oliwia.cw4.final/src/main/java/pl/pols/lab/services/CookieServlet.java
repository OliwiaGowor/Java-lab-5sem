/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.pols.lab.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet class of the application responsible for controlling cookie operation
 * @author Aleksandra Tlałka
 * @version 4.1 
 */
@WebServlet("/Cookie")
public class CookieServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookies = request.getCookies();
            String lastAdded = "never";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("lastAdded")) {
                        lastAdded = cookie.getValue();
                        break;
                    }
                }
            }

    }
}
