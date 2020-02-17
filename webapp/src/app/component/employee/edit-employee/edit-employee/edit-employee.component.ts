import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {Employee} from '../../../../model/employee/employee.module'
import {EmployeeService} from "../../../../service/employee/employee.service";

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  employee: Employee;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private employeeService: EmployeeService) { }

  ngOnInit() {
    let employeeId = window.localStorage.getItem("editEmployeeId");
    if(!employeeId) {
      alert("Invalid action.")
      this.router.navigate(['list-employee']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [''],
      names: ['', Validators.required],
      lastName: ['', Validators.required],
      identityNumber: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      addressPhysical: ['', Validators.required],
      addressPostal: ['', Validators.required],
      telephoneNumber: ['', Validators.required],
      employeeNumber: ['', Validators.required],
      company: [''],
    });
    this.employeeService.getEmployeeById(+employeeId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {

    if (this.editForm.invalid) {
        return;
    }

    this.employeeService.updateEmployee(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          //if(data.status === 200) {
            alert('Employee updated successfully.');
            this.router.navigate(['list-employee']);
          /*}else {
            alert(data.message);
          }*/
        },
        error => {
          alert(error);
        });
  }

}