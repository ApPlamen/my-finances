import { Component, Input } from '@angular/core';
import { MultiselectDropdown } from '../../models/multiselect-dropdown.model';

@Component({
    selector: 'tmc-multiselect-dropdown',
    templateUrl: './multiselect-dropdown.component.html',
    styleUrl: './multiselect-dropdown.component.css',
  })
  export class MultiselectDropdownComponent {
    @Input() items: MultiselectDropdown[];
    @Input() menuHidden: boolean = true;

    checkboxStatusChange(value: any): void {
        var item = this.items.find(i => i.value === value);
        item.checked = !item.checked;
    }

    toggleCheckboxArea(): void {
        this.menuHidden = !this.menuHidden;
    }

    get isMenuHidden() {
        return this.menuHidden ? 'none' : 'block'
    }

    get getSelectedItems() {
        return this.items.filter(i => i.checked);
    }

    get getSelectedItemsDisplayValue() {
        var selected = this.getSelectedItems.flatMap(i => i.displayValue).join(", ");
        return selected ? selected : "No option has been selected";
    }
  }
  