import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ServersComponent} from "../servers/servers.component";
import {ServerComponent} from "../servers/server/server.component";
import {EditServerComponent} from "../servers/edit-server/edit-server.component";
import {UsersComponent} from "../users/users.component";
import {UserComponent} from "../users/user/user.component";
import {HomeComponent} from "../home/home.component";
import {PageNotFoundComponent} from "../page-not-found/page-not-found.component";

const appRouts: Routes = [
  {
    path: "servers", component: ServersComponent, children: [
    {path: ":id", component: ServerComponent},
    {path: ":id/edit", component: EditServerComponent}]
  },
  {
    path: "users", component: UsersComponent, children: [
    {path: ":id/:name", component: UserComponent}]
  },
  {path: "", component: HomeComponent},
  {path: "not-found", component: PageNotFoundComponent},
  {path: "**", redirectTo: "/not-found"}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRouts)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule {
}
