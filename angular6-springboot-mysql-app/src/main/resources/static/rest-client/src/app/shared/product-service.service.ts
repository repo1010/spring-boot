import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import {catchError , map} from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Product} from '../product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

 private  _url = 'http://localhost:8080/api';
 private headers = new HttpHeaders( {'Content-Type':'application/json'});
 private tempProduct = new Product();
 constructor(private _http: HttpClient) { }

  getAllProducts() : Observable<Product []>{
    return this._http.get<Product []>(this._url+'/products',{headers : this.headers}).pipe(     
      catchError(this.hadleError('getAllProducts',[]))
    );
  }
 
  getProduct() {
    return this._http.get(this._url+'/product',{headers : this.headers}).pipe(     
      catchError(this.hadleError('getProduct',[]))
    );
  }

  deleteProduct(id : number) {
    return this._http.delete(this._url+'/product/'+id,{headers : this.headers}).pipe(     
      catchError(this.hadleError('deleteProduct',[]))
    );
  }

  createProduct(product : Product) {
    return this._http.post(this._url+'/product', JSON.stringify(product), {headers : this.headers}).pipe(     
      catchError(this.hadleError('getAllProducts',[]))
    );
  }

  updateProduct(product : Product) {
    return this._http.put(this._url+'/product', JSON.stringify(product), {headers : this.headers}).pipe(     
      catchError(this.hadleError('getAllProducts',[]))
    );
  }

  hadleError<T> (operation='operation', result? : T) {
    return (error : any) : Observable<T> => {
      console.error(error);          
      return of(result as T);
    };
  }

  setter(product : Product){
    this.tempProduct = product;
  }

  getter(){
    return this.tempProduct;
  }
}
