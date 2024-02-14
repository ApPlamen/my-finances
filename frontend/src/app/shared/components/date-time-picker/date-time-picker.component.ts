import {
    Component,
    Input,
    ChangeDetectorRef,
    Optional
} from "@angular/core";
import {
    NgbTimeStruct,
    NgbDateStruct,
    NgbPopoverConfig,
} from "@ng-bootstrap/ng-bootstrap";
import {
    NgControl
} from "@angular/forms";
import { DateTimeModel } from "../../models/date-time.model";
import { CustomControlDirective } from "../../services/base/custom-control.directive";
  
@Component({
    selector: "app-date-time-picker",
    templateUrl: "./date-time-picker.component.html",
  })
  export class DateTimePickerComponent extends CustomControlDirective {
    @Input() dateString: string;
    @Input() inputDatetimeFormat = "dd.MM.yyyy HH:mm:ss";
    @Input() hourStep = 1;
    @Input() minuteStep = 15;
    @Input() secondStep = 30;
    @Input() seconds = true;

    datetime: DateTimeModel = new DateTimeModel();
    private firstTimeAssign = true;

    constructor(@Optional() ngControl: NgControl, cd: ChangeDetectorRef, private config: NgbPopoverConfig) {
        super(ngControl, cd);
        config.autoClose = "outside";
        config.placement = "auto";
    }

    override writeValue(newModel: string) {
        if (newModel) {
        this.datetime = Object.assign(
            this.datetime,
            DateTimeModel.fromLocalString(newModel)
        );
        this.dateString = newModel;
        this.setDateStringModel();
        } else {
        this.datetime = new DateTimeModel();
        }
    }

    onInputChange($event: any) {
        const value = $event.target.value;
        const dt = DateTimeModel.fromLocalString(value);

        if (dt) {
        this.datetime = dt;
        this.setDateStringModel();
        } else if (value.trim() === "") {
        this.datetime = new DateTimeModel();
        this.dateString = "";
        this.onChange(this.dateString);
        } else {
        this.onChange(value);
        }
    }

    onDateChange($event: string | NgbDateStruct) {
        const date = new DateTimeModel($event);

        if (!date) {
        this.dateString = this.dateString;
        return;
        }

        if (!this.datetime) {
        this.datetime = date;
        }

        this.datetime.year = date.year;
        this.datetime.month = date.month;
        this.datetime.day = date.day;

        const adjustedDate = new Date(this.datetime.toString());
        if (this.datetime.timeZoneOffset !== adjustedDate.getTimezoneOffset()) {
        this.datetime.timeZoneOffset = adjustedDate.getTimezoneOffset();
        }

        this.setDateStringModel();
    }

    onTimeChange(event: NgbTimeStruct) {
        this.datetime.hour = event.hour;
        this.datetime.minute = event.minute;
        this.datetime.second = event.second;

        this.setDateStringModel();
    }

    setDateStringModel() {
        this.dateString = this.datetime.toString();

        if (!this.firstTimeAssign) {
        this.onChange(this.dateString);
        } else {
        // Skip very first assignment to null done by Angular
        if (this.dateString !== null) {
            this.firstTimeAssign = false;
        }
        }
    }

    public onBlur(event: Event): void {
        this.onTouch(event);
    }
  }
  