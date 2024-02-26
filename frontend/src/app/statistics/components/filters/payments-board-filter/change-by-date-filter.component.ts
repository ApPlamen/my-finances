import { Component, EventEmitter, Output } from '@angular/core';
import { ChangeByDateFilterForm } from '../../../forms/change-by-date-filter.form';
import { ChangeByDateFilterModel } from '../../../models/change-by-date-filter.model';

@Component({
  selector: 'app-change-by-date-filter',
  templateUrl: './change-by-date-filter.component.html',
})
export class ChangeByDateFilterComponent {
  changeByDateFilterForm: ChangeByDateFilterForm = new ChangeByDateFilterForm();
  @Output() filterSubmit = new EventEmitter<ChangeByDateFilterModel>();

  onSubmit(): void {
    if (this.changeByDateFilterForm.formGroup.valid) {
      this.filterSubmit.emit(this.changeByDateFilterForm.formGroup.value);
    }
  }

  onReset(): void {
    this.changeByDateFilterForm.clear();
  }
}
