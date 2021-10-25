<!doctype html>

<html>

<head>

    <meta charset="utf-8">

    <meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width">

    <meta http-equiv="Cache-Control" content="no-transform"/>

    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <meta name="applicable-device" content="pc,mobile">

    <meta name="author" content="order by">

    <title>折优优</title>

    <meta name="keywords" content=""/>

    <meta name="description" content="折优优 网站定制，wordpress模板"/>

    <link href="css/swiper.min.css" rel="stylesheet" type="text/css">

    <link href="css/mian.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/iconfont.css">
    <#--    引入vue-->
    <script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>

</head>

<body>

<div class="topmenu" id="tophead">

    <div class="wrap">

        <div id="mobilemenu"></div>

        <div class="mask"></div>

        <div class="logo"><a href='javascript:0'><img src="images/logo.jpg" alt="折优优" width="280" height="70"></a></div>

        <div class="menu">

            <ul id="nav">

                <li class="closex"><i class="iconfont icon-guanbi"></i></li>
                <#list navigationBars as bar>
                    <li class="mainlevel"><a class="${bar.cssClass!}" href="${bar.url}">${bar.title}</a></li>
                </#list>

                <div class="clear"></div>

            </ul>

        </div>

        <div class="search"><i class="iconfont icon-sousuo"></i></div>

    </div>

</div>


<div class="main">

    <div class="wrap">

        <div class="row">

            <div class="banner">

                <div class="swiper-container">

                    <div class="swiper-wrapper">
                        <div class="swiper-slide" style="background-image:url(images/1-2003301I501459.gif)"><a
                                    href='javascript:0' title="将Word2013文档设为最终版本">

                                <div class="title"><span>将Word2013文档设为最终版本</span>

                                    <h3 class="f20">我们做好了一份文档，并不希望别人进行更改，...</h3>

                                </div>

                            </a></div>

                        <div class="swiper-slide" style="background-image:url(images/1-2003301I444191.jpg)"><a
                                    href='javascript:0' title="利用表格法在Word2013中制作联合文件头">

                                <div class="title"><span>利用表格法在Word2013中制作联合文件头</span>

                                    <h3 class="f20">一些机关、政府经常会向下级部门发放一些公文...</h3>

                                </div>

                            </a></div>

                    </div>

                    <div class="swiper-pagination"></div>

                    <div class="swiper-button-prev"></div>

                    <div class="swiper-button-next"></div>

                </div>

            </div>

            <div class="top-news">

                <div class="top-news-box">

                    <h2>头条</h2>

                    <div class="top-img"><a href='javascript:0'><img src="images/15U55RJL560-54193.gif" alt="小说中反派人物的塑造"
                                                                     width="370" height="180"></a></div>


                    <div class="top-box">

                        <ul class="topnews">

                            <li><a href='javascript:0'><i class="iconfont icon-huoyan red"></i>两仪四相阵</a></li>

                            <li><a href='javascript:0'><i class="iconfont icon-huoyan red"></i>将Word2013文档设为最终版本</a>
                            </li>

                            <li><a href='javascript:0'><i class="iconfont icon-huoyan red"></i>Word中如何手动制作目录
                                    手动目录的2种方</a></li>

                            <li><a href='javascript:0'><i class="iconfont icon-huoyan red"></i>如何在Word2010中输入商标、版权符号</a>
                            </li>

                            <li><a href='javascript:0'><i
                                            class="iconfont icon-huoyan red"></i>利用表格法在Word2013中制作联合文件头</a></li>


                        </ul>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

<div class="hotnews">

    <div class="wrap">

        <div class="row">
            <div class="hotnewlist"><a href='javascript:0' target="_blank">

                    <div class="hotdiv" style="background-image:url(images/15U55RJL560-54193.gif)">

                        <div class="overlay"></div>

                        <div class="title"><span>反派人物</span>

                            <h3>小说中反派人物的塑造</h3>

                        </div>

                    </div>

                </a></div>

            <div class="hotnewlist"><a href='javascript:0' target="_blank">

                    <div class="hotdiv" style="background-image:url(images/1-2004231023592G.jpg)">

                        <div class="overlay"></div>

                        <div class="title"><span>Word制作表格</span>

                            <h3>两仪四相阵</h3>

                        </div>

                    </div>

                </a></div>

            <div class="hotnewlist"><a href='javascript:0' target="_blank">

                    <div class="hotdiv" style="background-image:url(images/1-2003301I501459.gif)">

                        <div class="overlay"></div>

                        <div class="title"><span>Word宏案例</span>

                            <h3>将Word2013文档设为最终版本</h3>

                        </div>

                    </div>

                </a></div>

        </div>

    </div>

