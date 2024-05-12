import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { ClienteDTO } from '../models/clienteDTO';
import { ClienteService } from '../services/cliente.service';

@Component({
  selector: 'app-modal-cliente',
  templateUrl: './modal-cliente.component.html',
  styleUrls: ['./modal-cliente.component.scss']
})
export class ModalClienteComponent implements OnInit {
  titulo!: string;
  formularioCliente!: FormGroup;


  constructor(
    private dialogRef: MatDialogRef<ModalClienteComponent>,
    private formBuilder: FormBuilder,
    private clienteService: ClienteService,
    @Inject(MAT_DIALOG_DATA) public datosEntrada: any
  ) {

  }
  ngOnInit(): void {
    
    this.titulo = this.datosEntrada.editar ? 'Edit Client' : 'Create New Client';
    this.crearFormularioModalCliente();

  }

  crearFormularioModalCliente() {
    this.formularioCliente = this.formBuilder.group({
      businessId: [this.datosEntrada.cliente.businessId, Validators.required],
      phone: [this.datosEntrada.cliente.phone, Validators.required],
      email: [this.datosEntrada.cliente.email, [Validators.required]],
      dataAdded: [this.datosEntrada.cliente.dataAdded, Validators.required],
    })
  };

  public closeModal() {
    this.dialogRef.close();
  }

  guardarCliente(): void {
    let cliente:ClienteDTO = new ClienteDTO();
    if(this.datosEntrada.editar){
      cliente.id = this.datosEntrada.cliente.id;
    }
    cliente.sharedKey = this.getSharedKey(this.formularioCliente.controls['businessId'].value);
    cliente.businessId = this.formularioCliente.controls['businessId'].value;
    cliente.email = this.formularioCliente.controls['email'].value;
    cliente.phone = this.formularioCliente.controls['phone'].value;
    cliente.dataAdded = this.formularioCliente.controls['dataAdded'].value;

    if (this.datosEntrada.editar) {
      console.log("EDITAR-GUARDAR");
      this.editarCliente(cliente);
    } else {
      this.crearCliente(cliente);
    }
    this.closeModal();
  }

  editarCliente(cliente: ClienteDTO) {
    this.clienteService.updateClient(cliente).subscribe({
      next: resp => {
      },
      error: (error) => {
        alert(error.error.message);
      },

    })
  }

  crearCliente(cliente: ClienteDTO) {
    this.clienteService.createClient(cliente).subscribe({
      next: resp => {
      },
      error: (error) => {
        alert(error.error.message);
      },
    })
  }

  getSharedKey(nomeCompleto: string): string {
    const partesNome = nomeCompleto.split(" ");
    if (partesNome.length >= 2) {
        const primeiraLetraNome = partesNome[0].charAt(0).toLowerCase();
        //const primeiraLetraSobrenome = partesNome[1].charAt(0).toLowerCase();
        return primeiraLetraNome  + partesNome.slice(1).join("").toLowerCase();
    } else {
        return nomeCompleto.toLowerCase();
    }
  }
}
