<template>
    <div class="login-container">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px" class="login-form">
            <h2 class="login-title">酒店管理系统</h2>

            <h4 class="login-title" style="color:red">{{this.mes}}</h4>
            <el-form-item label="用户名" prop="username">
                <el-input v-model="form.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="验证码" prop="identify">
                <el-col :span="9">
                    <el-input v-model="form.identify"></el-input>
                </el-col>
                <el-col :span="15">
                    <div class="demo-image__placeholder">
                        <div class="block">
                            <el-image :src="this.img"></el-image>
                        </div>
                    </div>
                </el-col>
            </el-form-item>
<!--            <el-form-item label="记住我">-->
<!--                <el-tooltip >-->
<!--                    <el-switch-->
<!--                            v-model="form.rememberMe"-->
<!--                            active-color="#13ce66"-->
<!--                            inactive-color="#d3d3d3"-->
<!--                            active-value=true-->
<!--                            inactive-value=false>-->
<!--                    </el-switch>-->
<!--                </el-tooltip>-->
<!--            </el-form-item>-->
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                form: {
                    username: "root",
                    password: "root",
                    identify: '',
                    rememberMe: true,
                },
                mes: '',
                img: 'http://127.0.0.1:8181/getCode',
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ],
                    identify: [
                        {required: true, message: '请输入验证码', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            onSubmit() {
                const _this = this
                console.log(this.form)
                axios.post('http://localhost:8181/logining', this.form).then(function (resp) {
                    console.log(resp)
                    // 0成功 	1验证码错误		2用户名不存在	3密码错误
                    if (resp.data == 0) {
                        _this.$router.push('/Home')
                    } else {
                        if (resp.data == 1) {
                            _this.mes = "验证码错误"
                        } else if (resp.data == 2) {
                            _this.mes = "用户名不存在"
                        } else if (resp.data == 3) {
                            _this.mes = "密码错误"
                        }
                    }
                })
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/login').then(function (resp) {
                if (resp.data == "success") {
                    _this.$router.push({
                        path: '/Home'
                    }).catch(err => {
                    })
                    console.log("登录成功")
                } else {
                    console.log(resp)
                    _this.$router.push({
                        path: '/Login'
                    }).catch(err => {
                    })
                }
            })
        }
    };
</script>

<style acoped>
    .login-form {
        width: 350px;
        margin: 160px auto; /* 上下间距160px，左右自动居中*/

        padding: 30px;
        border-radius: 20px; /* 圆角 */
    }

    /* 背景 */
    .login-container {
        position: absolute;
        width: 100%;
        height: 100%;

    }

    /* 标题 */
    .login-title {
        color: #303133;
        text-align: center;
    }
</style> -->