import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UsersInfoComponent } from './components/users-info/users-info.component';
import { HomeComponent } from './components/home/home.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import { LoginComponent } from './components/login/login.component';
import { UserHomePageComponent } from './components/user-home-page/user-home-page.component';
import { AdminHomePageComponent } from './components/admin-home-page/admin-home-page.component';
import { RestaurantHomePageComponent } from './components/restaurant-home-page/restaurant-home-page.component';
import { RestLoginComponent } from './components/rest-login/rest-login.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { CartComponent } from './components/cart/cart.component';
import { ShowFoodsComponent } from './components/show-foods/show-foods.component';
import { AddFoodComponent } from './components/add-food/add-food.component';
import { EditFoodComponent } from './components/edit-food/edit-food.component';
import { OrdersListComponent } from './components/orders-list/orders-list.component';
import { OrdersListUserComponent } from './components/orders-list-user/orders-list-user.component';
import { RestInfoComponent } from './components/rest-info/rest-info.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponent,
    UsersInfoComponent,
    HomeComponent,
    LoginComponent,
    UserHomePageComponent,
    AdminHomePageComponent,
    RestaurantHomePageComponent,
    RestLoginComponent,
    AdminLoginComponent,
    CartComponent,
    ShowFoodsComponent,
    AddFoodComponent,
    EditFoodComponent,
    OrdersListComponent,
    OrdersListUserComponent,
    RestInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatTableModule,
    MatFormFieldModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
