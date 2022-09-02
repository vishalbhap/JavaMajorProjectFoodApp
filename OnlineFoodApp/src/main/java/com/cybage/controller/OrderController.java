package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.OrderContentDTO;
import com.cybage.exception.CustomException;
import com.cybage.model.Restaurant;
import com.cybage.model.User;
import com.cybage.model.UserOrder;
import com.cybage.service.RestaurantService;
import com.cybage.service.UserOrderService;
import com.cybage.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/order")
public class OrderController {
	
//	static Logger logger=LogManager.getLogger(OrderController.class);
//
//	@Autowired
//	OrderInfoService orderService;
//
	@Autowired
	UserOrderService userOrderService;

	@Autowired
	UserService userService;

	@Autowired
	RestaurantService restaurantService;

//	@Autowired
//	SmsService smsService;
//
//	@GetMapping("/getAllOrdersForRestaurant/{restaurantId}")
//	public ResponseEntity<?> getAllOrdersForRestaurant(@PathVariable int restaurantId) {
//		System.out.println("Vishal1");
//		Restaurant restaurant = restaurantService.findByRestaurantId(restaurantId);
//		System.out.println("Vishal2");
//		List<UserOrder> orders = userOrderService.getAllOrders(restaurant);
//		System.out.println("Vishal3");
//		System.out.println(orders);
//		if (orders != null) {
//			System.out.println("Vishal5");
//			return new ResponseEntity<>(orders, HttpStatus.OK);
//		}			
//		System.out.println("Vishal4");
//		return new ResponseEntity<>("OrderList is Empty", HttpStatus.NOT_ACCEPTABLE);
//	}
	
	

