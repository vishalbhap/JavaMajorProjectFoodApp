import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/utility/user-service.service';

@Component({
  selector: 'app-orders-list-user',
  templateUrl: './orders-list-user.component.html',
  styleUrls: ['./orders-list-user.component.scss']
})
export class OrdersListUserComponent implements OnInit {

  orderList:any;
  userId:any;
  constructor(private _userService:UserServiceService) { }

  ngOnInit(): void {
    this.userId = sessionStorage.getItem('userId');
    this._userService.showAllOrders(this.userId).subscribe(data=>{
      this.orderList = data;
    })
  }

  acceptOrder(value:any){
    // this._orderService.acceptOrderStatus(value, this.orderList).subscribe(data=>{
    //   console.log(value);
    // })
  }

  rejectOrder(value:any){
    // this._orderService.rejectOrderStatus(value, this.orderList).subscribe(data=>{
    //   console.log(value);
    // })
  }

}
