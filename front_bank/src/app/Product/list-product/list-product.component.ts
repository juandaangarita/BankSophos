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

  addMovementMoney(idClient:any, idProduct:any): void{
    this.router.navigate(["clients/",idClient,"products",idProduct,"money"])
    
  }

  updateProduct(idClient:any, idProduct:any): void{
    this.productService.updateStatusProduct(idClient, idProduct, this.currentProduct)
    .subscribe({
      next: (res) => {
        alert("El estado del producto fue actualizado con éxito");
        this.route.paramMap.subscribe(params=> {
        this.router.navigate(["clients/",params.get("id"),"products"]);})
      },
      error: (e) => console.error(e)
    });
    this.route.paramMap.subscribe(params=> {
      this.router.navigate(["clients/"]);
      if (params.has("id")){        
      this.router.navigate(["clients/",params.get("id"),"products"]);
      }
    })
  }

  cancelProduct(idClient:any, idProduct:any): void{
    this.productService.cancelStatusProduct(idClient, idProduct, this.currentProduct)
    .subscribe({
      next: (res) => {
        alert("El estado del producto fue actualizado con éxito");
        this.route.paramMap.subscribe(params=> {
          this.router.navigate(["clients/",params.get("id"),"products"]);
          this.router.routeReuseStrategy.shouldReuseRoute = function() { return false; };
        })
      },
      error: (e) => console.error(e)
    });
  }

}
