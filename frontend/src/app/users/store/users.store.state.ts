import { createFeatureSelector, createSelector } from '@ngrx/store';

export interface UsersState {
  userId: number;
}

export const initialState: UsersState = {
  userId: undefined,
};

const getUsersFeatureState = createFeatureSelector<UsersState>('users');

export const getUserId = createSelector(
  getUsersFeatureState,
  state => state.userId
);
