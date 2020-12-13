<template>
    <div align="center">
        <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                 class="demo-ruleForm">
            <el-form-item label="开始时间" prop="startday">
                <el-input v-model="ruleForm.startday"></el-input>
            </el-form-item>
            <el-form-item label="结束时间" prop="endday">
                <el-input v-model="ruleForm.endday"></el-input>
            </el-form-item>
            <el-form-item label="房间类别" prop="typeid">
                <el-select v-model="ruleForm.typeid" style="width: 100%" placeholder="请选择"
                           value-key="id" @change="changeSelect">
                    <el-option v-for="(item,index) in this.ruleForm.options"
                               :label="item.name" :key="item.id" :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="折扣" prop="discount" >
                <el-input v-model="ruleForm.discount" v-bind:disabled="this.diasabledInput"></el-input>
            </el-form-item>
            <el-form-item label="说明" prop="description" >
                <el-input v-model="ruleForm.description" v-bind:disabled="this.diasabledInput"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            var checkEnding = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('结束时间不能为空'));
                }
                setTimeout(() => {
                    if (value <= this.ruleForm.startday) {
                        callback(new Error('结束时间必须晚于开始时间'));
                    } else {
                        callback();
                    }
                }, 1000);
            };
            return {
                ruleForm: {
                    options:[],
                    isbanded:1,
                    description:'',
                },
                diasabledInput:false,
                rules: {
                    discount: [
                        {required: true, message: '折扣不能为空', trigger: 'blur'}
                    ],
                    startday: [
                        {required: true, message: '开始时间不能为空', trigger: 'blur'}
                    ],
                    endday: [
                        {required: true, validator: checkEnding, trigger: 'blur'}
                    ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                if (this.ruleForm.isbanded){
                    this.$alert('该房间类别在预定时间内已有折扣！', '消息', {
                        confirmButtonText: '确定',
                    })
                    return false;
                }
                this.$refs[formName].validate((valid) => {
                    if (valid ) {
                        axios.post('http://localhost:8181/band/save',this.ruleForm).then(function (resp) {
                            if (resp.data == 'success') {
                                _this.$alert('折扣添加成功！', '消息', {
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
            },
            changeSelect(value){
                const _this = this
                if (this.ruleForm.startday!=null && this.ruleForm.endday!=null && this.ruleForm.endday>this.ruleForm.startday){
                    axios.post('http://localhost:8181/band/isBanded',this.ruleForm).then(function (resp) {
                        console.log(resp.data)
                        if (resp.data == 'success') {
                            _this.ruleForm.isbanded=0
                            _this.ruleForm.description=""
                            _this.diasabledInput=false
                        }else {
                            _this.ruleForm.isbanded=1
                            _this.ruleForm.description="该房间类别在预定时间内已有折扣"
                            _this.diasabledInput=true
                        }
                    })
                }
            },
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/type/getAll/').then(function (resp) {
                _this.ruleForm.options = resp.data
            })
        }
    }
</script>

