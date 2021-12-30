import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/Model/Client';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
  }

  Add(client: Client){
    this.service.addClient(client)
    .subscribe(data=>{
      alert("Se ha creado el cliente correctamente");
      this.router.navigate(["list"]);

    })
  }

}
