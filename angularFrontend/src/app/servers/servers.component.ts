import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
servers:{id:number;name:string}[] = [
  {id:1,name:'first'},
  {id:2,name:'second'},
  {id:3,name:'third'}
];
  constructor() {

  }

  ngOnInit() {
  }

}
