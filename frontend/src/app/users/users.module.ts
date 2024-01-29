import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { BoardUsersComponent } from './components/board-users/board-users.component';
import { StoreModule } from '@ngrx/store';
import { usersRecuder } from './store/users.store.reducer';
import { UsersRoutingModule } from './users-routing.module';
import { CreateEditUserComponent } from './dialogs/create-edit-user/create-edit-user.component';

@NgModule({
  declarations: [
    BoardUsersComponent,
    CreateEditUserComponent,
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    StoreModule.forFeature('users', usersRecuder),
  ],
  exports: [
  ],
  providers: [
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class UsersModule {}
