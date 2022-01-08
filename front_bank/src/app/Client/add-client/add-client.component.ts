import { formatDate } from '@angular/common';
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
  dateNow = new Date();

  client: Client ={
    typeId: '',
    numberId: '',
    lastname: '',
    name: '',
    email: '',
    dateBirth: '',
    telephone: '',
    dateCreation: '',
  };
  

  constructor(private router:Router, private clientService:ClientService) { }

  ngOnInit(): void {
  }

  saveClient(): void{
      const data={
        typeId: this.client.typeId,
        numberId: this.client.numberId,
        lastname: this.client.lastname,
        name: this.client.name,
        email: this.client.email,
        dateBirth: this.client.dateBirth,
        telephone: this.client.telephone,
        dateCreation: formatDate(this.dateNow, 'YYYY-MM-dd','en-US')
      };

      this.clientService.createClient(data)
      .subscribe({
        next: () => {          
          alert("El cliente fue creado con éxito");
          this.router.navigate(["clients"])
        },
        error: (e) => console.error(e)
      })
      
  }

}
