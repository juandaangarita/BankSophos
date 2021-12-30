import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../Model/Client';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Urlget='http://localhost:8080/clients/list';
  Urlpost='http://localhost:8080/clients/add';


  public getClient(){
    return this.http.get<Client[]>(this.Urlget);
  }

  public addClient(client:Client){
    return this.http.post<Client[]>(this.Urlpost,client);
  }
}
