import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IUser } from 'src/app/utility/IUser';
import { UserServiceService } from 'src/app/utility/user-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private fb:FormBuilder, private _userService:UserServiceService, private router:Router) { }
  hide = true;
  regexp = new RegExp(
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
  );
  


  loginForm:FormGroup=this.fb.group({       
    userEmail:['', [
      Validators.required,
      Validators.pattern(this.regexp),
    ]],
    userPassword:['', [
      Validators.required,
      Validators.maxLength(10),
      Validators.minLength(3),
    ]]
  });

  get userEmail() {
    return this.loginForm.get('userEmail');
  }
  get userPassword() {
    return this.loginForm.get('userPassword');
  }


  otp:any;
  email:any;
  backendOtp:any;
  otpUser!:IUser;
 
  userId:any;
 
//METHOD FOR LOGIN WITHOUT OTP
  // onSubmit(){
  //   console.log(this.loginForm.value);
  //       this._userService.login(this.loginForm.value).subscribe(data=>{
  //     console.log(data);      
  //     console.log("Vaibhav1")
  //     alert("Login Successful")
  //     this.router.navigateByUrl('userHome');
      
  //   }); 
  // }



  //METHOD FOR LOGIN WITH OTP

  onSubmit(){   
    this._userService.login(this.loginForm.value).subscribe(data=>{
      console.log(data);
      if(this.otp == this.backendOtp){
             console.log("Vaibhav1")
             alert("Login Successful")
             this.userId = data.userId;
             sessionStorage.setItem('userId', this.userId);
             this.router.navigateByUrl('userHome'); 
           }else{
             alert('Invalid Otp')
           }  
    })     
 
}

sendOtp(){

console.log(this.loginForm.value);
this._userService.loginOtp(this.loginForm.value).subscribe(data=>{
 console.log(data);
 this.backendOtp = data;
})
}

  ngOnInit(): void {
  }

}
