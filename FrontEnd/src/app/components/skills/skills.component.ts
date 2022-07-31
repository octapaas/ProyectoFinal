import { Component, OnInit } from '@angular/core';
import { Habilidades } from 'src/app/model/habilidades';
import { SHabilidadesService } from 'src/app/service/s-habilidades.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  habilidad: Habilidades[] = [];

  constructor(private sHabilidades: SHabilidadesService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarSkills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkills(): void {
    this.sHabilidades.lista().subscribe(data => { this.habilidad = data; });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sHabilidades.delete(id).subscribe(
        data => {
          this.cargarSkills();
        }, err => {
          alert("no se pudo borrar la 'habilidad'");

        }
      )
    }
  }

}
