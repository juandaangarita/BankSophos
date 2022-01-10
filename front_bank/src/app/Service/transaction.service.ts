import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../Model/Product';
import { Transaction } from '../Model/Transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  UrlTransaction='http://localhost:8080/clients/';

  constructor(private http:HttpClient) { }

  //List the transaction for the product
  getTransaction(id: any, idProduct:any): Observable<Transaction[]>{
    const url = `${this.UrlTransaction}${id}/products/${idProduct}/transaction`
    return this.http.get<Transaction[]>(url);
  }

    //Create a transaction for a product
    createTransaction(data: any, id: any, idProduct:any): Observable<any> {
      const url = `${this.UrlTransaction}${id}/products/${idProduct}/transaction`;
      return this.http.post(url, data);
    }

  //List all the products that are able to transfer money
  getProduct(id: any, idProduct:any): Observable<Product[]> {
    const url = `${this.UrlTransaction}${id}/products/${idProduct}/different`;
    return this.http.get<Product[]>(url);
  }
}
