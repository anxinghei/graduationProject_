<template>
    <div class="el-tabs__nav">
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" style="width:50% ">
            <el-tab-pane label="已入住房间" name="booked">
                <el-table
                        :data="bookedData"
                        stripe
                        style="width: 100%"
                        :default-sort="{prop: 'roomNum', order: 'ascending'}">
                    <el-table-column
                            prop="roomNum"
                            label="房间号"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="typeName"
                            label="房间类别"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="guestName"
                            label="入住者"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="guestPhone"
                            label="联系方式"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="startDay"
                            label="入住时间"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="endDay"
                            label="退房时间"
                            sortable>
                    </el-table-column>
                </el-table>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size="bookedPageSize"
                        :total="bookedTotal"
                        @current-change="bookedPage">
                </el-pagination>
            </el-tab-pane>

            <el-tab-pane label="未入住房间" name="unbooked">
                <el-table
                        :data="unbookedData"
                        stripe
                        style="width: 100%"
                        :default-sort="{prop: 'roomNum', order: 'ascending'}">
                    <el-table-column
                            prop="roomNum"
                            label="房间号"
                            sortable>
                    </el-table-column>
                    <el-table-column
                            prop="typeName"
                            label="房间类别"
                            sortable>
                    </el-table-column>
                </el-table>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size="unbookedPageSize"
                        :total="unbookedTotal"
                        @current-change="unbookedPage">
                </el-pagination>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                activeName: "booked",
                bookedData: [{
                    startDay: '2016-05-02',
                    guestName: '王小虎',
                    guestPhone: '13229435832',
                }],
                unbookedData:[],
                bookedPageSize:10,
                bookedTotal:0,
                unbookedPageSize:10,
                unbookedTotal:0,
            }
        },
        methods: {
            handleClick(tab, event) {
                this.activeName = tab.name
                console.log(this.activeName)
            },
            bookedPage(pageNum){
                const _this = this
                axios.get('http://localhost:8181/room/getRoom/'+(pageNum)+'/8').then(function(resp){
                    console.log(resp)
                    _this.bookedData = resp.data.list
                    _this.bookedPageSize = resp.data.pageSize
                    _this.bookedTotal = resp.data.total
                })
            },
            unbookedPage(pageNum){
                const _this = this
                axios.get('http://localhost:8181/room/getUnroom/'+(pageNum)+'/8').then(function(resp){
                    console.log(resp)
                    _this.unbookedData = resp.data.list
                    _this.unbookedPageSize = resp.data.pageSize
                    _this.unbookedTotal = resp.data.total
                })
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/room/getRoom/0/8').then(function(resp){
                console.log(resp)
                _this.bookedData = resp.data.list
                _this.bookedPageSize = resp.data.pageSize
                _this.bookedTotal = resp.data.total
                axios.get('http://localhost:8181/room/getUnroom/0/8').then(function(resp){
                    console.log(resp.data.total)
                    _this.unbookedData = resp.data.list
                    _this.unbookedPageSize = resp.data.pageSize
                    _this.unbookedTotal = resp.data.total
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