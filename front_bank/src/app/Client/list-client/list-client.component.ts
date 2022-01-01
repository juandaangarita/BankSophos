import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/Model/Client';
import { ClientService } from 'src/app/Service/client.service';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.css']
})
export class ListClientComponent implements OnInit {

  clients:Client[] | undefined;

  constructor(private service:ClientService, private router:Router) { }

  ngOnInit(): void {
    this.service.getClient().subscribe(data=>{this.clients=data;})
  }

}
