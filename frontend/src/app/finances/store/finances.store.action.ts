import { Action } from '@ngrx/store';

export const SET_PAYMENT_ID = '[FINANCES_STORE] Set Payment Id';

export class SetPaymentId implements Action {
  readonly type = SET_PAYMENT_ID;
  constructor(public payload: number) {}
}

export type FinancesActions = SetPaymentId;
