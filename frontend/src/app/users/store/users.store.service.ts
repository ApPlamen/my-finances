import * as UsersActions from './users.store.action';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { UsersState, getUserId } from './users.store.state';

@Injectable({
  providedIn: 'root'
})
export class UsersStoreService {
  constructor(private usersStore: Store<UsersState>) { }

  public get getUserId$(): Observable<number> {
    return this.usersStore.select(getUserId);
  }

  public set setUserId(userId: number) {
    this.usersStore.dispatch( new UsersActions.SetUserId(userId) );
  }
}
