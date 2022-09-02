import { Injectable } from '@angular/core';
import { IFood } from './IFood';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }

  cartList:IFood[]=[
    // {foodName:"VadaPav", foodCategory:"Java", price:120, offer:100, quantity:2, restaurant:{
    //   restaurantName:"BK", restId : 28,
    //   address : {
    //     area:"Pune"
    //   }
    // } }
  ];

  getCartList():IFood[]{
    return this.cartList;
  }

  addFoodToCart(food:IFood){
    this.cartList.push(food);
  }
}
