<template>
    <div class="el-tabs__nav">
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" style="width:50% ">
            <el-tab-pane label="入住者" name="roomed">
                <el-table
                        :data="roomedData"
                        stripe
                        style="width: 100%"
                        :default-sort="{prop: 'name', order: 'ascending'}">
                    <el-table-column
                            prop="name"
                            label="入住者"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="phone"
                            label="联系方式"
                            sortable>
                    </el-table-column>
                </el-table>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size="roomedPageSize"
                        :total="roomedTotal"
                        @current-change="roomedPage">
                </el-pagination>
            </el-tab-pane>

            <el-tab-pane label="预订者" name="unroomed">
                <el-table
                        :data="unroomedData"
                        stripe
                        style="width: 100%"
                        :default-sort="{prop: 'name', order: 'ascending'}">
                    <el-table-column
                            prop="name"
                            label="预订者"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="phone"
                            label="联系方式"
                            sortable>
                    </el-table-column>
                </el-table>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size="unroomedPageSize"
                        :total="unroomedTotal"
                        @current-change="unroomedPage">
                </el-pagination>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                activeName: "roomed",
                roomedData: [{
                    guestName: '王小虎',
                    guestPhone: '13229435832',
                }],
                unroomedData:[],
                roomedPageSize:10,
                roomedTotal:0,
                unroomedPageSize:10,
                unroomedTotal:0,
            }
        },
        methods: {
            handleClick(tab, event) {
                this.activeName = tab.name
                console.log(this.activeName)
            },
            roomedPage(pageNum){
                const _this = this
                axios.get('http://localhost:8181/guest/findAll/'+(pageNum)+'/8').then(function(resp){
                    _this.roomedData = resp.data.list
                    _this.roomedPageSize = resp.data.pageSize
                    _this.roomedTotal = resp.data.total
                })
            },
            unroomedPage(pageNum){
                const _this = this
                axios.get('http://localhost:8181/customer/findAll/'+(pageNum)+'/8').then(function(resp){
                    _this.unroomedData = resp.data.list
                    _this.unroomedPageSize = resp.data.pageSize
                    _this.unroomedTotal = resp.data.total
                })
            },
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/guest/findAll/0/8').then(function(resp){
                _this.roomedData = resp.data.list
                _this.roomedPageSize = resp.data.pageSize
                _this.roomedTotal = resp.data.total
                axios.get('http://localhost:8181/customer/findAll/0/8').then(function(resp){
                    _this.unroomedData = resp.data.list
                    _this.unroomedPageSize = resp.data.pageSize
                    _this.unroomedTotal = resp.data.total
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