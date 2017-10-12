import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {RouterModule, Routes} from '@angular/router'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ServersComponent } from './servers/servers.component';
import { UsersComponent } from './users/users.component';
import { EditServerComponent } from './servers/edit-server/edit-server.component';
import { ServerComponent } from './servers/server/server.component';
import { UserComponent } from './users/user/user.component';
import {ServerService} from "./servers/server.service";

const appRouts:Routes = [

  {path:"servers",component:ServersComponent},
  {path:"users",component:UsersComponent},
  {path:"users/:id/:name",component:UserComponent},
  {path:"",component:HomeComponent}
  ];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ServersComponent,
    UsersComponent,
    EditServerComponent,
    ServerComponent,
    UserComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRouts)
  ],
  providers: [ServerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
