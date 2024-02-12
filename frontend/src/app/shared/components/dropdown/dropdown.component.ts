import { Component, Input } from '@angular/core';
import { Dropdown } from '../../models/dropdown.model';
import { CustomControlDirective } from '../../services/base/custom-control.directive';

@Component({
    selector: 'tmc-dropdown',
    templateUrl: './dropdown.component.html',
    styleUrl: './dropdown.component.css',
  })
  export class DropdownComponent extends CustomControlDirective {
    @Input() items: Dropdown[];
    @Input() menuHidden: boolean = true;
    @Input() label = '';

    checkboxStatusChange(newValue: any): void {
        this.value = newValue;
    }

    toggleCheckboxArea(): void {
        this.menuHidden = !this.menuHidden;
    }

    isItemChecked(value: any) {
        return this.value == value;
    }

    get isMenuHidden() {
        return this.menuHidden ? 'none' : 'block'
    }

    get getSelectedItemsDisplayValue() {
        const selectedItems = this.items?.filter(item => item.value == this.value).flatMap(i => i.displayValue).join();
        return selectedItems ? selectedItems : "No option has been selected";
    }
  }
