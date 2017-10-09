import {EventEmitter, Injectable} from '@angular/core';

@Injectable()
export class TaskService {
  taskEmitter = new EventEmitter<string>();

  chooseLayout(mes:string){
    this.taskEmitter.emit(mes);
  }

  constructor() { }

}
