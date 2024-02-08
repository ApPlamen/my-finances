import { createFeatureSelector, createSelector } from '@ngrx/store';

export interface FinancesState {
  paymentId: number;
}

export const initialState: FinancesState = {
  paymentId: undefined,
};

const getFinancesFeatureState = createFeatureSelector<FinancesState>('finances');

export const getPaymentId = createSelector(
  getFinancesFeatureState,
  state => state.paymentId
);
