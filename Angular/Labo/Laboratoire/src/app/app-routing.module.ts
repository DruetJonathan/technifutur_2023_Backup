import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TournamentsComponent} from "./components/tournaments/tournaments.component";
import {SeeDetailComponent} from "./components/tournaments/see-detail/see-detail.component";
import {AddTournamentComponent} from "./components/tournaments/add-tournament/add-tournament.component";
import {LoginComponent} from "./components/member/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {AccesDeniedComponent} from "./components/acces-denied/acces-denied.component";
import {authGuard} from "./guard/auth.guard";
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {NewMemberComponent} from "./components/member/new-member/new-member.component";
import {ProfilComponent} from "./components/member/profil/profil.component";

const routes: Routes = [
  { path : '', component : HomeComponent },
  { path : 'notFound', component :  NotFoundComponent },
  { path : 'accesDenied', component : AccesDeniedComponent},
  { path : 'login', component : LoginComponent },
  { path : 'profil', component : ProfilComponent },
  { path : 'newMember', component : NewMemberComponent,canActivate:[authGuard] },
  { path : 'tournaments', component : TournamentsComponent },
  { path : 'tournaments/add', component : AddTournamentComponent,canActivate:[authGuard] },
  { path : 'tournaments/:id', component : SeeDetailComponent },
  { path : '**', component :  NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
