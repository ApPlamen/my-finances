import { Injectable } from '@angular/core';
import { Validators } from '@angular/forms';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { PaymentsBoardFilterModel } from '../models/payments-board-filter.model';

@Injectable()
export class PaymentsBoardFilterForm extends BaseFormModel<PaymentsBoardFilterModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      startDate: [null],
      endDate: [null],
    });
  }
}
