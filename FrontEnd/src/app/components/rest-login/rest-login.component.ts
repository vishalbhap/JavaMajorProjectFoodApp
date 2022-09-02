import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { RestService } from 'src/app/utility/rest.service';
import { UserServiceService } from 'src/app/utility/user-service.service';

@Component({
  selector: 'app-rest-login',
  templateUrl: './rest-login.component.html',
  styleUrls: ['./rest-login.component.scss']
})
export class RestLoginComponent implements OnInit {

  constructor(private fb:FormBuilder, private _restService:RestService, private router:Router) { }

  loginForm:FormGroup=this.fb.group({       
    restaurantEmail:[''],
    restaurantPassword:['']  
  })
 
  restId:any;

  onSubmit(){
    console.log(this.loginForm.value);
        this._restService.login(this.loginForm.value).subscribe(data=>{
      console.log(data);      
      console.log("Vaibhav1")
      alert("Restaurant Login Successful")
      this.restId = data.restId;
      sessionStorage.setItem('restId', this.restId);
      this.router.navigateByUrl('restaurantHome');
      
    });        
  }

 
  // }
  ngOnInit(): void {
  }

}
