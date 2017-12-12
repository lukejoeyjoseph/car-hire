import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class EmployeeService {

  getEmployees() {
    return this.http.get<Employee[]>("api/employees/visitor").toPromise();
  }

  constructor(private http: HttpClient) { }

}
