import { Component, OnInit } from '@angular/core';
import {ServerService} from "../server.service";

@Component({
  selector: 'app-edit-server',
  templateUrl: './edit-server.component.html',
  styleUrls: ['./edit-server.component.css']
})
export class EditServerComponent implements OnInit {

  server:{id:number,name:string,status:string};
  serverName='';
  serverStatus=''
  ;
  constructor(private serverService:ServerService) { }

  ngOnInit() {
    this.server = this.serverService.getServer(1);
    this.serverName = this.server.name;
    this.serverStatus = this.server.status;
  }

  updateServer(){
    this.serverService.updateServer(this.server);
  }

}
