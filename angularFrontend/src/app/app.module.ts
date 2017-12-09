import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {MainBoardComponent} from "./main-board/mainBoard.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {SidebarComponent} from "./sidebar/sidebar.component";
import {TasksComponent} from "./main-board/tasks/tasks.component";
import {TaskListComponent} from "./main-board/tasks/task-list/task-list.component";
import {TaskItemComponent} from "./main-board/tasks/task-list/task-item/task-item.component";
import {TaskEditComponent} from "./main-board/tasks/task-edit/task-edit.component";
import {StatusTasksComponent} from "./main-board/status-tasks/status-tasks.component";
import {GroupsComponent} from "./main-board/groups/groups.component";
import {ProjectsComponent} from "./main-board/projects/projects.component";
import {GoalsComponent} from "./main-board/goals/goals.component";
import {ReportsComponent} from "./main-board/reports/reports.component";
import {TestTaskBD} from "./testTaskBD";
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {DataServiceService} from "./data-services/data-service/data-service.service";
import {DataTestRoleService} from "./data-services/data-service/data-test-role-service";
import {TaskService} from "./main-board/tasks/task.service";
import { TestRoleComponentComponent } from './test-role-component/test-role-component.component';
import {TestRoleService} from "./test-role-component/test-role-service";


@NgModule({
  declarations: [
    AppComponent,
    MainBoardComponent,
    NavbarComponent,
    SidebarComponent,
    TasksComponent,
    TaskListComponent,
    TaskItemComponent,
    TaskEditComponent,
    StatusTasksComponent,
    GroupsComponent,
    ProjectsComponent,
    GoalsComponent,
    ReportsComponent,
    TestRoleComponentComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [
    TestTaskBD,
    DataServiceService,
    TaskService,
    TestRoleService,
    DataTestRoleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
