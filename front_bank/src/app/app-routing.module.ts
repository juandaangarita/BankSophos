import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddClientComponent } from './Client/add-client/add-client.component';
import { EditClientComponent } from './Client/edit-client/edit-client.component';
import { DeleteClientComponent } from './Client/delete-client/delete-client.component';
import { ListClientComponent } from './Client/list-client/list-client.component';
import { LandingComponent } from './Landing/landing/landing.component';

const routes: Routes = [
  {path:'', component:LandingComponent},
  // To list all the clients
  {path:'clients', component:ListClientComponent},
  // To create a client
  {path:'addClient', component:AddClientComponent},
  // To edit a client info
  {path:'client/idclient=', component:EditClientComponent},
  //To delete a client
  {path:'deleteClient', component:DeleteClientComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
