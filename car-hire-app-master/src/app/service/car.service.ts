import { Injectable } from '@angular/core';
import { Car } from '../model/car';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CarService {

  getCars(): Promise<Car[]> {
    return this.http.get<Car[]>("api/cars/visitor").toPromise();
  }

  getMakes(): Promise<string[]> {
    return this.http.get<string[]>("api/cars/makes").toPromise();
  }

  getModelsByMake(make:string): Promise<string[]> {
    return this.http.get<string[]>("api/cars/models/"+make).toPromise();
  }

  getModels(): Promise<string[]> {
    return this.http.get<string[]>("api/cars/models").toPromise();
  }

  constructor(private http: HttpClient) { }

}
