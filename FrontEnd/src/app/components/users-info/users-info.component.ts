import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/utility/user-service.service';

@Component({
  selector: 'app-users-info',
  templateUrl: './users-info.component.html',
  styleUrls: ['./users-info.component.scss']
})
export class UsersInfoComponent implements OnInit {


  constructor(private _httpClient:HttpClient, private _userService:UserServiceService) {

   }
  
   userArray:any;

  ngOnInit(): void {
    this._userService.getAllUsers().subscribe(data=>{    
      this.userArray = data;      
      console.log(this.userArray);    
    });
  }


}
