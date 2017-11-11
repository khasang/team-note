import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  constructor(private route: ActivatedRoute) {
  }

  id: number;

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.id=params['id'];
      }
    )
  }

}
