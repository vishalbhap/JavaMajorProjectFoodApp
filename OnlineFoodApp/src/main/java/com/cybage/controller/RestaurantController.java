package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.CustomException;
import com.cybage.model.Restaurant;
import com.cybage.service.RestaurantService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

//	@Autowired
//	private OrderInfoService orderService;
//	
//	@Autowired
//	private FoodMenusService foodMenusService;
//	// static Logger logger1=LogManager.getLogger(RestaurantController.class);
//
//	@Autowired
//	private EmailSenderService senderService;
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) throws CustomException {	
		System.out.println("Restaurant det "+restaurant);
		try {
			int distance = (int) (Math.floor(Math.random()*5)*5);
			restaurant.setDistance(Integer.toString( distance));
			System.out.println("Restaurant after setting distance "+restaurant);
			
		}catch (Exception e) {
			throw new CustomException("Restaurant Not added");
		}
		return new ResponseEntity<Restaurant>(restaurantService.save(restaurant), HttpStatus.OK);
	}

	
	
//	@PostMapping("/addRestaurant")
//	public ResponseEntity<Restaurant> addRestaurant(RestaurantRequestDTO restaurantRequestDTO) throws CustomException {
//		Restaurant newRestaurant = null;
//		try {
//			int distance = (int) (Math.floor(Math.random()*5)*5);
//			restaurantRequestDTO.setDistance(Integer.toString( distance));
//			System.out.println(restaurantRequestDTO);
//			newRestaurant = restaurantService.save(RestaurantRequestDTO.toEntity(restaurantRequestDTO),
//					restaurantRequestDTO.getThumbnail());
//			senderService.sendEmail(newRestaurant.getRestaurantEmail(), newRestaurant.getRestaurantPassword());
//		} catch (Exception e) {
//			throw new CustomException("Restaurant Not Added");
//		}
//		return new ResponseEntity<Restaurant>(newRestaurant, HttpStatus.OK);
//	}

//	@PutMapping("/updateRestaurant/{restaurantId}")
//	public ResponseEntity<?> updateRestaurant(@PathVariable int restaurantId,
//			RestaurantRequestDTO restaurantRequestDTO) {
//		Restaurant restaurant = restaurantService.findByRestaurantId(restaurantId);
//		restaurant.setRestaurantName(restaurantRequestDTO.getRestaurantName());
//		restaurant.setRestaurantUserName(restaurantRequestDTO.getRestaurantUserName());
//		return new ResponseEntity<>(
//				RestaurantResponseDTO
//						.fromEntity(restaurantService.update(restaurant, restaurantRequestDTO.getThumbnail())),
//				HttpStatus.ACCEPTED);
//	}
//
//	@DeleteMapping("/deleteRestaurant/{restaurantId}")
//	public ResponseEntity<String> deleteRestaurant(@PathVariable int restaurantId) throws CustomException {
//		String response = "";
//		List<FoodMenus> restaurantFood = foodMenusService.getByRestaurantId(restaurantId);
//		if (restaurantFood != null) {
//			for (FoodMenus foodMenu : restaurantFood) {
//				if (foodMenu.getOrderInfo() != null) {
//			throw new CustomException("Restaurant not deleted have orders");
//				}
//			}
//		}
//		response = restaurantService.deleteByRestaurantId(restaurantId);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}

	@GetMapping("/allRestaurant")
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		return new ResponseEntity<List<Restaurant>>(restaurantService.findAllRestaurants(), HttpStatus.OK);
	}

//	@GetMapping("/{thumbnail}")
//	public Resource findThumbnail(@PathVariable String thumbnail) {
//		return restaurantService.findByThumbnail(thumbnail);
//	}
//
//	@GetMapping("/getRestaurantById/{restaurantId}")
//	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int restaurantId) {
//		return new ResponseEntity<Restaurant>(restaurantService.findByRestaurantId(restaurantId), HttpStatus.OK);
//	}
//
//	@GetMapping("/searchByRating/{rating}")
//	public ResponseEntity<?> findRestaurantByRating(@PathVariable int rating){
//		Set<OrderInfo> list = orderService.findByFoodRating().stream().filter(element->rating == element.getFoodRating()).collect(Collectors.toSet());		 
////		   list.forEach(System.out::println);
////		   getRestaurantRating();
//		 return new ResponseEntity<>(list.stream().map(element->element.getFoodMenus().getRestaurant()).collect(Collectors.toSet()),HttpStatus.OK);
//	}
	
//	public void getRestaurantRating() {
//		int foodCount = 0;
//		int restaurantStar = 0;
//		int orderCount = 0;
//		int foodRatingAvg = 0;
//		List<Restaurant> findAllRestaurants = restaurantService.findAllRestaurants();
//		for (Restaurant restaurant : findAllRestaurants) {
//			List<FoodMenus> foodMenus = restaurant.getFoodMenus();
//			 foodCount = foodMenus.size();
//			for (FoodMenus foodMenu : foodMenus) {
//				List<OrderInfo> orderInfos = foodMenu.getOrderInfo();
//				orderCount = orderInfos.size();
//				for(OrderInfo orderInfo:orderInfos) {
//					 foodRatingAvg =+ orderInfo.getFoodRating();
//					 System.out.println("foodRatingAvg "+foodRatingAvg);
//				}
//			}
//		}
//		System.out.println("foodRatingAvg outside "+ foodRatingAvg/2+"  	"+foodRatingAvg);
//		System.out.println(findAllRestaurants);
//	}

	@PostMapping("/login")
	public ResponseEntity<?> restaurantLogin(@RequestBody Restaurant restaurant) throws CustomException {
		System.out.println("vishalRestLogin1");
		Restaurant loginRestaurant = restaurantService.findByRestaurantEmailAndRestaurantPassword(
				restaurant.getRestaurantEmail(), restaurant.getRestaurantPassword());
		if (loginRestaurant != null) {
			// logger1.info("Restaurant "+loginRestaurant.getRestaurantUserName()+" logged
			// in");
			return new ResponseEntity<>(loginRestaurant, HttpStatus.OK);
		}
		throw new CustomException("Email or password is wrong");
	}
}
