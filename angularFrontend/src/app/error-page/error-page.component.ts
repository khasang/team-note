import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-error-page',
  templateUrl: './error-page.component.html',
  styleUrls: ['./error-page.component.css']
})
export class ErrorPageComponent implements OnInit {
  errorMessage:string;

  constructor(private rout:ActivatedRoute) { }

  ngOnInit() {
    this.rout.data.subscribe(
      (data:Params)=>{
      this.errorMessage = data['errorMessage'];
    }
    )

  }

}
