import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { EditUserForm } from '../../forms/edit-user.form';
import { UsersService } from '../../services/users.service';
import { UsersStoreService } from '../../store/users.store.service';
import { AuthoritiesService } from '../../services/authorities.service';
import { MultiselectDropdown } from 'src/app/shared/models/multiselect-dropdown.model';

@Component({
  templateUrl: './create-edit-user.component.html',
})
export class CreateEditUserComponent implements OnInit {
  isNew = true;
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
        }
      }
    );

    this.authoritiesService.getRolesOptions()
      .subscribe(rolesOptions => this.roles = rolesOptions)
  }

  onSubmit(): void {
    if (this.userForm.formGroup.valid) {
      this.usersService.saveEditUser(this.userForm.formGroup.value)
        .subscribe(_ => {
          this.toastr.success('Success!');
          this.activeModalService.close();
        });
    }
  }
}
