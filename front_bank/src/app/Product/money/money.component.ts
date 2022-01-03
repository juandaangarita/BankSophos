import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ProductService } from 'src/app/Service/product.service';

@Component({
  selector: 'app-money',
  templateUrl: './money.component.html',
  styleUrls: ['./money.component.css']
})
export class MoneyComponent implements OnInit {

  currentProduct: Product = {
    typeAccount: '',
    numberAccount: '',
    creationDate: '',
    state: '',
    balance: 0,
  };

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private productService: ProductService) { }

  ngOnInit(): void {

  }

  backProduct(): void {
    this.route.paramMap.subscribe((params) => {
      this.router.navigate(['clients', params.get('id'), 'products']);
    });

  }

  addMoneytoProduct(idClient: any, idProduct: any, money: any): void {    

    this.route.paramMap.subscribe((params) => {
      this.productService.addMoney(params.get('id'),params.get('idProduct'), this.currentProduct.balance, this.currentProduct)
      .subscribe({
        next: () => {
          alert('consignación realizada');
          this.router.navigate(['clients', params.get('id'), 'products']);
        },
        error: (e) => console.error(e),
      });
    });
  }

  withdrawMoneytoProduct(idClient: any, idProduct: any, money: any): void {  

    this.route.paramMap.subscribe((params) => {
      this.productService.withdrawMoney(params.get('id'),params.get('idProduct'), this.currentProduct.balance, this.currentProduct)
      .subscribe({
        next: () => {
          alert('Retiro realizado');
          this.router.navigate(['clients', params.get('id'), 'products']);
        },
        error: (e) => console.error(e),
      });
    });
  }

}
