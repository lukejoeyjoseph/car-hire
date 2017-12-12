import { Injectable } from '@angular/core';
import { Customer } from '../model/customer';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class CustomerService {
 
  getCustomers() : Promise<Customer[]> {
    return this.http.get<Customer[]>('api/customers/visitor').toPromise();
  }

  getCustomerNames(): Promise<string[]> {
    return this.http.get<string[]>('api/customers/names').toPromise();
  }

  createCustomer(customer: Customer) {
    /*
      http://localhost:8080/api/customers/add -- hova küldjük
      JSON.stringify(this.model) -- a model JSON-né alakítása
      headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8') -- headerben a content-type beállítása
    */
      this.http.post('http://localhost:8080/api/customers/add', JSON.stringify(customer), {
        headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8'),
      }).subscribe();
  }

  constructor(private http: HttpClient) { }

}
