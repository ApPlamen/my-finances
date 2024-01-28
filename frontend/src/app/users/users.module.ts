import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { BoardUsersComponent } from './components/board-users/board-users.component';
// import { StoreModule } from '@ngrx/store';
// import { companyRecuder } from './store/company.store.reducer';
import { UsersRoutingModule } from './users-routing.module';

@NgModule({
  declarations: [
    BoardUsersComponent,
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    // StoreModule.forFeature('company', companyRecuder),
  ],
  exports: [
  ],
  providers: [
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class UsersModule {}
