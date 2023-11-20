import { Component } from '@angular/core';
import { JwtServiceService } from '../service/jwt-service.service';
import { Class } from '../model/class';
import { Router } from '@angular/router';


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent {
  user:Class=new Class();
  isLogin: boolean = true;
  constructor(private jwtservice:JwtServiceService,private router:Router){};

  login() {
   
    console.log('Login clicked');
    this.jwtservice.authenticate(this.user).subscribe((response:any)=>{
      console.log(response);
      if(response.token.message=="success"){
        alert("login Successful");
        console.log(response.token.token)
        localStorage.setItem('logintoken',response.token.token);

        this.router.navigate(['/landing']);
      }
    });
   

  }

  signup() {
    console.log('Sign Up clicked',this.user);

    this.jwtservice.register(this.user).subscribe((response:any)=>{
      console.log(response);
      if(response.token.message=="success"){
        alert("SignUp Successful")
        localStorage.setItem('logintoken',response.token.token);
        console.log(response.token.token)
      }
    });
    this.clearUser();
  }
  clearUser() {
    this.user = {
      // Reset user properties to their initial values or an empty state
      // For example:
      email:'',
      firstname: '',
      lastname:'',
      password: '',
      // Add other properties as needed
    };}

  toggleForm() {
    this.isLogin = !this.isLogin;
  }
}
