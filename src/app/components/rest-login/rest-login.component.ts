import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { RestService } from 'src/app/utility/rest.service';


@Component({
  selector: 'app-rest-login',
  templateUrl: './rest-login.component.html',
  styleUrls: ['./rest-login.component.scss']
})
export class RestLoginComponent implements OnInit {

  constructor(private fb:FormBuilder, private _restService:RestService, private router:Router) { }
  hide = true;
  regexp = new RegExp(
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
  );
  
  loginForm:FormGroup=this.fb.group({       
    restaurantEmail:['', [
      Validators.required,
      Validators.pattern(this.regexp),
    ]],
    restaurantPassword:['', [
      Validators.required,
      Validators.maxLength(10),
      Validators.minLength(3),
    ]]
  });

  get restaurantEmail() {
    return this.loginForm.get('restaurantEmail');
  }
  get restaurantPassword() {
    return this.loginForm.get('restaurantPassword');
  }

  get restaurantId() {
    return this.loginForm.get('restId');
  }
 
  userid:any;

  onSubmit(){
    console.log(this.loginForm.value);
        this._restService.login(this.loginForm.value).subscribe(data=>{
      console.log(data); 
      console.log(data.restId)     
      console.log("Vaibhav1")
      alert("Restaurant Login Successful")
      this.router.navigateByUrl('restaurantHome');
      sessionStorage.setItem('user', this.loginForm.value);
      sessionStorage.setItem('restId', data.restId);
    });        
  }

 
  // }
  ngOnInit(): void {
  }

}
