import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ClientService } from 'src/app/Service/client.service';
import { ProductService } from 'src/app/Service/product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  products?:Product[];
  currentProduct: Product = {};
  currentIndex = -1;

  constructor(private productService:ProductService,
    private clientService: ClientService, 
    private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params=> {
      if (params.has("id")){
        this.productService.getProduct(params.get("id")).subscribe(data =>this.products = data);
      }
    })
  }

  AddProduct(id: any): void{
    this.route.paramMap.subscribe(params=> {
      if (params.has("id")){        
        this.router.navigate(["clients/",params.get("id"),"products","add"]);
      }
    })
    
  }

}
