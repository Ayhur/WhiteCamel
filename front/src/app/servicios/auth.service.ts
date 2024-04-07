// src/app/services/auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginData } from '../models/login-data.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

// Ejemplo de cómo incluir un token JWT en tus solicitudes
public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Bearer YOUR_TOKEN_HERE'
    })
  };

  private loginUrl = 'http://localhost:8080/login';

  constructor(private http: HttpClient) { }

  login(loginData: LoginData): Observable<LoginData> {
    return this.http.post<LoginData>(this.loginUrl, loginData);
  }
}
