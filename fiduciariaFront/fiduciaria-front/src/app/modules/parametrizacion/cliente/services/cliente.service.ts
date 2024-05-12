import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente, ClienteDTO } from '../models/clienteDTO';




@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  url:string="http://localhost:8080";

  constructor(private http: HttpClient) { }

  	public getAllClientes(): Observable<ClienteDTO[]> {
		return this.http.get<ClienteDTO[]>(this.url + `/clients`);
	}

  public getBySharedKey(value: string): Observable<Cliente> {
		return this.http.get<Cliente>(this.url+`/clients/shared-key/${value}`);
	}

  public createClient(cliente: ClienteDTO) {
		return this.http.post(this.url+`/clients`,cliente);
	}

  public updateClient(cliente: ClienteDTO) {
		return this.http.put(this.url+`/clients/update`,cliente);
	}

  public deleteById(idClient: string) {
		return this.http.delete(this.url+`/clients/${idClient}`);
	}
}
