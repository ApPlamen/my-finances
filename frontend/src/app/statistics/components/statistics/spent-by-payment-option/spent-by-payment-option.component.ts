import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../../services/statistics.service';
import { KeyValuePair } from '../../../viewmodels/key-value-pair.viewmodel';
import { SpentByPaymentOptionFilterModel } from '../../../models/spent-by-payment-option-filter.model';

@Component({
  templateUrl: './spent-by-payment-option.component.html',
})
export class SpentByPaymentOptionComponent implements OnInit {
  multi: KeyValuePair[];

  // options
  gradient: boolean = true;
  showLegend: boolean = true;
  showLabels: boolean = true;
  isDoughnut: boolean = false;

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.fillData();
  }

  filter(value: SpentByPaymentOptionFilterModel) {
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

  private fillData(value: SpentByPaymentOptionFilterModel = new SpentByPaymentOptionFilterModel()): void {
    this.statisticsService.getSpentByPaymentOption(value)
      .subscribe(multi => this.multi = multi);
  }
}
