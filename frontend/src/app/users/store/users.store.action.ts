import { Action } from '@ngrx/store';

export const SET_USER_ID = '[USERS_STORE] Set User Id';

export class SetUserId implements Action {
  readonly type = SET_USER_ID;
  constructor(public payload: number) {}
}

export type UsersActions = SetUserId;
