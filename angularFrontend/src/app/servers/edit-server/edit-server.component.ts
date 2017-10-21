import {Component, OnInit, ViewChild} from "@angular/core";
import {ServerService} from "../server.service";
import {ActivatedRoute, Params, Router} from "@angular/router";

@Component({
  selector: 'app-edit-server',
  templateUrl: './edit-server.component.html',
  styleUrls: ['./edit-server.component.css']
})
export class EditServerComponent implements OnInit {
  firstClickFields: string[] = [];
  server: { id: number, name: string, status: string };
  serverId: number = -1;


  serverName = '';
  serverStatus = '';



  constructor(private serverService: ServerService,
              private rout: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.rout.queryParams.subscribe(
      (queryParams:Params) =>{
        console.log(queryParams['allowEdit']);
      }
    );
    this.serverId = this.rout.snapshot.params['id'];
    this.server = this.serverService.getServer(+this.serverId);

    this.serverName = this.server.name;
    this.serverStatus = this.server.status;
  }

  updateServer() {

    this.serverService.updateServer({
      id:this.server.id,
      name:this.serverName,
      status:this.serverStatus
    });
    this.router.navigate(['/servers']);
  }

  cancel() {
    this.router.navigate(['/servers']);
  }

  clear(fieldName: string, field: HTMLInputElement) {
    const checkName = this.firstClickFields.find(
      (name) => {
        return name === fieldName;
      }
    );
    if (!checkName) {
      field.value = "";
      this.firstClickFields.push(fieldName);
    }
  }

}
