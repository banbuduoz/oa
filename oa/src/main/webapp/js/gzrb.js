//年月日
var date1=new Date()
var yearMonth=`${date1.getFullYear()}-${date1.getMonth()+1}`
var wok=date1.getDay()
$('#yearMonth').html(yearMonth)
function getDates(){
    var curDate = new Date();
    /* 获取当前月份 */
    var curMonth = curDate.getMonth();
    /*  生成实际的月份: 由于curMonth会比实际月份小1, 故需加1 */
    curDate.setMonth(curMonth + 1);
    /* 将日期设置为0, 这里为什么要这样设置, 我不知道原因, 这是从网上学来的 */
    curDate.setDate(0);
    /* 返回当月的天数 */
    return curDate.getDate();
}
var dateNum=getDates()
$('#dayDate ul').empty()
for	(var i = 0 ; i<dateNum;i++){
	var x=new Date(`${yearMonth}-${i+1}`).getDay()
	switch (x){
		case 0:
			x='日'
			break;
			case 1:
			x='一'
			break;
			case 2:
			x='二'
			break;
			case 3:
			x='三'
			break;
			case 4:
			x='四'
			break;
			case 5:
			x='五'
			break;
			case 6:
			x='六'
			break;
		default:
			break;
	}
	if(x=='六'||x=='日'){
		$('#dayDate ul').append(`<li class='zm' id='${yearMonth}-${i+1}'><p>${i+1}</p><p>${x}</p></li>`)
	}
	else if((date1.getDate())==(i+1)){
		$('#dayDate ul').append(`<li class='td' id='${yearMonth}-${i+1}'><p>${i+1}</p><p>${x}</p></li>`)		
	}
	else{
		$('#dayDate ul').append(`<li id='${yearMonth}-${i+1}'><p>${i+1}</p><p>${x}</p></li>`)		
	}
}
$('#dayDate ul li').attr('style',`width:${1550/dateNum}px`)
$.ajax({
	url:'127.0.0.1:8080/oa/login.action',
	success:function(res){
		console.log(res)
		console.log(1)
	},
	fail:function(){
		console.log('error')
	},
})