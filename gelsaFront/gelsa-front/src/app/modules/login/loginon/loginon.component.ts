import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginon',
  templateUrl: './loginon.component.html',
  styleUrls: ['./loginon.component.scss']
})
export class LoginonComponent implements OnInit{

  form!:FormGroup;
  loading!: boolean;

  constructor(private fb:FormBuilder,private _snackBar: MatSnackBar,private router: Router){
    this.crearFormulario();
  }
 
  crearFormulario() {
    this.form=this.fb.group({
      usuario:['',Validators.required],
      contrasena:['',Validators.required]
    });
  }

  ngOnInit(): void {
  }

  ingresar(){
    console.log(this.form);

    const usuario= this.form.value.usuario;
    const contrasena= this.form.value.contrasena;

    if(usuario=='oscar' && contrasena=='123'){
      //validacion correcta
      this.fakeLouding();
    }else{
      //error
      this.error();
      this.form.reset();
    }
  }
  error(){
      this._snackBar.open('Datos ingresados incorrectos', 'Cerrar', {
        horizontalPosition:  'center',
        verticalPosition:  'bottom',
        duration:2000
      });
  }

  fakeLouding(){
    this.loading=true;
    setTimeout(() => {
      
      this.router.navigate(['clientes']);
    }, 1500);
  }
}
