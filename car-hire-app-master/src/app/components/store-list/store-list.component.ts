import { Component, OnInit } from '@angular/core';
import { Store } from '../../model/store';
import { StoreService } from '../../service/store.service';

@Component({
  selector: 'app-store-list',
  templateUrl: './store-list.component.html',
  styleUrls: ['./store-list.component.css']
})
export class StoreListComponent implements OnInit {

  stores: Store[] = [];

  constructor(private storeService:StoreService ) { 

  }

  async ngOnInit() {
    this.stores = await this.storeService.getStores();
  }

}
