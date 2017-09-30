import {Component,OnInit} from "@angular/core";
import {Task} from "./main-board/tasks/task.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  loadedFeature: string;
  taskArray:Task[] = [];

  onNavigateSidebar(feature: string) {
    this.loadedFeature = feature;
    if(feature==='inputTasks'){this.taskArray = this.createTestInputTasks();}
    if(feature==='outputTasks'){this.taskArray = this.createTestOutputTasks();}

  }

//for test only
  createTestInputTasks() {
    var taskArray:Task[] = [];
    var task = new Task("Забрать машину", "Галя","Я");
    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task("Написать first-page", "Сергей","Я"));
    taskArray.push(new Task("Купить подарок", "Павел","Я"));
    taskArray.push(new Task("Разобраться с Angular", "Павел","Я"));
    return taskArray;
  }

//for test only
  createTestOutputTasks() {
    var taskArray:Task[] = [];
    var task = new Task("Выучить стихотворение", "Я","Даша");

    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task("Написать книгу", "Я","Маша"));
    return taskArray;
  }


}
