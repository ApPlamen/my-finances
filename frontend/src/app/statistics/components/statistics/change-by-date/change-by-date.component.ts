import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../../services/statistics.service';
import { ChangeByDateFilterModel } from '../../../models/change-by-date-filter.model';
import { ListOfKeyValuePairs } from '../../../viewmodels/list-of-key-value-pairs.viewmodel';

@Component({
  templateUrl: './change-by-date.component.html',
})
export class ChangeByDateComponent implements OnInit {
  multi: ListOfKeyValuePairs[];

  // options
  legend: boolean = false;
  showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  showYAxisLabel: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Date';
  yAxisLabel: string = 'Amount';
  timeline: boolean = true;

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.fillData();
  }

  filter(value: ChangeByDateFilterModel) {
    this.fillData(value);
  }

  private fillData(value: ChangeByDateFilterModel = new ChangeByDateFilterModel()): void {
    this.statisticsService.getChangeByDate(value)
      .subscribe(multi => this.multi = multi);
  }
}
