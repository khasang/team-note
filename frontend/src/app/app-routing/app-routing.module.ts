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
import {TestRoleComponentComponent} from "../test-role-component/test-role-component.component";
import {SignupComponent} from "../auth/signup/signup.component";
import {SigninComponent} from "../auth/signin/signin.component";
import {AuthGuard} from "../auth/auth-guard.service";

const routes:Routes = [
  {path:"",redirectTo:"task/all",pathMatch:"full"},
  {path:"task",component:TasksComponent, children:[
    {path:"all",component:TaskListComponent},
    {path:"new",component:TaskEditComponent},
    {path:"edit/:id",component:TaskEditComponent},
  ]},


  {path:"status_tasks",component:StatusTasksComponent},
  {path:"goals",component:GoalsComponent},
  {path:"groups",component:GroupsComponent},
  {path:"projects",component:ProjectsComponent},
  {path:"reports",component:ReportsComponent},
  {path:"roles",component:TestRoleComponentComponent},
  {path:"signup",component:SignupComponent},
  {path:"signin",component:SigninComponent},
  {path:"logout",component:SigninComponent},
  {path:"**",redirectTo:""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule {
}
