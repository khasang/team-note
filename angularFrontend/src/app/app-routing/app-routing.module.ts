import {NgModule} from "@angular/core";
import {TasksComponent} from "../main-board/tasks/tasks.component";
import {GoalsComponent} from "../main-board/goals/goals.component";
import {GroupsComponent} from "../main-board/groups/groups.component";
import {ProjectsComponent} from "../main-board/projects/projects.component";
import {ReportsComponent} from "../main-board/reports/reports.component";
import {StatusTasksComponent} from "../main-board/status-tasks/status-tasks.component";
import {TaskEditComponent} from "../main-board/tasks/task-edit/task-edit.component";
import {RouterModule, Routes} from "@angular/router";
import {TaskListComponent} from "../main-board/tasks/task-list/task-list.component";

const routes:Routes = [
  {path:"",redirectTo:"/tasks/me/list",pathMatch:"full"},
  {path:"tasks/:executor",component:TasksComponent, children:[
    {path:"list",component:TaskListComponent},
    {path:"new",component:TaskEditComponent},
    {path:"edit/:id",component:TaskEditComponent},
  ]},
  {path:"status_tasks",component:StatusTasksComponent},
  {path:"goals",component:GoalsComponent},
  {path:"groups",component:GroupsComponent},
  {path:"projects",component:ProjectsComponent},
  {path:"reports",component:ReportsComponent},
  {path:"**",redirectTo:"/tasks/me/list"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule {
}
