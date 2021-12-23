$(document).ready(function () {
    ArticleTool.render({
        article: {
            selector: '.article-items',
            data: articleData,
            render: function (article) {
                return `
                    <div class="news_content_list fl clear">
                        <div class="content_list_time fl">
                            <dd>${formatDate(article.releaseDate)}</dd>
                            <dt class="iconfont"><span></span></dt>
                        </div>
                        <div class="content_list_txt fl">
                            <dd>
                                <a href="${article.url}">${article.title}</a>
                            </dd>
                            <p>
                                <a href="${article.url}">${article.excerpt ? article.excerpt : article.title}</a>
                            </p>
                        </div>
                        ${getCoverElement(article)}
                        <div class="btn  fl">${(article.tags == null || article.tags === '') ? '' : 'TAG：' + article.tags.replace(/,/g, ' / ')}</div>
                    </div>`
            }
        },
        page: {
            selector: '.page',
            current: 1,
            pageSize: 9
        }
    })

    function getCoverElement(article) {
        if (article != null && article.coverPath != null && article.coverPath != '') {
            return `
                <div class="content_list_img fl">
                    <a href="${article.url}">
                        <img src="${baseUrl}${article.coverPath}" alt="${article.title}" class="tra">
                    </a>
                </div>
            `;
        } else {
            return ''
        }
    }

    function formatDate(time){
        var releaseDate = new Date(time);
        return `${releaseDate.getMonth()}-${releaseDate.getDate()}`;
    }
});