package com.example.appartmentsapplication;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@WebServlet(name = "SearchApartmentsServlet", value = "/SearchApartmentsServlet")
public class SearchApartmentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/main.jsp");
        PrintWriter out = response.getWriter();

        try{
            String area = request.getParameter("surfaceArea");
            String price = request.getParameter("monthlyRent");
            String apartmentCity = request.getParameter("city");
            if(!(checkInputIfNumber(area) && checkInputIfNumber(price))){
                out.println("<font color=red> You have either entered an invalid area or price field!</font><br>");
            }
            if(apartmentCity.equals("none")){
                out.println("<font color=red> You have not enter the city field!</font><br>");
            }
            double apartmentArea = Double.parseDouble(area);
            double apartmentPrice = Double.parseDouble(price);
            ArrayList<Apartment> listOfSearchedApartments = this.searchForApartmentInList(apartmentArea, apartmentPrice, apartmentCity);

            if (!listOfSearchedApartments.isEmpty()){
                request.setAttribute("apartments_list", listOfSearchedApartments);
            } else {
                out.println("<font color=red>There are no apartments fulfilling these requirements!!</font><br>");
            }
        } catch (NumberFormatException e) {
            out.println("<font color=red>Incorrect number formats!!</font><br>");

        }finally {
            requestDispatcher.include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected boolean checkInputIfNumber(String userInput){
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }


    public ArrayList<Apartment> searchForApartmentInList(double area, double price, String city) throws IOException{
        ServletContext context = getServletContext();
        ArrayList<Apartment> allApartments =  ApartmentDAO.readApartmentsFromFile(context);
        List<Apartment> filteredApartments = allApartments.stream()
                .filter(apartment -> apartment.getSurfaceArea() >= area)
                .filter(apartment -> apartment.getMonthlyRent() >= price)
                .filter(apartment -> apartment.getCity().equals(Cities.valueOf(city)))
                .collect(Collectors.toList());
        return (ArrayList<Apartment>) filteredApartments;
    }
}
