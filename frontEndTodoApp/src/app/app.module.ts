import { BrowserModule } from '@angular/platform-browser';
import { ModuleWithProviders, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Http } from '@angular/http';
import { AppComponent } from './app.component';
import { SharedModule, HeaderComponent, TaskService } from './shared';
import { HomeModule } from './home/home.module';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InformationComponent } from './information/information.component';

const rootRouting: ModuleWithProviders = RouterModule.forRoot([
  { path: '', component: HomeComponent },
  { path: 'information', component: InformationComponent }
], { useHash: false });

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    InformationComponent
  ],
  imports: [
    BrowserModule, HomeModule, SharedModule, rootRouting, FormsModule, ReactiveFormsModule
  ],
  providers: [TaskService],
  bootstrap: [AppComponent]
})
export class AppModule { }
