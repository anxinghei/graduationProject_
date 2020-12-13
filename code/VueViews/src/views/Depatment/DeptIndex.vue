<template>
    <div align="center">
        <el-table
                :data="tableData"
                border
                style="width: 51% "
                :default-sort="{prop: 'roomNum', order: 'ascending'}">
            <el-table-column
                    prop="simplename"
                    label="部门名称"
                    width="120"
                    sortable>
            </el-table-column>
            <el-table-column
                    prop="description"
                    label="职责"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="magager"
                    label="经理"
                    width="120">
            </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    width="150">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">退房</el-button>
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
            deleteBook(row){
                const _this = this
                axios.delete('http://localhost:8181/book/deleteById/'+row.bookid).then(function(resp){
                    _this.$alert('退房成功！', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                            window.location.reload()
                        }
                    })
                })
            },
            edit(row) {
                this.$router.push({
                    path: '/update',
                    query:{
                        id:row.bookid
                    }
                })
            },
            page(pageNum){
                const _this = this
                axios.get('http://localhost:8181/book/findAll/'+(pageNum)+'/8').then(function(resp){
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
                tableData: [
                    {"simplename":"a","description":"a","magager":"a"}
                ]
            }
        },

        created() {
            const _this = this
            // var date=new Date();
            // var timer=date.getTime().toString();
            axios.get('http://localhost:8181/dept/getAll').then(function(resp){
                console.log("======"+resp.status)
                _this.tableData = resp.data.list
                console.log("======"+resp.data.list)
                _this.pageSize = resp.data.pageSize
                _this.total = resp.data.total
            })
        }
    }
</script>