import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Analytics } from './analytics/analytics';
import { BaristaAdd } from './baristas/barista-add/barista-add';
import { BaristaList } from './baristas/barista-list/barista-list';
import { CoffeeAdd } from './coffees/coffee-add/coffee-add';
import { CoffeeList } from './coffees/coffee-list/coffee-list';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'analytics', component: Analytics },
  { path: 'barista-add', component: BaristaAdd },
  { path: 'barista-list', component: BaristaList },
  { path: 'coffee-add', component: CoffeeAdd },
  { path: 'coffee-list', component: CoffeeList },
];
