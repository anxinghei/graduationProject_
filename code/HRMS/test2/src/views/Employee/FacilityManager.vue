<template>
    <div align="center">

        <el-button @click="dialogVisible = true" type="text" size="small" style="width: 100%">添加新的人员</el-button>
        <el-dialog title="添加新的部门" :visible.sync="dialogVisible">
            <el-form :model="form">
                <el-form-item label="名字" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="岗位" :label-width="formLabelWidth">
                    <!--                    <el-input v-model="form.pName" autocomplete="off"></el-input>-->
                    <el-select v-model="form.pid" style="width: 100%" placeholder="请选择"
                               value-key="id" @change="changePosition">
                        <el-option v-for="(item,index) in this.positions"
                                   :label="item.simplename" :value="item.id" ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="联系方式" :label-width="formLabelWidth">
                    <el-input v-model="form.tel" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="所属部门" >
                    <el-select v-model="form.did" style="width: 100%" placeholder="请选择"
                               value-key="id" @change="changeDept">
                        <el-option v-for="(item,index) in this.depts"
                                   :label="item.simplename" :value="item.id" ></el-option>
                    </el-select>
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
                style="width: 55% "
                :default-sort="{prop: 'roomNum', order: 'ascending'}">
            <el-table-column
                    prop="dId"
                    v-if="false"
            >
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="名字"
                    width="80"
                    sortable>
            </el-table-column>
            <el-table-column
                    prop="pName"
                    label="岗位"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="startyear,startmonth"
                    label="入职时间"
                    width="110">
                <template slot-scope="scope">
                    {{scope.row.startyear}}年{{scope.row.startmonth}}月
                </template>
            </el-table-column>
            <el-table-column
                    prop="tel"
                    label="联系方式"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="dName"
                    label="所属部门"
                    width="100">
            </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
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
                <el-form-item label="名字" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="岗位" :label-width="formLabelWidth">
<!--                    <el-input v-model="form.pName" autocomplete="off"></el-input>-->
                    <el-select v-model="form.pid" style="width: 100%" placeholder="请选择"
                               value-key="id" @change="changePosition">
                        <el-option v-for="(item,index) in this.positions"
                                   :label="item.simplename" :value="item.id" ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="联系方式" :label-width="formLabelWidth">
                    <el-input v-model="form.tel" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="所属部门" >
                    <el-select v-model="form.did" style="width: 100%" placeholder="请选择"
                               value-key="id" @change="changeDept">
                        <el-option v-for="(item,index) in this.depts"
                                   :label="item.simplename" :value="item.id" ></el-option>
                    </el-select>
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
            changePosition(pid){
                this.form.pid=pid
                console.log("++++"+this.form.pid)
            },
            changeDept(did){
                console.log("++++"+did)
                this.form.did=did
            },


            toUpdate(row){
                this.form.id=row.id;
                console.log("========"+this.form.id)
                this.form.name=row.name
                this.form.pid=row.pid
                this.form.tel=row.tel
                this.form.did=row.did
                this.dialogFormVisible = true
            },

            UpdateForm(formName){
                const _this = this
                console.log("---"+this.form.did)
                axios.put('http://localhost:8181/employee/update', _this.form).then(function (resp) {
                    if (resp.data == '1') {
                        console.log("1111111")
                        _this.$alert('人员信息修改成功！', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                window.location.reload()
                            }
                        })
                    }
                })
            },

            resetForm(){
                this.form.pName=""
                this.form.tel=""
                this.form.did=""
            },

            deleteBook(row){
                const _this = this
                this.$confirm('此操作将永久删除该人员, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.delete('http://localhost:8181/employee/deleteById/'+row.id).then(function(resp){
                        _this.$alert('人员删除成功！', '消息', {
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
                axios.get('http://localhost:8181/employee/findAll/'+(pageNum)+'/8').then(function(resp){
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
                    id:0,
                    name:'',
                    pid: '',
                    tel: '',
                    did: '',
                },
                formLabelWidth: '120px',
                depts:[],
                positions:[],
            }

        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/employee/findAll/0/8').then(function(resp){
                console.log("===")
                console.log(resp)
                _this.tableData = resp.data.list
                _this.pageSize = resp.data.pageSize
                _this.total = resp.data.total
            })
            axios.get('http://localhost:8181/dept/getAll').then(function(resp){
                console.log("=")
                _this.depts = resp.data
                console.log(_this.depts)
            })
            axios.get('http://localhost:8181/position/getAll').then(function(resp){
                console.log("==")
                _this.positions = resp.data
                console.log(_this.positions)
            })
        }
    }
</script>