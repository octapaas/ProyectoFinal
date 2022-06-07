import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logo-argentina-programa',
  templateUrl: './logo-argentina-programa.component.html',
  styleUrls: ['./logo-argentina-programa.component.css']
})
export class LogoArgentinaProgramaComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  login(){
    this.router.navigate(['/login'])
  }
}
