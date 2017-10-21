import {Injectable} from "@angular/core";

@Injectable()
export class ServerService {

  servers: { id: number; name: string, status: string }[] = [
    {id: 1, name: 'first', status: "old"},
    {id: 2, name: 'second', status: "old"},
    {id: 3, name: 'third', status: "old"}
  ];

  constructor() {  }

  getServers() {
    return this.servers;
  }

  getServer(id: number) {
    const server = this.servers.find(
      (s) => {
        return s.id === id;
      }
    );
    return server;
  }

  updateServer(server: { id: number, name: string, status: string }) {
    const updateServer = this.servers.find(
      (s) => {
        return s.id === server.id;
      }
    );
    if(updateServer){
      updateServer.name = server.name;
      updateServer.status = server.status;
    }
  }
}
