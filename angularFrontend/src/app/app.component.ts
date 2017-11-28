import {Component} from "@angular/core";
import {ServiceService} from "./service.service";
import {Response} from "@angular/http";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent {
  servers: { name: string, id: number }[] = [
    {name:"firstServer",id:123568},
    {name:"secondServer",id:126768}
  ];

  constructor(private serviceService:ServiceService){}

  onAddServer(serverName: string) {
    var server = {
      name:serverName,
      id:this.generateID()
    }
      this.servers.push(server);
  }

  onSave(){
    this.serviceService.storeServers(this.servers)
      .subscribe(
        (response)=>console.log(response),
        (error)=>console.log(error)
      );
  }

  onGet(){
    this.serviceService.getServers().subscribe(
      (servers:any[])=>{
        this.servers = servers;
      },
      (error)=>console.log(error)
    )
  }

  generateID() {
    let id = Math.round(Math.random()*10000);
    return id;
  }


}
