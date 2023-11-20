import { Component } from '@angular/core';


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent {
  isLogin: boolean = true;

  login() {
    // Implement login logic
    console.log('Login clicked');
  }

  signup() {
    // Implement signup logic
    console.log('Sign Up clicked');
  }

  toggleForm() {
    this.isLogin = !this.isLogin;
  }
}
