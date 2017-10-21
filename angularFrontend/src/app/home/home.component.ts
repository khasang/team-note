import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../auth-guard/auth.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private authService:AuthService,private router:Router) { }

  ngOnInit() {
  }
  onLoadServer(id:number){
    this.router.navigate(["/servers",id,'edit'],{queryParams:{"allowEdit":1},fragment:"loading"});
  }
  loginOrOut(isAuthenticated:boolean){
    if(isAuthenticated) {
      this.authService.login();
    } else{
      this.authService.logout();
    }
  }
}
