import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LogInModel } from '../models/login.model';
import { RegisterModel } from '../models/register.model';
import { environment } from 'src/environments/environment';
import { LoginResponse } from '../models/login-response.model';

const CONTROLER_URL = 'auth';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  login(model: LogInModel): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(BASE_URL + '/login', model);
  }

  register(model: RegisterModel): Observable<any> {
    return this.http.post(BASE_URL + '/register', model);
  }
}
