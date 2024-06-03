import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  search(query: string): Observable<any> {
    const body = {id_localidades: null, ciudad: query};
    return this.http.post<any>(`${this.apiUrl}`, body);
  }
}
