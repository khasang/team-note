import {Injectable} from "@angular/core";
import {Headers,Http} from "@angular/http";

@Injectable()
export class DataTestRoleService{
  constructor(private http:Http){}

  getAllRoles(){
    return this.http.get("http://localhost:8080/roles/all");
  }
}
