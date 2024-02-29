import { Component, EventEmitter, Output } from '@angular/core';
import { SpentByVendorFilterForm } from 'src/app/statistics/forms/spent-by-vendor-filter.form';
import { SpentByVendorFilterModel } from 'src/app/statistics/models/spent-by-vendor-filter.model';

@Component({
  selector: 'app-spent-by-vendor-filter',
  templateUrl: './spent-by-vendor-filter.component.html',
})
export class SpentByVendorFilterComponent {
  spentByVendorFilterForm: SpentByVendorFilterForm = new SpentByVendorFilterForm();
  @Output() filterSubmit = new EventEmitter<SpentByVendorFilterModel>();

  onSubmit(): void {
    if (this.spentByVendorFilterForm.formGroup.valid) {
      this.filterSubmit.emit(this.spentByVendorFilterForm.formGroup.value);
    }
  }

  onReset(): void {
    this.spentByVendorFilterForm.clear();
  }
}
