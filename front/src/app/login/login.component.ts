import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../servicios/auth.service';
import { NgForm } from '@angular/forms';
import { LoginData } from '../models/login-data.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  onLogin(form: NgForm) {
    if (form.invalid) {
      return;
    }

    const loginData: LoginData = {
      dni: form.value.dni,
      password: form.value.password
    };

    console.log("form:", form.value);
    console.log("dni:", loginData);

    this.authService.login(loginData).subscribe(
      response => {
        this.router.navigate(['/app']);
      },
      error => {
        console.error('Login failed', error);
      }
    );
  }
}
