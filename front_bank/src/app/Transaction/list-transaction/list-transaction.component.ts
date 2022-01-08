import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Transaction } from 'src/app/Model/Transaction';
import { ClientService } from 'src/app/Service/client.service';
import { ProductService } from 'src/app/Service/product.service';
import { TransactionService } from 'src/app/Service/transaction.service';

@Component({
  selector: 'app-list-transaction',
  templateUrl: './list-transaction.component.html',
  styleUrls: ['./list-transaction.component.css']
})
export class ListTransactionComponent implements OnInit {

  transactions?: Transaction[];

  constructor(private productService:ProductService,
    private clientService: ClientService,
    private transactionService: TransactionService, 
    private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params=> {
      if (params.has("id")){
        this.transactionService.getTransaction(params.get("id"),params.get("idProduct")).subscribe(data =>this.transactions = data);
      }
    })
  }

  backProduct(): void {
    this.route.paramMap.subscribe((params) => {
      this.router.navigate(['clients', params.get('id'), 'products']);
    });

  }
}
