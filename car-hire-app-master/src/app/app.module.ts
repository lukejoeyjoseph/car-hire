import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { RentListComponent } from './components/rent-list/rent-list.component';

import { RoutingModule } from './routing/routing.module';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { StoreListComponent } from './components/store-list/store-list.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { RentFormComponent } from './components/rent-form/rent-form.component';
import { RentFilterComponent } from './components/rent-filter/rent-filter.component';
import { CarListComponent } from './components/car-list/car-list.component';

import {CarService} from './service/car.service';
import {StoreService} from './service/store.service';
import {RentService} from './service/rent.service';
import {CustomerService} from './service/customer.service';
import {EmployeeService} from './service/employee.service';
import { CarouselComponent } from './components/carousel/carousel.component';
import { CustomerFormComponent } from './components/customer-form/customer-form.component';

import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    MainPageComponent,
    RentListComponent,
    EmployeeListComponent,
    StoreListComponent,
    CustomerListComponent,
    RentFormComponent,
    RentFilterComponent,
    CarListComponent,
    CarouselComponent,
    CustomerFormComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    CarService,
    StoreService,
    RentService,
    CustomerService,
    EmployeeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
