import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { UserForm } from '../../forms/user.form';
import { UsersService } from '../../services/users.service';
import { UsersStoreService } from '../../store/users.store.service';

@Component({
  templateUrl: './create-edit-user.component.html',
})
export class CreateEditUserComponent implements OnInit {
  isNew = true;
  userForm: UserForm = new UserForm();

  constructor(private usersService: UsersService,
              private usersStoreService: UsersStoreService,
              private activeModalService: NgbActiveModal,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.usersStoreService.getUserId$.subscribe(
      userId => {
        if ( userId ) {
          this.isNew = false;
          this.usersService.getUser(userId).subscribe( user => this.userForm.setModel(user) );
        }
      }
    );
  }

  onSubmit(): void {
    if (this.userForm.formGroup.valid) {
      this.usersService.saveUser(this.userForm.formGroup.value)
        .subscribe(_ => {
          this.toastr.success('Success!');
          this.activeModalService.close();
        });
    }
  }
}
