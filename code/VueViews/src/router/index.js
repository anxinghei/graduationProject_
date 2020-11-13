import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from '../views/Index'
import Login from '../views/Login'
import Home from "../views/Home";

// import BookManaging from '../views/Book/BookManaging'
// import BookAdding from '../views/Book/BookAdding'

Vue.use(VueRouter)

const routes = [
  {
    path: '/Login',
    component: Login,
    show: false
  },
  {
    path: '/Home',
    component: Home,
    show: false
  },

  // {
  //   path: "/",
  //   name: "个人管理",
  //   component: Index,
  //   show: true,
  //   redirect: "/BookManage",
  //   children: [
  //     {
  //       path: "/BookManage",
  //       name: "查询订单",
  //       component: BookManaging
  //     },
  //     {
  //       path: "/AddBook",
  //       name: "添加订单",
  //       component: BookAdding
  //     }
  //   ]
  // },
  // {
  //   path: '/update',
  //   component: Index,
  //   show: false,
  //   redirect: "/update",
  //   children: [
  //     {
  //       path: "/update",
  //       name: "修改订单",
  //       component: BookUpdating
  //     }
  //   ]
  // },
  //
  // {
  //   path: "/RoomManage",
  //   name: "房间管理",
  //   show: true,
  //   component: Index,
  //   // RoomManaging
  //   redirect: "/RoomManage",
  //   children: [
  //     {
  //       path: "/RoomManage",
  //       name: "查看房间",
  //       component: RoomManaging
  //     }
  //   ]
  // },
  //
  // {
  //   path: "/GuestList",
  //   name: "酒店管理",
  //   show: true,
  //   component: Index,
  //   redirect: "/GuestList",
  //   children: [
  //
  //     {
  //       path: "/GuestList",
  //       name: "顾客列表",
  //       component: GuestList
  //     },
  //     {
  //       path: "/RoomOf",
  //       name: "房间相关",
  //       component: RoomOf
  //     },
  //     {
  //       path: "/FacilityManager",
  //       name: "设施管理",
  //       component: FacilityManager
  //     },
  //     {
  //       path: "/Payment",
  //       name: "收费统计",
  //       component: Payment
  //     },
  //   ]
  // },
  // {
  //   path: '/TypeUpdate',
  //   component: Index,
  //   show: false,
  //   redirect: "/TypeUpdate",
  //   children: [
  //     {
  //       path: "/TypeUpdate",
  //       name: "房间类别修改",
  //       component: TypeUpdate
  //     }
  //   ]
  // },
  // {
  //   path: '/TypeFacilities',
  //   component: Index,
  //   name: '设施修改',
  //   show: false,
  //   redirect: "/TypeFacilities",
  //   children: [
  //     {
  //       path: "/TypeFacilities",
  //       name: "房间设施修改",
  //       component: TypeFacilities
  //     }
  //   ]
  // },
  // {
  //   path: '/DiscountAdd',
  //   component: Index,
  //   show: false,
  //   redirect: "/DiscountAdd",
  //   children: [
  //     {
  //       path: "/DiscountAdd",
  //       name: "增加折扣",
  //       component: DiscountAdd
  //     }
  //   ]
  // },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
