import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
}
