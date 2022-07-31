import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Habilidades } from 'src/app/model/habilidades';
import { SHabilidadesService } from 'src/app/service/s-habilidades.service';

@Component({
  selector: 'app-new-skills',
  templateUrl: './new-skills.component.html',
  styleUrls: ['./new-skills.component.css']
})
export class NewSkillsComponent implements OnInit {
  nombreH: string = '';
  porcentajeH: string = '';
  imgH: string = '';


  constructor(private sHabilidad: SHabilidadesService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {    
    const habilidad = new Habilidades(this.nombreH, this.porcentajeH, this.imgH);
    this.sHabilidad.save(habilidad).subscribe(
      data => {
      alert("Habilidad añadida");
      this.router.navigate(['']);
    }, err => {
      alert("Falló la creación de una nueva habilidad");
      this.router.navigate(['']);
    }
    )
  }

}
