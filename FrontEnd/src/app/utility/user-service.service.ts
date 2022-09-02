import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private _httpClient:HttpClient) { }

  registerUser(user:any){
    return this._httpClient.post<any>("http://localhost:8080/food-delivery/register", user);
  }

  getAllUsers():Observable<any>{
    return this._httpClient.get<any>("http://localhost:8080/food-delivery/allUser");
  }

  login(user:any){
    console.log("vishalLogin6")
    console.log("user "+user)
    return this._httpClient.post<any>("http://localhost:8080/food-delivery/login", user);
  }

  showAllOrders(userId:any):Observable<any>{
    return this._httpClient.get<any>("http://localhost:8080/order/getAllOrdersForUser/"+userId);
  }



}
