import {Component, OnInit} from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Link } from 'src/app/shared/models/Link';
import {User} from "../../shared/models/user";
import {FakeAuthService} from "../../shared/services/fake-auth.service";
import {Subject} from "rxjs";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{
  connectedUser : User | undefined;
 ngOnInit() {
   this._fakeAuthService.$connectedUser.subscribe({
     next : (newUser : User | undefined) =>{
       // se declenche quand notre observable va changer de valeur
       console.log("next déclanché dans navbar: ",newUser)
       this.connectedUser = newUser;
     }
   });
 }
 constructor(private _fakeAuthService : FakeAuthService) {
 }

  links: Link[] = [
    {
      title: 'Accueil',
      url: '/',
    },
    {
      title: 'Démos',
      children: [
        {
          title: 'Démo 1 - Bindings',
          url: '/demo/demo1'
        },
        {
          title: 'Démo 2 - Pipes',
          url: '/demo/demo2'
        },
        {
          title: 'Démo 3 - Directives',
          url: '/demo/demo3'
        },
        {
          title: 'Démo 4 - Input & Output',
          url: '/demo/demo4'
        },
        {
          title: 'Démo 5 - Service & Injection',
          url: '/demo/demo5'
        },
        {
          title: 'Démo 6 - Les formulaires',
          url: '/demo/demo6'
        },
        {
          title: 'Démo 7 - Les routing',
          url: '/demo/demo7'
        },
        {
          title: 'Démo 8 - HttpClient',
          url: '/demo/demo8'
        }
      ],
      isVisible: false
    },
    {
      title: 'Exos',
      children: [
        {
          title: 'Exo 1 - Chrono',
          url: '/exos/exo1'
        },
        {
          title: 'Exo 2 - ShoppingList',
          url: '/exos/exo2'
        },
        {
          title: 'Exo 3 - ShoppingList - Service',
          url: '/exos/exo3'
        },
        {
          title: 'Exo 4 - Forms - Validator',
          url: '/exos/exo4'
        },
        {
          title: 'Exo 5 - CRUD',
          url: '/exos/exo5'
        },
        {
          title: 'Exo 6 - Pokedex',
          url: '/exos/exo6'
        }
      ],
      isVisible: false
    }

  ];
  toggleShowLink(index: number): void {
    let currentState = this.links[index].isVisible;

    this.links.forEach(l => l.isVisible = false);

    this.links[index].isVisible = !currentState;
  }
  disconnect():void{
    this._fakeAuthService.logout();
  }
}
