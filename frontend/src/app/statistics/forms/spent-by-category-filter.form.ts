import { Injectable } from '@angular/core';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { SpentByCategoryFilterModel } from '../models/spent-by-category-filter.model';

@Injectable()
export class SpentByCategoryFilterForm extends BaseFormModel<SpentByCategoryFilterModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      startDate: [null],
      endDate: [null],
    });
  }
}
