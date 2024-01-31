import { Component, Input } from '@angular/core';
import { MultiselectDropdown } from '../../models/multiselect-dropdown.model';
import { CustomControlDirective } from '../../services/base/custom-control.directive';

@Component({
    selector: 'tmc-multiselect-dropdown',
    templateUrl: './multiselect-dropdown.component.html',
    styleUrl: './multiselect-dropdown.component.css',
  })
  export class MultiselectDropdownComponent extends CustomControlDirective {
    @Input() items: MultiselectDropdown[];
    @Input() menuHidden: boolean = true;
    @Input() label = '';

    checkboxStatusChange(newValue: any): void {
        let values = this.value;

        const index = values.indexOf(newValue);
        if(index > -1) {
            values.splice(index, 1);
        }
        else {
            values.push(newValue);
        }

        this.value = values;
    }

    toggleCheckboxArea(): void {
        this.menuHidden = !this.menuHidden;
    }

    get isMenuHidden() {
        return this.menuHidden ? 'none' : 'block'
    }

    get getSelectedItems() {
        return this.items.filter(item => this.value.includes(item.value));
    }

    get getSelectedItemsDisplayValue() {
        const selectedItems = this.getSelectedItems.flatMap(i => i.displayValue).join(", ");
        return selectedItems ? selectedItems : "No option has been selected";
    }

    isItemChecked(value: any) {
        return this.value.includes(value);
    }
  }
