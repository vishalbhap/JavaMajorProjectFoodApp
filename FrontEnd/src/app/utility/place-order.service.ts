import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IPlaceOrder } from './IPlaceOrder';

@Injectable({
  providedIn: 'root'
})
export class PlaceOrderService {

  constructor(private _httpClient:HttpClient) { }

  placeOrder(order:any){
    console.log("vishalPlaceHttp1")
    console.log(order)
    return this._httpClient.post<any>("http://localhost:8080/order/place-orderSimple", order);
  }


  // registerUser(user:any){
  //   return this._httpClient.post<any>("http://localhost:8080/food-delivery/register", user);
  // }

  acceptOrderStatus(orderId:any, order:any){    
    return this._httpClient.put<any>("http://localhost:8080/order/updateOrderStatusAccept/"+orderId, order);
  }

  rejectOrderStatus(orderId:any, order:any){    
    return this._httpClient.put<any>("http://localhost:8080/order/updateOrderStatusReject/"+orderId, order);
  }



}
 