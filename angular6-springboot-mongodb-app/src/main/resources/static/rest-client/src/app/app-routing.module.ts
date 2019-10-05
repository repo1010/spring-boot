import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent} from './components/product-list/product-list.component'
import { ProductFormComponent } from './components/product-form/product-form.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

const routes: Routes = [
  {path : '', redirectTo : '/products', pathMatch:'full'},
  {path : 'products', component : ProductListComponent},
  {path : 'productform', component : ProductFormComponent},
  {path : '**', component : PageNotFoundComponent}
];

export const routingComponents = [
  ProductListComponent,
  ProductFormComponent,
  PageNotFoundComponent
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule  ]
})
export class AppRoutingModule {

  
 }
