import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../services/statistics.service';
import { SpentByVendorFilterModel } from '../../models/spent-by-vendor-filter.model';
import { ListOfKeyValuePairs } from '../../viewmodels/list-of-key-value-pairs.viewmodel';
import { multi } from './data';

@Component({
  templateUrl: './spent-by-vendor-by-payment-option.component.html',
})
export class SpentByVendorByPaymentOptionComponent implements OnInit {
  multi: ListOfKeyValuePairs[];

  // options
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  gradient: boolean = false;
  showLegend: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Country';
  showYAxisLabel: boolean = true;
  yAxisLabel: string = 'Population';
  animations: boolean = true;
  legendTitle: string = 'Years';

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.fillData();
  }

  filter(value: SpentByVendorFilterModel) {
    this.fillData(value);
  }

  openTab(tab: string, tabContent: string) {
    let tabs = document.getElementsByClassName("nav-link");
    for (let i = 0; i < tabs.length; i++) {
      tabs.item(i).classList.remove("active");
    }
    document.getElementById(tab).classList.add("active");

    let tabcontent = document.getElementsByClassName("tab-pane");
    for (let i = 0; i < tabcontent.length; i++) {
      tabcontent.item(i).classList.remove("show", "active");
    }
    document.getElementById(tabContent).classList.add("show", "active");
  }

  private fillData(value: SpentByVendorFilterModel = new SpentByVendorFilterModel()): void {
    // this.statisticsService.getSpentByVendorByPaymentOption(value)
    //   .subscribe(multi => this.multi = multi);
    Object.assign(this, { multi })
  }
}
