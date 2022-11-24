/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.pols.lab.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import pl.polsl.lab.model.Order;
import pl.polsl.lab.model.OrdersList;

/**
 *
 * @author Oliwia
 */
@WebServlet("/showAllOrders")
public class ShowAllOrdersServlet extends HttpServlet {

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
        String number = request.getParameter("number");

        boolean showAll = number == null || number.length() == 0;
        PrintWriter out = response.getWriter();
        for (Order order : ordersList.getOrdersList()) {
            if (showAll || order.getNumber().contains(number)) {
                int rowspan = order.getProducts().size();
                out.println("<tr>");
                out.println(String.format("<td rowspan = %s>", rowspan));
                out.println(order.getNumber());
                out.println("</td>");
                out.println(String.format("<td rowspan = %s>", rowspan));
                out.println(order.getBuyer().toString());
                out.println("</td>");
                out.println(String.format("<td rowspan = %s>", rowspan));
                out.println(order.getOrderDate().toString());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getProductName());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getPriceNetto());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getQuantinity());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getUnit());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getValueNetto());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getVatRate());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getValueVat());
                out.println("</td>");
                out.println("<td>");
                out.println(order.getProducts().get(0).getValueBrutto());
                out.println("</td>");
                out.println(String.format("<td rowspan = %s>", rowspan));
                out.println(order.getPaymentMethod());
                out.println("</td>");
                out.println(String.format("<td rowspan = %s>", rowspan));
                out.println(order.getSumNetto());
                out.println("</td>");
                out.println(String.format("<td rowspan = %s>", rowspan));
                out.println(order.getSumVat());
                out.println("</td>");
                out.println(String.format("<td rowspan = %s>", rowspan));
                out.println(order.getSumBrutto());
                out.println("</td>");
                out.println("</tr>");
                
                if (order.getProducts().size() > 1) {
                    for (int i = 1; i < order.getProducts().size(); i++) {
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getProductName());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getPriceNetto());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getQuantinity());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getUnit());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getValueNetto());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getVatRate());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getValueVat());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(order.getProducts().get(i).getValueBrutto());
                        out.println("</td>");
                        out.println("</tr>");
                    }
                }
            }
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
