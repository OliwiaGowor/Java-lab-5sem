/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.jpa;

import entities.Model;
import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet class of the application responsible for adding new and showing all
 * products.
 *
 * @author Oliwia Gowor
 * @version 5.0
 */
@WebServlet("/showAllProducts")
public class ShowAllProductsServlet extends HttpServlet {

    /**
     * Parameter repsresenting list of orders.
     */
    public static List<Product> products;
    /**
     * Parameter repsresenting list of orders.
     */
    private Model model;

    /**
     * Method initalizes servlet.
     */
    @Override
    public void init() {
        products = new ArrayList();
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
        String productName = request.getParameter("productName");

        Product tmpProduct = new Product(productName, Double.parseDouble(request.getParameter("priceNetto")),
                Product.VatRate.valueOf(request.getParameter("vatRate")), Integer.parseInt(request.getParameter("quantinity")),
                request.getParameter("unit"));
        PrintWriter out = response.getWriter();

        products.add(tmpProduct);

        for (Product product : products) {
            out.println("<td>");
            out.println(product.getProductName());
            out.println("</td>");
            out.println("<td>");
            out.println(product.getPriceNetto());
            out.println("</td>");
            out.println("<td>");
            out.println(product.getQuantinity());
            out.println("</td>");
            out.println("<td>");
            out.println(product.getUnit());
            out.println("</td>");
            out.println("<td>");
            out.println(product.getValueNetto());
            out.println("</td>");
            out.println("<td>");
            out.println(product.getVatRate());
            out.println("</td>");
            out.println("<td>");
            out.println(product.getValueVat());
            out.println("</td>");
            out.println("<td>");
            out.println(product.getValueBrutto());
            out.println("</td>");
            out.println("</tr>");
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
