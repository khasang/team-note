import {Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent implements OnInit {

  someServer={
    name:"first",
    value:"50",
    description:"Some text fffffffffffffdfdfdfdfd"+"...",
    date:new Date()
  };


  constructor() {}

  ngOnInit() { }
}
