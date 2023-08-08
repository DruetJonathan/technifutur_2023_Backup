import {CanActivateFn, Router} from '@angular/router';
import {MemberService} from "../services/member.service";
import {inject} from "@angular/core";

export const authGuard: CanActivateFn = (route, state) => {
  console.log("ici")
  // @ts-ignore
  let test:MemberService = inject(MemberService);
  if (test.isAdmin()) {
    console.log("admin")
    return true;
  } else {
    console.log("not admin")
    const router = inject(Router);
    router.navigate(['/accesDenied']);
    return false;
  }
};
