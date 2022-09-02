package com.cybage.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.model.FoodMenus;
import com.cybage.model.Restaurant;

public interface FoodMenusService {
	
	public FoodMenus save(FoodMenus foodMenus);

//	public FoodMenus save(FoodMenus foodMenus,MultipartFile thumbnail,Restaurant restaurant);
	
//	public FoodMenus updateFoodMenu(FoodMenus foodMenus,MultipartFile thumbnail);

	public void deleteFoodMenu(int foodId);

	public FoodMenus findByFoodId(int foodId);

	public FoodMenus updateFoodMenu(FoodMenus foodMenus, int foodId);

	public List<FoodMenus> findAllFoodMenus();

	public FoodMenus findById(int foodId);

	public List<FoodMenus> getByRestaurantId(int restuarantId);

//	public FoodMenus updateOffer(FoodMenus foodItem);
//	
//	List<FoodMenus> findByOfferNot(double offer);
//
//	List<FoodMenus> findByOffer(double offer);
}
