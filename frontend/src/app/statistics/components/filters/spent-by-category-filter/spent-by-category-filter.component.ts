import { Component, EventEmitter, Output } from '@angular/core';
import { SpentByCategoryFilterForm } from 'src/app/statistics/forms/spent-by-category-filter.form';
import { SpentByCategoryFilterModel } from 'src/app/statistics/models/spent-by-category-filter.model';

@Component({
  selector: 'app-spent-by-category-filter',
  templateUrl: './spent-by-category-filter.component.html',
})
export class SpentByCategoryFilterComponent {
  spentByCategoryFilterForm: SpentByCategoryFilterForm = new SpentByCategoryFilterForm();
  @Output() filterSubmit = new EventEmitter<SpentByCategoryFilterModel>();

  onSubmit(): void {
    if (this.spentByCategoryFilterForm.formGroup.valid) {
      this.filterSubmit.emit(this.spentByCategoryFilterForm.formGroup.value);
    }
  }

  onReset(): void {
    this.spentByCategoryFilterForm.clear();
  }
}
