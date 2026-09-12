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

/* compiled from: Tingchina.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J*\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u0016\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020!H\u0016¨\u0006$"}, d2 = {"Lcom/github/eprendre/sources_by_shun/Tingchina;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/ILogin;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "coverHeaders", "", "coverUrl", "", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getLoginUrl", "getName", "getSourceId", "getUrl", "isLoginDesktop", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Tingchina extends TingShu implements ILogin, CoverUrlExtraHeaders {
    public static final Tingchina INSTANCE = new Tingchina();

    private Tingchina() {
    }

    public String getSourceId() {
        return "966475a6c66a47408449a6cfa7696fb0";
    }

    public String getUrl() {
        return "https://www.tings8.com/";
    }

    public String getDesc() {
        return "推荐指数:2星 ⭐⭐\n此网站好像已关闭了，等开吧。";
    }

    public String getName() {
        return "听中国";
    }

    public String getLoginUrl() {
        return "https://www.tings8.com/pc/login/index.html";
    }

    public boolean isLoginDesktop() {
        return true;
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
        AudioUrlWebViewSniffExtractor.INSTANCE.setUp(true, new Function1<String, Boolean>() { // from class: com.github.eprendre.sources_by_shun.Tingchina$getAudioUrlExtractor$1
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
        Connection connect = Jsoup.connect("https://www.tings8.com/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = doc.select(".nav-ol > li, .quanben > li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "navs");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.selectFirst("a").text();
            String href = li.selectFirst("a").absUrl("href");
            if (!Intrinsics.areEqual(title, "首页") && !Intrinsics.areEqual(title, "留言求书")) {
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new CategoryTab(title, href));
            }
        }
        return CollectionsKt.listOf(new CategoryMenu("标题", list));
    }

    public Category getCategoryList(String url) {
        String str;
        Object element$iv;
        int totalPage;
        String str2;
        Object element$iv2;
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        ArrayList list = new ArrayList();
        Iterable select = doc.select(".list-works > li");
        Intrinsics.checkNotNullExpressionValue(select, "lies");
        Iterable $this$forEach$iv = select;
        int $i$f$forEach = 0;
        Iterator it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            Object element$iv3 = it.next();
            Element li = (Element) element$iv3;
            String title = li.selectFirst(".list-book-dt > a").text();
            String href = li.selectFirst(".list-book-dt > a").absUrl("href");
            String status = li.selectFirst(".list-book-dt > .ztlz").text();
            String img = li.selectFirst(".list-imgbox > .thumb > .lazy").absUrl("src");
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            int $i$f$forEach2 = $i$f$forEach;
            String author = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(0)).text();
            String artist = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(1)).text();
            String intro = li.selectFirst(".list-works-dl > .list-book-des").text();
            Iterator it2 = it;
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
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach2;
            it = it2;
        }
        String text = doc.select(".pagination  >.active > span").text();
        Intrinsics.checkNotNullExpressionValue(text, "doc.select(\".pagination  >.active > span\").text()");
        int currentPage = Integer.parseInt(text);
        Iterable select2 = doc.select(".pagination > li > a");
        Intrinsics.checkNotNullExpressionValue(select2, "pages");
        Iterable $this$firstOrNull$iv = select2;
        int $i$f$firstOrNull = 0;
        Iterator it3 = $this$firstOrNull$iv.iterator();
        while (true) {
            str = null;
            if (!it3.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it3.next();
            Element it4 = (Element) element$iv;
            String text2 = it4.text();
            Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
            Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
            int $i$f$firstOrNull2 = $i$f$firstOrNull;
            Iterator it5 = it3;
            if (StringsKt.contains$default(text2, "»", false, 2, (Object) null)) {
                break;
            }
            $this$firstOrNull$iv = $this$firstOrNull$iv2;
            $i$f$firstOrNull = $i$f$firstOrNull2;
            it3 = it5;
        }
        Element nextPage = (Element) element$iv;
        if (nextPage == null) {
            totalPage = currentPage;
        } else {
            totalPage = currentPage + 1;
        }
        Iterable select3 = doc.selectFirst(".pagination").select("li > a");
        Intrinsics.checkNotNullExpressionValue(select3, "doc.selectFirst(\".pagination\").select(\"li > a\")");
        Iterable $this$firstOrNull$iv3 = select3;
        int $i$f$firstOrNull3 = 0;
        Iterator it6 = $this$firstOrNull$iv3.iterator();
        while (true) {
            if (!it6.hasNext()) {
                str2 = str;
                element$iv2 = str2;
                break;
            }
            element$iv2 = it6.next();
            Element it7 = (Element) element$iv2;
            String text3 = it7.text();
            Intrinsics.checkNotNullExpressionValue(text3, "it.text()");
            Document doc2 = doc;
            Iterable $this$firstOrNull$iv4 = $this$firstOrNull$iv3;
            int $i$f$firstOrNull4 = $i$f$firstOrNull3;
            Iterator it8 = it6;
            str2 = null;
            if (StringsKt.contains$default(text3, "»", false, 2, (Object) null)) {
                break;
            }
            str = null;
            $i$f$firstOrNull3 = $i$f$firstOrNull4;
            it6 = it8;
            doc = doc2;
            $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
        }
        Element element = (Element) element$iv2;
        String absUrl = element != null ? element.absUrl("href") : str2;
        String nextUrl = absUrl == null ? "" : absUrl;
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
        if (!StringsKt.contains$default(coverUrl, "www.tings8.com", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://www.tings8.com/");
        return true;
    }
}
