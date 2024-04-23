// src/app/services/auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginData } from '../models/login-data.model';
import { BehaviorSubject, Observable, map } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    // Ejemplo de cómo incluir un token JWT en tus solicitudes
    public httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': 'Bearer YOUR_TOKEN_HERE'
        })
    };

    private currentUserSubject: BehaviorSubject<any>;
    public currentUser: Observable<any>;

    private loginUrl = 'http://localhost:8080/login';

    constructor(private http: HttpClient) {
        const currentUser = localStorage.getItem('currentUser');
        const currentUserParsed = currentUser ? JSON.parse(currentUser) : null;
        this.currentUserSubject = new BehaviorSubject<any>(currentUserParsed);
        this.currentUser = this.currentUserSubject.asObservable();
    }

    //   login2(loginData: LoginData): Observable<LoginData> {
    //     return this.http.post<LoginData>(this.loginUrl, loginData);
    //   }

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
}
