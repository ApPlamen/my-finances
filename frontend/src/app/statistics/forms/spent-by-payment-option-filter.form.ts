import { Injectable } from '@angular/core';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { SpentByPaymentOptionFilterModel } from '../models/spent-by-payment-option-filter.model';

@Injectable()
export class SpentByPaymentOptionFilterForm extends BaseFormModel<SpentByPaymentOptionFilterModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      startDate: [null],
      endDate: [null],
    });
  }
}
