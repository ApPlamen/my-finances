import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NgControl } from '@angular/forms';

import { NumberInputComponent } from './number-input.component';

describe('InputComponent', () => {
  let component: NumberInputComponent;
  let fixture: ComponentFixture<NumberInputComponent>;
  let onChangeSpy: any;
  let onTouchSpy: any;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NumberInputComponent],
      providers: [NgControl]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NumberInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    onChangeSpy = spyOn(component, 'onChange');
    onTouchSpy = spyOn(component, 'onTouch');
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('value setter should call onChange and onTouch', () => {
    component.value = 'test';

    expect(onChangeSpy).toHaveBeenCalled();
    expect(onTouchSpy).toHaveBeenCalled();
  });

  it('writeValue should call onChange and onTouch', () => {
    component.writeValue('test');

    expect(onChangeSpy).toHaveBeenCalled();
    expect(onTouchSpy).toHaveBeenCalled();
  });

  it('registerOnChange should set onChange', () => {
    const testOnChange = () => {};

    component.registerOnChange(testOnChange);

    expect(component.onChange).toBe(testOnChange);
  });

  it('registerOnTouched should set onTouch', () => {
    const testOnTouch = () => {};

    component.registerOnTouched(testOnTouch);

    expect(component.onTouch).toBe(testOnTouch);
  });

  it('should trigger CustomControlDirective.onTouch, when onBlur is called', () => {
    const event = new Event('click');
    component.onBlur(event);

    expect(onTouchSpy).toHaveBeenCalled();
  });
});
