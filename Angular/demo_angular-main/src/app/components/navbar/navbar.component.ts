import { Component } from '@angular/core';
import { Link } from 'src/app/shared/models/link';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  navLinks : Link[] = [
    { title : 'Accueil', url : '/', isVisible : false },
    { title : 'Demos', /* url : '/demo', */ children : [
      { title : 'Demo 1 - Les Bindings', url : '/demo/demo1'},
      { title : 'Demo 2 - Les Pipes', url : '/demo/demo2'},
      { title : 'Demo 3 - Les Directives', url : '/demo/demo3'},
      { title : 'Demo 4 - Input & Output', url : '/demo/demo4'},
      { title : 'Demo 5 - Services', url : '/demo/demo5'},
      { title : 'Demo 6 - Les Formulaires', url : '/demo/demo6'},
      { title : 'Demo 7 - Routing (Presque Full Crud)', url : '/demo/demo7'}

    ], isVisible : false },
    { title : 'Exos', /* url : '/exo',*/ children : [
      { title : 'Exo 1 - Le Chrono', url : '/exo/exo1'},
      { title : 'Exo 2 - Shopping List V1', url : '/exo/exo2'},
      { title : 'Exo 3 - Shopping List V2', url : '/exo/exo3'},
      { title : 'Exo 4 - P\'tit formulaire', url : '/exo/exo4'}
    ], isVisible : false },
    { title : 'Rappels', url : '/rappels', isVisible : false }
  ]
  
  
  toggleVisible(link : Link) : void {
    // On stock l'état de isVisible du lien sur lequel on vient de cliquer
    let currentState = link.isVisible;

    // On parcourt chacun des liens "parents" du tableau navLinks et change leur propriété isVisible en false (ferme tout)
    this.navLinks.forEach(l => l.isVisible = false)

    // On met la prop isVisible du lien sur lequel on vient de cliquer à son état contraire
    link.isVisible = !currentState;
  }

}
