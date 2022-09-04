export interface IFood{
    foodName:string;
    foodCategory:string;
    price:number;
    offer:number,
    quantity:number;
    restaurant:{
        restaurantName:string;
        address:{
            area:string;
        }
    }   
  
}