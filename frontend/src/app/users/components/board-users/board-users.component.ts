import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { SimpleTableColumn } from 'src/app/shared/models/simple-table.model';
import { UsersService } from '../../services/users.service';
import { UsersViewModel } from '../../viewmodels/user.viewmodel';
import { JoinPipe } from 'src/app/shared/pipes/join.pipe';
import { UserActiveModel } from '../../models/user-active.model';
import { UsersStoreService } from '../../store/users.store.service';
import { CreateEditUserComponent } from '../../dialogs/create-edit-user/create-edit-user.component';

@Component({
  templateUrl: './board-users.component.html',
})
export class BoardUsersComponent implements OnInit {
  @ViewChild('tableActionCellTemplate', { static: true }) tableActionCellTemplate: TemplateRef<any>;

  public users: UsersViewModel[];

  public columns: SimpleTableColumn<{ [key: string]: string }>[] = [
    {
      header: 'User name',
      field: 'userName',
    },
    {
      header: 'Full name',
      field: 'fullName',
    },
    {
      header: 'Roles',
      field: 'roles',
      pipe: JoinPipe
    }
  ];

  constructor(private usersService: UsersService,
              private usersStoreService: UsersStoreService,
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
    this.usersStoreService.setUserId = null;
    this.openEditModal();
  }

  openEdit(userId: number): void {
    this.usersStoreService.setUserId = userId;
    this.openEditModal();
  }

  setActive(userId: number, active: boolean): void {
    const model: UserActiveModel = {
      userId: userId,
      active: active
    }

    this.usersService.setActive(model)
      .subscribe(_ => {
        this.toastr.success('Success!');
        this.fillData();
      });
  }

  private openEditModal() {
    this.modalService.open(CreateEditUserComponent, {size: 'lg'})
      .closed
      .subscribe(_ => this.fillData());
  }

  private fillData(): void {
    this.usersService.getUserBoard()
      .subscribe(users => this.users = users);
  }
}
