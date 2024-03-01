import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../../services/statistics.service';
import { ListOfKeyValuePairs } from '../../../viewmodels/list-of-key-value-pairs.viewmodel';

@Component({
  templateUrl: './spent-by-month.component.html',
})
export class SpentByMonthComponent implements OnInit {
  multi: ListOfKeyValuePairs[];

  // options
  legend: boolean = true;
  showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  showYAxisLabel: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Month';
  yAxisLabel: string = 'Amount';
  timeline: boolean = true;

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.fillData();
  }

  private fillData(): void {
    this.statisticsService.getSpentByMonth()
      .subscribe(multi => this.multi = multi);
  }
}
