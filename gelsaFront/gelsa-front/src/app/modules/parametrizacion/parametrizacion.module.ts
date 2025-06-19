import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ParametrizacionRoutingModule } from './parametrizacion-routing.module';

import { MaterialModule } from 'src/app/material/material.module';


import { ClienteComponent } from './cliente/cliente.component';
import { ModalClienteComponent } from './cliente/modal-cliente/modal-cliente.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    ClienteComponent,
    ModalClienteComponent,


  ],
  imports: [
    CommonModule,
    ParametrizacionRoutingModule,
    MaterialModule,

  
  ]
})
export class ParametrizacionModule {
}
