//全局
$(function() {
	Highcharts.setOptions({
        // 所有语言文字相关配置都设置在 lang 里
        lang: {
            resetZoom: '重置',
            resetZoomTitle: '重置缩放比例',
	        loading:"加载中",
	        months:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
	        shortMonths: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
	        weekdays: ["星期一", "星期二", "星期三", "星期三", "星期四", "星期五", "星期六","星期天"]
        }
    });
	lineData();
	cycleData();
	$(".alert .fa-close").click(function() {
		$(this).parent().fadeOut();
	});
});
function lineData() {
	$('#hc-userFlow').highcharts({
    	chart: {
    		type: 'line',
    		zoomType: 'x',	//xy
//			    		selectionMarkerFill: 'rgba(0,0,0, 0.2)',	//选择区颜色
			resetZoomButton: {
                // 按钮定位
            	position:{
                    align: 'right', // by default
                    verticalAlign: 'top', // by default
                    x: 0,
                    y: -30
                },
                // 按钮样式
                theme: {
                    fill: 'white',
                    stroke: 'silver',
                    r: 0,
                    states: {
                        hover: {
                            fill: '#41739D',
                            style: {
                                color: 'white'
                            }
                        }
                    }
                }
           }           
    	},
        title: {
//			        	useHTML: true,	//使用html解析
            text: '<a href="#">注册/最多在线用户数据统计图</a>',
            x: -20 //center
        },			        
        xAxis: {
//			            categories: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
			type: 'datetime',
			maxZoom: 24*3600000,			
			labels: {
				formatter :function() {
               		return Highcharts.dateFormat('%m月%d日', this.value);
            	}
            }
        },
        yAxis: {
            title: {
                text: '人数 (人)'
            }			            
        },
        tooltip: {
            valueSuffix: '人',
            useHTML: true,
            headerFormat: '<a href="#" style="display:block;">第几场竞赛</a>',
            pointFormat: '<a href="#">{series.name}{point.y}</a>',			             
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
        	pointInterval: 24*3600 * 1000,	//1天间隔
			pointStart: Date.UTC(2015, 9, 10),
            name: '注册用户',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,1,2,3,4,5]			            
	        },{
        	pointInterval: 24*3600 * 1000,	//1天间隔
			pointStart: Date.UTC(2015, 9, 10),
            name: '最多在线用户',
            data: [1,2,3,4,5,6,7,8,9,10,11,12]			            
	    }],
	    credits: {
	    	enabled: false
	    }
    }, function(chart) {
    	var o = $(chart.title.textStr);
    	//设置标题			    	
    	chart.setTitle({
    		text: new Date().getFullYear() + '年 ' +o.text()
    	});
    	for (var i = 0; i < chart.series.length; i ++) {
        	addLabel(chart, getMax(chart.series[i].points));			        	
       	}
    });
    function getMax(points) {
    	var val = points[0];			    	
    	for (var i = 1; i < points.length; i ++) {
    		if ( val.y < points[i].y ) val = points[i];			    		
    	}
    	return val;
    }
    function addLabel(chart, point) {			    	
    	chart.renderer
        	.label('最大值: ' + point.y + chart.tooltip.options.valueSuffix,  point.plotX + chart.plotLeft -20 , point.plotY + chart.plotTop - 45, 'callout', point.plotX + chart.plotLeft, point.plotY + chart.plotTop)
            .css({
                color: '#FFFFFF'
            })
            .attr({
                fill: 'rgba(0, 0, 0, 0.75)',
                padding: 8,
                r: 5,
                zIndex: 6
            })
            .add();
    }
}
function cycleData() {
	$('#hc-problemCount').highcharts({
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false
	    },
	    credits:{
		     enabled:false // 禁用版权信息
		},
	    title: {
	        text: '系统题目分类饼图'
	    },
	    tooltip: {
	    	useHTML:true,
		    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b><a href="#">点击</a>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: false
	            },
	            showInLegend: true
	        },
	        /*series: {
	        	events: {
	        		click: function(e) {
	        			alert(1);
	        		}
	        	}
	        }*/
	    },
	    series: [{
	        type: 'pie',
	        name: 'Browser share',
	        data: [
	            ['入门题',   10],
	            ['动态规划',       20],
	            {
	                name: '数据结构',
	                y: 30,
	                sliced: true,
	                selected: true
	            },
	            ['线段数',    40],
	            ['贪心',     50],			                    
	            ]
	        }]
	    });
}
