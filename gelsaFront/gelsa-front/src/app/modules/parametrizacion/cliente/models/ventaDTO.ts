export class VentaDTO {
  id!: string;
  cantidad!: number;
  valor!: number;
  operador!: string;
  vendedor!: string;
}

export interface Venta {
  id: string;
  cantidad: number;
  valor: number;
  operador: string;
  vendedor: string;
}
