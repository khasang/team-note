import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {ServerService} from "../server.service";

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit,OnDestroy {

  server:{id:number,name:string};
  paramsSubscriptions: Subscription;


  constructor(private rout:ActivatedRoute,
              private serverService:ServerService,
              private router:Router) {
  }

  ngOnInit() {
    this.server = this.serverService.getServer(+this.rout.snapshot.params['id']);
    this.paramsSubscriptions = this.rout.params.subscribe(
      (params:Params) => {
        this.server=this.serverService.getServer(+params['id']);
      }
    )


  }
  ngOnDestroy(): void {
    this.paramsSubscriptions.unsubscribe();
  }

  onEdit(){
    this.router.navigate(["edit"],{relativeTo:this.rout});
  }

}
