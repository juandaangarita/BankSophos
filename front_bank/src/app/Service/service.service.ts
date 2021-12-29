import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url='http:localhost:8080/clients';

  getClients(){
    return this.http.get<Client[]>(this.Url);
  }
}
