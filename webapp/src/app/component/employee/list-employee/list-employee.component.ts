import { Component, OnInit , ChangeDetectorRef} from '@angular/core';
import {Router} from "@angular/router";
import {Employee} from '../../../model/employee/employee.module';
import {EmployeeService} from "../../../service/employee/employee.service";
import {DataSource} from '@angular/cdk/table';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  employees : Employee[];

  constructor(private router: Router, private employeeService: EmployeeService, private changeDetectorRefs: ChangeDetectorRef) { }

  displayedColumns = ['id', 'names', 'lastName', 'identityNumber', 'dateOfBirth', 'addressPhysical', 'addressPostal', 'telephoneNumber', 'employeeNumber', 'action'];

  dataSource = new PostDataSource(this.employeeService);

  ngOnInit() {
  }

  deleteEmployee(employee: Employee): void {
      if(confirm("Are you sure to delete "+name)) {
        this.employeeService.deleteEmployee(employee.id)
        .subscribe( data => {
          this.dataSource = new PostDataSource(this.employeeService);        
          this.changeDetectorRefs.detectChanges();
        })  
      }  
  };

  editEmployee(employee: Employee): void {
    window.localStorage.removeItem("editEmployeeId");
    window.localStorage.setItem("editEmployeeId", employee.id.toString());
    this.router.navigate(['edit-employee']);
    this.dataSource = new PostDataSource(this.employeeService);    
  };

  addEmployee(): void {
    this.router.navigate(['add-employee']);
    this.dataSource = new PostDataSource(this.employeeService);
  }; 
}

export class PostDataSource extends DataSource<any> {
  constructor(private employeeService: EmployeeService) {
    super();
  }

  connect(): Observable<Employee[]> {
    return this.employeeService.getEmployees();
  }

  disconnect() {
  }
}