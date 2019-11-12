console.log('1号脚本加载完成')

function exLogin(){
    localStorage.setItem('name','阿状')
    localStorage.setItem('dep','财务部')
    localStorage.setItem('status','工作中')
    localStorage.setItem('src','images/exPhoto.jpg')
       alert('假人登陆完成')
    $('#sname').html(localStorage.getItem('name'))
    $('#sdep').html(localStorage.getItem('dep'))
    $('#sstatus').html(localStorage.getItem('status'))
    $('#ssrc img').attr('src',localStorage.getItem('src'))
    $('#login').html('退出').attr('id','outLogin').unbind()
    $('#outLogin').click(function(){alert('无法退出')})
}

// 信息设置
$('.left-nav ul li').click(function(){
    $('.left-nav ul li').removeClass('mouseClick')
    $(this).addClass('mouseClick')
    $("#mainTopNav").empty()
    $.each(eval($(this).attr('id')),function(i,t){
        console.log(t)
        if(i==0){
            $('#mainTopNav').append($(`<div class="mouseClick" id=${t['id']}>${t['name']}</div>`))
            $('#iframeO').attr('src',`./others/${t['id']}.html`)
        }else{
            $('#mainTopNav').append($(`<div id=${t['id']}>${t['name']}</div>`))
        }
    })
    load()
})
// 横向导航功能重加载
function load(){
    $('.main .main-top-nav div').click(function(){
        $('.main .main-top-nav div').removeClass('mouseClick')
        $(this).addClass('mouseClick')
        $('#iframeO').attr('src',`./others/${$(this).attr('id')}.html`)
    })
}
// 登陆显示隐藏~~~需要重新判断
$('#login').hover(function(){
    $('#loginModel').attr('style','right:0')
})
$('#loginModel').mouseleave(function(){
    $(this).removeAttr('style')
})
$('#clickLogin').click(function(){
    $('#loginModel').attr('style','right:0')
})









// 一次性加载
load()
//exLogin()