</div>

<div class="mainbody">

    <div class="wrap">

        <div class="row">

            <div class="left">
<#--                推荐文章列表-->
               <#list articleItems as item>
                    <div class="article_box">
                    <div class="items">

                        <div class="content-box">

                            <div class="posts-gallery-img"><a href='javascript:0'><img class="thumbnail"
                                                                                       src="${item.coverUrl!}"
                                                                                       alt="${item.title!}"></a></div>

                            <div class="posts-gallery-content">

                                <h2><a href='javascript:0' target="_blank">${item.title}</a></h2>

                                <div class="posts-gallery-text">
                                    ${item.sketch}
                                </div>

                                <div class="posts-default-info posts-gallery-info">

                                    <ul>

                                        <li class="ico-cat"><i class="iconfont icon-liebiao"></i> <a href='javascript:0'
                                                                                                     target="_blank">${item.className}</a>
                                        </li>

                                        <li class="ico-time"><i class="iconfont icon-iconfontshijian"></i> 2020-04-24
                                        </li>

                                        <li class="ico-eye"><i class="iconfont icon-yanjing1"></i> 4</li>

                                    </ul>

                                </div>

                            </div>

                        </div>

                    </div>

                </div>
               </#list>

            </div>

            <!-- 右侧 -->

            <div class="right">

                <div class="widget">

                    <h3><span>热门标签</span></h3>

                    <div class="widge_tags">

                        <div class="tag-items"><a href='javascript:0'>画圆</a> <a href='javascript:0'>文稿</a> <a
                                    href='javascript:0'>下载</a> <a href='javascript:0'>官方</a> <a
                                    href='javascript:0'>提取</a> <a href='javascript:0'>底色</a> <a
                                    href='javascript:0'>大小</a> <a href='javascript:0'>图案</a> <a
                                    href='javascript:0'>插件</a> <a href='javascript:0'>校园</a> <a
                                    href='javascript:0'>何在</a> <a href='javascript:0'>切换</a> <a
                                    href='javascript:0'>多种</a> <a href='javascript:0'>链接</a> <a
                                    href='javascript:0'>圆心</a> <a href='javascript:0'>特效</a> <a
                                    href='javascript:0'>中的</a> <a href='javascript:0'>免费</a> <a
                                    href='javascript:0'>国庆</a> <a href='javascript:0'>免费下</a> <a
                                    href='javascript:0'>帮你</a> <a href='javascript:0'>材质</a> <a
                                    href='javascript:0'>单元格</a> <a href='javascript:0'>裁剪</a> <a
                                    href='javascript:0'>声音</a> <a href='javascript:0'>词典</a> <a
                                    href='javascript:0'>插入</a> <a href='javascript:0'>批量</a> <a
                                    href='javascript:0'>2011</a> <a href='javascript:0'>Office</a> <a
                                    href='javascript:0'>其它</a> <a href='javascript:0'>自动播放</a> <a
                                    href='javascript:0'>使用</a> <a href='javascript:0'>次数</a> <a
                                    href='javascript:0'>压缩</a> <a href='javascript:0'>相册</a> <a
                                    href='javascript:0'>主题</a> <a href='javascript:0'>常用</a> <a
                                    href='javascript:0'>移动</a> <a href='javascript:0'>函数</a> <a
                                    href='javascript:0'>某点</a> <a href='javascript:0'>金山</a> <a
                                    href='javascript:0'>安装</a> <a href='javascript:0'>地址</a> <a
                                    href='javascript:0'>更改</a> <a href='javascript:0'>颜色</a> <a
                                    href='javascript:0'>多彩</a> <a href='javascript:0'>第十</a> <a
                                    href='javascript:0'>背景图片</a> <a href='javascript:0'>2012</a> <a href='javascript:0'>实例</a>
                            <a href='javascript:0'>进入</a> <a href='javascript:0'>去除</a> <a href='javascript:0'>布局</a> <a
                                    href='javascript:0'>撤销</a> <a href='javascript:0'>相关</a> <a
                                    href='javascript:0'>修改</a> <a href='javascript:0'>个人版</a> <a
                                    href='javascript:0'>透明度</a> <a href='javascript:0'>动画</a></div>

                    </div>

                </div>

                <div class="widget">

                    <h3><span>随便看看</span></h3>

                    <ul class="recent-posts-widget">

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/15U55TF2c10-193Z9.jpg"
                                                                                      class="thumbnail"
                                                                                      alt="如何在Word2010中输入商标、版权符号"></a>
                            </div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>如何在Word2010中输入商标、版权符号</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 11</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/1-2003301I501459.gif"
                                                                                      class="thumbnail"
                                                                                      alt="将Word2013文档设为最终版本"></a></div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>将Word2013文档设为最终版本</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 10</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img
                                            src="images/15U55TA46210-143O0.gif" class="thumbnail"
                                            alt="Word中如何手动制作目录 手动目录的2种方"></a></div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>Word中如何手动制作目录 手动目录的2种方</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 9</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/1-2004231023592G.jpg"
                                                                                      class="thumbnail" alt="两仪四相阵"></a>
                            </div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>两仪四相阵</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 8</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/1-2003301J031R1.gif"
                                                                                      class="thumbnail"
                                                                                      alt="解决Word2013禁用Web服务器访问的故障"></a>
                            </div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>解决Word2013禁用Web服务器访问的故障</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 6</span></div>

                        </li>


                    </ul>

                </div>

                <div class="widget">

                    <h3><span>热门阅读</span></h3>

                    <ul class="hot-article">


                    </ul>

                </div>

                <div class="widget">

                    <h3><span>阅读排行</span></h3>

                    <ul class="recent-posts-widget">

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/15U55RJL560-54193.gif"
                                                                                      class="thumbnail"
                                                                                      alt="设置幻灯片画笔标记：星辰玩PPT第二十五"></a>
                            </div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>设置幻灯片画笔标记：星辰玩PPT第二十五</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 1</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/15U55RJL560-54193.gif"
                                                                                      class="thumbnail"
                                                                                      alt="圣诞节快乐！教你纯手工打造：圣诞节"></a></div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>圣诞节快乐！教你纯手工打造：圣诞节</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 1</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/15U55RJL560-54193.gif"
                                                                                      class="thumbnail"
                                                                                      alt="Word2013中高级计算功能的应用"></a>
                            </div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>Word2013中高级计算功能的应用</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 1</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/15U55RJL560-54193.gif"
                                                                                      class="thumbnail"
                                                                                      alt="Excel2010名称管理器配合数据有效性一起使"></a>
                            </div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>Excel2010名称管理器配合数据有效性一起使</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 1</span></div>

                        </li>

                        <li>

                            <div class="recent-posts-img"><a href='javascript:0'><img src="images/1-2004231023592G.jpg"
                                                                                      class="thumbnail" alt="两仪四相阵"></a>
                            </div>

                            <div class="recent-posts-title">

                                <h4 class="tit"><a href='javascript:0'>两仪四相阵</a></h4>

                                <span class="info"><i class="iconfont icon-yanjing1"></i> 8</span></div>

                        </li>


                    </ul>

                </div>

                <div class="widget">

                    <h3><span>关注我们</span></h3>

                    <div class="attentionus">

                        <ul class="items clearfix">

                            <span class="social-widget-link social-link-wechat"> <span class="social-widget-link-count"><i
                                            class="iconfont icon-iconfontmoban"></i>微信公众号</span> <span
                                        class="social-widget-link-title">微信公众号</span> <a id="tooltip-s-weixin"
                                                                                         href="javascript:void(0);"></a> </span>
                            <span class="social-widget-link social-link-taobao-wangxiao"> <span
                                        class="social-widget-link-count"><i
                                            class="iconfont icon-taobao1"></i>淘宝网店</span> <span
                                        class="social-widget-link-title">淘宝网店</span> <a href='javascript:0'
                                                                                        target="_blank"
                                                                                        rel="nofollow"></a> </span>
                            <span class="social-widget-link social-link-ketang"> <span class="social-widget-link-count"><i
                                            class="iconfont icon-xuexi"></i>在线课堂</span> <span
                                        class="social-widget-link-title">在线课堂</span> <a href='javascript:0'
                                                                                        target="_blank"
                                                                                        rel="nofollow"></a> </span>

                        </ul>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

