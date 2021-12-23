$(document).ready(function ($) {

    // 选中菜单
    $('.menu > ul > li[data-menu-key="' + currentPage + '"]').addClass('on active')

    //回到顶部
    $("#top").click(function () {
        $("html,body").animate({scrollTop: 0}, "slow");
    });

    $(window).scroll(function (e) {
        setHeaderClass();
    })

    function setHeaderClass(){
        var top = $(document).scrollTop();
        if (top > 10) {
            // 添加悬浮class
            $('.pc_header').addClass('pc_header_fixed')
        } else {
            $('.pc_header').removeClass('pc_header_fixed')
        }
    }

    setHeaderClass();

    $(".burger").click(function () {
        $(".banner").toggleClass("on");
    });


    if ($(window).width() < 1065) {
        $(".service_items").click(function () {
            $(".DropDown").addClass("on");
            $(".DropDown").removeClass("in");
            $(".menu_title ").hide();
        })
        $(".DropDown").append("<div class='DropDown_close iconfont'>&#xe608;</div>")
        $(".DropDown_close").click(function () {
            $(".DropDown").removeClass("on");
            $(".DropDown").addClass("in");
            $(".menu_title ").show();
        })
    }


    //移动切换
    if ('ontouchstart' in window) {
        var click = 'touchstart';
    } else {
        var click = 'click';
    }

    $('div.burger').on(click, function () {
        if (!$(this).hasClass('open')) {
            openMenu();
        } else {
            closeMenu();
        }
    });

    function openMenu() {
        $('div.circle').addClass('expand');
        $('div.burger').addClass('open');
        $('div.x, div.y, div.z').addClass('collapse');
        $('.menu li').addClass('animate');
        $('.menu').addClass('on');
        setTimeout(function () {
            $('div.y').hide();
            $('div.x').addClass('rotate30');
            $('div.z').addClass('rotate150');
        }, 70);
        setTimeout(function () {
            $('div.x').addClass('rotate45');
            $('div.z').addClass('rotate135');
        }, 120);
    }

    function closeMenu() {
        $('div.burger').removeClass('open');
        $('div.x').removeClass('rotate45').addClass('rotate30');
        $('div.z').removeClass('rotate135').addClass('rotate150');
        $('div.circle').removeClass('expand');
        $('.menu li').removeClass('animate');
        $('.menu').removeClass('on');
        setTimeout(function () {
            $('div.x').removeClass('rotate30');
            $('div.z').removeClass('rotate150');
        }, 50);
        setTimeout(function () {
            $('div.y').show();
            $('div.x, div.y, div.z').removeClass('collapse');
        }, 70);
    }
});


