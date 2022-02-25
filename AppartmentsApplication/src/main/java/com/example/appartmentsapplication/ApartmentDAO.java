package com.example.appartmentsapplication;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ApartmentDAO {

    public static ArrayList<Apartment> readApartmentsFromFile(ServletContext context) {
        ArrayList<Apartment> apartmentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResourceAsStream("/WEB-INF/listOfApartments.txt")))){
            String lineOfFile;
            while ((lineOfFile = reader.readLine()) != null) {
                String[] detailsOfApartment = lineOfFile.split(",");
                Apartment apartment = new Apartment(Double.parseDouble(detailsOfApartment[0]), Double.parseDouble(detailsOfApartment[1]), Cities.valueOf(detailsOfApartment[2]));
                apartmentList.add(apartment);
            }
        } catch (IOException e) {
            System.out.println("An error occurred, " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("An error occured, " + e.getMessage());
        }
        return apartmentList;
    }
}


