import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JwtServiceService {

  constructor(private httpclient:HttpClient) { }

  private getHeaders(): HttpHeaders {
    // Retrieve the token from where you stored it (e.g., localStorage)
    const token = localStorage.getItem('logintoken');

    // Set headers with Authorization Bearer token
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }

  register(obj:any):Observable<any>{
    const apiUrl="http://localhost:8084/jwt/register";
    return this.httpclient.post(apiUrl,obj);
  }
  authenticate(obj:any):Observable<any>{
    const apiUrl="http://localhost:8084/jwt/authenticate";
    return this.httpclient.post(apiUrl,obj);
  }
  hello(){
    const headers = this.getHeaders();
    const apiUrl="http://localhost:8084/js";
    return this.httpclient.get(apiUrl, { headers });
  }
}
