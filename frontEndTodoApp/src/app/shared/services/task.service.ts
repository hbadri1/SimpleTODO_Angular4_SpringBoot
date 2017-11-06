import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Task } from '../models';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class TaskService {

  tasksUrl = "/api/allTasks";
  deleteUrls = "/api/delete";
  createUrl = "/api/add";
  updateUrl = "/api/update";

  constructor(private http: Http) { }


  getAllTasks(): Promise<Task[]> {
    return this.http.get(this.tasksUrl)
      .toPromise()
      .then(res => res.json() as Task[])
      .catch(this.handlError);
  }

  removeTask(task: Task): Promise<any> {
    let url = this.deleteUrls + `/${task.id}`;
    return this.http.delete(url)
      .toPromise()
      .catch(this.handlError);
  }

  creatTask(task: Task): Promise<Task> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    return this.http.post(this.createUrl, task, { headers: cpHeaders })
      .toPromise()
      .then(res => res.json() as Task)
      .catch(this.handlError);
  }

  updateTask(task: Task): Promise<Task> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    console.log(task)
    return this.http.put(this.updateUrl, task, { headers: cpHeaders })
      .toPromise()
      .then(res => res.json().data)
      .catch(this.handlError);
  }

  private handlError(error: any): Promise<any> {
    return Promise.reject(error.message | error);
  }
}
