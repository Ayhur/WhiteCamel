import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LoginData } from '../models/login-data.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;

  // Ejemplo de cómo incluir un token JWT en tus solicitudes
  public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer YOUR_TOKEN_HERE'
    })
  };

  private loginUrl = 'http://localhost:8081/login';

  constructor(private http: HttpClient) {
    const currentUser = localStorage.getItem('currentUser');
    const currentUserParsed = currentUser ? JSON.parse(currentUser) : null;
    this.currentUserSubject = new BehaviorSubject<any>(currentUserParsed);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue() {
    return this.currentUserSubject.value;
  }

  /**
   * Servicio que llama al login del servidor y trae los datos del usuario.
   * @param loginData
   * @returns userData
   */
  login(loginData: LoginData): Observable<LoginData> {
    return this.http.post<LoginData>(this.loginUrl, loginData)
      .pipe(map(user => {
            // almacenar detalles del usuario y token jwt en local storage para mantener al usuario logueado
            localStorage.setItem('currentUser', JSON.stringify(user));
            this.currentUserSubject.next(user);
            return user;
            }));
  }

  /**
   * Eliminamos del local storage al usuario para log out.
   */
  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

  /**
   * Validamos si el usuario esta autenticado.
   * @returns boolean
   */
  isAuthenticated(): boolean {
    console.log("isAuthenticated")
    return !!this.currentUserValue;
  }
}
