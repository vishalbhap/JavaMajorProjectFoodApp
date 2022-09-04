package com.cybage.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.excel.RestaurantExcelExporter;
import com.cybage.excel.UserExcelExporter;
import com.cybage.model.Restaurant;
import com.cybage.model.User;
import com.cybage.model.UserOrder;
import com.cybage.service.RestaurantService;
import com.cybage.service.UserOrderService;
import com.cybage.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private UserOrderService userOrderService;

	@GetMapping("/usersData")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		List<User> listUser = userService.findAllUsers();
		UserExcelExporter excelExporter = new UserExcelExporter(listUser);
		excelExporter.export(response);
	}

	@GetMapping("/restaurantData")
	public void exportToExcelRestaurant(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Restaurant> listRestaurant = restaurantService.findAllRestaurants();

		RestaurantExcelExporter excelExporter = new RestaurantExcelExporter(listRestaurant);

		excelExporter.export(response);
	}

//	 @GetMapping("/Orders/export/excel")
//	    public void exportToExcelOrder(HttpServletResponse response) throws IOException {
//	        response.setContentType("application/octet-stream");
//	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//	        String currentDateTime = dateFormatter.format(new Date());
//	         
//	        String headerKey = "Content-Disposition";
//	        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
//	        response.setHeader(headerKey, headerValue);
//	         Restaurant restaurant=null;
//	        List<UserOrder> listOrder = userOrderService.getAllOrdersssss();
//	         
//	        OrderExcelExporter excelExporter = new OrderExcelExporter(listOrder);
//	         
//	        excelExporter.export(response);    
//	    }
}
