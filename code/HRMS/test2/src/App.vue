<template>
  <div id="app">

        <router-view></router-view>

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
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item),
      }
    },
    methods:{

    },

    created() {
      const _this = this
      axios.get('http://localhost:8181/login').then(function(resp){
        if (resp.data == "success"){
          _this.$router.push({
            path: '/Home'
          }).catch(err => {})
          console.log("登录成功")
        }else{
          console.log(resp)
          _this.$router.push({
            path: '/Login'
          }).catch(err => {})
        }
      })
    }
  };
</script>
