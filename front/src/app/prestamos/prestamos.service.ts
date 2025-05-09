import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pageable } from '../core/model/page/Pageable';
import { Prestamos } from './model/Prestamos';
import { PrestamosPage } from './model/PrestamosPage';

@Injectable({
  providedIn: 'root'
})
export class PrestamosService {

  constructor(private http: HttpClient) { }

  getPrestamos(pageable: Pageable, gameId?: number, clienteId?: number, fecha?: Date): Observable<PrestamosPage> {
    let params: any = { pageable: pageable };
    if (gameId != null) params.gameId = gameId;
    if (clienteId != null) params.clienteId = clienteId;
    if (fecha != null) params.fecha = fecha.toISOString().split('T')[0];

    return this.http.post<PrestamosPage>('http://localhost:8080/prestamos', params);
  }

  savePrestamo(prestamo: Prestamos): Observable<void> {
    let url = 'http://localhost:8080/prestamos';
    if (prestamo.id != null) url += '/' + prestamo.id;

    return this.http.put<void>(url, prestamo);
  }

  deletePrestamo(id: number): Observable<void> {
    return this.http.delete<void>('http://localhost:8080/prestamos/' + id);
  }
}
