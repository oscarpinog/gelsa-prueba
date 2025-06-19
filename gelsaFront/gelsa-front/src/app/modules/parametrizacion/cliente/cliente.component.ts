import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from './services/cliente.service';
import { Venta, VentaDTO } from './models/ventaDTO';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModalClienteComponent } from './modal-cliente/modal-cliente.component';
import { MatDialog } from '@angular/material/dialog';




export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}



@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {

  ELEMENT_DATA: Venta[] = [];

  clientsList!: VentaDTO[];
  clientsListView!: VentaDTO[];
  displayedColumns: string[] = ['sharedKey', 'businessId', 'email', 'phone', 'dataAdded'];

  formulario!: FormGroup;
  searchValue: string = '';
  foundInf: boolean = false;
  cliente!: Venta;

  constructor(
    public dialog: MatDialog,
    private router: Router,
    private clienteService: ClienteService,
    private formBuilder: FormBuilder,
  ) { }
  ngOnInit(): void {

    this.obtenerClientes();
    this.crearFormularioCliente();

  }

  openModal() {

    let cliente = new VentaDTO();
    cliente.id = "";
    cliente.cantidad = 0;
    cliente.valor = 0;
    cliente.operador = "";
    cliente.vendedor = "";
    //cliente.id = "";

    const data = {
      cliente: cliente,
      editar: false
    }

    const dialogRef = this.dialog.open(ModalClienteComponent, {
      width: '85rem',
      height: '60rem',
  
      data: data,
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(() => {
      this.obtenerClientes()
    });
  }

  // editModal(cliente : VentaDTO) {

  //   const data = {
  //     cliente: cliente,
  //     editar: true
  //   }

  //   const dialogRef = this.dialog.open(ModalClienteComponent, {
  //     width: '85rem',
  //     height: '60rem',
  
  //     data: data,
  //     disableClose: true
  //   });

  //   dialogRef.afterClosed().subscribe(() => {
  //     this.obtenerClientes();
  //   });
  // }

  obtenerClientes() {
    this.clienteService.getAllClientes().subscribe({
      next: resp => {
        this.clientsList = [...resp];
        this.clientsListView = [...this.clientsList];
        console.log("listClients: ", this.clientsList);
      },
      error: (error) => {
        alert("No es posible obtener informacion");
      },

    })
  }
  crearFormularioCliente() {
    this.formulario = this.formBuilder.group({
      businessId: ['', Validators.required],
      cantidad: ['', Validators.required],
      valor: ['', Validators.required],
      operador: ['', [Validators.required]],
      vendedor: ['', Validators.required]
    });
  };


  onSubmit() {
    if (this.formulario.valid) {
      // Aquí puedes manejar la lógica para enviar el formulario
      console.log(this.formulario.value);
    } else {
      alert("Please fill out all fields correctly.");
    }
  }

  onClickAdvance() {
    this.crearFormularioCliente();
    this.searchValue;
    if (this.searchValue === "") {
      this.foundInf = false;
      alert("Debe agregar informacion");

    } else {
      this.findBySharedKey(this.searchValue);
    }
  }

  findBySharedKey(sharedKey: string) {
    this.clienteService.getBySharedKey(sharedKey).subscribe({
      next: resp => {
        this.foundInf = true;
        this.cliente = resp;
        console.log("OBJETO: ", this.cliente);
        this.cargarFormulario();
      },
      error: (error) => {
        this.searchValue = "";
        this.foundInf = false;
        alert(error.error.message);
      },

    })
  }

  cargarFormulario() {
    this.formulario = this.formBuilder.group({
      id: [this.cliente.id, Validators.required],
      cantidad: [this.cliente.cantidad, Validators.required],
      valor: [this.cliente.valor, [Validators.required]],
      operador: [this.cliente.operador, Validators.required],
      vendedor: [this.cliente.vendedor, Validators.required]
    });

  };

}
