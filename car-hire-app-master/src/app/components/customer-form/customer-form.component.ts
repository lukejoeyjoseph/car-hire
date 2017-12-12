import { Component, Input, Output, EventEmitter } from '@angular/core'; 
import { Customer } from '../../model/customer';
import { CustomerService } from '../../service/customer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {
  
  customerForm: FormGroup;
  model: Customer;

  genders: string[] = ['Férfi', 'Nő'];
  
    constructor(
      private fb: FormBuilder,
      private http: HttpClient,
      private customerService: CustomerService
    ) { 
      this.createForm();
    }
  
    createForm() {
      this.customerForm = this.fb.group({
        name: ['', Validators.required],
        birth: ['', Validators.required],
        address: ['', Validators.required],
        gender: ['', Validators.required],
        idNumber: ['', Validators.required],
        loans: 0,
        joined: 2017,
      });
    }

    submit() {
      //Model értékének beállítása:
      this.model = this.customerForm.value;
      //Customer felvétele: 
      this.customerService.createCustomer(this.model);
      //Form kinullázása:
      this.createForm();
    }
}