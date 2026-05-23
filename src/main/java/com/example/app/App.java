package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class App extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        String operation = request.getParameter("operation");

        int result = 0;

        if(operation.equals("add")) {
            result = num1 + num2;
        }
        else if(operation.equals("sub")) {
            result = num1 - num2;
        }
        else if(operation.equals("mul")) {
            result = num1 * num2;
        }
        else if(operation.equals("div")) {
            result = num1 / num2;
        }

        out.println("<html><body>");
        out.println("<h1>Calculator Result</h1>");
        out.println("<h2>Result = " + result + "</h2>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<h1>Calculator App</h1>");

        out.println("<form method='post' action='calculator'>");

        out.println("Number 1: <input type='number' name='num1'><br><br>");

        out.println("Number 2: <input type='number' name='num2'><br><br>");

        out.println("<select name='operation'>");
        out.println("<option value='add'>Addition</option>");
        out.println("<option value='sub'>Subtraction</option>");
        out.println("<option value='mul'>Multiplication</option>");
        out.println("<option value='div'>Division</option>");
        out.println("</select><br><br>");

        out.println("<input type='submit' value='Calculate'>");

        out.println("</form>");

        out.println("</body></html>");
    }
}
