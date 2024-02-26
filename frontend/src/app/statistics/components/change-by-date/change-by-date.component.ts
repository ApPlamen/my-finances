import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../services/statistics.service';
import { ChangeByDateFilterModel } from '../../models/change-by-date-filter.model';

@Component({
  templateUrl: './change-by-date.component.html',
})
export class ChangeByDateComponent implements OnInit {
  multi: any[];

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
