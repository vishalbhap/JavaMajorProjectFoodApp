import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FoodService } from 'src/app/utility/food.service';

@Component({
  selector: 'app-foodlist',
  templateUrl: './foodlist.component.html',
  styleUrls: ['./foodlist.component.scss']
})
export class FoodlistComponent implements OnInit {

  constructor(private _httpClient:HttpClient, private _foodService:FoodService) { }

  // foodArray:any;
  // restaurantId:any;
  // foodId:any;

  ngOnInit(): void {
    // this.restaurantId=sessionStorage.getItem('restId');
    // this._foodService.getFoodByRestaurant(this.restaurantId).subscribe(data=>{    
    //   this.foodArray = data;      
    //   console.log(this.foodArray);    
    // });
  }

  // onClickDelete(food_id:any){
  //   console.log("data");
  //  // this.foodId=sessionStorage.getItem('food_Id');
  //   this._foodService.deleteFood(food_id).subscribe(data=>{
  //     // this.foodArray=data;
     
  //   });
  // }


}
