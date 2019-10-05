import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from 'src/app/shared/product-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  private product ;
  constructor(private productService : ProductServiceService, private router : Router) { }

  ngOnInit() {
    this.product = this.productService.getter();
  }

  processForm(){
    if(this.product.id === undefined){
      this.productService.createProduct(this.product).subscribe((data) => {
        console.log('Created Product: '+ data);
        this.router.navigate(['']);
      },
      (error) => 
      {
        console.log('Error: '+ error);
        this.router.navigate(['/productform']);
      });
    } else {
      this.productService.updateProduct(this.product).subscribe((data) => {
        console.log('Created Product: '+ data);
        this.router.navigate(['']);
      },
      (error) => 
      {
        console.log('Error: '+ error);
        this.router.navigate(['/productform']);
      });
    }
  }
}
