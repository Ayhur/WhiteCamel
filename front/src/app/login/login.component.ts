import { Component } from '@angular/core';
import { AuthService } from '../servicios/auth.service';
import { NgForm } from '@angular/forms';
import { LoginData } from '../models/login-data.model';
import { LoginService } from '../servicios/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private authService: AuthService, private loginService: LoginService,
     private router: Router) { }

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

    this.loginService.login(loginData).subscribe(
      response => {
        console.log('Login successful', response);
        this.authService.login(response.nombre);
        this.router.navigate(['/general'])
      },
      error => {
        console.error('Login failed', error);
      }
    );
  }

}
