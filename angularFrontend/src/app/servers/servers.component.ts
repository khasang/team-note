import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
servers:{name:string}[] = [
  {name:'first'},
  {name:'second'},
  {name:'third'}
];
  constructor() { }

  ngOnInit() {
  }

}
