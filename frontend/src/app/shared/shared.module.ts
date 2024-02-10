import { CommonModule } from '@angular/common';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ButtonComponent } from './components/button/button.component';
import { InputComponent } from './components/input/input.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NumberInputComponent } from './components/number-input/number-input.component';
import { SimpleTableComponent } from './components/simple-table/simple-table.component';
import { TextareaComponent } from './components/textarea/textarea.component';
import { authInterceptorProviders } from './interceptors/auth.interceptor';
import { JoinPipe } from './pipes/join.pipe';
import { MultiselectDropdownComponent } from './components/multiselect-dropdown/multiselect-dropdown.component';
import { DropdownComponent } from './components/dropdown/dropdown.component';


@NgModule({
  declarations: [
    SimpleTableComponent,
    InputComponent,
    NumberInputComponent,
    TextareaComponent,
    ButtonComponent,
    NavbarComponent,
    MultiselectDropdownComponent,
    DropdownComponent,
  ],
  imports: [
    RouterModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [
    SimpleTableComponent,
    InputComponent,
    NumberInputComponent,
    TextareaComponent,
    ButtonComponent,
    NavbarComponent,
    MultiselectDropdownComponent,
    DropdownComponent,
  ],
  providers: [
    authInterceptorProviders,
    JoinPipe,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class SharedModule {}
