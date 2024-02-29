import { Injectable } from '@angular/core';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { SpentByVendorByPaymentOptionFilterModel } from '../models/spent-by-vendor-by-payment-option-filter.model';

@Injectable()
export class SpentByVendorByPaymentOptionFilterForm extends BaseFormModel<SpentByVendorByPaymentOptionFilterModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      startDate: [null],
      endDate: [null],
    });
  }
}
