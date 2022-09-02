import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/utility/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private fb:FormBuilder, private _userService:UserServiceService, private router:Router) { }

  loginForm:FormGroup=this.fb.group({       
    userEmail:[''],
    userPassword:['']  
  })
 
  userId:any;

  onSubmit(){
    console.log(this.loginForm.value);
        this._userService.login(this.loginForm.value).subscribe(data=>{
      console.log(data);      
      console.log("Vaibhav1")
      alert("Login Successful")
      this.userId = data.userId;
      sessionStorage.setItem('userId', this.userId);
      this.router.navigateByUrl('userHome');      
    });        
  }

  ngOnInit(): void {
  }

}
