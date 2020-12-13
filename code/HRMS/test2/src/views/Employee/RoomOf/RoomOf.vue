<template>
    <div class="el-tabs__nav">
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" style="width:50% ">
            <el-tab-pane label="房间类别" name="type">
                <el-table
                        :data="typeData"
                        stripe
                        style="width: 100%"
                        :default-sort="{prop: 'price', order: 'ascending'}">
                    <el-table-column
                            prop="name"
                            label="类别名"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="price"
                            label="价格"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="area"
                            label="大小"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            label="操作">
                        <template slot-scope="scope">
                            <el-button @click="editType(scope.row)" type="text" size="small">修改</el-button>
                            <el-button @click="editF(scope.row)" type="text" size="small">设施管理</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size="typePageSize"
                        :total="typeTotal"
                        @current-change="typePage">
                </el-pagination>
            </el-tab-pane>

            <el-tab-pane label="折扣" name="discount">
                <el-button @click="addDiscount" type="text" size="small" style="width: 100%">增加折扣</el-button>
                <el-table
                        :data="discountData"
                        stripe
                        style="width: 100%"
                        :default-sort="{prop: 'startday', order: 'ascending'}">
                    <el-table-column
                            prop="typename"
                            label="类别名"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="startday"
                            label="开始时间"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="endday"
                            label="结束时间"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="discount"
                            label="折扣"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="description"
                            label="说明">
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            label="操作">
                        <template slot-scope="scope">
                            <el-button @click="deleteDiscount(scope.row)" type="text" size="small">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size="discountPageSize"
                        :total="discountTotal"
                        @current-change="discountPage">
                </el-pagination>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                activeName: "type",
                typeData: [{
                    name: '',
                    price: '',
                    area: '',
                }],
                discountData:[],
                typePageSize:10,
                typeTotal:0,
                discountPageSize:10,
                discountTotal:0,
            }
        },
        methods: {
            handleClick(tab, event) {
                this.activeName = tab.name
                console.log(this.activeName)
            },
            typePage(pageNum){
                const _this = this
                axios.get('http://localhost:8181/type/findAll/'+(pageNum)+'/8').then(function(resp){
                    _this.typeData = resp.data.list
                    _this.pageSize = resp.data.pageSize
                    _this.total = resp.data.total
                })
            },
            discountPage(pageNum){
                const _this = this
                axios.get('http://localhost:8181/band/findAll/'+(pageNum)+'/8').then(function(resp){
                    _this.discountData = resp.data.list
                    _this.discountPageSize = resp.data.pageSize
                    _this.discountTotal = resp.data.total
                })
            },
            editType(row) {
                this.$router.push({
                    path: '/TypeUpdate',
                    query:{
                        id:row.id
                    }
                })
            },
            editF(row) {
                this.$router.push({
                    path: '/TypeFacilities',
                    query:{
                        id:row.id
                    }
                })
            },
            deleteDiscount(row){
                const _this = this
                console.log(row)
                axios.delete('http://localhost:8181/band/deleteById/'+row.id).then(function(resp){
                    _this.$alert('删除成功！', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                            window.location.reload()
                        }
                    })
                })
            },
            addDiscount(){
                this.$router.push({
                    path: '/DiscountAdd',
                })
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/type/findAll/0/8').then(function(resp){
                _this.typeData = resp.data.list
                _this.typePageSize = resp.data.pageSize
                _this.typeTotal = resp.data.total
                axios.get('http://localhost:8181/band/findAll/0/8').then(function(resp){
                    console.log(resp.data)
                    _this.discountData = resp.data.list
                    _this.discountPageSize = resp.data.pageSize
                    _this.discountTotal = resp.data.total
                })
            })
        }
    }
</script>

<style scoped>
    .el-tabs__nav {
        width: 100%;
        display: flex;
        justify-content: space-around;
    }
</style>