import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../servicios/auth.service';
import { ScoresService } from '../servicios/scores.service';
import { Score } from '../models/score.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  user: string = this.authService.currentUserValue.nombre;
  displayedColumns: string[] = ["fecha", "hora", "puntuacion"]
  lastAttempts: Score[] = []

  constructor(
    private authService: AuthService,
    private router: Router,
    private scoresService: ScoresService
  ) { }

  ngOnInit(): void {
    this.scoresService
      .getScores(this.authService.currentUserValue.dni)
      .subscribe(data => {
        this.lastAttempts = data;
        while (this.lastAttempts.length < 5) {
          this.lastAttempts.push({
            fecha: '--/--/--',
            hora: '--:--',
            puntuacion: 0,
          });
        }
      })
  }

  onLogout() {
    console.log("logging out");
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
