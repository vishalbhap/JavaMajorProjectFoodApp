import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/utility/cart.service';
import { FoodService } from 'src/app/utility/food.service';
import { IFood } from 'src/app/utility/IFood';

@Component({
  selector: 'app-show-foods',
  templateUrl: './show-foods.component.html',
  styleUrls: ['./show-foods.component.scss']
})
export class ShowFoodsComponent implements OnInit {

  foodArray:any;
  restaurantId:any;

  constructor(private _foodService:FoodService, private _cartService:CartService) { }

  ngOnInit(): void {
    this.restaurantId = sessionStorage.getItem('restId');
    this._foodService.getFoodMenusByRestId( this.restaurantId).subscribe(data=>{
      this.foodArray =  data;
    });
  }

   addToCart(food:IFood){
    this._cartService.addFoodToCart(food);
    alert('Food added to cart2')
  }
  


}
