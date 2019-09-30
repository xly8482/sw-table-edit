let fieldMap = {
    'squNo': '序号',
    'projectNo': '工程编号',
    'drawingNo': '图纸编号',
    'projectName': '工程名称',
    'ownerUnit': '业主单位',
    'implUnit': '实施单位',
    'contractPrice': '合同价款',
    'princSupplier': '甲供主材',
    'provAmount': '暂定金',
    'taxedIncome': '含税工程收入',
    'noneTaxedIncome': '除税工程收入',
    'projectState': '工程状态',
    'rateOfMonth': '当月实际进度',
    'actualOutputOfMonth': '当月实际施工产值',
    'cumulaActRate': '累计实际进度(%)',
    'cumulaActOutput': '累计实际施工产值',
    'supervReOfMonth': '当月监理月报(%)',
    'supervReOutOfMonth': '当月监理月报产值',
    'setIncomeOfMonth': '当月结算收入(除税)',
    'cumulaSupOutOfMonth': '累计监理月报产值',
    'cumulaFinSetIncome': '累计财务结算收入(除税)',
    'cumulaFinIncomeRate': '累计结算收入占比(%)',
    'unFinIncome': '未结算收入(除税)',
    'incomeOfMonth': '本月收款金额',
    'cumulaIncome': '累计收款金额',
    'payRateOfContract': '合同约定支付比例',
    'paRaOfConIncome': '按合同支付比例应收款',
    'paRaOfConDeficit': '按合同支付比例欠收款',
    'receIncome': '应收账款',
    'payAmount': '应付账款',
    'proPlanTalCost': '工程计划总成本',
    'proPlanProfit': '工程计划毛利润',
    'proPlanProfitRate': '工程计划毛利率',
    'settleCostNow': '工程现阶段已结转成本',
    'grossProfitNow': '工程现阶段毛利润',
    'grossRateNow': '工程现阶段毛利率',
    'preExamineAmount': '工程预估审定金额(含税)',
    'preActTolIncome': '工程预估实际总收入(除税)',
    'preActCost': '工程预估实际总成本',
    'preActGroProfit': '工程预估实际毛利润',
    'preActGroRate': '工程预估实际毛利率',
    'examineAmount': '工程审定金额',
    'exaActTolIncome': '工程审计后实际总收入',
    'exaActCost': '工程审计后实际总成本',
    'exaActGroProfit': '工程审计后实际毛利润',
    'exaActGroRate': '工程审计后实际毛利率',
    'dirCharPerson': '直接负责人',
    'leaderOfBranch': '分管领导',
    'remark': '备注',
    'taxRate': '税率',
    'contractType': '合同类型',
    'settleStates': '结算状态',
    'proRemarks': '项目备注'
};

