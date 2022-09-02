import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private _httpClient:HttpClient) { }
  

  login(restaurant:any){
    console.log("vishalRestLogin")
    console.log("user "+restaurant)
    return this._httpClient.post<any>("http://localhost:8080/restaurant/login", restaurant);
  }

  getAllRestaurants():Observable<any>{
    return this._httpClient.get<any>("http://localhost:8080/restaurant/allRestaurant");
  }

  addFoodMenus(newFoodMenu:any){
    return this._httpClient.post<any>("http://localhost:8080/food-menu/addFoodMenus", newFoodMenu);
  }

  editFood(foodId:any, updatedFoodMenu:any){    
    return this._httpClient.put<any>("http://localhost:8080/food-menu/updateFoodMenu/"+foodId, updatedFoodMenu);
  }

  getAllOrders(restId:any):Observable<any>{
    return this._httpClient.get<any>("http://localhost:8080/order/getAllOrdersForRestaurant/"+restId);
  }

  

 
}

