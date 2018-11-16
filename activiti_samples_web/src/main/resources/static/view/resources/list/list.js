var vue = new Vue({
    el: '#app',
    data: function() {
        return {
            visible: false ,
            tableData: [],
            activeIndex: '1',
            activeIndex2: '1',
            isCollapse: false,
            pageSizes: [100, 200, 300, 400],
            pageSize: 100,
            pageNumber: 1,
            tatal: 400,
            dialogFormVisible: false,
            form: {
                modelName: '',
                modelCode: '',
                modelDesc: ''
            },
            formLabelWidth: '120px',
        }
    },
    methods: {
        tableRowClassName({row, rowIndex}) {
            if (rowIndex === 1) {
                return 'warning-row';
            } else if (rowIndex === 3) {
                return 'success-row';
            }
            return '';
        },
        handleClick(row) {
            console.log(row);
        },
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        },
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
        },
        loadData(pageNumber, pageSize){
            //发送get请求
            axios.get('/models/getModelLists',{params:{"pageSize":pageSize,"pageNumber":pageNumber}})
                .then(function(res){
                    vue.tableData = res.data.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        // 新增流程
        add(){
            this.dialogFormVisible = false;
            //发送get请求
            axios.post('/models/newModel',this.form,{emulateJSON:true})
                .then(function(res){
                    vue.loadData(vue.pageNumber,vue.pageSize);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
});

vue.loadData(vue.pageNumber,vue.pageSize);