import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Filter } from '../../model/filter';
import { CarService } from '../../service/car.service';
import { StoreService } from '../../service/store.service';
import { CustomerService } from '../../service/customer.service';
import { RentService } from '../../service/rent.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-rent-filter',
  templateUrl: './rent-filter.component.html',
  styleUrls: ['./rent-filter.component.css']
})
export class RentFilterComponent implements OnInit {
  @Output() filterRentsEvent = new EventEmitter<Filter>();

  attributes: string[] = ['Ügyfél neve', 'Autó márkája', 'Autó típusa', 'Üzlet neve'];
  values: string[] = [];
  selectedAtrribute: string = '';
  
  model: Filter;
  filterForm: FormGroup;

  constructor(
    private carService: CarService,
    private customerService: CustomerService,
    private storeService: StoreService,
    private rentService: RentService,
    private http: HttpClient,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.createForm();
  }

  async setSelectedAttribute(attribute) {
    this.selectedAtrribute = attribute;

    switch (this.selectedAtrribute) {
      case this.attributes[0]: {
        this.values = await this.customerService.getCustomerNames();
        break;
      }
      case this.attributes[1]: {
        this.values = await this.carService.getMakes();
        break;
      }
      case this.attributes[2]: {
        this.values = await this.carService.getModels();
        break;
      }
      case this.attributes[3]: {
        this.values = await this.storeService.getStoreNames();
        break;
      }
      case this.attributes[4]: {
        this.values = await this.rentService.getRentDates();
        break;
      }
    }
  }

  createForm() {
    this.filterForm = this.fb.group({
      type: ['', Validators.required],
      value: ['', Validators.required]
    });
  }

  submit() {
    //Model értékének beállítása:
    this.model = this.filterForm.value;
      
    switch( this.model.type ) {
      case this.attributes[0]: {
        this.model.type="customerName"
        break;
      }
      case this.attributes[1]: {
        this.model.type="carMake"
        break;
      }
      case this.attributes[2]: {
        this.model.type="carModel"
        break;
      }
      case this.attributes[3]: {
        this.model.type="storeName"
        break;
      }
      case this.attributes[4]: {
        this.model.type="rentDate"
        break;
      }
    }

    this.filterRentsEvent.next(this.model);
    console.log(this.model);

    //Form kinullázása:
    this.filterForm.reset();
  }
}
