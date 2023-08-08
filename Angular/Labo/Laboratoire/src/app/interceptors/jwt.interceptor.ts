import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {MemberService} from "../services/member.service";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private _memberServ:MemberService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    console.log('on passe par ici')
    let user = this._memberServ.authData;
    console.log(user)
    if( user ) {
      let headers = new HttpHeaders();
      let token = user.token;
      headers = headers.append('Authorization', `Bearer ${token}`);
      const newRequest = request.clone({ headers: headers })
      console.log(token)
      return next.handle(newRequest)
    }

    return next.handle(request);
  }
}
