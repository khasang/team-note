import {Component, OnInit} from "@angular/core";
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
  private allowEdit: boolean = false;


  constructor(private serverService: ServerService,
              private rout: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.rout.queryParams.subscribe(
      (queryParams: Params) => {
        this.allowEdit = queryParams['allowEdit'] === '1' ? true : false;
      }
    );
    this.serverId = this.rout.snapshot.params['id'];
    this.server = this.serverService.getServer(+this.serverId);

    this.serverName = this.server.name;
    this.serverStatus = this.server.status;
  }

  updateServer() {

    this.serverService.updateServer({
      id: this.server.id,
      name: this.serverName,
      status: this.serverStatus
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
