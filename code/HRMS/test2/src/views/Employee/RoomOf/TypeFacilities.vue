<template>
    <div align="center">
        <p>{{typeName}}的设施管理</p>
        <el-checkbox :indeterminate="isIndeterminated" v-model="selectedAll" @change='handleSelectedAll'>
            <span style="display: block;margin: 20px;">全选</span>
        </el-checkbox>
        <el-checkbox-group v-model="selectedAllList" @change="handleSelectedAllChange">
            <el-checkbox v-for="item in selectedData" :key='item.id' :label="item.id"> {{item.name}}</el-checkbox>
        </el-checkbox-group>
        <el-button type="primary" @click="submitForm" style="margin-top:25px">修改</el-button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                selectedAll: false,
                selectedAllList: [],
                isIndeterminated: false,
                selectedData: [],
                typeName: '',
            }
        },
        methods: {
            submitForm() {
                const _this = this
                axios.put('http://localhost:8181/type/save/'+ _this.$route.params.id, this.selectedAllList).then(function (resp) {
                    if (resp.data == 'success') {
                        _this.$alert('设施修改成功！', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                _this.$router.push('/RoomOf')
                            }
                        })
                    }
                })
            },
            handleSelectedAll(val) {
                if (val) {
                    this.selectedData.forEach(item => {
                        this.selectedAllList.push(item.id)
                        this.isIndeterminated = false
                        this.selectedAll = true
                    })
                } else {
                    this.selectedAll = false
                    this.isIndeterminated = true
                    this.selectedAllList = []
                }

                console.log(this.selectedAllList)
            },
            handleSelectedAllChange(val) {
                this.selectedAll = val.length === this.selectedData.length
                this.isIndeterminated = val.length > 0 && val.length < this.selectedData.length
                console.log(this.selectedAllList)
            },
        },
        created() {
            const _this = this
            console.log(this.$route.query.id)
            axios.get('http://localhost:8181/facility/findAll/0/80').then(function (resp) {
                _this.selectedData = resp.data.list
                axios.get('http://localhost:8181/type/getFacilitiyIds/' + _this.$route.query.id).then(function (resp) {
                    _this.selectedAllList = resp.data
                })
            })
            axios.get('http://localhost:8181/type/getNameById/' + _this.$route.query.id).then(function (resp) {
                _this.typeName = resp.data
            })
        }
    };
</script>

<style scoped>

</style>