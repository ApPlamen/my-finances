import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const CONTROLER_URL = 'statistics';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  constructor(private http: HttpClient) { }

  getChangeByDate(): Observable<any[]> {
    return this.http.get<any[]>(BASE_URL + '/change-by-date');
  }

}
