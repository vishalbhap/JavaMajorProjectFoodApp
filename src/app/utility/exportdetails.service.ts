import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExportdetailsService {

  constructor(private _httpClient:HttpClient) { }


  getAllUserData():Observable<any>{
    return this._httpClient.get<any>("http://localhost:8080/Admin/usersData");
  }

  getAllRestaurantData():Observable<any>{
    return this._httpClient.get<any>("http://localhost:8080/Admin/restaurantData");
  }
}
