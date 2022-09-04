import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RestService } from 'src/app/utility/rest.service';

@Component({
  selector: 'app-rest-info',
  templateUrl: './rest-info.component.html',
  styleUrls: ['./rest-info.component.scss']
})
export class RestInfoComponent implements OnInit {

  constructor(private _httpClient:HttpClient, private _restService:RestService) {

  }
 
  restArray:any;

 ngOnInit(): void {
   this._restService.getAllRestaurants().subscribe(data=>{    
     this.restArray = data;      
     console.log(this.restArray);    
   });
 }

 deleteRestaurant(value:any){
  this._restService.deleteRestaurant(value).subscribe(data=>{
    console.log(data);
  })
}


}
