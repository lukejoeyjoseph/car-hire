import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core'; 
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { StoreService } from '../../service/store.service';
import { CarService } from '../../service/car.service';
import { CustomerService } from '../../service/customer.service';
import { Rent } from '../../model/rent';
import { RentService } from '../../service/rent.service';

@Component({
  selector: 'app-rent-form',
  templateUrl: './rent-form.component.html',
  styleUrls: ['./rent-form.component.css']
})
export class RentFormComponent implements OnInit {
  storeNames: string[] = [];
  customerNames: string[] = [];
  makes: string[] = [];
  models: string[] = [];

  rentForm: FormGroup;
  model: Rent;

  async refreshModels(make:string) {
    this.models = await this.carService.getModelsByMake(make);
  }
  
  constructor(
    private storeService: StoreService,
    private carService: CarService,
    private customerService: CustomerService,
    private rentService: RentService,
    private http: HttpClient,
    private fb: FormBuilder
  ) 
  { 
    this.createForm();
  }

  async ngOnInit() {
    this.storeNames = await this.storeService.getStoreNames();
    this.makes = await this.carService.getMakes();
    this.customerNames = await this.customerService.getCustomerNames();
  }

  createForm() {
    this.rentForm = this.fb.group({
      customerName: ['', Validators.required],
      storeName: ['', Validators.required],
      carMake: ['', Validators.required],
      carModel: ['', Validators.required],
      note: '-',
      employeeName: 'Ez a funkció még nem támogatott!',
      rentDate: this.createActualDate(),
    });
  }

  createActualDate(): string {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    var date;
    if( dd< 10 && mm<10)
      date = yyyy.toString()+'. 0'+mm.toString()+'. 0'+dd.toString()+'.';
    else if ( dd< 10 )
      date = yyyy.toString()+'. '+mm.toString()+'. 0'+dd.toString()+'.';
    else if ( mm< 10 )
      date = yyyy.toString()+'. 0'+mm.toString()+'. '+dd.toString()+'.';
    else
      date = yyyy.toString()+'. '+mm.toString()+'. '+dd.toString()+'.';
    return date;
  }

  initModel() {
    this.model = this.rentForm.value;
    this.model.carMake = this.rentForm.value.carMake[0];
    this.model.carModel = this.rentForm.value.carModel[0];
  }

  submit() {
    //Model értékének beállítása:
    this.initModel();

    //Kölcsönzés felvétele:
    this.rentService.createRent(this.model);
    
    //Form kinullázása:
    this.rentForm.reset();
  }
}
