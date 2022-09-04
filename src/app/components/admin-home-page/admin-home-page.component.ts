import { Component, OnInit } from '@angular/core';
import { ExportdetailsService } from 'src/app/utility/exportdetails.service';
import { IUser } from 'src/app/utility/IUser';

@Component({
  selector: 'app-admin-home-page',
  templateUrl: './admin-home-page.component.html',
  styleUrls: ['./admin-home-page.component.scss']
})
export class AdminHomePageComponent implements OnInit {

  constructor(private _exportdetailsService:ExportdetailsService) { }

  ngOnInit(): void {
  }

  // userData(){
  //   this._exportdetailsService.getAllUserData();
  //   alert('Downloaded File')
  // }

  userData(){  
   
    this._exportdetailsService.getAllUserData().subscribe(data=>{
      console.log("in usev  data")
      console.log(data);
    });
    console.log("User File Downloaded ")
    
  }

restaurantData(){
    this._exportdetailsService.getAllRestaurantData().subscribe(data=>{
      JSON.stringify(data);
    });
    console.log("Restaurant File Downloaded ")
  }


}
