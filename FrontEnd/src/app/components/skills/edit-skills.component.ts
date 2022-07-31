import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Habilidades } from 'src/app/model/habilidades';
import { SHabilidadesService } from 'src/app/service/s-habilidades.service';

@Component({
  selector: 'app-edit-skills',
  templateUrl: './edit-skills.component.html',
  styleUrls: ['./edit-skills.component.css']
})
export class EditSkillsComponent implements OnInit {
  habilidad: Habilidades = null;

  constructor(private sHabilidades: SHabilidadesService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHabilidades.detail(id).subscribe(
      data =>{
        this.habilidad = data;
      }, err =>{        
        alert ('Error al editar proyecto')
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHabilidades.update(id, this.habilidad).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert ("Error al editar habilidad");
        this.router.navigate(['']);
      }
    )

  }

}
