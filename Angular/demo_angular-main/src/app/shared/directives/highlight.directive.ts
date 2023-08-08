import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[highlight]'
})
export class HighlightDirective {

  constructor(private _elemRef : ElementRef) { }

  @HostListener('mouseenter') onMouseEnter () : void {
    this._elemRef.nativeElement.style = 'background-color : yellow' ;
  }

  @HostListener('mouseleave') onMouseLeave() : void {
    this._elemRef.nativeElement.style =  'background-color : transparent' ;
  }

}