	@GetMapping("/getAllOrdersForRestaurant/{restaurantId}")
	public ResponseEntity<?> getAllOrdersForRestaurant(@PathVariable int restaurantId) {
		Restaurant restaurant = restaurantService.findByRestaurantId(restaurantId);
		List<UserOrder> orders = userOrderService.getAllOrders(restaurant);
		System.out.println(orders);
		if (orders != null) {	
			return new ResponseEntity<>(orders, HttpStatus.OK);
		}			
		System.out.println("Vishal4");
		return new ResponseEntity<>("OrderList is Empty", HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/getAllOrdersForUser/{userId}")
	public ResponseEntity<?> getAllOrdersForUser(@PathVariable int userId) throws CustomException {
//		System.out.println(userId);

//		User user = userService.findByUser(userId);
		List<UserOrder> orders = userService.findByUser(userId);
//		List<UserOrder> orders = userOrderService.getAllOrderForUser(user);
		// System.out.println(orders);
		 if(orders.size()==0){
		 throw new CustomException("no order found");
		 }
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

//	@GetMapping("/getOrderDetails/{orderId}")
//	public ResponseEntity<?> getOrderDetails(@PathVariable int orderId) {
//		List<OrderInfo> orderDetails = orderService.getOrderDetails(orderId);
//		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
//	}

//	@PostMapping("/place-order")
//	public ResponseEntity<?> placeOrder(@RequestBody OrderContentDTO orderContent) {
//		UserOrder userOrder = new UserOrder();
//		UserOrder order = userOrderService.save(userOrder, orderContent.getTotal(),
//				orderContent.getFoodMenus().get(0).getRestaurant(), orderContent.getUser());
////		smsService.sendSMS(orderContent.getUser().getUserMobileNo()); //sending sms
//		// on user mobile number
//		for (FoodMenus foodItem : orderContent.getFoodMenus()) {
//			orderService.saveFoodItems(foodItem, order, foodItem.getQuantity());
//		}
//		logger.info("Customer "+orderContent.getUser().getUserName()+"Placed Order");
//		return new ResponseEntity<>(order, HttpStatus.OK);
//	}
	
	@PostMapping("/place-order")
	public ResponseEntity<?> placeOrder(@RequestBody OrderContentDTO orderContent) {
		UserOrder userOrder = new UserOrder();
		UserOrder order = userOrderService.save(userOrder, orderContent.getTotal(),
				orderContent.getFoodMenus().get(0).getRestaurant(), orderContent.getUser());
//		smsService.sendSMS(orderContent.getUser().getUserMobileNo()); //sending sms
		// on user mobile number
//		for (FoodMenus foodItem : orderContent.getFoodMenus()) {
//			orderService.saveFoodItems(foodItem, order, foodItem.getQuantity());
//		}
//		logger.info("Customer "+orderContent.getUser().getUserName()+"Placed Order");
		return new ResponseEntity<>(order, HttpStatus.OK); 
	}
	
	@PostMapping("/place-orderSimple")
	public ResponseEntity<?> placeOrderSimple(@RequestBody UserOrder userOrderSimple) {
		System.out.println("VishalOrderSimple1");
		UserOrder order = userOrderService.saveOrderSimple(userOrderSimple);		
		return new ResponseEntity<>(order, HttpStatus.OK); 
	}

//	@PutMapping("/updateOrderStatus/{orderStatus}/{orderId}")
//	public ResponseEntity<?> updateOrderStatus(@PathVariable int orderId, @PathVariable String orderStatus) {
//		UserOrder userOrder = userOrderService.findUserOrderByOrderId(orderId);
//		userOrder.setOrderStatus(orderStatus);
//		userOrderService.save(userOrder);
//		return new ResponseEntity<>("updated", HttpStatus.OK);
//
//	}
	
	@PutMapping("/updateOrderStatusAccept/{orderId}")
	public ResponseEntity<?> acceptOrder(@PathVariable int orderId) {
		UserOrder userOrder = userOrderService.findUserOrderByOrderId(orderId);
		userOrder.setOrderStatus("Accepted");
		userOrderService.save(userOrder);
		return new ResponseEntity<>("updated", HttpStatus.OK);
	}
	
	@PutMapping("/updateOrderStatusReject/{orderId}")
	public ResponseEntity<?> rejectOrder(@PathVariable int orderId) {
		UserOrder userOrder = userOrderService.findUserOrderByOrderId(orderId);
		userOrder.setOrderStatus("Rejected");
		userOrderService.save(userOrder);
		return new ResponseEntity<>("updated", HttpStatus.OK);
	}
	
//
//	@PostMapping("/check-order-status-api")
//	public ResponseEntity<?> checkOrderStatusAPI(@RequestBody UserOrder order) {
//		boolean flag = false;
//		LocalDateTime now = LocalDateTime.now();
//		LocalTime orderCancelTime = order.getOrderTime().toLocalTime().plusMinutes(15);
//		if (order.getOrderTime().toLocalDate().compareTo(now.toLocalDate()) == 0) {
//			if (now.toLocalTime().compareTo(orderCancelTime) <= 0) {
//				flag = true;
//			}
//		}
//		return new ResponseEntity<>(flag, HttpStatus.OK);
//	}

//	@PutMapping("/cancel-order/{orderId}")
//	public ResponseEntity<?> cancelOrder(@PathVariable int orderId,@RequestBody UserOrder order) {
//		return new ResponseEntity<>(userOrderService.cancelOrder(order), HttpStatus.OK);
//	}
//	
//	@GetMapping("/getUserOrderDetail/{sNumber}")
//	public ResponseEntity<?> getUserOrderDetail(@PathVariable int sNumber,@RequestBody OrderInfo order) {
//		OrderInfo userOrderInfo=orderService.findUserOrderBySerialId(sNumber);	
//		return new ResponseEntity<>(userOrderInfo, HttpStatus.OK);
//	}
//	
//	@PutMapping("/setRatingFeedback/{sNumber}")
//	public ResponseEntity<?> addRatingAndFeedback(@PathVariable int sNumber,@RequestBody OrderInfo order) {
//		OrderInfo userOrderInfo=orderService.findUserOrderBySerialId(sNumber);	
//		userOrderInfo.setFoodRating(order.getFoodRating());
//		userOrderInfo.setFeedback(order.getFeedback());
//		orderService.save(userOrderInfo);
//		return new ResponseEntity<>("updated", HttpStatus.OK);
//	}
	
	
}
