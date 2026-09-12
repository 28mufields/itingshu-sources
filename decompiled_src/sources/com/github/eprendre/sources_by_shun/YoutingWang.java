package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtraHeaders;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlWebViewExtractor;
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
import java.util.HashMap;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: YoutingWang.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016J*\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u0016\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020!H\u0016¨\u0006$"}, d2 = {"Lcom/github/eprendre/sources_by_shun/YoutingWang;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtraHeaders;", "()V", "coverHeaders", "", "coverUrl", "", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "", "audioUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class YoutingWang extends TingShu implements CoverUrlExtraHeaders, AudioUrlExtraHeaders {
    public static final YoutingWang INSTANCE = new YoutingWang();

    private YoutingWang() {
    }

    public String getSourceId() {
        return "c3c5bdc9145c4200a38e9a3558861e98";
    }

    public String getUrl() {
        return "https://www.ting15.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n注意：不是所有都能听，有的可能要会员。";
    }

    public String getName() {
        return "有听网";
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        Object element$iv;
        List groupValues;
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://www.ting15.com/?s=ting-search-wd-" + URLEncoder.encode(keywords, "utf8") + "-p-" + page + ".html";
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).headers(MapsKt.mapOf(TuplesKt.to("referer", "https://www.ting15.com/"))).get();
        Element page1 = doc.selectFirst(".category-list > ul");
        Elements lies = page1.select("li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".info > h4 > a").text();
            String href = li.selectFirst(".info > h4 > a").absUrl("href");
            Element page12 = page1;
            String img = li.selectFirst(".img > a > img").absUrl("src");
            Elements lies2 = lies;
            int $i$f$map2 = $i$f$map;
            String author = ((Element) li.selectFirst(".info").select("p").get(1)).text();
            String artist = ((Element) li.selectFirst(".info").select("p").get(2)).text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(img, href, title, author, artist);
            $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
            $this$search_u24lambda_u241_u24lambda_u240.setIntro("");
            $this$search_u24lambda_u241_u24lambda_u240.setStatus("");
            destination$iv$iv.add($this$search_u24lambda_u241_u24lambda_u240);
            url = url;
            page1 = page12;
            lies = lies2;
            $this$map$iv = $this$map$iv;
            $i$f$map = $i$f$map2;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
        }
        List books = (List) destination$iv$iv;
        String text = doc.selectFirst(".category-list > .c-page > .current").text();
        int currentPage = text != null ? Integer.parseInt(text) : 1;
        Iterable select = doc.selectFirst(".category-list > .c-page").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "pages");
        Iterable $this$firstOrNull$iv = select;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Element it2 = (Element) element$iv;
                String text2 = it2.text();
                Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
                if (StringsKt.contains$default(text2, "尾页", false, 2, (Object) null)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Element element = (Element) element$iv;
        String lastpage = element != null ? element.absUrl("href") : null;
        if (lastpage == null) {
            lastpage = "";
        }
        Regex regex = new Regex("p-(\\d+)\\.html");
        MatchResult matchResult = Regex.find$default(regex, lastpage, 0, 2, (Object) null);
        int totalPage = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? currentPage : intOrNull.intValue();
        return new Pair<>(books, Integer.valueOf(totalPage));
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewExtractor.setUp$default(AudioUrlWebViewExtractor.INSTANCE, true, (String) null, new Function1<String, String>() { // from class: com.github.eprendre.sources_by_shun.YoutingWang$getAudioUrlExtractor$1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "str");
                Document doc = Jsoup.parse(str);
                Element audioElement = doc.selectFirst("#jp_audio_0");
                String absUrl = audioElement.absUrl("src");
                Intrinsics.checkNotNullExpressionValue(absUrl, "audioElement.absUrl(\"src\")");
                return StringsKt.replace$default(absUrl, "https://cloud.guoguo.org.cn/nyts.php?uid=", "https://oss-links.guoguo.org.cn/uploads/", false, 4, (Object) null);
            }
        }, 2, (Object) null);
        return AudioUrlWebViewExtractor.INSTANCE;
    }

    public Map<String, String> headers(String audioUrl) {
        Intrinsics.checkNotNullParameter(audioUrl, "audioUrl");
        HashMap hashMap = new HashMap();
        if (StringsKt.contains$default(audioUrl, "guoguo", false, 2, (Object) null)) {
            hashMap.put("referer", "https://www.ting15.com/");
        }
        return hashMap;
    }

    public List<CategoryMenu> getCategoryMenus() {
        Connection connect = Jsoup.connect("https://www.ting15.com/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = doc.selectFirst(".nav").select("a");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "navs");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.text();
            String href = li.absUrl("href");
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
        Object element$iv2;
        List groupValues;
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).headers(MapsKt.mapOf(TuplesKt.to("referer", "https://www.ting15.com/"))).get();
        String text = doc.selectFirst(".category-list > .c-page > .current").text();
        Intrinsics.checkNotNullExpressionValue(text, "doc.selectFirst(\".catego…-page > .current\").text()");
        int currentPage = Integer.parseInt(text);
        Elements pages = doc.selectFirst(".category-list > .c-page").select("a");
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
            if (StringsKt.contains$default(text2, "尾页", false, 2, (Object) null)) {
                break;
            }
            $this$firstOrNull$iv = $this$firstOrNull$iv2;
        }
        Element element = (Element) element$iv;
        String absUrl = element != null ? element.absUrl("href") : null;
        if (absUrl == null) {
            absUrl = "";
        }
        String lastpage = absUrl;
        Regex regex = new Regex("index(\\d+)\\.html");
        MatchResult matchResult = Regex.find$default(regex, lastpage, 0, 2, (Object) null);
        int totalPage = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? currentPage : intOrNull.intValue();
        Iterable select = doc.selectFirst(".category-list > .c-page").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".catego…t > .c-page\").select(\"a\")");
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
            $i$f$firstOrNull = $i$f$firstOrNull2;
            $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
        }
        Element element2 = (Element) element$iv2;
        String absUrl2 = element2 != null ? element2.absUrl("href") : null;
        String nextUrl = absUrl2 != null ? absUrl2 : "";
        ArrayList list = new ArrayList();
        Elements lies = doc.selectFirst(".category-list > ul").select("li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        Iterator it5 = $this$forEach$iv.iterator();
        while (it5.hasNext()) {
            Object element$iv3 = it5.next();
            Element li = (Element) element$iv3;
            Document doc2 = doc;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String title = li.selectFirst(".info > h4 > a").text();
            String href = li.selectFirst(".info > h4 > a").absUrl("href");
            int $i$f$forEach2 = $i$f$forEach;
            Iterator it6 = it5;
            Elements pages2 = pages;
            String status = ((Element) li.selectFirst(".info").select("p").get(3)).text();
            String lastpage2 = lastpage;
            String img = li.selectFirst(".img > a > img").absUrl("src");
            Elements lies2 = lies;
            String author = ((Element) li.selectFirst(".info").select("p").get(1)).text();
            String artist = ((Element) li.selectFirst(".info").select("p").get(2)).text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u247_u24lambda_u246 = new Book(img, href, title, author, artist);
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setSourceId(INSTANCE.getSourceId());
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setIntro("");
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setStatus(status);
            list.add($this$getCategoryList_u24lambda_u247_u24lambda_u246);
            doc = doc2;
            $i$f$forEach = $i$f$forEach2;
            $this$forEach$iv = $this$forEach$iv2;
            it5 = it6;
            pages = pages2;
            lastpage = lastpage2;
            lies = lies2;
        }
        return new Category(list, currentPage, totalPage, url, nextUrl);
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        Connection connect = Jsoup.connect(bookUrl);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
        Document doc = MyExtKt.config(connect, true).headers(MapsKt.mapOf(TuplesKt.to("Referer", "https://www.ting15.com/"))).get();
        if (loadEpisodes) {
            Element ul = doc.selectFirst(".plist > ul");
            Iterable select = ul.select("li");
            Intrinsics.checkNotNullExpressionValue(select, "lis");
            Iterable $this$forEach$iv = select;
            for (Object element$iv : $this$forEach$iv) {
                Element li = (Element) element$iv;
                String title = li.selectFirst("a").text();
                String href = li.selectFirst("a").absUrl("href");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new Episode(title, href));
            }
        }
        String intro = doc.selectFirst(".intro > p").text();
        return new BookDetail(list, intro, (String) null, (String) null, 0, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.contains$default(coverUrl, "guoguo.org", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://www.ting15.com/");
        return true;
    }
}
