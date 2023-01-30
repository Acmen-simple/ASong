import {
  createRouter,
  createWebHistory
} from 'vue-router'
import Login from '../views/Login'
import Home from '../views/Home.vue'


const routes = [
  // {
  //   path: '/',
  //   name: 'Login',
  //   component: Login
  // },
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: [{
        path: '/',
        name: 'Index',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import( /* webpackChunkName: "about" */ '../views/index.vue')
      },
      {
        //各地协会
        path: '/places',
        name: 'Places',
        component: () => import( /* webpackChunkName: "about" */ '../views/places/index.vue')
      },
      {
        //自然动物百科
        path: '/natural',
        name: 'Natural',
        component: () => import( /* webpackChunkName: "about" */ '../views/natural/index.vue')
      },
      //关于我们
      {
        path: '/aboutUs',
        name: 'AboutUs',
        children: [{
            //协会简章
            path: '/information',
            name: 'Infomation',
            component: () => import( /* webpackChunkName: "about" */ '../views/aboutUs/Information.vue')
          },
          {
            //组织机构
            path: '/orgnization',
            name: 'Orgnization',
            component: () => import( /* webpackChunkName: "about" */ '../views/aboutUs/Orgnization.vue')
          },
          {
            //大事记
            path: '/thing',
            name: 'Thing',
            component: () => import( /* webpackChunkName: "about" */ '../views/aboutUs/Thing.vue')
          },
          {
            //合作伙伴
            path: '/patener',
            name: 'Patener',
            component: () => import( /* webpackChunkName: "about" */ '../views/aboutUs/Patener.vue')
          },
          {
            //关于我们
            path: '/us',
            name: 'Us',
            component: () => import( /* webpackChunkName: "about" */ '../views/aboutUs/Us.vue')
          },
          {
            //章程
            path: '/constitution',
            name: 'Constitution',
            component: () => import( /* webpackChunkName: "about" */ '../views/aboutUs/Constitution.vue')
          },
        ]
      },
      //资源库
      {
        path: '/resources',
        name: 'Resources',
        children: [{
            //协会简章
            path: '/animalData',
            name: 'AnimalData',
            component: () => import( /* webpackChunkName: "about" */ '../views/resources/AnimalData.vue')
          },
          {
            //组织机构
            path: '/animalImage',
            name: 'AnimalImage',
            component: () => import( /* webpackChunkName: "about" */ '../views/resources/AnimalImage.vue')
          },
          {
            //大事记
            path: '/animalVideo',
            name: 'AnimalVideo',
            component: () => import( /* webpackChunkName: "about" */ '../views/resources/AnimalVideo.vue')
          },
          {
            //合作伙伴
            path: '/publish',
            name: 'Publish',
            component: () => import( /* webpackChunkName: "about" */ '../views/resources/Publish.vue')
          },
          {
            //关于我们
            path: '/wildAnimalInfo',
            name: 'WildAnimalInfo',
            component: () => import( /* webpackChunkName: "about" */ '../views/resources/WildAnimalInfo.vue')
          },
         
          
        ]
      },
      //新闻
      {
        path: '/news',
        name: 'News',
        children: [{
            //协会动态
            path: '/associationDynamics',
            name: 'AssociationDynamics',
            component: () => import( /* webpackChunkName: "about" */ '../views/news/AssociationDynamics.vue')
          },
          {
            //协会公告
            path: '/associationNotice',
            name: 'AssociationNotice',
            component: () => import( /* webpackChunkName: "about" */ '../views/news/AssociationNotice.vue')
          },
          {
            //新闻报道
            path: '/newsReport',
            name: 'NewsReport',
            component: () => import( /* webpackChunkName: "about" */ '../views/news/NewsReport.vue')
          },
          {
            //党建强会
            path: '/partyBuilding',
            name: 'PartyBuilding',
            component: () => import( /* webpackChunkName: "about" */ '../views/news/PartyBuilding.vue')
          },
        ]
      },
      //活动
      {
        path: '/activity',
        name: 'Activity',
        children: [{
            //专题回顾
            path: '/activityReview',
            name: 'ActivityReview',
            component: () => import( /* webpackChunkName: "about" */ '../views/activity/ActivityReview.vue')
          },
          {
            //协会公告
            path: '/pandaProtect',
            name: 'PandaProtect',
            component: () => import( /* webpackChunkName: "about" */ '../views/activity/PandaProtect.vue')
          },
          {
            //科普宣传
            path: '/propaganda',
            name: 'Propaganda',
            component: () => import( /* webpackChunkName: "about" */ '../views/activity/Propaganda.vue')
          },
          {
            //志愿者
            path: '/volunteer',
            name: 'Volunteer',
            component: () => import( /* webpackChunkName: "about" */ '../views/activity/Volunteer.vue')
          },
        ]
      },
      //生态法制
      {
        path: '/ecological',
        name: 'Ecological',
        children: [{
            //专题回顾
            path: '/case',
            name: 'Case',
            component: () => import( /* webpackChunkName: "about" */ '../views/ecologicalLegal/Case.vue')
          },
          {
            //协会公告
            path: '/legal',
            name: 'Legal',
            component: () => import( /* webpackChunkName: "about" */ '../views/ecologicalLegal/Legal.vue')
          },
        ]
      },

    ]
  },

  {
    path: '/forgetpw',
    name: 'forgetpw',
    component: () => import('../views/Login/forgetpw.vue')
  }, {
    path: '/register',
    name: 'register',
    component: () => import('../views/register/index.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router