import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/Model/Client';
import { Product } from 'src/app/Model/Product';
import { ProductService } from 'src/app/Service/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  dateNow = new Date();

  products?:Product[];
  clients?:Client[];

  product: Product ={
    typeAccount: '',
    numberAccount: '',
    creationDate: '',
    state: '',
    balance: 0,
  };
  save = false;

  constructor(private router:Router, private route: ActivatedRoute, private productService:ProductService) { }

  ngOnInit(): void {
  }

  saveProduct(): void{
    

    const data={
      typeAccount: this.product.typeAccount,
      numberAccount: this.product.numberAccount,
      creationDate: formatDate(this.dateNow, 'YYYY-MM-dd','en-US')
    };

    this.route.paramMap.subscribe(params=> {
      if (params.has("id")){
        this.productService.getProduct(params.get("id")).subscribe(data =>this.products = data);
      }
    })

    this.productService.createProduct(data)
    .subscribe({
      next: () => {          
        alert("El producto fue creado con éxito");
        this.router.navigate(["clients"])
      },
      error: (e) => console.error(e)
    })
    
}

}
