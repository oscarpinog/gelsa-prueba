import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParametrizacionComponent } from './parametrizacion.component';

import { ClienteComponent } from './cliente/cliente.component';

const routes: Routes = [
  {path:'',
  component: ParametrizacionComponent,
  children: [

    { path:'clientes', component : ClienteComponent }
  ]
  }   
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ParametrizacionRoutingModule { }
