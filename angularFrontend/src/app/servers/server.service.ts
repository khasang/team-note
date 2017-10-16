import {Injectable} from "@angular/core";

@Injectable()
export class ServerService {

  servers: { id: number, name: string, status: string }[];

  constructor() {
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
    this.servers[server.id] = server;
  }
}
