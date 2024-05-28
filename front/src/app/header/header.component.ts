import { Component } from '@angular/core';
import { AuthService } from '../servicios/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  nombre: string | undefined = this.authService.currentUserValue.nombre;

  constructor(private authService: AuthService, private router: Router) { }

  onLogout() {
    console.log("logging out");
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
