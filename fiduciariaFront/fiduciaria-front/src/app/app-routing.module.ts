import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path:'',
    children:[
      {
        path:'parametrizacion',
        loadChildren:()=> import('./modules/parametrizacion/parametrizacion.module').then( m => m.ParametrizacionModule )
      }
    ]
  },
  {
    path:'',
    children:[
      {
        path:'login',
        loadChildren:()=> import('./modules/login/login.module').then( m => m.LoginModule )
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
