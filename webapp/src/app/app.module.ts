import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';

import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MaterialModule} from './model/material/material.module';
import {FlexLayoutModule} from '@angular/flex-layout';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from '@angular/forms';
import {ReactiveFormsModule} from '@angular/forms';

import { EmployeeService } from './service/employee/employee.service';
import { ListEmployeeComponent } from './component/employee/list-employee/list-employee.component'
import { AddEmployeeComponent } from './component/employee/add-employee/add-employee/add-employee.component';
import { EditEmployeeComponent } from './component/employee/edit-employee/edit-employee/edit-employee.component';
import { DashboardComponent } from './component/dashboard/dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    ListEmployeeComponent,
    AddEmployeeComponent,
    EditEmployeeComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,    
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    FlexLayoutModule,    
    RouterModule.forRoot([
      { path: '', component: DashboardComponent },
      { path: 'list-employee', component: ListEmployeeComponent },
      { path: 'add-employee', component: AddEmployeeComponent },
      { path: 'edit-employee', component: EditEmployeeComponent }
    ]),
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