layui.use(['table', 'upload'], function () {
    let table = layui.table;
    let upload = layui.upload;

    tableInit();

    $("#search").on('click', function () {
        tableInit();
    });

    //回车事件绑定
    $(document).bind('keyup', function (event) {
        if (event.keyCode == "13") {
            //回车执行查询
            tableInit();
        }
    });

    function tableInit() {
        let shData = {
            projectNo: $("#sh_projectNo").val().trim(),
            projectName: $("#sh_projectName").val().trim()
        };

        table.render({
            id: 'mainDataTable',
            elem: '#mainDataTable',
            url: '/api/mainData/list',
            height: 'full-75',
            cellMinWidth: 80,
            where: shData,
            cols: [[
                {field: 'squNo', type: 'numbers', align: 'center', fixed: 'left', title: '序号', width: 60},
                {align: 'center', fixed: 'left', title: '操作', toolbar: '#dataDemo', width: 100},
                {field: 'id', hide: true, title: 'ID', width: 60},
                {field: 'projectNo', sort: true, edit: 'text', title: '工程编号', width: 110},
                {field: 'drawingNo', sort: true, edit: 'text', title: '图纸编号', width: 110},
                {field: 'projectName', sort: true, edit: 'text', title: '工程名称', width: 110},
                {field: 'ownerUnit', sort: true, edit: 'text', title: '业主单位', width: 110},
                {field: 'implUnit', sort: true, edit: 'text', title: '实施单位', width: 110},
                {field: 'contractPrice', sort: false, edit: 'text', title: '合同价款', width: 90},
                {field: 'princSupplier', sort: false, edit: 'text', title: '甲供主材', width: 90},
                {field: 'provAmount', sort: false, edit: 'text', title: '暂定金', width: 80},
                {field: 'taxedIncome', sort: false, edit: 'text', title: '含税工程收入', width: 120},
                {field: 'noneTaxedIncome', sort: false, edit: 'text', title: '除税工程收入', width: 120},
                {field: 'projectState', sort: false, edit: 'text', title: '工程状态', width: 90},
                {field: 'rateOfMonth', sort: false, edit: 'text', title: '当月实际进度', width: 120},
                {field: 'actualOutputOfMonth', sort: false, edit: 'text', title: '当月实际施工产值', width: 150},
                {field: 'cumulaActRate', sort: false, edit: 'text', title: '累计实际进度(%)', width: 140},
                {field: 'cumulaActOutput', sort: false, edit: 'text', title: '累计实际施工产值', width: 150},
                {field: 'supervReOfMonth', sort: false, edit: 'text', title: '当月监理月报(%)', width: 150},
                {field: 'supervReOutOfMonth', sort: false, edit: 'text', title: '当月监理月报产值', width: 150},
                {field: 'setIncomeOfMonth', sort: false, edit: 'text', title: '当月结算收入(除税)', width: 160},
                {field: 'cumulaSupOutOfMonth', sort: false, edit: 'text', title: '累计监理月报产值', width: 150},
                {field: 'cumulaFinSetIncome', sort: false, edit: 'text', title: '累计财务结算收入(除税)', width: 180},
                {field: 'cumulaFinIncomeRate', sort: false, edit: 'text', title: '累计结算收入占比(%)', width: 170},
                {field: 'unFinIncome', sort: false, edit: 'text', title: '未结算收入(除税)', width: 140},
                {field: 'incomeOfMonth', sort: false, edit: 'text', title: '本月收款金额', width: 120},
                {field: 'cumulaIncome', sort: false, edit: 'text', title: '累计收款金额', width: 120},
                {field: 'payRateOfContract', sort: false, edit: 'text', title: '合同约定支付比例', width: 160},
                {field: 'paRaOfConIncome', sort: false, edit: 'text', title: '按合同支付比例应收款', width: 180},
                {field: 'paRaOfConDeficit', sort: false, edit: 'text', title: '按合同支付比例欠收款', width: 180},
                {field: 'receIncome', sort: false, edit: 'text', title: '应收账款', width: 90},
                {field: 'payAmount', sort: false, edit: 'text', title: '应付账款', width: 90},
                {field: 'proPlanTalCost', sort: false, edit: 'text', title: '工程计划总成本', width: 130},
                {field: 'proPlanProfit', sort: false, edit: 'text', title: '工程计划毛利润', width: 130},
                {field: 'proPlanProfitRate', sort: false, edit: 'text', title: '工程计划毛利率', width: 130},
                {field: 'settleCostNow', sort: false, edit: 'text', title: '工程现阶段已结转成本', width: 170},
                {field: 'grossProfitNow', sort: false, edit: 'text', title: '工程现阶段毛利润', width: 150},
                {field: 'grossRateNow', sort: false, edit: 'text', title: '工程现阶段毛利率', width: 150},
                {field: 'preExamineAmount', sort: false, edit: 'text', title: '工程预估审定金额(含税)', width: 180},
                {field: 'preActTolIncome', sort: false, edit: 'text', title: '工程预估实际总收入(除税)', width: 200},
                {field: 'preActCost', sort: false, edit: 'text', title: '工程预估实际总成本', width: 160},
                {field: 'preActGroProfit', sort: false, edit: 'text', title: '工程预估实际毛利润', width: 160},
                {field: 'preActGroRate', sort: false, edit: 'text', title: '工程预估实际毛利率', width: 160},
                {field: 'examineAmount', sort: false, edit: 'text', title: '工程审定金额', width: 120},
                {field: 'exaActTolIncome', sort: false, edit: 'text', title: '工程审计后实际总收入', width: 180},
                {field: 'exaActCost', sort: false, edit: 'text', title: '工程审计后实际总成本', width: 180},
                {field: 'exaActGroProfit', sort: false, edit: 'text', title: '工程审计后实际毛利润', width: 180},
                {field: 'exaActGroRate', sort: false, edit: 'text', title: '工程审计后实际毛利率', width: 180},
                {field: 'dirCharPerson', sort: true, edit: 'text', title: '直接负责人', width: 130},
                {field: 'leaderOfBranch', sort: true, edit: 'text', title: '分管领导', width: 110},
                {field: 'remark', sort: false, edit: 'text', title: '备注'},
                {field: 'taxRate', hide: true, title: '税率', width: 60},
                {field: 'contractType', hide: true, title: '合同类型', width: 110},
                {field: 'settleStates', hide: true, title: '结算状态', width: 110},
                {field: 'proRemarks', hide: true, title: '项目备注', width: 110}
            ]],
            toolbar: '#barDemo',
            defaultToolbar: ['filter', 'print', 'exports']
        });

        //监听单元格编辑
        table.on('edit(mainDataTable)', function (obj) {
            let value = obj.value //得到修改后的值
                , data = obj.data //得到所在行所有键值
                , field = obj.field; //得到字段

            relationSet(obj);

            if (data.id == null || data.id == '') {
                data.id = $($(obj.tr[0].children[1]).children()[0]).html();
            }

            let url = 'api/mainData/save';
            $.ajax({
                type: "post",
                url: url,
                data: data,
                dataType: 'json',
                success: function (resData) {
                    if (data.id == null || data.id == '') {
                        $($(obj.tr[0].children[1]).children()[0]).html(resData.data[0].id);
                    }
                    layer.msg('[工程编号: ' + data.projectNo + '] ' + fieldMap[field] + ' 字段更改为：' + value);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg(XMLHttpRequest.responseText);
                }
            });
        });

        //监听工具条
        table.on('toolbar(mainDataTable)', function (obj) {
            let layEvent = obj.event;
            if (layEvent === 'import') { //导入
                let tempHtml = '<ul class="layui-table-tool-panel" style="max-height: 401px;margin-top:5px;" id="tableImportBtnSel">'
                    + '<li data-type="report100">导入修改后报表</li>'
                    + '<li data-type="report200">1.导入项目信息报表</li>'
                    + '<li data-type="report201">2.导入工程收款报表</li>'
                    + '<li data-type="report300">3.导入财务报表</li>'
                    + '</ul>';
                $('#tableImportBtn').after(tempHtml);

                $('#tableImportBtnSel li').on('click', function () {
                    updloadDataFile($(this).attr('data-type'));
                });
            } else if (layEvent === 'count') {
                let url = 'api/mainData/countData';
                let data = {};
                $.ajax({
                    type: "post",
                    url: url,
                    data: data,
                    dataType: 'json',
                    success: function (resData) {
                        tableInit();
                        layer.msg('数据计算刷新成功');
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        layer.msg(XMLHttpRequest.responseText);
                    }
                });
            } else if (layEvent === 'clear') {
                layer.confirm('确认要清空全部数据?', {icon: 2, title: '警告'}, function (index) {
                    let url = 'api/mainData/deleteData';
                    $.ajax({
                        type: "delete",
                        url: url,
                        success: function (resData) {
                            tableInit();
                            layer.msg('数据已全部清空');
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            layer.msg(XMLHttpRequest.responseText);
                        }
                    });
                    layer.close(index);
                });
            }
        });

        //监听工具条
        table.on('tool(mainDataTable)', function (obj) {
            let layEvent = obj.event;

            if (layEvent === 'report') {
                layer.open({
                    type: 2,
                    title: ['富康小区泵房二次供水泵房智能终端改造项目 10月 建设报告', 'text-align: center;font-size: 20px;font-weight: 600;'],
                    area: ['100%','100%'],
                    content: '../project_report.html?v=1'
                });
            }
        });
    }

    function updloadDataFile(reportType) {
        if (reportType == 'report300') {
            layer.msg('财务数据未处理!');
            return;
        }

        upload.render({
            elem: '#tableImportBtnSel'
            , url: '/api/mainData/upload/'
            , accept: 'file'
            , acceptMime: '.xls, .xlsx'
            , exts: 'xls|xlsx'
            , data: {'reportType': reportType}
            , before: function () {
                layer.load(); //上传loading
            }
            , done: function () {
                layer.closeAll('loading'); //关闭loading
                tableInit();
            }
            , error: function () {
                layer.closeAll('loading'); //关闭loading
            }
        });

    }

//     function relationSet(obj) {
//         let value = obj.value //得到修改后的值
//             , data = obj.data //得到所在行所有键值
//             , field = obj.field; //得到字段
//
// //	  if(field == 'contractPrice' || field == 'princSupplier' || field == 'provAmount') {
// //		  data.taxedIncome = formatNum(data.contractPrice-data.princSupplier-data.provAmount, 2);
// //		  $($(obj.tr[0].children[11]).children()[0]).html(data.taxedIncome);
// //	  } else if(field == 'taxedIncome' || field=='rateOfMonth') {
// //		  data.actualOutputOfMonth = formatNum(data.taxedIncome*fixedPercent(data.rateOfMonth), 2);
// //		  $($(obj.tr[0].children[15]).children()[0]).html(data.actualOutputOfMonth);
// //	  }
//     }
//
//     formatNum = function (f, digit) {
//         let m = Math.pow(10, digit);
//         return parseInt(f * m, 10) / m;
//     }
//
//     fixedPercent = function (val) {
//         if (val.indexOf('%') >= 0) {
//             return formatNum(val.replace('%', '') / 100, 2);
//         }
//         return val;
//     }

});