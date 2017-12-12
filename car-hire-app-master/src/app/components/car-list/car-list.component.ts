import { Component, OnInit } from '@angular/core';
import { Car } from '../../model/car';
import { CarService } from '../../service/car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  cars: Car[] = [];

  constructor(private carSerive: CarService) { 
  }

  async ngOnInit() {
    this.cars = await this.carSerive.getCars();
  }

}
