import { Injectable } from '@angular/core';
import { Validators } from '@angular/forms';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { UserModel } from '../models/user.model';

@Injectable()
export class UserForm extends BaseFormModel<UserModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      id: ['', Validators.required],
      userName: ['', Validators.required],
      fullName: ['', Validators.required],
    });
  }
}
