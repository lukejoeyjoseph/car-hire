import { NgModule } from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';

import { AppComponent } from '../app.component';
import { MainPageComponent } from '../components/main-page/main-page.component';
import { RentListComponent } from '../components/rent-list/rent-list.component';
import { EmployeeListComponent } from '../components/employee-list/employee-list.component';
import { StoreListComponent } from '../components/store-list/store-list.component';
import { CustomerListComponent } from '../components/customer-list/customer-list.component';
import { RentFormComponent} from '../components/rent-form/rent-form.component';
import { CarListComponent} from '../components/car-list/car-list.component';
import { CustomerFormComponent } from '../components/customer-form/customer-form.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    component: MainPageComponent
  },
  {
    path: 'rents',
    component: RentListComponent
  },
  {
    path: 'employees',
    component: EmployeeListComponent
  },
  {
    path: 'stores',
    component: StoreListComponent
  },
  {
    path: 'customers',
    component: CustomerListComponent
  },
  {
    path: 'cars',
    component: CarListComponent
  },
  {
    path: 'add-rent',
    component: RentFormComponent
  },
  {
    path: 'add-customer',
    component: CustomerFormComponent
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }