package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlWebViewSniffExtractor;
import com.github.eprendre.tingshu.sources.CoverUrlExtraHeaders;
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
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: YuetingBa.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J*\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u0018\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020!H\u0016R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006$"}, d2 = {"Lcom/github/eprendre/sources_by_shun/YuetingBa;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "coverHeaders", "", "coverUrl", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class YuetingBa extends TingShu implements CoverUrlExtraHeaders {
    public static final YuetingBa INSTANCE = new YuetingBa();
    private static final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("Cookie", MyExtKt.getCookie("http://www.yuetingba.cn/")));

    private YuetingBa() {
    }

    public String getSourceId() {
        return "cc17e42c42fc434aa13f783567a947db";
    }

    public String getUrl() {
        return "http://www.yuetingba.cn/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n 不是所有都能听，有的可能要会员。";
    }

    public String getName() {
        return "悦听吧";
    }

    public final Map<String, String> getHeaders() {
        return headers;
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        Object obj;
        int totalPage;
        String text;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "http://www.yuetingba.cn/search?type=1&name=" + URLEncoder.encode(keywords, "utf8") + "&pageIndex=" + page;
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Elements lies = doc.selectFirst(".section-box").select(".section-box-list-item");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".box-list-item-text > .box-list-item-text-title > a").text();
            String href = li.selectFirst(".box-list-item-text > .box-list-item-text-title > a").absUrl("href");
            String url2 = url;
            String img = li.selectFirst(".box-list-item-img > a > img").absUrl("src");
            Elements lies2 = lies;
            Iterable $this$map$iv2 = $this$map$iv;
            Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
            String author = ((Element) li.selectFirst(".box-list-item-text > .box-list-item-text-autspeaker").select("span").get(0)).selectFirst("a").text();
            String artist = ((Element) li.selectFirst(".box-list-item-text > .box-list-item-text-autspeaker").select("span").get(1)).select("a").text();
            String intro = li.selectFirst(".box-list-item-text > .box-list-item-text-intro.text-desc-content").text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(img, href, title, author, artist);
            $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$search_u24lambda_u241_u24lambda_u240.setIntro(intro);
            $this$search_u24lambda_u241_u24lambda_u240.setStatus("");
            destination$iv$iv.add($this$search_u24lambda_u241_u24lambda_u240);
            url = url2;
            lies = lies2;
            $this$map$iv = $this$map$iv2;
            $i$f$map = $i$f$map;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
        }
        List books = (List) destination$iv$iv;
        Element selectFirst = doc.getElementById("PageContent").selectFirst(".current");
        int currentPage = (selectFirst == null || (text = selectFirst.text()) == null) ? 1 : Integer.parseInt(text);
        Iterable select = doc.getElementById("PageContent").select("a");
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
            if (StringsKt.contains$default(text2, "下一页", false, 2, (Object) null)) {
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
        AudioUrlWebViewSniffExtractor.INSTANCE.setUp(true, new Function1<String, Boolean>() { // from class: com.github.eprendre.sources_by_shun.YuetingBa$getAudioUrlExtractor$1
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
        Connection connect = Jsoup.connect("http://www.yuetingba.cn/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Element navs = doc.selectFirst(".nav.navbar-nav");
        Iterable select = navs.select("li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "lis");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.selectFirst("a").text();
            String href = li.selectFirst("a").absUrl("href");
            if (!Intrinsics.areEqual(title, "首页")) {
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new CategoryTab(title, href));
            }
        }
        return CollectionsKt.listOf(new CategoryMenu("标题", list));
    }

    public Category getCategoryList(String url) {
        Object element$iv;
        int totalPage;
        Object element$iv2;
        String text;
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Element selectFirst = doc.getElementById("PageContent").selectFirst(".current");
        int currentPage = (selectFirst == null || (text = selectFirst.text()) == null) ? 1 : Integer.parseInt(text);
        String str = "a";
        Elements pages = doc.getElementById("PageContent").select("a");
        Intrinsics.checkNotNullExpressionValue(pages, "pages");
        Iterable $this$firstOrNull$iv = (Iterable) pages;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            Element it2 = (Element) element$iv;
            String text2 = it2.text();
            Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
            Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
            if (StringsKt.contains$default(text2, "下一页", false, 2, (Object) null)) {
                break;
            }
            $this$firstOrNull$iv = $this$firstOrNull$iv2;
        }
        Element nextPage = (Element) element$iv;
        if (nextPage == null) {
            totalPage = currentPage;
        } else {
            totalPage = currentPage + 1;
        }
        Iterable select = doc.getElementById("PageContent").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.getElementById(\"PageContent\").select(\"a\")");
        Iterable $this$firstOrNull$iv3 = select;
        int $i$f$firstOrNull = 0;
        Iterator it3 = $this$firstOrNull$iv3.iterator();
        while (true) {
            if (!it3.hasNext()) {
                element$iv2 = null;
                break;
            }
            element$iv2 = it3.next();
            Element it4 = (Element) element$iv2;
            String text3 = it4.text();
            Intrinsics.checkNotNullExpressionValue(text3, "it.text()");
            Iterable $this$firstOrNull$iv4 = $this$firstOrNull$iv3;
            int $i$f$firstOrNull2 = $i$f$firstOrNull;
            if (StringsKt.contains$default(text3, "下一页", false, 2, (Object) null)) {
                break;
            }
            $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
            $i$f$firstOrNull = $i$f$firstOrNull2;
        }
        Element element = (Element) element$iv2;
        String absUrl = element != null ? element.absUrl("href") : null;
        String nextUrl = absUrl == null ? "" : absUrl;
        ArrayList list = new ArrayList();
        Elements lies = doc.selectFirst(".section-box").select(".section-box-list-item");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        Iterator it5 = $this$forEach$iv.iterator();
        while (it5.hasNext()) {
            Object element$iv3 = it5.next();
            Element li = (Element) element$iv3;
            Document doc2 = doc;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String title = li.selectFirst(".box-list-item-text > .box-list-item-text-title > a").text();
            String href = li.selectFirst(".box-list-item-text > .box-list-item-text-title > a").absUrl("href");
            int $i$f$forEach2 = $i$f$forEach;
            String img = li.selectFirst(".box-list-item-img > a > img").absUrl("src");
            Elements pages2 = pages;
            Element nextPage2 = nextPage;
            Elements lies2 = lies;
            Iterator it6 = it5;
            String author = ((Element) li.selectFirst(".box-list-item-text > .box-list-item-text-autspeaker").select("span").get(0)).selectFirst(str).text();
            String artist = ((Element) li.selectFirst(".box-list-item-text > .box-list-item-text-autspeaker").select("span").get(1)).select(str).text();
            String intro = li.selectFirst(".box-list-item-text > .box-list-item-text-intro.text-desc-content").text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u247_u24lambda_u246 = new Book(img, href, title, author, artist);
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setIntro(intro);
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setStatus("");
            list.add($this$getCategoryList_u24lambda_u247_u24lambda_u246);
            doc = doc2;
            $i$f$forEach = $i$f$forEach2;
            $this$forEach$iv = $this$forEach$iv2;
            pages = pages2;
            nextPage = nextPage2;
            lies = lies2;
            it5 = it6;
            str = str;
        }
        return new Category(list, currentPage, totalPage, url, nextUrl);
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        Connection connect = Jsoup.connect(bookUrl);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
        Document doc = MyExtKt.config(connect, true).get();
        if (loadEpisodes) {
            Element ul = doc.selectFirst(".ting-list-content.row");
            Iterable select = ul.select(".col-md-3.col-xs-12");
            Intrinsics.checkNotNullExpressionValue(select, "lis");
            Iterable $this$forEach$iv = select;
            for (Object element$iv : $this$forEach$iv) {
                Element li = (Element) element$iv;
                String title = li.selectFirst(".col-md-10.col-xs-10 > a").text();
                String attr = li.selectFirst(".col-md-10.col-xs-10 > a").attr("onclick");
                Intrinsics.checkNotNullExpressionValue(attr, "li.selectFirst(\".col-md-…-10 > a\").attr(\"onclick\")");
                String id = StringsKt.replace$default(StringsKt.replace$default(attr, "testFn('", "", false, 4, (Object) null), "')", "", false, 4, (Object) null);
                String href = "http://36.5.86.202:35661," + id;
                Intrinsics.checkNotNullExpressionValue(title, "title");
                list.add(new Episode(title, href));
            }
        }
        return new BookDetail(list, (String) null, (String) null, (String) null, 0, (String) null, 62, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers2) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        if (!StringsKt.contains$default(coverUrl, "www.yuetingba.cn/", false, 2, (Object) null)) {
            return false;
        }
        headers2.put("referer", "http://www.yuetingba.cn/");
        return true;
    }
}
