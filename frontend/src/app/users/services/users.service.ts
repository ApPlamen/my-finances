import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UsersViewModel } from '../viewmodels/user.viewmodel';
import { UserActiveModel } from '../models/user-active.model';
import { UserModel } from '../models/user.model';

const CONTROLER_URL = 'users';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private http: HttpClient) { }

  getUserBoard(): Observable<UsersViewModel[]> {
    return this.http.get<UsersViewModel[]>(BASE_URL + '/board');
  }

  getUser(userId: number): Observable<UserModel> {
    return this.http.get<UserModel>(BASE_URL + '/get-edit/' + userId);
  }

  saveUser(model: UserModel): Observable<void> {
    return this.http.put<void>(BASE_URL + '/update', model);
  }

  setActive(model: UserActiveModel): Observable<void> {
    return this.http.post<void>(BASE_URL + '/set-active', model);
  }

  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>(BASE_URL + '/' + userId);
  }
}
