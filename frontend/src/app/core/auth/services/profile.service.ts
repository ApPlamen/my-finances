import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProfileModel } from '../models/profile.model';
import { ChangePasswordModel } from '../models/change-password.model';
import { environment } from 'src/environments/environment';

const CONTROLER_URL = 'profile';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  constructor(private http: HttpClient) { }

  getUserProfile(): Observable<ProfileModel> {
    return this.http.get<ProfileModel>(BASE_URL);
  }

  saveUserProfile(model: ProfileModel): Observable<void>  {
    return this.http.put<void> (BASE_URL, model);
  }

  changePassword(model: ChangePasswordModel): Observable<void>  {
    return this.http.put<void> (BASE_URL + '/change-password', model);
  }
}
