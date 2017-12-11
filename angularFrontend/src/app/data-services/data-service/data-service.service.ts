import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Task} from "../../app-entities/task.entity";
import {AuthService} from "../../auth/auth.service";

@Injectable()
export class DataServiceService {

  constructor(private http: Http,
              private authService: AuthService) {
  }

  saveTaskToDB(tasks:Task[]) {
    const token  = this.authService.getToken();
    console.log("token = "+token);
    return this.http.put("https://team-note-firebase.firebaseio.com/tasks.json?auth="+token, tasks);
  }

  getTaskFromDB() {
     const token  = this.authService.getToken();
     console.log("token = "+token);
     return this.http.get("https://team-note-firebase.firebaseio.com/tasks.json?auth="+token);
  }

}
