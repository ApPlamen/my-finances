import { Component, EventEmitter, Output } from '@angular/core';
import { SpentByVendorByPaymentOptionFilterForm } from 'src/app/statistics/forms/spent-by-vendor-filter-by-payment-option.form';
import { SpentByVendorByPaymentOptionFilterModel } from 'src/app/statistics/models/spent-by-vendor-by-payment-option-filter.model';

@Component({
  selector: 'app-spent-by-vendor-by-payment-option-filter',
  templateUrl: './spent-by-vendor-by-payment-option-filter.component.html',
})
export class SpentByVendorByPaymentOptionFilterComponent {
  spentByVendorByPaymentOptionFilterForm: SpentByVendorByPaymentOptionFilterForm = new SpentByVendorByPaymentOptionFilterForm();
  @Output() filterSubmit = new EventEmitter<SpentByVendorByPaymentOptionFilterModel>();

  onSubmit(): void {
    if (this.spentByVendorByPaymentOptionFilterForm.formGroup.valid) {
      this.filterSubmit.emit(this.spentByVendorByPaymentOptionFilterForm.formGroup.value);
    }
  }

  onReset(): void {
    this.spentByVendorByPaymentOptionFilterForm.clear();
  }
}
