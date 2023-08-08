import { CanActivateFn } from '@angular/router';

export const connectedGuard: CanActivateFn = (route, state) => {
  //? normalement ici, on fait genre des verifications de si on a un user connecté
  // ! la guard renvoie juste un boolean vrai ou faux pour savir si peut accéder au composants
  // ! souvent plutot que renvoyer faux on va faire une redirection vers une page: ex login,register,...
  return true;
};
