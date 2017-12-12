import { Component, OnInit } from '@angular/core';
import { RentFilterComponent } from '../rent-filter/rent-filter.component';
import { RentService } from '../../service/rent.service';
import { Rent } from '../../model/rent';
import { Filter } from '../../model/filter';

@Component({
  selector: 'app-rent-list',
  templateUrl: './rent-list.component.html',
  styleUrls: ['./rent-list.component.css']
})
export class RentListComponent implements OnInit {

  rents: Rent[] = [];

  constructor(
    private rentService: RentService
  )
  { }

  async filterRents(filter: Filter) {
    this.rents = await this.rentService.getFilteredRents(filter);
  }

  async ngOnInit() {
    this.rents = await this.rentService.getRents();
  }

}
