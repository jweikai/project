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
			      	'<button type="button" class="btn btn-danger js-btn-confirm hide">确定</button>' +
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
//				_this.openImageIndex();
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
		openConfirm: function(str, fn) {
			var _this = this;
			this.modalTemplate.find('.js-btn-confirm').removeClass('hide');
			this.modalTemplate.find(".modal-body").text(str);
			this.modalTemplate.modal('show');
			if ( fn ) {
				this.modalTemplate.find('.js-btn-confirm').one("click", function() {
					_this.modalTemplate.find('.js-btn-confirm').addClass('hide');
					_this.modalTemplate.modal('toggle');
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
			var $control = $("[data-run]"),
				animateName= $control.data("run"), 
				sel = $control.data("target"),		
				$target = (sel == null ? $control : $control.find(sel));
			$control.hover(function() {
				$target.addClass("animated " + animateName);
			}, function() {
				$target.removeClass("animated " + animateName);
			});
		},
		globalSet: function(config) {	//全局设置			
			if ( config.gDate ) {
				this.openDate();				
			}
		},
		createUE: function(id, config) {		
			var c = {
	        	toolbars: [[
   		            'fullscreen', 'source', '|', 'undo', 'redo', '|',
   		            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
   		            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
   		            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
   		            'directionalityltr', 'directionalityrtl', 'indent', '|',
   		            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
   		            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
   		            'simpleupload', 'insertimage', 'emotion', 'scrawl', 'attachment', 'insertcode', 'pagebreak', 'template', 'background', '|',
   		            'horizontal', 'date', 'time', 'spechars', '|',										            
   		            'print', 'preview', 'searchreplace', 'help', 'drafts'
   		        ]],
   			    initialFrameWidth: '100%',
   			    initialFrameHeight: 200,	
   			    elementPathEnabled: false,
   			    wordCount: false,
   			    //initialContent: '随便写',			    
   			    autoClearinitialContent: true
   			};
			if ( config ) {
				for (var p in c) {
					if ( !config[p] ) continue ;
					c[p] = config[p];
				}
			}
			UE.getEditor(id, c);
		}
	};
	window.g = g;
	g.init();
})(jQuery);
function requestFullScreen() {
    var de = document.documentElement;
    if (de.requestFullscreen) {
        de.requestFullscreen();
    } else if (de.mozRequestFullScreen) {
        de.mozRequestFullScreen();
    } else if (de.webkitRequestFullScreen) {
        de.webkitRequestFullScreen();
    }
}
$(function() {
	function deleteAction(url) {
		$(".js-loading-success").hide();
		$(".js-loading").show();
		$.ajax({
			type: 'POST',
			url: url,
			dataType: 'json',
			success:function(resp) {
				$(".js-loading").hide();
				$(".js-loading-success").text(resp.msg).fadeIn(function() {
					window.location.href = 'list';
				});				
			}
		});
	}
	$(".js-delete").click(function() {
		var url = $(this).attr("href");
		deleteAction(url);
		return false;
	});
	$("#delAllBtn").click(function() {
		var $cs = $(":checked");
		if ( $cs.length == 0 ) {
			g.openDialog('请选择删除对象');
			return false;
		}
		var name = $cs.attr('name');
		g.openConfirm('是否要选择删除?', function() {			
			var data = '?'+($cs.map(function() {
				return name+'='+this.value;
			}).get().join('&'));
			var url = ['delete'];
			url.push(data);			
			deleteAction(url.join(''));
		});
		return false;
	});
	$("#checkall-btn").click(function() {
		var $cs = $(":checkbox");
		$cs.prop('checked', !$cs.prop('checked'));
	});
	$("#searchBtn").click(function() {
		var $this = $(this),
		 	action = $this.data('action'),
		 	$form = $this.parents('form');
		window.location.href = action + '?' + $form.serialize();
	});
});