<div class="footer">

    <div class="wrap">

        <div class="social-footer"><a id="tooltip-f-weixin" class="wxii" href="javascript:void(0);"><i
                        class="iconfont icon-iconfontmoban"></i></a> <a class="taobaodibu"
                                                                        href="https://www.taobao.com/" target="_blank"
                                                                        rel="nofollow" title="淘宝"><i
                        class="iconfont icon-taobao1"></i></a> <a class="ketangdibu" href="" target="_blank"><i
                        class="iconfont icon-xuexi"></i></a></div>

        <div class="nav-footer">
<#--            <a href='javascript:0'>网站首页</a>-->
<#--            <a href='javascript:0'>阵法</a>-->
<#--            <a href='javascript:0'>人物塑造</a>-->
<#--            <a href='javascript:0'>PPT教程</a>-->
<#--            <a href='javascript:0'>WPS教程</a>-->
<#--            <a href='javascript:0'>办公软件</a>-->
<#--            <a href='javascript:0'>今日特价</a>-->
<#--            <a href='javascript:0'>关于我们</a>-->
            <#list navigationBars as bar>
                <a href='${bar.url}'>${bar.title}</a>
            </#list>
        </div>

        <div class="copyright-footer">

            <p>Copyright &copy; 2002-2020 折优优 版权所有 <a href='javascript:0' target="_blank" rel="nofollow">皖ICP备17011273号-1</a>
                <a href='javascript:0' target="_blank">XML地图</a></p>

        </div>

        <div class="links-footer"><span>友情链接：</span>
            <a href='http://www.tkv5.cn' target='_blank'>网站源码</a>
            <a href='http://www.tkv5.cn' target='_blank'>织梦模板</a>
            <a href='http://www.tkv5.cn' target='_blank'>模版下载</a>
            <a href='http://www.tkv5.cn' target='_blank'>dedecms模板</a>
            <a href='http://www.tkv5.cn' target='_blank'>dede模版</a>
            <a href='http://www.tkv5.cn' target='_blank'>仿站</a>
            <a href='http://www.tkv5.cn' target='_blank'>图标下载</a>
            <a href='http://www.tkv5.cn' target='_blank'>网站模板</a>
            <a href='http://www.tkv5.cn' target='_blank'>源码下载</a>
        </div>

    </div>

