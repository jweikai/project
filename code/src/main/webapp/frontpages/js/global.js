;(function($){
	NProgress.configure({ trickleRate: 0.06 });	//步长
	var g = {
		baseUrl: "/code/",	//项目名
		extendDir: "../extends/",	//插件文件夹				
		modalTemplate: $('<div class="modal fade" id="myAlertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">' +
			  '<div class="modal-dialog" role="document">' +
			    '<div class="modal-content">' +
			      '<div class="modal-header">' +
			        '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>' + 
			        '<h4 class="modal-title" style="font-family: '+'microsoft yahei'+'; color: red;" id="myAlertModalLabel">警告</h4>' +
			      '</div>' +
			      '<div class="modal-body" style="color: #3071A9;font-size:14px;">' +		        	
			      '</div>' +
			      '<div class="modal-footer">' +
			        '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>' +
			      '</div>' +
			    '</div>' +
			  '</div>' +
			'</div>'),	//modal框
		init: function() {			
			var _this = this;
			var $scripts = $("script");
			//页面加载进度
			$(function() {
				NProgress.start();
				NProgress.set(0.8);
				_this.openPjax();
				_this.openImageIndex();
				_this.siteRegister();
				_this.runRegister();
				$scripts.each(function() {
					if ( /.+datetimepicker.+min\.js/.test(this.src) ) {
						_this.openDate();
					}
				});
			});
			$(window).load(function() {
				NProgress.done();
			});
		},
		openPjax: function() {
			$.ajaxSetup({
				timeout: 10000 //10 second		 		
			});
			var _this = this;
			//ajax全局设置			
			$(document)
				.ajaxStart(function() {
					NProgress.start();
				})
				.ajaxStop(function() {
					NProgress.done();
				})
				.ajaxError(function(jqXHR, options, errorMsg) {
					if ( options.status == 500 ) {
						window.location.href = '../error/500.html';
					}else if (options.status == 404) {
						window.location.href = '../error/404.html';
					}else if ( options.statusText === "timeout" ) {
						_this.openDialog('网速不给力, 刷新看看', function() {
							window.location.reload();
						});
					}
				});
		},
		openDate: function() {	//日期
			var $control = $("[data-date]"),				
				dateFormat = "YYYY-MM-DD",
				exactFormat = " HH:mm:ss";
			$control.each(function() {
				var config = {
//					format: 'YYYY-MM-DD HH:mm:ss',		
	                ignoreReadonly: true,
//					maxDate: new Date(),
	                minDate: new Date(1800,1,1)
				},
					$this = $(this),
					setting = $this.data("date"),
					format = dateFormat;
				if ( setting.isExact ) {
					format = dateFormat + exactFormat;					
				}
				config["format"] = format;				
				if ( setting.limitTime ) {
					config["maxDate"] = new Date();
				}
				$this.datetimepicker(config);
			});
		},
		openDialog: function(str, fn) {	//弹出框
			this.modalTemplate.find(".modal-body").text(str);
			this.modalTemplate.modal('show');
			if ( fn ) {
				this.modalTemplate.one("hidden.bs.modal", function() {
					fn();				
				});
			}
		},		
		openImageIndex: function() {	//图片显示,索引全局图片位置
			$(".lb-details").on("click", ".lb-number", function() {
				var idxTxt = $(this).find(".lb-img-index").text(),
					idx = idxTxt.match(/(\d) of \d/)[1],
					targetImg = $($("[data-lightbox]")[idx-1]);
				lightbox.end();	//lightbox挂在了window上
				$("html,body").animate({
					scrollTop: targetImg.offset().top-10
				}, 200);
			});
		},
		siteRegister: function() {	//侧滑
			var $control = $(".site-nav");
			if ( $control.length == 0 )	return ;			
			$control.on({
				mouseover: function() {
					$("body.contract .site-nav").css({
						left: 0,
						opacity: 1
					});
					$("body.contract .container").css({
						marginLeft: 150
					});
				},
				mouseleave: function() {
					$("body.contract .site-nav").css({
						left: -100,
						opacity: .5
					});
					$("body.contract .container").css({
						marginLeft: 50
					});
				}				
			});	
			$(window).resize(function() {
				if ( $(this).width() <= 700 ) {
					$("body").removeClass("contract");
				}else {
					$("body").addClass("contract");
				}
			});
		},
		runRegister: function() {
			var $control = $("[data-run]");
			$control.each(function() {				
				var $this = $(this),
					sel = $this.data("target");
				this.animateName = $this.data("run");
				this.target = (sel == null ? $this : $this.find(sel))
				$this.hover(function() {
					this.target.addClass("animated " + this.animateName);
				}, function() {
					this.target.removeClass("animated " + this.animateName);
				});			
			});
		},
		globalSet: function(config) {	//全局设置			
			if ( config.gDate ) {
				this.openDate();				
			}
		}
	};
	window.g = g;
	g.init();
})(jQuery);
