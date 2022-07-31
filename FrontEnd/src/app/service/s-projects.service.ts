import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Projects } from '../model/projects';

@Injectable({
  providedIn: 'root'
})
export class SProjectsService {
  proURL = 'http://localhost:8080/pro/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Projects[]>{
    return this.httpClient.get<Projects[]>(this.proURL + 'lista');
  }

  public detail(id: number): Observable<Projects>{
    return this.httpClient.get<Projects>(this.proURL + `detail/${id}`);
  }

  public save(projects: Projects): Observable<any>{
    return this.httpClient.post<any>(this.proURL + 'create', projects);
  }

  public update(id: number, projects: Projects): Observable<any>{
    return this.httpClient.put<any>(this.proURL + `update/${id}`, projects);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.proURL + `delete/${id}`);
  }
}
