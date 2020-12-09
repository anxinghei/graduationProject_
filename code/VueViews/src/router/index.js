import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from '../views/Index'
import Login from '../views/Login'
import Home from "../views/Home";

import DeptIndex from '../views/Depatment/DeptIndex'
import DeptUpdate from '../views/Depatment/DeptUpdate'
import EmpIndex from '../views/Employee/EmpIndex'
import EmpUpdate from '../views/Employee/EmpUpdate'
import WorksIndex from '../views/Recruitment/WorksIndex'
import WorksUpdate from '../views/Recruitment/WorksUpdate'
import ResumeList from '../views/Recruitment/ResumeList'
import ResumeOne from '../views/Recruitment/ResumeOne'
import Trainee from '../views/Recruitment/Trainee'
import Employee from '../views/Recruitment/Employee'

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

  {
    path: "/DeptManage",
    name: "部门管理",
    component: Index,
    show: true,
    redirect: "/DeptManage",
    children: [
      {
        path: "/DeptSearch",
        name: "查看所有部门",
        component: DeptIndex
      },
      // {
      //   path: "/DeptCreate",
      //   name: "添加新的部门",
      //   component: DeptCreate
      // }
    ]
  },
  {
    path: '/DeptUpdate',
    component: Index,
    show: false,
    redirect: "/DeptUpdate",
    children: [
      {
        path: "/DeptUpdate",
        name: "修改部门信息",
        component: DeptUpdate
      }
    ]
  },

  {
    path: "/EmpManage",
    name: "员工管理",
    show: true,
    component: Index,
    // RoomManaging
    redirect: "/EmpManage",
    children: [
      {
        path: "/EmpSearch",
        name: "查看所有在职员工",
        component: EmpIndex
      },
      // {
      //   path: "/EmpCreate",
      //   name: "添加新员工",
      //   component: EmpCreate
      // }
    ]
  },
  {
    path: '/EmpUpdate',
    component: Index,
    show: false,
    redirect: "/EmpUpdate",
    children: [
      {
        path: "/EmpUpdate",
        name: "修改员工信息",
        component: EmpUpdate
      }
    ]
  },

  {
    path: "/ResManage",
    name: "招聘管理",
    show: true,
    component: Index,
    redirect: "/ResManage",
    children: [

      {
        path: "/ResPost",
        name: "近期岗位",
        component: WorksIndex
      },
      {
        path: "/ResView",
        name: "近期简历",
        component: ResumeList
      },
      {
        path: "/ResTrainee",
        name: "实习生",
        component: Trainee
      },
      {
        path: "/ResEmpee",
        name: "校招/社招",
        component: Employee
      },
    ]
  },
  // {
  //   path: '/TypeUpdate',
  //   name: "招聘管理",
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
