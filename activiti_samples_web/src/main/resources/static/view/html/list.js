var vue = new Vue({
    el: '#app',
    data: function() {
        return {
            visible: false ,
            tableData: [],
            activeIndex: '1',
            activeIndex2: '1',
            isCollapse: false,
            pageSizes: [10, 20, 50, 100],
            pageSize: 10,
            pageNumber: 1,
            tatal: 0,
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
                    vue.tatal = res.data.data.totalElements;
                    vue.tableData = res.data.data.content;
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
        },
        //删除流程
        handelDel(row){
            layer.confirm('删除就抹得了啊！！！', {icon: 2, title:'警告'}, function(index){
                var index2 = layer.load(0);
                //do something
                var id = row.id;
                //发送get请求
                axios.delete('/models/del/'+id,{emulateJSON:true})
                    .then(function(res){
                        layer.close(index2);
                        layer.msg('删除好了啊', {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            //do something
                        });
                        vue.loadData(vue.pageNumber,vue.pageSize);
                    })
                    .catch(function (error) {
                        layer.close(index2);
                        console.log(error);
                    });
                layer.close(index);
            });
        },
        //分页参数变化，重新加载数据
        handlePaginationChange(){
            vue.loadData(vue.pageNumber,vue.pageSize);
        },
        //设计流程
        handleDesign(row){
            var modelId = row.activiModelId;
            var frameSrc = "/index?modelId=" + modelId + "&t=" + new Date();
            var index = layer.open({
                type: 2,
                title: '流程定义设计',
                maxmin: false,
                shadeClose: true, //点击遮罩关闭层
                area : ['100%' , '100%'],
                content: frameSrc

            });
        },
        //发布
        handleDeployment(row){
            var modelId = row.activiModelId;
            axios.post('/deployment/'+modelId,{emulateJSON:true})
                .then(function(res){
                    layer.msg('发布成功', {
                        icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        //do something
                    });
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
});

vue.loadData(vue.pageNumber,vue.pageSize);