import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit,OnDestroy {

  server:{id:number,name:string};
  paramsSubscriptions: Subscription;

  constructor(private rout:ActivatedRoute) {
    this.paramsSubscriptions = this.rout.params.subscribe(
      (params:Params) => {

        this.server = {
          id:params['id'],
          name:params['name']
        };
      }
    )
  }

  ngOnInit() {
    this.server = {
      id:this.rout.snapshot.params['id'],
      name:this.rout.snapshot.params['name']
    };
  }
  ngOnDestroy(): void {
    this.paramsSubscriptions.unsubscribe();
  }

}
