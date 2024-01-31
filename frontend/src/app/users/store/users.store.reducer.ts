import * as UsersActions from './users.store.action';
import { UsersState, initialState } from './users.store.state';

export function usersRecuder(state: UsersState = initialState, action) {
  switch (action.type) {
    case UsersActions.SET_USER_ID: {
      return { ...state, userId: action.payload };
    }
  }

  return state;
}
