package com.java.rest;

import java.sql.SQLException;
import java.util.Scanner;


public class RestaurantSearchMain {
public static void main(String[] args) {
	int restaurantid;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter RestaurantId");
	restaurantid=sc.nextInt();
	RestaurantDAO dao=new RestaurantDAO();
	try {
		RestaurantDetails restaurant = dao.searchrestaurant(restaurantId);
		if (restaurant!=null) {
			System.out.println(restaurant);
		} else {
			System.out.println("*** Record Not Found ***");
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}



