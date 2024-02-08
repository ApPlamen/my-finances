import { Injectable } from '@angular/core';
import { Validators } from '@angular/forms';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { PaymentModel } from '../models/payment.model';

@Injectable()
export class PaymentForm extends BaseFormModel<PaymentModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      id: [null],
      description: ['', Validators.required],
      amount: [0, Validators.required],
    });
  }
}
