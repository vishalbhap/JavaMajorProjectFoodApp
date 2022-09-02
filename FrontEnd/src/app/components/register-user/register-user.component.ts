import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { UserServiceService } from 'src/app/utility/user-service.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {

  
  constructor(private fb:FormBuilder, private _userService:UserServiceService) { }

  userForm:FormGroup=this.fb.group({       
    userName:[''],
    userPassword:[''],
    userEmail:[''],
    userMobileNo:[''],  
    address:this.fb.group({
      area:[''],
      street:[''],
      pincode:['']
    })   
  })
 

  onSubmit(){
    console.log(this.userForm.value);
    this._userService.registerUser(this.userForm.value).subscribe(data=>{
      console.log(data);
    });
    
  }

  ngOnInit(): void {
  }

}
