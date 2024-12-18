/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Services;

import Model.GenericList;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Kamil
 */
@WebServlet("/InitializationServlet")
public class InitializationServlet extends HttpServlet {

    @Override
    public void init() {
        
        var context = getServletContext();        
        GenericList model = (GenericList)context.getAttribute("GenericList");
        if(model == null) {
            //context.setAttribute("DataSource", new People());
            context.setAttribute("GenericList", new GenericList());
        }
        
    }   
}
