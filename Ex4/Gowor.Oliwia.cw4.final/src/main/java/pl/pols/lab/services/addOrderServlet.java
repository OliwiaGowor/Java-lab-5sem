/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.util.ArrayList;
import java.util.List;
import pl.polsl.lab.model.Order;
import pl.polsl.lab.model.OrdersList;
import pl.polsl.lab.model.Product;

/**
 *
 * @author oliwia
 */
@WebServlet("/addOrder")
public class addOrderServlet extends HttpServlet{
    
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

        List<Product> products = new ArrayList();
        String productName = request.getParameter("inputProductName");
        double priceNetto = Double.parseDouble(request.getParameter("inputPriceNetto"));
        int quantinity = Integer.parseInt(request.getParameter("inputQuantinity"));
        String unit = request.getParameter("inputUnit");
        Product.VatRate vatRate = Product.VatRate.valueOf(request.getParameter("vat"));
        products.add(new Product(productName, priceNetto, vatRate, quantinity, unit));
        
        
        
        String date = request.getParameter("orderDate");
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        
        /*for (Order order : ordersList.getOrdersList()) {
            if (order.getYear() == year) {
                if (order.getMonth() == month) {
                    if (order.getDay() == day) {
                        order.addEvent(new Event(model.countEvents(tmpDay.getListOfEvents()), note, type));
                        Cookie cookie = new Cookie("lastAdded", date);
                        response.addCookie(cookie);
                    }
                }
            }
        }*/
        
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
