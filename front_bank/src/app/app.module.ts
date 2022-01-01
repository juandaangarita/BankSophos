import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ClientService} from './Service/client.service';
import { HttpClientModule } from '@angular/common/http';
import { LandingComponent } from './Landing/landing/landing.component';
import { AddClientComponent } from './Client/add-client/add-client.component';
import { EditClientComponent } from './Client/edit-client/edit-client.component';
import { DeleteClientComponent } from './Client/delete-client/delete-client.component';
import { ListClientComponent } from './Client/list-client/list-client.component';


@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    AddClientComponent,
    EditClientComponent,
    DeleteClientComponent,
    ListClientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
