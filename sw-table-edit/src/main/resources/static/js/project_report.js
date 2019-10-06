let dataConProgressChart, dataPlanCheckChart, dataReceiveSettleChart;

layui.use(['table', 'upload'], function () {
    // let table = layui.table;
    // let upload = layui.upload;

    //监听滚动条事件
    $(window).scroll(function () {
        let paddingHeight = 0;
        //获取当前滚动条高度
        let scrollToTop = $(document).scrollTop();

        let heightR1 = $('#data-plan').height() + paddingHeight * 2;
        let heightR2 = heightR1 + $('#data-produce').height() + paddingHeight * 2;
        let heightR3 = heightR2 + $('#data-finance').height() + paddingHeight * 2;
        let heightR4 = heightR3 + $('#data-con-progress').height() + paddingHeight * 2;
        let heightR5 = heightR4 + $('#data-plan-check').height() + paddingHeight * 2;
        let heightR6 = heightR5 + $('#data-receive-settle').height() + paddingHeight * 2;

        if (scrollToTop < heightR1) {
            $('#nav2 li').siblings(".current").removeClass('current');
            $('#nav2 #r1').addClass('current');
        } else if (scrollToTop >= heightR1 && scrollToTop < heightR2) {
            $('#nav2 li').siblings(".current").removeClass('current');
            $('#nav2 #r2').addClass('current');
        } else if (scrollToTop >= heightR2 && scrollToTop < heightR3) {
            $('#nav2 li').siblings(".current").removeClass('current');
            $('#nav2 #r3').addClass('current');
        } else if (scrollToTop >= heightR3 && scrollToTop < heightR4) {
            $('#nav2 li').siblings(".current").removeClass('current');
            $('#nav2 #r4').addClass('current');
        } else if (scrollToTop >= heightR4 && scrollToTop < heightR5) {
            $('#nav2 li').siblings(".current").removeClass('current');
            $('#nav2 #r5').addClass('current');
        } else if (scrollToTop >= heightR5 && scrollToTop < heightR6) {
            $('#nav2 li').siblings(".current").removeClass('current');
            $('#nav2 #r6').addClass('current');
        }
    });

    // 增加锚点动画
    $('#nav2 li a').on('click', function () {
        let hsHight = $($(this).attr("href")).offset().top;
        $("html, body").animate({
            scrollTop: hsHight + "px"
        }, 500);

        return false;
    });

    let dataConProgressChartOption = {
        title: {
            text: '实际/监理'
        },
        tooltip: {},
        legend: {
            data: ['实际', '监理']
        },
        grid: {
            height: '90%'
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                {name: '当月进度', max: 100},
                {name: '当月产值', max: 700000},
                {name: '累计产值', max: 1078000}
            ],
            center: ['50%', '60%']
        },
        series: [{
            name: '实际 vs 监理',
            type: 'radar',
            data: [
                {
                    value: [15, 280000, 620000],
                    name: '实际',
                    // 设置区域边框和区域的颜色
                    itemStyle: {
                        normal: {
                            color: '#B8D3E4',
                            lineStyle: {
                                color: '#72ACD1',
                            },
                        },
                    },
                    areaStyle: {
                        normal: {
                            opacity: 0.5,
                            color: new echarts.graphic.RadialGradient(0.5, 0.5, 1, [
                                {
                                    color: '#B8D3E4',
                                    offset: 0
                                },
                                {
                                    color: '#72ACD1',
                                    offset: 1
                                }
                            ])
                        }
                    }
                },
                {
                    value: [12, 220000, 560000],
                    name: '监理',
                    // 设置区域边框和区域的颜色
                    itemStyle: {
                        normal: {
                            color: '#FFE100',
                            lineStyle: {
                                color: '#FFB717',
                            },
                        },
                    }
                }
            ]
        }]
    };

    dataConProgressChart = echarts.init(document.getElementById('dataConProgressChart'));
    dataConProgressChart.setOption(dataConProgressChartOption);

    let dataPlanCheckChartOption = {
        title: {
            text: '计划/预估/审定'
        },
        tooltip: {},
        legend: {
            data: ['计划', '预估', '审定']
        },
        grid: {
            height: '90%'
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                {name: '工程金额', max: 1000000},
                {name: '收入(除税)', max: 800000},
                {name: '成本', max: 800000},
                {name: '毛利润', max: 500000},
                {name: '毛利率', max: 100}
            ],
            center: ['50%', '60%']
        },
        series: [{
            name: '计划 vs 预估 vs 审定',
            type: 'radar',
            data: [
                {
                    value: [800000.00, 727272.73, 400000.00, 327272.73, 45],
                    name: '计划',
                    // 设置区域边框和区域的颜色
                    itemStyle: {
                        normal: {
                            color: '#B8D3E4',
                            lineStyle: {
                                color: '#72ACD1',
                            },
                        },
                    }
                },
                {
                    value: [700000.00, 636363.64, 450000.00, 186363.64, 29.29],
                    name: '预估',
                    // 设置区域边框和区域的颜色
                    itemStyle: {
                        normal: {
                            color: '#FFE100',
                            lineStyle: {
                                color: '#FFB717',
                            },
                        },
                    }
                },
                {
                    value: [650000.00, 590909.09, 450000.00, 140909.09, 23.85],
                    name: '审定',
                    // 设置区域边框和区域的颜色
                    itemStyle: {
                        normal: {
                            color: '#ffbec0',
                            lineStyle: {
                                color: '#ff7784',
                            },
                        },
                    }
                }
            ]
        }]
    };

    dataPlanCheckChart = echarts.init(document.getElementById('dataPlanCheckChart'));
    dataPlanCheckChart.setOption(dataPlanCheckChartOption);


    let dataReceiveSettleChartOption = {
        title: {
            text: '未来一周气温变化'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['最高气温', '最低气温']
        },
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                magicType: {type: ['line', 'bar']},
                restore: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value} °C'
            }
        },
        series: [
            {
                name: '最高气温',
                type: 'line',
                data: [11, 11, 15, 13, 12, 13, 10],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '最低气温',
                type: 'line',
                data: [1, -2, 2, 5, 3, 2, 0],
                markPoint: {
                    data: [
                        {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'},
                        [{
                            symbol: 'none',
                            x: '90%',
                            yAxis: 'max'
                        }, {
                            symbol: 'circle',
                            label: {
                                normal: {
                                    position: 'start',
                                    formatter: '最大值'
                                }
                            },
                            type: 'max',
                            name: '最高点'
                        }]
                    ]
                }
            }
        ]
    };

    dataReceiveSettleChart = echarts.init(document.getElementById('dataReceiveSettleChart'));
    dataReceiveSettleChart.setOption(dataReceiveSettleChartOption);

});