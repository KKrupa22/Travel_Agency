/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Services;

import Model.*;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kamil
 */
@WebServlet("/BudgetServlet")
public class BudgetServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = request.getServletContext();
        GenericList model = (GenericList)context.getAttribute("GenericList");         
        PrintWriter out = response.getWriter();
        
        double budget = Double.parseDouble(request.getParameter("budget"));
        List<Trip> data = new ArrayList();
        
        try {
            for(int i = 0; i < model.size(); i++) {
                if(budget >= model.get(i).getPrice()) {
                    data.add(model.get(i));
                }
            }
        } catch (OutOfBoundsException ex) {
            out.println(ex.toString());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        
        for(Trip trip : data){
            out.println("<tr>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"Country"+trip.getId()+"\" name=\"country"+trip.getId()+"\" placeholder=\"Country\" value=\""+ trip.getCountry() + "\"readonly/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"City"+trip.getId()+"\" name=\"city"+trip.getId()+"\" placeholder=\"City\" value=\""+ trip.getPlace()+ "\"readonly/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"DepCity"+trip.getId()+"\" name=\"depCity"+trip.getId()+"\" placeholder=\"DepCity\" value=\""+ trip.getDepPlace() + "\"readonly/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"number\" id=\"Price"+trip.getId()+"\" name=\"price"+trip.getId()+"\" value=\"" + trip.getPrice() +"\"readonly/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"Date"+trip.getId()+"\" name=\"date"+trip.getId()+"\" value=\"" + trip.getDate() +"\"readonly/>");
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
