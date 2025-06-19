import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login.component';
import { LoginonComponent } from './loginon/loginon.component';

const routes: Routes = [
  {path:'',
  component: LoginComponent,
  children: [
    { path:'loginon', component : LoginonComponent }
  ]
  } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
