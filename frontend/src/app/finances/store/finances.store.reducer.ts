import * as FinancesActions from './finances.store.action';
import { FinancesState, initialState } from './finances.store.state';

export function financesRecuder(state: FinancesState = initialState, action) {
  switch (action.type) {
    case FinancesActions.SET_PAYMENT_ID: {
      return { ...state, paymentId: action.payload };
    }
  }

  return state;
}
