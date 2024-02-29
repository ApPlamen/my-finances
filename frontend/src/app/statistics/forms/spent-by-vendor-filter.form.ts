import { Injectable } from '@angular/core';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { SpentByVendorFilterModel } from '../models/spent-by-vendor-filter..model';

@Injectable()
export class SpentByVendorFilterForm extends BaseFormModel<SpentByVendorFilterModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      startDate: [null],
      endDate: [null],
    });
  }
}
