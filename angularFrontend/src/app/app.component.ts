import {Component} from "@angular/core";
import {Task} from "./main-board/tasks/task.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  loadedFeature: string = '';
  taskArray:Task[] = [];

  onNavigateSidebar(feature: string) {
    this.loadedFeature = feature;
    if(feature==='inputTasks'){this.taskArray = this.createTestInputTasks();}
    if(feature==='outputTasks'){this.taskArray = this.createTestOutputTasks();}

  }

  createTestInputTasks() {
    var taskArray:Task[] = [];
    var task = new Task("Забрать машину", "Галя");
    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task("Написать first-page", "Сергей"));
    taskArray.push(new Task("Купить подарок", "Павел"));
    taskArray.push(new Task("Разобраться с Angular", "Павел"));
    return taskArray;
  }

  createTestOutputTasks() {
    var taskArray:Task[] = [];
    var task = new Task("Выучить стихотворение", "Даша");
    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task("Написать книгу", "Юля"));
    return taskArray;
  }
}
