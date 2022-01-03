import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../Model/Client';



@Injectable({
  providedIn: 'root'
})
export class ClientService {

  UrlClient='http://localhost:8080/clients/';

  constructor(private http:HttpClient) { }

  //List all the clients of the DB
  getClient(): Observable<Client[]>{
    return this.http.get<Client[]>(this.UrlClient);
  }

  //Create a client
  createClient(data: any): Observable<any>{
    return this.http.post(this.UrlClient,data);
  }

  //List only one client
  getClientId(id:any): Observable<any>{
    const url = `${this.UrlClient}${id}`
    return this.http.get(url);    
  }

  //Update client info
  updateClient(id: any, data: any): Observable<any>{
    const url = `${this.UrlClient}${id}`
    return this.http.put(url, data);
  }

  //Delete client
  deleteClient(id:any): Observable<any>{
    const url = `${this.UrlClient}${id}`
    return this.http.delete(url);
  }
}
