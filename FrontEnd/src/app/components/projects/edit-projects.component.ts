import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Projects } from 'src/app/model/projects';
import { SProjectsService } from 'src/app/service/s-projects.service';

@Component({
  selector: 'app-edit-projects',
  templateUrl: './edit-projects.component.html',
  styleUrls: ['./edit-projects.component.css']
})
export class EditProjectsComponent implements OnInit {
  pro: Projects = null;

  constructor(private sProjects: SProjectsService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProjects.detail(id).subscribe(
      data =>{
        this.pro = data;
      }, err =>{        
        alert ('Error al editar proyecto')
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProjects.update(id, this.pro).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert ("Error al editar proyecto");
        this.router.navigate(['']);
      }
    )

  }

}
