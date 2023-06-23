import { createRouter, createWebHistory } from 'vue-router';
import HomeNeprijavljeniView from '../views/HomeNeprijavljeniView.vue';
import HomeCitalacView from '../views/HomeCitalacView.vue';
import HomeAutorView from '../views/HomeAutorView.vue';
import HomeAdministratorView from '../views/HomeAdministratorView.vue';
import KnjigaView from '../views/KnjigaView.vue';

import PretragaNeprijavljeniView from '../views/PretragaNeprijavljenihView.vue';
import PretragaCitalacView from '../views/PretragaCitalacView.vue';
import PretragaAutorView from '../views/PretragaAutorView.vue';
import PretragaAdministratorView from '../views/PretragaAdministratorView.vue';

import LoginSection from '../components/LoginSection.vue';
import RegisterSection from '../components/RegisterSection.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeNeprijavljeniView,
    meta: {
      title: 'Home'
    }
  },
  {
    path: '/homeCitalac',
    name: 'homeCitalac',
    component: HomeCitalacView,
    meta: {
      title: 'Home'
    }
  },
  {
    path: '/homeAutor',
    name: 'homeAutor',
    component: HomeAutorView,
    meta: {
      title: 'Home'
    }
  },
  {
    path: '/homeAdministrator',
    name: 'homeAdministrator',
    component: HomeAdministratorView,
    meta: {
      title: 'Home'
    }
  },
  {
    path: '/pretragaNeprijavljeni',
    name: 'pretragaNeprijavljeni',
    component: PretragaNeprijavljeniView,
    meta: {
      title: 'Pretraga'
    }
  },
  {
    path: '/pretragaCitalac',
    name: 'pretragaCitalac',
    component: PretragaCitalacView,
    meta: {
      title: 'Pretraga'
    }
  },
  {
    path: '/pretragaAutor',
    name: 'pretragaAutor',
    component: PretragaAutorView,
    meta: {
      title: 'Pretraga'
    }
  },
  {
    path: '/pretragaAdministrator',
    name: 'pretragaAdministrator',
    component: PretragaAdministratorView,
    meta: {
      title: 'Pretraga'
    }
  },
  {
    path: '/login',
    name: 'login',
    component: LoginSection,
    meta: {
      title: 'Pretraga'
    }
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterSection,
    meta: {
      title: 'Pretraga'
    }
  },
  {
    path: '/knjiga/:id',
    name: 'knjiga',
    component: KnjigaView,
    meta: {
      title: 'Knjiga'
    }
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

router.beforeEach((to, from, next) => {
  const pageTitle = to.meta.title || 'Book Buddy';
  document.title = pageTitle;
  next();
});

export default router;