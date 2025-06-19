import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginRoutingModule } from './login-routing.module';
import { LoginonComponent } from './loginon/loginon.component';
import { MaterialModule } from 'src/app/material/material.module';

@NgModule({
  declarations: [
    LoginonComponent
  ],
  imports: [
    CommonModule,
    LoginRoutingModule,
    MaterialModule
    
  ]
})
export class LoginModule { }
