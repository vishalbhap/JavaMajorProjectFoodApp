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
import { RestInfoComponent } from './components/rest-info/rest-info.component';
import { RegisterRestComponent } from './components/register-rest/register-rest.component';



import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDividerModule } from '@angular/material/divider';
import { AddFoodComponent } from './components/add-food/add-food.component';
import { FoodlistComponent } from './components/foodlist/foodlist.component';
// import { UpdateFoodComponent } from './components/update-food/update-food.component';
import { SearchFoodPipe } from './pipes/search-food.pipe';
import { SearchRestAreaPipe } from './pipes/search-rest-area.pipe';
import { EditFoodComponent } from './components/edit-food/edit-food.component';
import { FavListComponent } from './components/fav-list/fav-list.component';
import { ShowFoodComponent } from './components/show-food/show-food.component';
import { OrdersListComponent } from './components/orders-list/orders-list.component';
import { OrdersListUserComponent } from './components/orders-list-user/orders-list-user.component';
import { RestUpdateComponent } from './components/rest-update/rest-update.component';
import { UpdatePasswordComponent } from './components/update-password/update-password.component';
import { UpdateUserProfileComponent } from './components/update-user-profile/update-user-profile.component';

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
    RestInfoComponent,
    RegisterRestComponent,
    AddFoodComponent,
    FoodlistComponent,
    // UpdateFoodComponent,
    SearchFoodPipe,
    SearchRestAreaPipe,
    EditFoodComponent,
    FavListComponent,
    ShowFoodComponent,
    OrdersListComponent,
    OrdersListUserComponent,
    RestUpdateComponent,
    UpdatePasswordComponent,
    UpdateUserProfileComponent
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
    MatFormFieldModule,

 MatCardModule,
 MatTabsModule ,
  MatInputModule, 
  MatButtonModule, 
  MatIconModule ,
  MatSnackBarModule, 
  MatRadioModule ,
  MatDatepickerModule,
 MatNativeDateModule ,
  MatSelectModule ,
  MatButtonToggleModule, 
  MatProgressSpinnerModule, 
 MatDividerModule ,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
