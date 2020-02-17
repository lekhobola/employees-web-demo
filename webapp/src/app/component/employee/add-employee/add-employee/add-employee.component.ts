import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {EmployeeService} from "../../../../service/employee/employee.service";

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private employeeService: EmployeeService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
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

  }

  onSubmit() {

    if (this.addForm.invalid) {
        return;
    }

    this.employeeService.createEmployee(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-employee']);
      });
  }

}