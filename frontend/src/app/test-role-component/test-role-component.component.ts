import { Component, OnInit } from '@angular/core';
import {TestRoleService} from "./test-role-service";

@Component({
  selector: 'app-test-role-component',
  templateUrl: './test-role-component.component.html',
  styleUrls: ['./test-role-component.component.css']
})
export class TestRoleComponentComponent implements OnInit {

  constructor(private testRoleService:TestRoleService) { }

  ngOnInit() {
  }

  loadData(){
    this.testRoleService.loadRolesFromDB();
  }
}
