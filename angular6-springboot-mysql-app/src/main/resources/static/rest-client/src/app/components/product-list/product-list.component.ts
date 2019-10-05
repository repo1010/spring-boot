import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ProductServiceService } from 'src/app/shared/product-service.service';
import { Product} from '../../product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  private products : Product[];
  constructor(private productService : ProductServiceService, private router : Router) { }

  ngOnInit() {
    this.productService.getAllProducts().subscribe((products)=> {
      console.log(products);
      this.products = products ;
    },
    (error) => {
      console.log(error);
    })
  }

  deleteProduct(product : Product){
    this.productService.deleteProduct(product.id).subscribe((data)=>{
        console.log(data);
        return this.products.splice(this.products.indexOf(product),1);
    },
    (error) => {
      console.log(error);
    })
  }

  test(){
    console.log('ing');
  }
  updateProduct(product : Product){
    console.log('Inside update product');
    this.productService.setter(product);  
     
    this.router.navigate(['/productform']);
  }

  newProduct(){
    let product = new Product();
    this.productService.setter(product);
    this.router.navigate(['/productform']);
  }
}
