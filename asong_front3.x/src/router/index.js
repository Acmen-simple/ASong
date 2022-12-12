import { createRouter, createWebHistory } from 'vue-router'
import Login  from '../views/Login'
import Welcome  from '../views'


const routes = [
  // {
  //   path: '/',
  //   name: 'Login',
  //   component: Login
  // },
  {
    path: '/',
    name: 'Welcome',
    component: Welcome
  },
  {
    path: '/welcome',
    name: 'welcome',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/index.vue')
  },
  {
    path: '/forgetpw',
    name: 'forgetpw',
    component:() => import('../views/Login/forgetpw.vue')
  }, {
    path: '/register',
    name: 'register',
    component:() => import('../views/register/index.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
