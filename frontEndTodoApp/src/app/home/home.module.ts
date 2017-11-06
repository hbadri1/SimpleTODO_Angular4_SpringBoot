import { ModuleWithProviders, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared';

const homeRouting: ModuleWithProviders = RouterModule.forChild([
  {
    path: '',
    component: HomeComponent
  }
]);


@NgModule({
  imports: [
    homeRouting, SharedModule, FormsModule, ReactiveFormsModule
  ],
  declarations: [HomeComponent]
})
export class HomeModule { }
