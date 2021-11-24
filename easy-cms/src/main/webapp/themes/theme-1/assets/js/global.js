$(document).ready(function ($) {

//回到顶部
    function auth_change() {
        $("html,body").animate({scrollTop: 0}, "slow");
    }

    $("#top").click(function () {
        auth_change();
    });

    $(".NewsDetails .NewsDetails_content .NewsDetails_content_top p").each(function () {
        if ($(this).find('img').length >= 1) {
            $(this).addClass("on");
        }
    });

    $(".burger").click(function () {
        $(".banner").toggleClass("on");
    });


    $(function () {
        if ($(window).width() >= 1065) {
        } else {
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
    });


//点赞
    $(function () {
        for (var i = 0; i < $('.NewsDetails .NewsDetails_content .NewsDetails_content_bottom .content_bottom_help a dt').length; i++) {
            var ran = Math.floor(Math.random() * 1000 + 1)
            $('.likes').eq(i).text(ran)
        }
        $(".NewsDetails .NewsDetails_content .NewsDetails_content_bottom .content_bottom_help a dd").click(function () {
            var num = $(this).next().text()
            num++;
            $(this).next().text(num);
        });
    });


//视频开关
    $(".videobox").click(function () {
        $(".video_title_item").toggleClass("on");
    });


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

//内页banner
    var sh = -1, nh = 0;

    var h = window.setInterval(function () {

        var ww = parseInt($(window).width());
        var oldh = 520;

        if (ww < 1200) {
            sh = ww / 1200 * oldh;
        } else {
            sh = oldh;
        }

        if (nh != sh) {
            sh > 240 ? sh : sh = 100;
            $(".details_banner").height(sh);

            nh = sh;
        }
    }, 200);


//内页banner
    var sh = -1, nh = 0;

    var h = window.setInterval(function () {

        var ww = parseInt($(window).width());
        var oldh = 520;

        if (ww < 1200) {
            sh = ww / 1200 * oldh;
        } else {
            sh = oldh;
        }

        if (nh != sh) {
            sh > 240 ? sh : sh = 100;
            $(".WeChatBanner").height(sh);

            nh = sh;
        }
    }, 200);

//内页banner
    var sh = -1, nh = 0;

    var h = window.setInterval(function () {

        var ww = parseInt($(window).width());
        var oldh = 520;

        if (ww < 1200) {
            sh = ww / 1200 * oldh;
        } else {
            sh = oldh;
        }

        if (nh != sh) {
            sh > 240 ? sh : sh = 100;
            $(".case_banner,.case_banner .case_banner_content").height(sh);

            nh = sh;
        }
    }, 200);


});


