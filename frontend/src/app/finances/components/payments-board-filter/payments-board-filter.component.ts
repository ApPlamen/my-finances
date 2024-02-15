import { Component, EventEmitter, Output } from '@angular/core';
import { PaymentsBoardFilterForm } from '../../forms/payments-board-filter.form';
import { PaymentsBoardFilterModel } from '../../models/payments-board-filter.model';

@Component({
  selector: 'app-payments-board-filter',
  templateUrl: './payments-board-filter.component.html',
})
export class PaymentsBoardFilterComponent {
  paymentsBoardFilterForm: PaymentsBoardFilterForm = new PaymentsBoardFilterForm();
  @Output() filterSubmit = new EventEmitter<PaymentsBoardFilterModel>();

  onSubmit(): void {
    if (this.paymentsBoardFilterForm.formGroup.valid) {
      this.filterSubmit.emit(this.paymentsBoardFilterForm.formGroup.value);
    }
  }

  onReset(): void {
    this.paymentsBoardFilterForm.clear();
  }
}
