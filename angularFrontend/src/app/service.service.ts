import {Injectable} from "@angular/core";
import {Headers, Http,Response} from "@angular/http";
import 'rxjs/Rx';

@Injectable()
export class ServiceService {
  constructor(private http: Http) {
  }

  storeServers(servers: any[]) {
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http.put(
      'https://angular-study-859f4.firebaseio.com/data.json',
      servers,
      {headers: headers}
    );
  }

  getServers() {
    return this.http.get('https://angular-study-859f4.firebaseio.com/data.json')
      .map((response: Response) => {
        const data = response.json();
        return data;
      });
  }
}