</div>

<!-- 返回顶部按钮-->

<div class="backtop" id="backtop"><i class="iconfont icon-xiangshang"></i></div>

<!-- 搜索框-->

<div class="search-box">
    <div class="search-close"><i class="iconfont icon-guanbi"></i></div>
    <div class="search-con">
        <dl class="se">
            <form name="formsearch" action="/plus/search.php">
                <input type="hidden" name="kwtype" value="0"/>
                <dt>
                    <input name="q" type="text" class="search-keyword" id="search-keyword" value="输入搜索关键词"
                           onfocus="if(this.value=='输入搜索关键词'){this.value='';}"
                           onblur="if(this.value==''){this.value='输入搜索关键词';}"/>
                </dt>

                <dd>

                    <button type="submit"><i class="iconfont icon-sousuo"></i></button>

                </dd>

            </form>

        </dl>

        <div class="search-tips">大家都在搜</div>

        <div class="search-as"> 　<a href='javascript:0'>ppt</a> 　<a href='javascript:0'>word</a> 　<a
                    href='javascript:0'>价值</a> 　<a href='javascript:0'>表格</a> 　<a href='javascript:0'>生成</a> 　<a
                    href='javascript:0'>全自动采集</a> 　<a href='javascript:0'>淘宝</a> 　<a href='javascript:0'>淘宝客</a> 　<a
                    href='javascript:0'>www.ymwears.cn</a></div>

    </div>

</div>

<!-- 微信二维码-->

<div class="f-weixin-dropdown">

    <div class="tooltip-weixin-inner">

        <h3>微信公众号</h3>

        <div class="qcode"><img src="images/follow-weixin.png" width="160" height="160"/></div>

    </div>

    <i class="iconfont icon-guanbi close_tip"></i></div>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/swiper.min.js"></script>

<script type="text/javascript" src="js/slide.js"></script>

</body>

</html>