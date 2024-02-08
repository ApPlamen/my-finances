import * as FinancesActions from './finances.store.action';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { FinancesState, getPaymentId } from './finances.store.state';

@Injectable({
  providedIn: 'root'
})
export class FinancesStoreService {
  constructor(private financesStore: Store<FinancesState>) { }

  public get getPaymentId$(): Observable<number> {
    return this.financesStore.select(getPaymentId);
  }

  public set setPaymentId(paymentId: number) {
    this.financesStore.dispatch( new FinancesActions.SetPaymentId(paymentId) );
  }
}
