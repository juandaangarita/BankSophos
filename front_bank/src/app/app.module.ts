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
import { ListProductComponent } from './Product/list-product/list-product.component';
import { AddProductComponent } from './Product/add-product/add-product.component';
import { DeleteProductComponent } from './Product/delete-product/delete-product.component';
import { RouterModule } from '@angular/router';
import { MoneyComponent } from './Product/money/money.component';


@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    AddClientComponent,
    EditClientComponent,
    DeleteClientComponent,
    ListClientComponent,
    ListProductComponent,
    AddProductComponent,
    DeleteProductComponent,
    MoneyComponent
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
function routes(routes: any, arg1: { onSameUrlNavigation: "reload"; }): any[] | import("@angular/core").Type<any> | import("@angular/core").ModuleWithProviders<{}> {
  throw new Error('Function not implemented.');
}

