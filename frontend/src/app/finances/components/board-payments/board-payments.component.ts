import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { SimpleTableColumn } from 'src/app/shared/models/simple-table.model';
import { PaymentBoardViewModel } from '../../viewmodels/payment-board.viewmodel';
import { PaymentsService } from '../../services/payments.service';
import { FinancesStoreService } from '../../store/finances.store.service';
import { CreateEditPaymentComponent } from '../../dialogs/create-edit-payment/create-edit-payment.component';

@Component({
  templateUrl: './board-payments.component.html',
})
export class BoardPaymentsComponent implements OnInit {
  @ViewChild('tableActionCellTemplate', { static: true }) tableActionCellTemplate: TemplateRef<any>;

  public payments: PaymentBoardViewModel[];

  public columns: SimpleTableColumn<{ [key: string]: string }>[] = [
    {
      header: 'Description',
      field: 'description',
    },
    {
      header: 'Amount',
      field: 'amount',
    }
  ];

  constructor(private paymentsService: PaymentsService,
              private financesStoreService: FinancesStoreService,
              private modalService: NgbModal,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.columns = [
      ...this.columns,
      {
        field: 'id',
        cellTemplate: this.tableActionCellTemplate
      }
    ];

    this.fillData();
  }

  openCreate(): void {
    this.financesStoreService.setPaymentId = null;
    this.openEditModal();
  }

  openEdit(paymentId: number): void {
    this.financesStoreService.setPaymentId = paymentId;
    this.openEditModal();
  }

  delete(paymentId: string): void {
    this.paymentsService.deletePayment(paymentId)
      .subscribe(() => {
        this.toastr.success('Success!');
        this.fillData();
      });
  }

  private openEditModal() {
    this.modalService.open(CreateEditPaymentComponent, {size: 'lg'})
      .closed
      .subscribe(() => this.fillData());
  }

  private fillData(): void {
    this.paymentsService.getPaymentsBoard()
      .subscribe(payments => this.payments = payments);
  }
}
