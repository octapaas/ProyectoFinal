import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Projects } from 'src/app/model/projects';
import { SProjectsService } from 'src/app/service/s-projects.service';

@Component({
  selector: 'app-new-projects',
  templateUrl: './new-projects.component.html',
  styleUrls: ['./new-projects.component.css']
})
export class NewProjectsComponent implements OnInit {

  nombreP: string = '';
  descripcionP: string = '';
  imgP: string = '';

  constructor(private sProjects: SProjectsService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {    
    const pro = new Projects(this.nombreP, this.descripcionP, this.imgP);
    this.sProjects.save(pro).subscribe(
      data => {
      alert("Proyecto añadido");
      this.router.navigate(['']);
    }, err => {
      alert("Falló");
      this.router.navigate(['']);
    }
    )
  }

}
