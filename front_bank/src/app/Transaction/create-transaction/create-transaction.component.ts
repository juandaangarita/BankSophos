import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { Transaction } from 'src/app/Model/Transaction';
import { TransactionService } from 'src/app/Service/transaction.service';

@Component({
  selector: 'app-create-transaction',
  templateUrl: './create-transaction.component.html',
  styleUrls: ['./create-transaction.component.css']
})
export class CreateTransactionComponent implements OnInit {
  
  
  dateNow = new Date();

  transaction: Transaction={
    idSecondaryProduct:0,
    typeOperation: '' ,
    valueOperation:0 ,
    dateOperation: '',
    description:'',
    resultOperation:'',
    finalBalance:0 ,
    GMF:0 ,
    financeMovement:'',
  };

  isCollapsed(): boolean {
    if (this.transaction.typeOperation != 'Transferencia' )
      return true;
    else
      return false;
  }

  products?: Product[];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private transactionService: TransactionService
  ) { }

  

  ngOnInit(): void {  
    this.route.paramMap.subscribe(params=> {
      if (params.has("id")){
        this.transactionService.getProduct(params.get("id"),params.get("idProduct")).subscribe(data =>this.products = data);
      }
    })
  }

  

  saveTransaction(): void {
    const data = {
      idSecondaryProduct:this.transaction.idSecondaryProduct,
      typeOperation: this.transaction.typeOperation ,
      valueOperation:this.transaction.valueOperation ,
      dateOperation: formatDate(this.dateNow, 'YYYY-MM-dd', 'en-US'),
      description:this.transaction.description,
    };

    this.route.paramMap.subscribe((params) => {
        this.transactionService.createTransaction(data, params.get('id'), params.get('idProduct')).subscribe(
          {
          next: () => {
            console.log(data)
            alert("Transacción realizada");
            this.router.navigate(['clients', params.get('id'), 'products',params.get('idProduct'),'transactions']);
          },
          error: (e) => console.error(e),
        });
      });
  }

  backProduct(): void {
    this.route.paramMap.subscribe((params) => {
      this.router.navigate(['clients', params.get('id'), 'products']);
    });

  }

}
