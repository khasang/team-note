import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { MainBoardComponent } from './main-board/mainBoard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { TasksComponent } from './main-board/tasks/tasks.component';
import { TaskListComponent } from './main-board/tasks/task-list/task-list.component';
import { TaskDetailComponent } from './main-board/tasks/task-detail/task-detail.component';
import { TaskItemComponent } from './main-board/tasks/task-list/task-item/task-item.component';

@NgModule({
  declarations: [
    AppComponent,
    MainBoardComponent,
    NavbarComponent,
    SidebarComponent,
    TasksComponent,
    TaskListComponent,
    TaskDetailComponent,
    TaskItemComponent
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
