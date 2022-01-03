import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddClientComponent } from './Client/add-client/add-client.component';
import { EditClientComponent } from './Client/edit-client/edit-client.component';
import { DeleteClientComponent } from './Client/delete-client/delete-client.component';
import { ListClientComponent } from './Client/list-client/list-client.component';
import { LandingComponent } from './Landing/landing/landing.component';
import { AddProductComponent } from './Product/add-product/add-product.component';
import { MoneyComponent } from './Product/money/money.component';

const routes: Routes = [
  {path:'', component:LandingComponent},
  // To list all the clients
  {path:'clients', component:ListClientComponent},
  // To create a client
  {path:'addClient', component:AddClientComponent},
  // To edit a client info
  {path:'clients/:id/products', component:EditClientComponent},
  //To delete a client
  {path:'clients/:id/products', component:DeleteClientComponent},
  //To create a product
  {path:'clients/:id/products/add', component:AddProductComponent},
  //To make movement of money
  {path:'clients/:id/products/:idProduct/money', component:MoneyComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
