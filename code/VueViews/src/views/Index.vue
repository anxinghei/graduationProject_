<template>
    <div id="app">
        <el-row :gutter="24" align="middle">
            <el-col :span="21">
                <div class="grid-content bg-purple">

                </div>
            </el-col>
            <el-col :span="3">
                <el>{{this.user}}                                  </el>
                <el-button  @click="logouting">退出</el-button>
            </el-col>
        </el-row>

        <el-container style="height: 700px; border: 1px solid #eee">

            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">

                <el-menu  :router="true" default-active="this.activeUrl" v-for="(item,index) in this.rules">
                    <el-submenu  :index="item.url">
                        <template slot="title" >{{item.name}}</template>
                        <el-menu-item v-for="(item2,index2) in item.permissions"  :index="item2.url"
                                      @select="activeChange(item2.url)">{{item2.name}}</el-menu-item>
                    </el-submenu>

                </el-menu>

            </el-aside>

            <el-main>
                <router-view></router-view>
            </el-main>

        </el-container>
    </div>
</template>

<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }

    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }
    .bg-purple {
        background: #d3dce6;
    }
</style>

<script>


    export default {
        data() {
            return{
                user:'',
                rules:[],
                userId:0,
                activeUrl:'/',
            }

        },
        methods:{
            logouting(){
                const _this=this
                axios.post('http://localhost:8181/sysuser/logouting').then(function(resp){
                    _this.$router.push({
                        path: '/Login'
                    }).catch(err => {})
                })
            },
            activeChange(url){
                this.activeUrl=url
                console.log(this.activeUrl)
            }
        },
        created() {
            if (sessionStorage.getItem("activeUrl") ) {
                this.$store.replaceState(Object.assign({}, this.activeUrl,sessionStorage.getItem("activeUrl")))
            }
            //在页面刷新时将vuex里的信息保存到sessionStorage里
            window.addEventListener("beforeunload",()=>{
                sessionStorage.setItem("activeUrl",this.activeUrl)
            })
            console.log(this.activeUrl)
            const _this=this
            axios.get('http://localhost:8181/sysuser/toHome').then(function(resp){
                console.log('当前用户')
                console.log(resp)
                _this.user=resp.data.data.user.nickname
                _this.rules=resp.data.data.rules
                _this.userId=resp.data.data.user.id
            })
        }
    };
</script>
