import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { VentaDTO } from '../models/ventaDTO';
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
     // id: [this.datosEntrada.cliente.id, Validators.required],
      cantidad: [this.datosEntrada.cliente.cantidad, Validators.required],
      valor: [this.datosEntrada.cliente.valor, Validators.required],
      operador: [this.datosEntrada.cliente.operador, [Validators.required]],
      vendedor: [this.datosEntrada.cliente.vendedor, Validators.required],
    })
  };

  public closeModal() {
    this.dialogRef.close();
  }

  guardarCliente(): void {
    let cliente:VentaDTO = new VentaDTO();
    if(this.datosEntrada.editar){
      cliente.id = this.datosEntrada.cliente.id;
    }
   // cliente.id = this.getSharedKey(this.formularioCliente.controls['id'].value);
    cliente.cantidad = this.formularioCliente.controls['cantidad'].value;
    cliente.valor = this.formularioCliente.controls['valor'].value;
    cliente.operador = this.formularioCliente.controls['operador'].value;
    cliente.vendedor = this.formularioCliente.controls['vendedor'].value;

    if (this.datosEntrada.editar) {
      console.log("EDITAR-GUARDAR");
      this.editarCliente(cliente);
    } else {
      this.crearCliente(cliente);
    }
    this.closeModal();
  }

  editarCliente(cliente: VentaDTO) {
    this.clienteService.updateClient(cliente).subscribe({
      next: resp => {
      },
      error: (error) => {
        alert(error.error.message);
      },

    })
  }

  crearCliente(cliente: VentaDTO) {
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
