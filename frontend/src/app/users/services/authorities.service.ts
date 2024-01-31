import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { MultiselectDropdown } from 'src/app/shared/models/multiselect-dropdown.model';

const CONTROLER_URL = 'authorities';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class AuthoritiesService {
  constructor(private http: HttpClient) { }

  getRolesOptions(): Observable<MultiselectDropdown[]> {
    return this.http.get<MultiselectDropdown[]>(BASE_URL + '/options-roles');
  }
}
