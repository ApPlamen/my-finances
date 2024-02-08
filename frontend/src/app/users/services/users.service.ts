import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserBoardViewModel } from '../viewmodels/user-board.viewmodel';
import { UserActiveModel } from '../models/user-active.model';
import { CreateEditUserModel } from '../models/create-edit-user.model';

const CONTROLER_URL = 'users';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private http: HttpClient) { }

  getUserBoard(): Observable<UserBoardViewModel[]> {
    return this.http.get<UserBoardViewModel[]>(BASE_URL + '/board');
  }

  getEditUser(userId: number): Observable<CreateEditUserModel> {
    return this.http.get<CreateEditUserModel>(BASE_URL + '/get-edit/' + userId);
  }

  saveEditUser(model: CreateEditUserModel): Observable<void> {
    return this.http.post<void>(BASE_URL + '/create-edit-user', model);
  }

  setActive(model: UserActiveModel): Observable<void> {
    return this.http.post<void>(BASE_URL + '/set-active', model);
  }

  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>(BASE_URL + '/' + userId);
  }
}
