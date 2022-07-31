import { Component, OnInit } from '@angular/core';
import { Projects } from 'src/app/model/projects';
import { SProjectsService } from 'src/app/service/s-projects.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  pro: Projects[] = [];

  constructor(private sProjects: SProjectsService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarProyectos();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProyectos(): void {
    this.sProjects.lista().subscribe(data => { this.pro = data; });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sProjects.delete(id).subscribe(
        data => {
          this.cargarProyectos();
        }, err => {
          alert("No se pudo borrar el proyecto!");

        }
      )
    }
  }

}
