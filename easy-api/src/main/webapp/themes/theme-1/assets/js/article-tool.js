var ArticleTool = function () {
    // 私有
    var options = {
        article: {
            selector: null,
            data: [],
            render: function (){}
        },
        page: {
            selector: null,
            current: 1,
            pageSize: 10
        }
    }

    /**
     * 渲染文章
     */
    var renderArticle = function () {
        var container = $(options.article.selector).empty();
        var startIndex = (options.page.current - 1) * options.page.pageSize;
        var endIndex = options.page.current * options.page.pageSize;

        for (let i = startIndex; i < endIndex && i < options.article.data.length; i++) {
            container.append(options.article.render(options.article.data[i]));
        }
    }

    /**
     * 渲染分页
     */
    var renderPagination = function () {
        function addPageNumber(number, checkBoundary){
            if(typeof checkBoundary === 'undefined'){
                checkBoundary = true;
            }
            if(!checkBoundary || (number > 1 && number < totalPage)){
                container.append(`<li><a class="pagination-link pagination-link-number ${options.page.current === number ? 'pagination-link-active' : ''}" data-page="${number}">${number}</a></li>`);
            }
            if(checkBoundary){
                lastPageNumber = number;
            }
            if(firstPageNumber == null){
                firstPageNumber = number
            }
        }

        var container = $(options.page.selector).html('<ul class="pagination"></ul>').find('ul');
        // 总页数
        var totalPage = Math.ceil(options.article.data.length / options.page.pageSize)
        // var totalPage = 20
        var firstPageNumber = null;
        var lastPageNumber = 1;
        // 上一页
        container.append(`<li><a class="pagination-link pagination-link-prev ${options.page.current === 1 ? 'pagination-link-disabled' : ''}">&lt;</a></li>`);
        // 第一页
        addPageNumber(1, false);
        // ...
        if ((firstPageNumber - 1) > 1) {
            container.append(`<li><a class="pagination-link pagination-link-more pagination-link-more-before pagination-link-disabled">...</a></li>`);
        }

        // 中间页
        for (let i = 1; i <= 5; i++) {
            if (options.page.current <= 3) {
                // 1 2 3 4 5 ... 10
                addPageNumber(i)
            } else if (totalPage - options.page.current <= 3) {
                // 1 ... 6 7 8 9 10
                addPageNumber(totalPage + i - 5)
            } else {
                // 1 ... 3 4 5 6 7 ... 10
                addPageNumber(options.page.current + i - 3)
            }
        }

        // ...
        if ((totalPage - lastPageNumber) > 1) {
            container.append(`<li><a class="pagination-link pagination-link-more pagination-link-more-after pagination-link-disabled">...</a></li>`);
        }

        // 最后一页
        if (totalPage > 1) {
            addPageNumber(totalPage, false);
        }

        // 下一页
        container.append(`<li><a class="pagination-link pagination-link-next ${options.page.current === totalPage ? 'pagination-link-disabled' : ''}">&gt;</a></li>`);

        bindPaginationEvent()
    }

    var bindPaginationEvent = function (){
        // 点击事件
        var ul = $(options.page.selector).find('ul')
        ul.on('click', 'a.pagination-link', function () {
            if ($(this).hasClass('pagination-link-disabled')) {
                return;
            }
            var currentPage;
            if ($(this).hasClass('pagination-link-number')) {
                currentPage = Number($(this).data('page'));
            } else {
                currentPage = Number(ul.find('.pagination-link-active').data('page'));
                if ($(this).hasClass('pagination-link-prev')) {
                    currentPage--;
                } else if ($(this).hasClass('pagination-link-next')) {
                    currentPage++;
                }
            }
            options.page.current = currentPage

            renderPagination()

            renderArticle()
        })
    }

    return {
        /**
         * 渲染文章
         */
        renderArticle: function () {
            renderArticle();
        },
        /**
         * 渲染分页
         */
        renderPagination: function () {
            renderPagination()
        },
        /**
         * 渲染数据&分页
         *
         * @param config.article.selector {string} 选择器
         * @param config.article.data {array} 数据
         * @param config.article.render {function} 渲染函数
         * @param config.page.selector {string} 选择器
         * @param config.page.current {number} 当前页
         * @param config.page.pageSize {number} 页大小
         */
        render: function (config) {
            options.article = config.article
            options.page = config.page

            renderArticle()

            renderPagination()
        }
    }
}()