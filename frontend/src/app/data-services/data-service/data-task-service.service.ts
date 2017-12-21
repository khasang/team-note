import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Task} from "../../app-entities/task.entity";
import {AuthService} from "../../auth/auth.service";
import {User} from "../../sharing/entities/user.entity";

@Injectable()
export class DataTaskService {
  taskUrl = "http://localhost:8080/tasks/";

  constructor(private http: Http,
              private authService: AuthService) {
  }

  getAll(){
    return this.http.get(this.taskUrl)
  }

  putTask(task) {
    //const token  = this.authService.getToken();
    //return this.http.put("https://team-note-firebase.firebaseio.com/tasks.json?auth="+token, tasks);
    return this.http.put(this.taskUrl+task.id,task);
  }

  getTaskById(id:number){
    //const token  = this.authService.getToken();
    //return this.http.get("https://team-note-firebase.firebaseio.com/tasks.json?auth="+token);
    return this.http.get(this.taskUrl+"taskId/",id);
  }

  getTaskByExecutor(user:User){
    return this.http.get(this.taskUrl+"executor/"+user.id);
  }

  getTaskByCreator(user:User){
    return this.http.get(this.taskUrl+"creator/"+user.id)
  }

  deleteTask(id:number){
    return this.http.get(this.taskUrl,id);
  }

}
