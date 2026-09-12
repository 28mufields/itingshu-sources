package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlWebViewSniffExtractor;
import com.github.eprendre.tingshu.sources.CoverUrlExtraHeaders;
import com.github.eprendre.tingshu.sources.ILogin;
import com.github.eprendre.tingshu.sources.TingShu;
import com.github.eprendre.tingshu.utils.Book;
import com.github.eprendre.tingshu.utils.BookDetail;
import com.github.eprendre.tingshu.utils.Category;
import com.github.eprendre.tingshu.utils.CategoryMenu;
import com.github.eprendre.tingshu.utils.CategoryTab;
import com.github.eprendre.tingshu.utils.Episode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: Tingchina2.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J*\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u0016\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020!H\u0016¨\u0006$"}, d2 = {"Lcom/github/eprendre/sources_by_shun/Tingchina2;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/ILogin;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "coverHeaders", "", "coverUrl", "", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getLoginUrl", "getName", "getSourceId", "getUrl", "isLoginDesktop", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Tingchina2 extends TingShu implements ILogin, CoverUrlExtraHeaders {
    public static final Tingchina2 INSTANCE = new Tingchina2();

    private Tingchina2() {
    }

    public String getSourceId() {
        return "966475a6c66a47408449a6cfa7696fb0";
    }

    public String getUrl() {
        return "https://m.i275.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n资源挺全，但是未必都能播放。注意：有的音频需要登陆才能听。";
    }

    public String getName() {
        return "听中国";
    }

    public String getLoginUrl() {
        return "https://m.i275.com/pc/user/index.html";
    }

    public boolean isLoginDesktop() {
        return false;
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        Object obj;
        int totalPage;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://www.tings8.com/pc/index/search.html?keyword=" + URLEncoder.encode(keywords, "utf8") + "&page=" + page;
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Elements lies = doc.select(".list-works > li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        int $i$f$mapTo = 0;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".list-book-dt > a").text();
            String href = li.selectFirst(".list-book-dt > a").absUrl("href");
            String url2 = url;
            String status = li.selectFirst(".list-book-dt > .ztlz").text();
            Elements lies2 = lies;
            String img = li.selectFirst(".list-imgbox > .thumb > .lazy").absUrl("src");
            Iterable $this$map$iv2 = $this$map$iv;
            int $i$f$map2 = $i$f$map;
            String author = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(0)).text();
            String artist = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(1)).text();
            String intro = li.selectFirst(".list-works-dl > .list-book-des").text();
            Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(img, href, title, author, artist);
            $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$search_u24lambda_u241_u24lambda_u240.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$search_u24lambda_u241_u24lambda_u240.setStatus(status);
            destination$iv$iv.add($this$search_u24lambda_u241_u24lambda_u240);
            url = url2;
            lies = lies2;
            $this$map$iv = $this$map$iv2;
            $i$f$map = $i$f$map2;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
            $i$f$mapTo = $i$f$mapTo;
        }
        List books = (List) destination$iv$iv;
        String text = doc.select(".pagination  >.active > span").text();
        Intrinsics.checkNotNullExpressionValue(text, "doc.select(\".pagination  >.active > span\").text()");
        int currentPage = Integer.parseInt(text);
        Iterable select = doc.select(".pagination > li > a");
        Intrinsics.checkNotNullExpressionValue(select, "pages");
        Iterable $this$firstOrNull$iv = select;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            Element it2 = (Element) element$iv;
            String text2 = it2.text();
            Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
            if (StringsKt.contains$default(text2, "»", false, 2, (Object) null)) {
                obj = element$iv;
                break;
            }
        }
        Element nextPage = (Element) obj;
        if (nextPage == null) {
            totalPage = currentPage;
        } else {
            totalPage = currentPage + 1;
        }
        return new Pair<>(books, Integer.valueOf(totalPage));
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewSniffExtractor.INSTANCE.setUp(false, new Function1<String, Boolean>() { // from class: com.github.eprendre.sources_by_shun.Tingchina2$getAudioUrlExtractor$1
            public final Boolean invoke(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                boolean z = true;
                if (!StringsKt.contains(url, ".m4a", true) && !StringsKt.contains(url, ".mp3", true) && !StringsKt.contains(url, ".m4b", true) && !StringsKt.contains(url, ".flac", true) && !StringsKt.contains(url, ".aa3", true) && !StringsKt.contains(url, ".ogg", true) && !StringsKt.contains(url, ".wma", true) && !StringsKt.contains(url, ".wav", true) && !StringsKt.contains(url, ".aac", true) && !StringsKt.contains(url, ".ac3", true) && !StringsKt.contains(url, ".mp4", true)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        return AudioUrlWebViewSniffExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        CategoryMenu menu1 = new CategoryMenu("有声小说", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("玄幻奇幻", "https://m.i275.com/category/6.html"), new CategoryTab("都市言情", "https://m.i275.com/category/7.html"), new CategoryTab("宫斗女频", "https://m.i275.com/category/8.html"), new CategoryTab("官场商战", "https://m.i275.com/category/9.html"), new CategoryTab("仙侠武侠", "https://m.i275.com/category/10.html"), new CategoryTab("刑侦推理", "https://m.i275.com/category/11.html"), new CategoryTab("探险科幻", "https://m.i275.com/category/12.html"), new CategoryTab("重生穿越", "https://m.i275.com/category/13.html"), new CategoryTab("恐怖惊悚", "https://m.i275.com/category/14.html"), new CategoryTab("文学历史", "https://m.i275.com/category/15.html"), new CategoryTab("两性感情", "https://m.i275.com/category/49.html")}));
        CategoryMenu menu2 = new CategoryMenu("有声综艺", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("戏曲综艺", "https://m.i275.com/category/28.html"), new CategoryTab("小品戏剧", "https://m.i275.com/category/30.html"), new CategoryTab("评书相声", "https://m.i275.com/category/31.html"), new CategoryTab("百家讲坛", "https://m.i275.com/category/32.html"), new CategoryTab("综合娱乐", "https://m.i275.com/category/33.html"), new CategoryTab("文学名著", "https://m.i275.com/category/50.html")}));
        CategoryMenu menu3 = new CategoryMenu("儿童故事", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("益智故事", "https://m.i275.com/category/29.html"), new CategoryTab("儿童文学", "https://m.i275.com/category/51.html"), new CategoryTab("国学启蒙", "https://m.i275.com/category/52.html"), new CategoryTab("家教育儿", "https://m.i275.com/category/53.html"), new CategoryTab("卡通动画", "https://m.i275.com/category/54.html"), new CategoryTab("少儿名著", "https://m.i275.com/category/55.html"), new CategoryTab("儿童综合", "https://m.i275.com/category/56.html")}));
        return CollectionsKt.listOf(new CategoryMenu[]{menu1, menu2, menu3});
    }

    public Category getCategoryList(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, false).get();
        Element page = doc.selectFirst(".home-wrapper page-width > .scroll-wrapper2 page-width > .home-content > .all-list > .pagination page-width > span");
        String ownText = page.ownText();
        Intrinsics.checkNotNullExpressionValue(ownText, "page.ownText()");
        List it = StringsKt.split$default(ownText, new String[]{"/"}, false, 0, 6, (Object) null);
        int currentPage = Integer.parseInt((String) it.get(0));
        int totalPage = Integer.parseInt((String) it.get(1));
        String str = "src";
        String nextUrl = doc.selectFirst(".home-wrapper page-width > .scroll-wrapper2 page-width > .home-content > .all-list > .pagination page-width > .page next").absUrl("src");
        ArrayList list = new ArrayList();
        Elements lies = doc.select(".home-wrapper page-width > .scroll-wrapper2 page-width > .home-content > .all-list > .home-list > .list-wrapper > ul");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        Iterator it2 = $this$forEach$iv.iterator();
        while (it2.hasNext()) {
            Object element$iv = it2.next();
            Element ul = (Element) element$iv;
            Document doc2 = doc;
            String title = ul.selectFirst("a").attr("title");
            String href = ul.selectFirst("a").absUrl("href");
            Iterator it3 = it2;
            String status = ul.selectFirst("a > .item > .text > .name > .status").text();
            String img = ul.selectFirst("a > .item > .icon > img").absUrl(str);
            String str2 = str;
            String author = ul.select("a > .item > .text > .broadcaster > .icon-broad").text();
            String artist = ul.select("a > .item > .text > .broadcaster > .icon-broad").text();
            Element page2 = page;
            String intro = ul.selectFirst("a > .item > .text > .desc").text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u245_u24lambda_u244 = new Book(img, href, title, author, artist);
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setStatus(status);
            list.add($this$getCategoryList_u24lambda_u245_u24lambda_u244);
            doc = doc2;
            $this$forEach$iv = $this$forEach$iv;
            $i$f$forEach = $i$f$forEach;
            it2 = it3;
            str = str2;
            page = page2;
            lies = lies;
        }
        Intrinsics.checkNotNullExpressionValue(nextUrl, "nextUrl");
        return new Category(list, currentPage, totalPage, url, nextUrl);
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        Connection connect = Jsoup.connect(bookUrl);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable elementsByTag = doc.getElementById("playlist").getElementsByTag("a");
        Intrinsics.checkNotNullExpressionValue(elementsByTag, "doc.getElementById(\"play…   .getElementsByTag(\"a\")");
        Iterable $this$map$iv = elementsByTag;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            String text = it.text();
            Intrinsics.checkNotNullExpressionValue(text, "it.text()");
            String absUrl = it.absUrl("href");
            Intrinsics.checkNotNullExpressionValue(absUrl, "it.absUrl(\"href\")");
            destination$iv$iv.add(new Episode(text, absUrl));
        }
        List episodes = (List) destination$iv$iv;
        String intro = doc.selectFirst(".book-des > .div-b").ownText();
        return new BookDetail(episodes, intro, (String) null, (String) null, 0, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.contains$default(coverUrl, "http://m.i275.com/", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://m.i275.com/");
        return true;
    }
}
