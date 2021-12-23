$(document).ready(function (){
    ArticleTool.render({
        article: {
            selector: '.article-items',
            data: articleData,
            render: function (article){
                return `
                    <div class="IndexCase_content_list fl" >
                        <div class="content_list_img">
                            <div>${getCoverElement(article)}</div>
                            <div class="content_list_hover iconfont">
                                <dd></dd>
                                <dt>&#xe657;</dt>
                                <div class="hr">
                                    <a href="${article.url}" title="${article.title}"  target="_blank">
                                        <img src="${themeUrl}/assets/images/bn7.png">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="content_list_title clear">
                            <div class="list_title_left fl">
                                <dd><a href="${article.url}" target="_blank">${article.title}</a><i>|</i><span>${article.subtitle}</span></dd>
                                <dt>${article.tags == null ? '' : article.tags.replace(/,/g, ' / ')}</dt>
                            </div>
                            <div class="list_title_icon fr iconfont">&#xe614;</div>
                        </div>
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
                <img src="${baseUrl}${article.coverPath}" class="tra" >
            `;
        } else {
            return ''
        }
    }
});