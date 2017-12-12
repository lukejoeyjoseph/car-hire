import { Injectable } from '@angular/core';
import { Rent } from '../model/rent';
import { Filter } from '../model/filter';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class RentService {

  constructor(
    private http: HttpClient)
  { }

  getRents() {
    return this.http.get<Rent[]>("api/rents/visitor").toPromise();
  }

  getRentDates() {
    return this.http.get<string[]>("api/rents/dates").toPromise();
  }

  /*
    Annak megfelelően, hogy melyik attribútumra hívtuk meg
    tudunk keresni speciális értékre
  */
  getFilteredRents(filter: Filter) {
    switch (filter.type) {
      case 'customerName': {
        return this.http.get<Rent[]>("api/rents/list/customerName/"+filter.value).toPromise();
      }
      case 'carMake': {
        return this.http.get<Rent[]>("api/rents/list/carMake/"+filter.value).toPromise();
      }
      case 'carModel': {
        return this.http.get<Rent[]>("api/rents/list/carModel/"+filter.value).toPromise();
      }
      case 'storeName': {
        return this.http.get<Rent[]>("api/rents/list/storeName/"+filter.value).toPromise();
      }
      case 'rentDate': {
        return this.http.get<Rent[]>("api/rents/list/rentDate/"+filter.value).toPromise();
      }
      default:
        return this.getRents();
    }
  }

  createRent(rent: Rent) {
    /*
      http://localhost:8080/api/customers/add -- hova küldjük
      JSON.stringify(this.model) -- a model JSON-né alakítása
      headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8') -- headerben a content-type beállítása
    */
    this.http.post('http://localhost:8080/api/rents/add', JSON.stringify(rent), {
      headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8'),
    }).subscribe();
  }

}
