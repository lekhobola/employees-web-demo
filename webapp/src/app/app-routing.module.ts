import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ListEmployeeComponent} from './component/employee/list-employee/list-employee.component';

const routes: Routes = [
  { path: 'list-employee', component: ListEmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
