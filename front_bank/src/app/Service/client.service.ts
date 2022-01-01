import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../Model/Client';

const UrlList='http://localhost:8080/clients/list';
const UrlAdd='http://localhost:8080/clients/add';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http:HttpClient) { }

  //List all the clients of the DB
  getClient(): Observable<Client[]>{
    return this.http.get<Client[]>(UrlList);
  }

  //Create a client
  createClient(data: any): Observable<any>{
    return this.http.post(UrlAdd,data);
  }

  //List only one client
  getClientId(id:any): Observable<any>{
    return this.http.get('${UrlList}/idClient={id}');    
  }

  //Update client info
  updateClient(id: any, data: any): Observable<any>{
    return this.http.put('${UrlList}/idClient=${id}', data);
  }

  //Delete client
  deleteClient(id:any): Observable<any>{
    return this.http.delete('${UrlList}/idClient=${id}');
  }
}
