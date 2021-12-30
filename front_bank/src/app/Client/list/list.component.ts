import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/Model/Client';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  clients:Client[] | undefined;

  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    this.service.getClient().subscribe(data=>{this.clients=data;})
  }

}
