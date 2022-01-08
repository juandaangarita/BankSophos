import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    idSecondaryClient:0,
    typeOperation: '' ,
    valueOperation:0 ,
    dateOperation: '',
    description:'',
    resultOperation:'',
    finalBalance:0 ,
    GMF:0 ,
    financeMovement:'',
  };

  public isCollapsed = true;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private transactionService: TransactionService
  ) { }

  ngOnInit(): void {  
  }

  saveTransaction(): void {
    const data = {
      idSecondaryProduct:this.transaction.idSecondaryProduct,
      idSecondaryClient:this.transaction.idSecondaryClient,
      typeOperation: this.transaction.typeOperation ,
      valueOperation:this.transaction.valueOperation ,
      dateOperation: formatDate(this.dateNow, 'YYYY-MM-dd', 'en-US'),
      description:this.transaction.description,
    };

    this.route.paramMap.subscribe((params) => {
        this.transactionService.createTransaction(data, params.get('id'), params.get('idProduct')).subscribe({
          next: () => {
            alert(this.transaction.resultOperation);
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
