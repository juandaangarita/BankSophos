import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bank Sophos';

  constructor(private router:Router){}

  ngOnInit(): void {
    this.router.navigate(['']);
  }

  List(){
    this.router.navigate(["clients"]);    
  }

  New(){
    this.router.navigate(["addClient"]);
  }


}
