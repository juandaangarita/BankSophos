import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/Model/Client';
import { ClientService } from 'src/app/Service/client.service';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  constructor(private router:Router, private service:ClientService) { }

  ngOnInit(): void {
  }

  saveClient(client:Client){
    this.service.createClient(client)
    .subscribe(data =>{alert("El cliente fue creado con éxito");
    this.router.navigate(["list"]);
  })
  }

}
