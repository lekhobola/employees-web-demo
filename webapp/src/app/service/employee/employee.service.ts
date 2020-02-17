import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../../model/employee/employee.module';
import { Observable } from 'rxjs';
 
@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/employees-demo/api/v1/employees';

  getEmployees() : Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl);
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.http.get<Employee>(this.baseUrl + '/' + id);
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.baseUrl, employee);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.baseUrl + '/' + employee.id, employee);
  }

  deleteEmployee(id: number): Observable<Employee> {
    return this.http.delete<Employee>(this.baseUrl + '/' + id);
  }
}