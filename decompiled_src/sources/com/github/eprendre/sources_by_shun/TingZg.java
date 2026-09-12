package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlWebViewSniffExtractor;
import com.github.eprendre.tingshu.sources.CoverUrlExtraHeaders;
import com.github.eprendre.tingshu.sources.ISearchVerification;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: TingZg.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J*\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0004\u0012\u00020$0\"2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016¨\u0006&"}, d2 = {"Lcom/github/eprendre/sources_by_shun/TingZg;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/ISearchVerification;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "coverHeaders", "", "coverUrl", "", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSearchDelayMs", "", "getSearchVerificationUA", "getSearchVerificationUrl", "keywords", "getSourceId", "getUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TingZg extends TingShu implements ISearchVerification, CoverUrlExtraHeaders {
    public static final TingZg INSTANCE = new TingZg();

    private TingZg() {
    }

    public boolean isSearchValidated() {
        return ISearchVerification.DefaultImpls.isSearchValidated(this);
    }

    public String getSourceId() {
        return "17251780a2804f2fae21f93d3efd2a66";
    }

    public String getUrl() {
        return "https://www.tingzh.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n注意：搜索会跳出验证页面，输入验证码然后退出即可。";
    }

    public String getName() {
        return "中文听书网";
    }

    public String getSearchVerificationUrl(String keywords) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String encodedKeywords = URLEncoder.encode(keywords, "utf-8");
        return "https://www.tingzh.com/search.php?searchword=" + encodedKeywords;
    }

    public String getSearchVerificationUA() {
        return MyExtKt.getDesktopUA();
    }

    public long getSearchDelayMs() {
        return 6000L;
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        List groupValues;
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://www.tingzh.com/search.php?page=" + page + "&searchword=" + URLEncoder.encode(keywords, "utf8") + "&searchtype=";
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        int i = 0;
        Document doc = MyExtKt.config(connect, true).headers(MapsKt.mapOf(new Pair[]{TuplesKt.to("Cookie", MyExtKt.getCookie("https://www.tingzh.com")), TuplesKt.to("Referer", "https://www.tingzh.com/")})).get();
        Elements lies = doc.selectFirst(".clist.sear_height > ul").select("li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = ((Element) li.select("p").get(i)).select("b > a").text();
            String href = li.selectFirst("a").absUrl("href");
            Elements lies2 = lies;
            String status = ((Element) li.select("p").get(4)).text();
            Iterable $this$map$iv2 = $this$map$iv;
            String img = li.selectFirst("a > img").absUrl("src");
            int $i$f$map2 = $i$f$map;
            String author = ((Element) li.select("p").get(1)).text();
            String artist = ((Element) li.select("p").get(3)).selectFirst("a").text();
            String intro = ((Element) li.select("p").get(2)).text();
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
            url = url;
            lies = lies2;
            $this$map$iv = $this$map$iv2;
            $i$f$map = $i$f$map2;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
            i = 0;
        }
        List books = (List) destination$iv$iv;
        String pages = doc.select(".clist.sear_height > .page > span").text();
        Regex regex = new Regex("页次:\\d+/(\\d+)页");
        Intrinsics.checkNotNullExpressionValue(pages, "pages");
        MatchResult matchResult = Regex.find$default(regex, pages, 0, 2, (Object) null);
        int totalPage = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 0 : intOrNull.intValue();
        return new Pair<>(books, Integer.valueOf(totalPage));
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewSniffExtractor.setUp$default(AudioUrlWebViewSniffExtractor.INSTANCE, true, (Function1) null, 2, (Object) null);
        return AudioUrlWebViewSniffExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        Connection connect = Jsoup.connect("https://www.tingzh.com/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Element navs = doc.getElementById("nav");
        Iterable select = navs.select("ul > li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "lists");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.selectFirst("a").text();
            String href = li.selectFirst("a").absUrl("href");
            if (!Intrinsics.areEqual(title, "首 页")) {
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new CategoryTab(title, href));
            }
        }
        return CollectionsKt.listOf(new CategoryMenu("标题", list));
    }

    public Category getCategoryList(String url) {
        Object element$iv;
        List groupValues;
        String str;
        Integer intOrNull;
        List groupValues2;
        String str2;
        Integer intOrNull2;
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).headers(MapsKt.mapOf(new Pair[]{TuplesKt.to("Cookie", MyExtKt.getCookie("https://www.tingzh.com")), TuplesKt.to("Referer", "https://www.tingzh.com/")})).get();
        String pages1 = doc.select(".clist > .page > span > span").text();
        Regex regex = new Regex("页次:(\\d+)/");
        Intrinsics.checkNotNullExpressionValue(pages1, "pages1");
        MatchResult matchResult = Regex.find$default(regex, pages1, 0, 2, (Object) null);
        int currentPage = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = (String) groupValues2.get(1)) == null || (intOrNull2 = StringsKt.toIntOrNull(str2)) == null) ? 0 : intOrNull2.intValue();
        Regex regex2 = new Regex("页次:\\d+/(\\d+)页");
        MatchResult matchResult2 = Regex.find$default(regex2, pages1, 0, 2, (Object) null);
        int totalPage = (matchResult2 == null || (groupValues = matchResult2.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 0 : intOrNull.intValue();
        Iterable select = doc.selectFirst(".clist > .page ").selectFirst("span").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".clist …First(\"span\").select(\"a\")");
        Iterable $this$firstOrNull$iv = select;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Element it2 = (Element) element$iv;
                String text = it2.text();
                Intrinsics.checkNotNullExpressionValue(text, "it.text()");
                if (StringsKt.contains$default(text, "下一页", false, 2, (Object) null)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Element element = (Element) element$iv;
        String nextUrl = element != null ? element.absUrl("href") : null;
        if (nextUrl == null) {
            nextUrl = "";
        }
        ArrayList list = new ArrayList();
        Elements lies = doc.selectFirst(".clist > ul").select("li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        Iterator it3 = $this$forEach$iv.iterator();
        while (it3.hasNext()) {
            Object element$iv2 = it3.next();
            Document doc2 = doc;
            Element li = (Element) element$iv2;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String title = li.selectFirst("a").attr("title");
            String pages12 = pages1;
            String href = li.selectFirst("a").absUrl("href");
            Regex regex3 = regex;
            MatchResult matchResult3 = matchResult;
            Regex regex22 = regex2;
            String status = ((Element) li.select("p").get(4)).text();
            MatchResult matchResult22 = matchResult2;
            String img = li.selectFirst("a > img").absUrl("src");
            Elements lies2 = lies;
            String author = ((Element) li.select("p").get(1)).text();
            Iterator it4 = it3;
            String artist = ((Element) li.select("p").get(3)).selectFirst("a").text();
            String intro = ((Element) li.select("p").get(2)).text();
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
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach;
            pages1 = pages12;
            regex = regex3;
            matchResult = matchResult3;
            regex2 = regex22;
            matchResult2 = matchResult22;
            lies = lies2;
            it3 = it4;
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
            Element ul = doc.selectFirst(".compress");
            Iterable select = ul.select("li");
            Intrinsics.checkNotNullExpressionValue(select, "lis");
            Iterable $this$forEach$iv = select;
            for (Object element$iv : $this$forEach$iv) {
                Element li = (Element) element$iv;
                String title = li.selectFirst("a").attr("title");
                String href = li.selectFirst("a").absUrl("href");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new Episode(title, href));
            }
        }
        String intro = doc.selectFirst(".introBox").text();
        return new BookDetail(list, intro, (String) null, (String) null, 0, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.contains$default(coverUrl, "tingzh.com", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://www.tingzh.com/");
        return true;
    }
}
