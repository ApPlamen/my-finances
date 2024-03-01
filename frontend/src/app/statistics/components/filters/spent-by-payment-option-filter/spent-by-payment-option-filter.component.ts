import { Component, EventEmitter, Output } from '@angular/core';
import { SpentByPaymentOptionFilterForm } from 'src/app/statistics/forms/spent-by-payment-option-filter.form';
import { SpentByPaymentOptionFilterModel } from 'src/app/statistics/models/spent-by-payment-option-filter.model';

@Component({
  selector: 'app-spent-by-payment-option-filter',
  templateUrl: './spent-by-payment-option-filter.component.html',
})
export class SpentByPaymentOptionFilterComponent {
  spentByPaymentOptionFilterForm: SpentByPaymentOptionFilterForm = new SpentByPaymentOptionFilterForm();
  @Output() filterSubmit = new EventEmitter<SpentByPaymentOptionFilterModel>();

  onSubmit(): void {
    if (this.spentByPaymentOptionFilterForm.formGroup.valid) {
      this.filterSubmit.emit(this.spentByPaymentOptionFilterForm.formGroup.value);
    }
  }

  onReset(): void {
    this.spentByPaymentOptionFilterForm.clear();
  }
}
