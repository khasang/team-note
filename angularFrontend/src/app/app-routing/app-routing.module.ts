import {NgModule} from "@angular/core";
import {TasksComponent} from "../main-board/tasks/tasks.component";
import {GoalsComponent} from "../main-board/goals/goals.component";
import {GroupsComponent} from "../main-board/groups/groups.component";
import {ProjectsComponent} from "../main-board/projects/projects.component";
import {ReportsComponent} from "../main-board/reports/reports.component";
import {StatusTasksComponent} from "../main-board/status-tasks/status-tasks.component";
import {TaskEditComponent} from "../main-board/tasks/task-edit/task-edit.component";
import {RouterModule, Routes} from "@angular/router";

const routes:Routes = [
  {path:"",redirectTo:"/tasks/me",pathMatch:"full"},
  {path:"tasks/:executor",component:TasksComponent},
  {path:"goals",component:GoalsComponent},
  {path:"groups",component:GroupsComponent},
  {path:"projects",component:ProjectsComponent},
  {path:"reports",component:ReportsComponent},
  {path:"status_tasks",component:StatusTasksComponent},
  {path:"tasks/:executor/:changeOperation/:id",component:TaskEditComponent},
  {path:"tasks/:executor/:changeOperation",component:TaskEditComponent},
  {path:"**",redirectTo:"/tasks/me"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule {
}
