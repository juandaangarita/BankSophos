import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/Model/Client';
import { ClientService } from 'src/app/Service/client.service';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {

  // currentClient: Client;

    currentClient: Client = {
    typeId: '',
    numberId: '',
    lastname: '',
    name: '',
    email: '',
    dateBirth: '',
    telephone: '',
    dateCreation: '',
  };
  
  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params=> {
      if (params.has("id")){
        this.clientService.getClientId(params.get("id")).subscribe(data =>this.currentClient = data);
      }
    })
  }

  getClient(id: String): void{
    this.clientService.getClientId(id)
    .subscribe({
      next: (data)=>{
        this.currentClient = data;
      },
      error: (e) => console.error(e)
    });
  }

  updateClient(): void{
    this.clientService.updateClient(this.currentClient.id, this.currentClient)
    .subscribe({
      next: (res) => {
        alert("La información del cliente fue actualizada con éxito. Será redirigido a la página de gestión de clientes");
        this.router.navigate(['/clients']);
      },
      error: (e) => console.error(e)
    });
  }

  deleteClient(): void{
    this.clientService.deleteClient(this.currentClient.id)
    .subscribe({
      next: (res) => {
        this.router.navigate(['/clients']);
      },
      error: (e) => console.error(e)
    });
  }

  backClient(): void{
    this.router.navigate(['/clients']);
  }

}
