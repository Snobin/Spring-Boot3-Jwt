import { Component, OnInit } from '@angular/core';
import { JwtServiceService } from '../service/jwt-service.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  constructor(private jwtservice:JwtServiceService) { }

  ngOnInit(): void {
  }
hello(){
this.jwtservice.hello().subscribe((item:any)=>{
     console.log(item);
});
}
}
