import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../Model/Client';
import { Product } from '../Model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  UrlProduct='http://localhost:8080/clients/';

  constructor(private http:HttpClient) { }

  //List all the products of the client
  getProduct(id: any): Observable<Product[]>{
    const url = `${this.UrlProduct}${id}/products`
    return this.http.get<Product[]>(url);
  }

  //Create a product for a client
  createProduct(data: any, id: any): Observable<any>{
    const url = `${this.UrlProduct}${id}/products`
    return this.http.post(url,data);
  }

  // //List only one product of the client
  // getProductId(id:any): Observable<any>{
  //   return this.http.get(`${this.UrlProduct}?clientId=${id}`);    
  // }

  //This is not usefull now
  updateStatusProduct(id: any, idProduct: any, data: any): Observable<any>{
    const url = `${this.UrlProduct}${id}/products/${idProduct}/changeStatus`
    return this.http.put(url, data);
  }

}
