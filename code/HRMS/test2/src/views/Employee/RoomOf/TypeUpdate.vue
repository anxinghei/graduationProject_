<template>
    <div align="center">
        <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                 class="demo-ruleForm">
            <el-form-item label="类别名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="价格" prop="price">
                <el-input v-model="ruleForm.price"></el-input>
            </el-form-item>
            <el-form-item label="大小" prop="area">
                <el-input v-model="ruleForm.area" readOnly></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>

<script >
    import {isIntGtZero, isInteger} from "../../../static/checkForm";

    export default {
        data() {
            var checkEnding = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('价格不能为空'));
                }
                setTimeout(() => {
                    if (value!=this.Oldprice){
                        if (!isInteger(value) || !isIntGtZero(value) ) {
                            callback(new Error('请输入大于零的整数数字'));
                        }else {
                            callback();
                        }
                    }else {
                        callback();
                    }
                }, 1000);
            };
            return {
                ruleForm: {
                    name: '',
                    price: '',
                    area: '',
                },
                Oldprice:0,
                rules: {
                    name: [
                        {required: true, message: '类别名不能为空', trigger: 'blur'}
                    ],
                    price: [
                        {required: true, validator: checkEnding, trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                console.log(this.ruleForm)
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put('http://localhost:8181/type/update', _this.ruleForm).then(function (resp) {
                            console.log(resp.data)
                            if (resp.data == 'success') {
                                _this.$alert('房间类别修改成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/RoomOf')
                                    }
                                })
                            }
                        })
                    } else {
                        return false;
                    }
                });
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/type/findById/' + this.$route.query.id).then(function (resp) {
                _this.ruleForm = resp.data
                _this.Oldprice=resp.data.price
            })
        }
    }
</script>