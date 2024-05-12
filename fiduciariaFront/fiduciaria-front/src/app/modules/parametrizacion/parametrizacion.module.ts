import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ParametrizacionRoutingModule } from './parametrizacion-routing.module';
import { PropertyComponent } from './property/property.component';
import { MaterialModule } from 'src/app/material/material.module';
import { InicioComponent } from './inicio/inicio.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { ClienteComponent } from './cliente/cliente.component';
import { ModalClienteComponent } from './cliente/modal-cliente/modal-cliente.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    PropertyComponent,
    InicioComponent,
    UsuariosComponent,
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
