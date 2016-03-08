;(function($) {	
	var school = {
		places: [],
		isFirst: true,
		dividCn: ["a","ai","an","ang","ao","ba","bai","ban","bang","bao","bei","ben","beng","bi","bian","biao","bie","bin","bing","bo","bu","ca","cai","can","cang","cao","ce","ceng","cha","chai","chan","chang","chao","che","chen","cheng","chi","chong","chou","chu","chuai","chuan","chuang","chui","chun","chuo","ci","cong","cou","cu","cuan","cui","cun","cuo","da","dai","dan","dang","dao","de","deng","di","dian","diao","die","ding","diu","dong","dou","du","duan","dui","dun","duo","e","en","er","fa","fan","fang","fei","fen","feng","fo","fou","fu","ga","gai","gan","gang","gao","ge","gei","gen","geng","gong","gou","gu","gua","guai","guan","guang","gui","gun","guo","ha","hai","han","hang","hao","he","hei","hen","heng","hong","hou","hu","hua","huai","huan","huang","hui","hun","huo","ji","jia","jian","jiang","jiao","jie","jin","jing","jiong","jiu","ju","juan","jue","jun","ka","kai","kan","kang","kao","ke","ken","keng","kong","kou","ku","kua","kuai","kuan","kuang","kui","kun","kuo","la","lai","lan","lang","lao","le","lei","leng","li","lia","lian","liang","liao","lie","lin","ling","liu","long","lou","lu","lv","luan","lue","lun","luo","ma","mai","man","mang","mao","me","mei","men","meng","mi","mian","miao","mie","min","ming","miu","mo","mou","mu","na","nai","nan","nang","nao","ne","nei","nen","neng","ni","nian","niang","niao","nie","nin","ning","niu","nong","nu","nv","nuan","nue","nuo","o","ou","pa","pai","pan","pang","pao","pei","pen","peng","pi","pian","piao","pie","pin","ping","po","pu","qi","qia","qian","qiang","qiao","qie","qin","qing","qiong","qiu","qu","quan","que","qun","ran","rang","rao","re","ren","reng","ri","rong","rou","ru","ruan","rui","run","ruo","sa","sai","san","sang","sao","se","sen","seng","sha","shai","shan","shang","shao","she","shen","sheng","shi","shou","shu","shua","shuai","shuan","shuang","shui","shun","shuo","si","song","sou","su","suan","sui","sun","suo","ta","tai","tan","tang","tao","te","teng","ti","tian","tiao","tie","ting","tong","tou","tu","tuan","tui","tun","tuo","wa","wai","wan","wang","wei","wen","weng","wo","wu","xi","xia","xian","xiang","xiao","xie","xin","xing","xiong","xiu","xu","xuan","xue","xun","ya","yan","yang","yao","ye","yi","yin","ying","yo","yong","you","yu","yuan","yue","yun","za","zai","zan","zang","zao","ze","zei","zen","zeng","zha","zhai","zhan","zhang","zhao","zhe","zhen","zheng","zhi","zhong","zhou","zhu","zhua","zhuai","zhuan","zhuang","zhui","zhun","zhuo","zi","zong","zou","zu","zuan","zui","zun","zuo"],
		backTemp: $('<div class="js-school-back school-back"></div>'),
		mainTemp: $('<div class="js-school school">' +
			'<div class="panel panel-default">' +				
				'<div class="panel-heading">选择你的<span class="high">大学</span></div>' +
				'<div class="panel-body">' +
					'<div class="js-school-select school-select">' +
						'<div class="col-md-3">' +
							'<select class="js-school-city form-control">' +
							'</select>' +
						'</div>' +
						'<div class="col-md-3">' +
							'<input type="text" class="js-school-key form-control" placeholder="输入关键字查询学校">' +
						'</div>' +
					'</div>' +
					'<div class="clearfix"></div>' +
					'<div class="js-school-name school-name">' +
					'</div>' +					
				'</div>' +
				'<div class="panel-footer text-right">' +
					'<button class="btn btn-success-outline js-school-close">关闭</button>' +
				'</div></div></div>'),
		schools: [],
		init: function(dataUrl) {
			var _this = this;
			$(function() {				
				$.ajax({		
					url: dataUrl,
					success: function(resp) {
						var schools = $.parseJSON(resp);						
						for (var i = 0; i < schools.length; i ++) _this.places[schools[i].place] = i;		//索引place
						_this.schools = schools;
						_this.injectData(schools, '北京');
						_this.registerEvent(schools);
						_this.initAlpha();
					}
				});
			});					
		},
		injectData: function(schools, place) {
			var _this = this,
				$control = _this.mainTemp,
				$back = _this.backTemp,
				$window = $(window),
				$city = $control.find(".js-school-city"),
				plist = _this.getSchoolsByPlace(schools, place);				
			for (var i in _this.places) {
				var $obj = $("<option>", {
					value: i,
					text: i
				});
				$city.append($obj);
			}
			$city.get(0).selectedIndex = 0;
			_this.updatePlace(plist.schools);
			if ( _this.isFirst ) {
				$("body").append($back).append($control);
				$control.css({
					marginLeft: ($window.width()-$control.width())/2			
				});		
				_this.isFirst = false;
			}			
		},
		updatePlace: function(schools) {
			var $pschool = this.mainTemp.find(".js-school-name");
			$pschool.empty();
			for (var i = 0; i < schools.length; i ++) {
				var s = schools[i];
				var $obj = $('<a href="#" class="list-tag list-tag-default"></a>');
				$obj.html(s.name);
				$pschool.append($obj);
			}
			this.query = '';
			this.parseRet = [];
			this.filter = [];
		},
		registerEvent: function(schools) {
			var $outInput = $("[data-school]").find("input[type=text]"),
				$btn = $("[data-school]").find("button"),
				_this = this;
			//页面btn显示
			$btn.click(function() {
				_this.show();													
			});			
			//tag点击返回
			this.mainTemp.find(".js-school-name").on("click", ".list-tag", function() {
				var $this = $(this);
				$outInput.val($this.html());
				_this.close();
			});			
			//close
			this.bindCloseEvent();
			
			//select 
			this.mainTemp.find(".js-school-city").change(function() {
				var $this = $(this);				
				_this.changeData(schools, $this.val());
				_this.mainTemp.find(".js-school-key").val('');
			});
			
			this.mainTemp.find(".js-school-key").on('keyup.keyinput', $.proxy(this.inputKeyEvent, this));
		},
		query: '',
		filter: [],
		inputKeyEvent: function(e) {
			var index = this.mainTemp.find(".js-school-city").val();
			var pschool = this.schools[this.places[index]].schools;			
			var query = this.mainTemp.find(".js-school-key").val();
			query = $.trim(query);
			if ( query == this.query ) return ;
			var filter = [];
			if ( query == '' ) filter = pschool; 
			else {
				if ( /^[a-zA-z]+$/.test(query) ) {
					query = query.toLowerCase();
					//由query过滤部分数据,加速查询					
					if ( this.query == '' || query.indexOf(this.query) != 0 ) this.filter = pschool;	//优化				
					filter = this.filterQuery(query, this.filter);
					this.parseRet = [];										
					this.parseQuery(query, query[0], 1, filter);
					filter = this.deepFilterQuery(filter);
				}else {
					for (var i = 0; i < pschool.length; i ++) {
						if ( pschool[i].name.indexOf(query) > -1 ) filter.push(pschool[i]);
					}		
				}
			}
			this.updatePlace(filter);			
			this.query = query;
			this.filter = filter;
		},
		filterQuery: function(query, pschool) {	//模糊匹配过滤部分数据
			var filter = [];
			var s = '';
			for (var i = 0; i < query.length; i ++) {
				s += (query[i] + '.+');
			}
			var regex = new RegExp(s);
			var cnt = 0;
			for (var i = 0; i < pschool.length; i ++) {
				if ( regex.test(pschool[i].py) ) filter.push(pschool[i]);
				else cnt ++;
			}			
			return filter;
		},
		deepFilterQuery: function(pschool) {
			var ret = this.parseRet;				
			var filter = [], vis = [];
			for (var i = 0; i < ret.length; i ++) {
				var s = this.getFirstAlpha(ret[i].split(','));				
				for (var j = 0; j < pschool.length; j ++) {
					var zm = pschool[j].zm;
					if ( !vis[j] && zm.indexOf(s) > -1 ) {
						vis[j] = true;
					}
				}
			}
			for (var i = 0; i < pschool.length; i ++) {
				if ( vis[i] ) filter.push(pschool[i]);
			}
			return filter;			
		},
		getFirstAlpha: function(str) {
			var ret = '';
			for (var i = 0; i < str.length; i ++) ret += str[i][0];
			return ret;
		},
		alphaExclude: {},	//哪些首字母是出现的
		initAlpha: function() {
//			var obj = this.schools;
//			for (var i = 0; i < obj.length; i ++) {
//				var o = obj[i].schools;
//				for (var j = 0; j < o.length; j ++) {
//					var name = o[j].zm;
//					for (var k = 0; k < name.length; k ++) {
//						if ( !this.alphaExclude[name[k]] ) this.alphaExclude[name[k]] = true;						
//					}
//				}
//			}
			//直接结果，数据跑过一次了
			for (var i = 0; i < 26; i ++) {
				this.alphaExclude[String.fromCharCode(('a'.charCodeAt(0)+i))] = true;
			}			
			this.alphaExclude['i'] = this.alphaExclude['u'] = this.alphaExclude['v'] = false;			
		},
		parseRet: [],
		checkQuery: function(str, pschool) {
			if ( pschool == null || pschool.length == 0 ) return true;
			var spstr = str.split(',');
			var zm = '';
			for (var i = 0; i < spstr.length; i ++) zm += spstr[0];	//拼接每个首字母
			for (var i = 0; i < pschool.length; i ++) {
				var ps = pschool[i];
				if ( ps.zm.indexOf(zm) == 0 )	return true;
			}
			return false;
		},
		parseQuery: function(query, s, pos, pschool) {	//分解查询(枚举分割点子集)	
			if ( pos == query.length ) {
				this.parseRet.push(s);
				return ;
			}
			var ts = s + (',' + query[pos]);
			if ( this.alphaExclude[query[pos]] && this.checkQuery(ts, pschool) ) {	//如果每段字母首字母拼接在原数据中不存在则过滤					
				this.parseQuery(query, ts, pos+1);						
			}
			this.parseQuery(query, s + query[pos], pos+1);
		},
		changeData: function(schools, place) {
			var plist = this.getSchoolsByPlace(schools, place);
			this.updatePlace(plist.schools);
		},
		bindCloseEvent: function() {
			var _this = this;				
			this.backTemp.click(function() {
				_this.close();
			});
			this.mainTemp.find(".js-school-close").click(function() {
				_this.close();
			});			
			$(document).on('keyup.keyboard', $.proxy(this.actionKeyEvent, this));
		},
		actionKeyEvent: function(e) {
			var KEYCODE_ESC = 27;			
			if ( e.keyCode === KEYCODE_ESC ) {
				this.close();
			}
		},
		offKeyClose: function() {
			$(document).off('.keyboard');
		},
		show: function() {
			this.mainTemp.css({
				top: -this.mainTemp.height()+20
			});
			this.backTemp.fadeIn();											
			this.mainTemp.fadeIn().animate({
				top: 0
			}, 300);
		},
		close: function() {			
			if ( this.mainTemp.css('top') != '0px' ) return ;
			this.mainTemp.fadeOut();
			this.backTemp.fadeOut();
		},
		getSchoolsByPlace: function(schools, place) {			
			return schools[this.places[place]];
		}
	};
	school.init('js/dschool.js');
})(jQuery);
