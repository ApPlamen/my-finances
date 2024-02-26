import { Injectable } from '@angular/core';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { ChangeByDateFilterModel } from '../models/change-by-date-filter.model';

@Injectable()
export class ChangeByDateFilterForm extends BaseFormModel<ChangeByDateFilterModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      startDate: [null],
      endDate: [null],
    });
  }
}
