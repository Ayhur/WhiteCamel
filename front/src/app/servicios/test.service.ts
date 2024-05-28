import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, EMPTY, Observable, map } from 'rxjs';
import { Question } from '../models/question.model';

@Injectable({
    providedIn: 'root'
})
export class TestService {

    private testUrl = 'http://localhost:8081/test';

    private preguntasYRespuestasSubject = new BehaviorSubject<any[]>([]);
    preguntasYRespuestas$ = this.preguntasYRespuestasSubject.asObservable();
  
    setPreguntasYRespuestas(preguntasYRespuestas: any[]) {
      this.preguntasYRespuestasSubject.next(preguntasYRespuestas);
    }

    public httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
            //'Authorization': 'aqui el token app'
        })
    };
    


    constructor(private http: HttpClient) { }

    /**
     * Retorna el listado de los temarios.
     * @returns 
     */
    listMenu(): Observable<any> {
        const url = this.testUrl + '/menu';
        return this.http.post<any>(url, EMPTY).pipe();
    }

    /**
     * Retorna el temario seleccionado por el usuario.
     * @param temarioId 
     */
    getTest(testId: number): Observable<Question[]> {
        const url = this.testUrl + '/test';
        return this.http.post<any>(url, testId).pipe();
      }
}
