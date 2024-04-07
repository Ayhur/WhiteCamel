import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SearchResult } from './search-result.model'; // Asegúrate de que la ruta es correcta

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiUrl = 'http://localhost:8080/api'; // URL del backend

  constructor(private http: HttpClient) { }

  search(query: string): Observable<any> {
    const body = {id_localidades: null, ciudad: query};
    return this.http.post<any>(`${this.apiUrl}`, body);
  }
}
