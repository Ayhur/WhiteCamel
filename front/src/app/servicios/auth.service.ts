import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;

  constructor(private http: HttpClient) {
    const currentUser = localStorage.getItem('currentUser');
    const currentUserParsed = currentUser ? JSON.parse(currentUser) : null;
    this.currentUserSubject = new BehaviorSubject<any>(currentUserParsed);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue() {
    return this.currentUserSubject.value;
  }

  login(user: any) {
    localStorage.setItem('currentUser', JSON.stringify(user));
    console.log('currentUser', localStorage.getItem('currentUser'));
    this.currentUserSubject.next(user);
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
