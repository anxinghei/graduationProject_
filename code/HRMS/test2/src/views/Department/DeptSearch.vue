<template>
    <div align="center">

        <el-button @click="dialogVisible = true" type="text" size="small" style="width: 100%">添加新的部门</el-button>
        <el-dialog title="添加新的部门" :visible.sync="dialogVisible">
            <el-form :model="form">
                <el-form-item label="部门名称" :label-width="formLabelWidth">
                    <el-input v-model="form.dName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="职责描述" :label-width="formLabelWidth">
                    <el-input v-model="form.description" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="resetForm()">重 置</el-button>
                <el-button type="primary" @click="AddForm('form')">提 交</el-button>
            </div>
        </el-dialog>


        <el-table
                :data="tableData"
                border
                style="width: 51% "
                :default-sort="{prop: 'roomNum', order: 'ascending'}">
            <el-table-column
                    prop="dId"
                    v-if="false"
            >
            </el-table-column>
            <el-table-column
                    prop="dName"
                    label="部门名称"
                    width="120"
                    sortable>
            </el-table-column>
            <el-table-column
                    prop="description"
                    label="职责"
                    width="252">
            </el-table-column>
            <el-table-column
                    prop="mName"
                    label="经理"
                    width="120">
            </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    width="150">
                <template slot-scope="scope">
                    <el-button @click="toUpdate(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
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

        <el-dialog title="部门信息修改" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="部门名称" :label-width="formLabelWidth">
                    <el-input v-model="form.dName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="职责描述" :label-width="formLabelWidth">
                    <el-input v-model="form.description" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="resetForm()">重 置</el-button>
                <el-button type="primary" @click="UpdateForm('form')">提 交</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script>
    export default {
        methods: {

            AddForm(formName){
                const _this = this
                axios.post('http://localhost:8181/dept/save', this.form).then(function (resp) {
                    if (resp.data == '1') {
                        _this.$alert('部门添加成功！', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                window.location.reload()
                            }
                        })
                    }
                })
            },

            toUpdate(row){
                console.log("========"+row.dName)
                this.form.dId=row.dId
                this.form.dName=row.dName
                this.form.description=row.description
                this.dialogFormVisible = true
            },

            UpdateForm(formName){
                const _this = this
                console.log(this.form)
                axios.put('http://localhost:8181/dept/update', _this.form).then(function (resp) {
                    if (resp.data == '1') {
                        console.log("1111111")
                        _this.$alert('部门信息修改成功！', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                window.location.reload()
                            }
                        })
                    }
                })
            },

            resetForm(){
                this.form.dName=""
                this.form.description=""
            },

            deleteBook(row){
                const _this = this
                this.$confirm('此操作将永久删除该部门, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.delete('http://localhost:8181/dept/deleteById/'+row.dId).then(function(resp){
                        _this.$alert('部门删除成功！', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                window.location.reload()
                            }
                        })
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });

            },

            page(pageNum){
                const _this = this
                axios.get('http://localhost:8181/dept/findAll/'+(pageNum)+'/8').then(function(resp){
                    console.log(resp)
                    _this.tableData = resp.data.list
                    _this.pageSize = resp.data.pageSize
                    _this.total = resp.data.total
                })
            }
        },

        data() {
            return {
                pageSize:10,
                total:10,
                tableData: [],
                dialogFormVisible: false,
                dialogVisible: false,
                form: {
                    dId:0,
                    dName: '',
                    description: ''
                },
                formLabelWidth: '120px'
            }

        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/dept/findAll/0/8').then(function(resp){
                console.log("===")
                console.log(resp)
                _this.tableData = resp.data.list
                _this.pageSize = resp.data.pageSize
                _this.total = resp.data.total
            })
        }
    }
</script>