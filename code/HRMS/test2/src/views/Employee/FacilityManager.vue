<template>
    <div align="center">
        <el-button @click="dialogVisible = true" type="text" size="small" style="width: 100%">增加设施</el-button>
        <el-dialog title="增加设施" :visible.sync="dialogVisible">
            <el-form style="width: 100%" :model="ruleForm"  ref="ruleForm" label-width="100px"
                     class="demo-ruleForm">
                <el-form-item label="设施名" prop="name">
                    <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button @click="dialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

        <el-table
                :data="tableData"
                border
                style="width: 40% "
                :default-sort="{prop: 'index', order: 'ascending'}">
            <el-table-column
                    type="index"
                    sortable>
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="设施名"
                    sortable>
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作">
                <template slot-scope="scope">
                    <el-button @click="deleteF(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid ) {
                        axios.post('http://localhost:8181/facility/save', this.ruleForm).then(function (resp) {
                            if (resp.data == 'success') {
                                _this.$alert('设施添加成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        window.location.reload()
                                        _this.dialogVisible=false
                                    }
                                })
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            deleteF(row){
                const _this = this
                axios.delete('http://localhost:8181/facility/deleteById/'+row.id).then(function(resp){
                    if (resp.data == 'success') {
                        _this.$alert('删除成功！', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                window.location.reload()
                            }
                        })
                    }
                })
            },
            page(pageNum){
                const _this = this
                axios.get('http://localhost:8181/facility/findAll/'+(pageNum)+'/8').then(function(resp){
                    console.log(resp)
                    _this.tableData = resp.data.list
                    _this.pageSize = resp.data.pageSize
                    _this.total = resp.data.total
                })
            },
        },

        data() {
            return {
                pageSize:10,
                total:10,
                tableData: [],
                dialogVisible: false,
                ruleForm:{},
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/facility/findAll/0/8').then(function(resp){
                console.log(resp)
                _this.tableData = resp.data.list
                _this.pageSize = resp.data.pageSize
                _this.total = resp.data.total
            })
        }
    }
</script>