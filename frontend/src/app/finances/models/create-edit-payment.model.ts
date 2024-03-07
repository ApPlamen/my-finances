export class CreateEditPaymentModel {
  id: number | null;
  description: string;
  vendor: string;
  amount: number;
  income: boolean;
  paymentOption: number;
  paymentCategory: number | null;
  dateTime: Date;
}
