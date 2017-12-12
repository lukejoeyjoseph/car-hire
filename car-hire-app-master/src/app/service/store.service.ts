import { Injectable } from '@angular/core';
import { Store} from '../model/store';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class StoreService {
  
  getStores() : Promise<Store[]> {
    return this.http.get<Store[]>('api/stores/visitor').toPromise();
  }

  getStoreNames(): Promise<string[]> {
    return this.http.get<string[]>('api/stores/names').toPromise();
  }

  constructor(private http: HttpClient) { }

}
