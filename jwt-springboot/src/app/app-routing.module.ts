import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { LandingComponent } from './landing/landing.component';


const routes: Routes = [

  {path:'auth',component:AuthComponent},
  {path:'',redirectTo:'auth',pathMatch:'full'},
  {path:'landing',component:LandingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
