import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFoodComponent } from './components/add-food/add-food.component';
import { AdminHomePageComponent } from './components/admin-home-page/admin-home-page.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { CartComponent } from './components/cart/cart.component';
import { EditFoodComponent } from './components/edit-food/edit-food.component';
import { FavListComponent } from './components/fav-list/fav-list.component';
import { FoodlistComponent } from './components/foodlist/foodlist.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { OrdersListUserComponent } from './components/orders-list-user/orders-list-user.component';
import { OrdersListComponent } from './components/orders-list/orders-list.component';
import { RegisterRestComponent } from './components/register-rest/register-rest.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { RestInfoComponent } from './components/rest-info/rest-info.component';
import { RestLoginComponent } from './components/rest-login/rest-login.component';
import { RestUpdateComponent } from './components/rest-update/rest-update.component';
import { RestaurantHomePageComponent } from './components/restaurant-home-page/restaurant-home-page.component';
import { ShowFoodComponent } from './components/show-food/show-food.component';
// import { UpdateFoodComponent } from './components/update-food/update-food.component';
import { UpdatePasswordComponent } from './components/update-password/update-password.component';
import { UpdateUserProfileComponent } from './components/update-user-profile/update-user-profile.component';
import { UserHomePageComponent } from './components/user-home-page/user-home-page.component';
import { UsersInfoComponent } from './components/users-info/users-info.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:"register", component:RegisterUserComponent},
  {path:"getAllUsers", component:UsersInfoComponent},
  {path: "login", component:LoginComponent},
  {path:"userHome", component:UserHomePageComponent},
  {path:"adminHome", component:AdminHomePageComponent},
  {path:"restaurantHome", component:RestaurantHomePageComponent},
  {path:"restLogin", component:RestLoginComponent},
  {path:"adminLogin", component:AdminLoginComponent},
  {path:"userHome/cartPage", component:CartComponent},
  {path:"getAllRestaurants", component:RestInfoComponent},
  {path:"addRestaurant", component:RegisterRestComponent},
  // {path:"addfoodMenu", component:AddFoodComponent},
  // {path:"getFoodByRestaurant", component:FoodlistComponent},
  {path:"deleteFood", component:RestaurantHomePageComponent},
  // {path:"editFood", component:UpdateFoodComponent},



  {path:"showAllFoodsByRestId/cartPage", component:CartComponent},
  {path:"showAllFoodsByRestId", component:ShowFoodComponent},
  {path:"restaurantHome/addFood", component:AddFoodComponent},
  {path:"editFood", component:EditFoodComponent},
  {path:"restaurantHome/AllOrdersByRestId", component:OrdersListComponent},
  {path:"userHome/showOrdersForUser", component:OrdersListUserComponent},
  {path:"getAllRestaurants",component:RestInfoComponent},
  {path:"restaurantHome/updateRestaurant", component:RestUpdateComponent},
  {path:"userHome/updateUserProfile", component:UpdateUserProfileComponent},
  {path:"userHome/changePassword", component:UpdatePasswordComponent},
  {path:"showAllFoodsByRestId/favList", component:FavListComponent}

  // {path:"***", component:CartComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


 }
