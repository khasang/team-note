import {Injectable} from "@angular/core";
import {Headers,Http} from "@angular/http";

@Injectable()
export class DataTestRoleService{
  constructor(private http:Http){}

  getAllRoles(){
    const headers = new Headers(
      {'Accept':'*/*',
      "Cash-Control":"no-cash"}
    );
    return this.http.get(
      "http://localhost:8080/roles/all",
      {headers:headers}
      );
  }
}
