import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { EditUserForm } from '../../forms/edit-user.form';
import { UsersService } from '../../services/users.service';
import { UsersStoreService } from '../../store/users.store.service';
import { AuthoritiesService } from '../../services/authorities.service';
import { MultiselectDropdown } from 'src/app/shared/models/multiselect-dropdown.model';
import { Validators } from '@angular/forms';

@Component({
  templateUrl: './create-edit-user.component.html',
})
export class CreateEditUserComponent implements OnInit {
  _isNew = true;
  userForm: EditUserForm = new EditUserForm();
  roles: MultiselectDropdown[]

  constructor(private usersService: UsersService,
              private authoritiesService: AuthoritiesService,
              private usersStoreService: UsersStoreService,
              private activeModalService: NgbActiveModal,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.usersStoreService.getUserId$.subscribe(
      userId => {
        if ( userId ) {
          this.isNew = false;
          this.usersService.getEditUser(userId)
            .subscribe( user => this.userForm.setModel(user) );
        } else {
          this.isNew = true;
        }
      }
    );

    this.authoritiesService.getRolesOptions()
      .subscribe(rolesOptions => this.roles = rolesOptions)
  }

  onSubmit(): void {
    if (this.userForm.formGroup.valid) {
      this.usersService.saveEditUser(this.userForm.formGroup.value)
        .subscribe(() => {
          this.toastr.success('Success!');
          this.activeModalService.close();
        });
    }
  }

  get isNew(): boolean {
    return this._isNew;
  }
  set isNew(value) {
    this.updatePasswordValidation(value);
    this._isNew = value;
  }

  private updatePasswordValidation(value: boolean) {
    if (value) {
      this.userForm.formGroup.get('newPassword').addValidators(Validators.required);
    } else {
      this.userForm.formGroup.get('newPassword').removeValidators(Validators.required);
    }
    this.userForm.formGroup.get('newPassword').updateValueAndValidity();
  }
}
