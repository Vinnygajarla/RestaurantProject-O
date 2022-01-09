package com.java.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RestaurantDAO {
	Connection connection;
	PreparedStatement pst;

	public List<RestaurantDetails> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<RestaurantDetails> restaurantList = new ArrayList<RestaurantDetails>();
		RestaurantDetails restaurant = null; 
		while(rs.next()) {
			restaurant = new RestaurantDetails();
			restaurant.setRestaurantId(rs.getInt("restaurantid"));
			restaurant.setRestaurantName(rs.getString("restaurantname"));
			restaurant.setCity(rs.getString("city"));
			restaurant.setBranch(rs.getString("branch"));
			restaurant.setEmail(rs.getString("email"));
			restaurant.setContactno(rs.getInt("contactno"));
			restaurantList.add(restaurant);
		}
		return restaurantList ;
}
}