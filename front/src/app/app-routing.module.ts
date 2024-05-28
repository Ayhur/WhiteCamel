import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { GeneralComponent } from './general/general.component';
import { DashboardComponent } from './dashboard/dashboard.component'
import { AuthGuard } from './auth.guard';
import { ContentComponent } from './content/content.component';

const routes: Routes = [
  {
    path: 'general', component: GeneralComponent, canActivate: [AuthGuard],
    children: [
      { path: 'content', component: ContentComponent },
      { path: 'score', component: DashboardComponent },
    ]
  },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
