import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Venta, VentaDTO } from '../models/ventaDTO';




@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  url:string="http://localhost:8080";

  constructor(private http: HttpClient) { }

  	public getAllClientes(): Observable<VentaDTO[]> {
		return this.http.get<VentaDTO[]>(this.url + `/clients`);
	}

  public getBySharedKey(value: string): Observable<Venta> {
		return this.http.get<Venta>(this.url+`/clients/shared-key/${value}`);
	}

  public createClient(cliente: VentaDTO) {
		return this.http.post(this.url+`/clients`,cliente);
	}

  public updateClient(cliente: VentaDTO) {
		return this.http.put(this.url+`/clients/update`,cliente);
	}

  public deleteById(idClient: string) {
		return this.http.delete(this.url+`/clients/${idClient}`);
	}
}
