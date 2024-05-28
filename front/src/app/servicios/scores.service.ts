import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Score } from '../models/score.model';

@Injectable({
  providedIn: 'root'
})
export class ScoresService {

  constructor(private http: HttpClient) { }

  getScores(dni: string) {
    return this.http.get<Score[]>(`http://localhost:8081/scores/${dni}`);
  }

  saveScore(dni: string, puntuacion: number) {
    console.log("Enviando resultados")
    return this.http.post<{ dni: string, puntuacion: number }>("http://localhost:8081/scores", {
      dni: dni,
      puntuacion: puntuacion,
    }).subscribe();
  }
}
