import {Injectable} from "@angular/core";
import {DataTestRoleService} from "../data-services/data-service/data-test-role-service";
import {Response} from "@angular/http";
import {Role} from "../app-entities/role.entity";

@Injectable()
export class TestRoleService{
    constructor(private dataTestRoleService:DataTestRoleService){}

    roles:Role[] = [];

    loadRolesFromDB(){
      this.dataTestRoleService.getAllRoles()
        .subscribe(
        (response:Response)=>{
          console.log(response);
        }
      )
    }
}
