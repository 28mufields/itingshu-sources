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

/* compiled from: YiyeHuanting.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J*\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0004\u0012\u00020$0\"2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016¨\u0006&"}, d2 = {"Lcom/github/eprendre/sources_by_shun/YiyeHuanting;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/ISearchVerification;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "coverHeaders", "", "coverUrl", "", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSearchDelayMs", "", "getSearchVerificationUA", "getSearchVerificationUrl", "keywords", "getSourceId", "getUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class YiyeHuanting extends TingShu implements ISearchVerification, CoverUrlExtraHeaders {
    public static final YiyeHuanting INSTANCE = new YiyeHuanting();

    private YiyeHuanting() {
    }

    public boolean isSearchValidated() {
        return ISearchVerification.DefaultImpls.isSearchValidated(this);
    }

    public String getSourceId() {
        return "488676f5ccf8455aa7770cbd197fd500";
    }

    public String getUrl() {
        return "https://22ting.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n注意：搜索会跳出验证页面，输入验证码然后退出即可。";
    }

    public String getName() {
        return "一夜幻听";
    }

    public String getSearchVerificationUrl(String keywords) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String encodedKeywords = URLEncoder.encode(keywords, "utf-8");
        return "https://22ting.com/search.php?searchword=" + encodedKeywords;
    }

    public String getSearchVerificationUA() {
        return MyExtKt.getDesktopUA();
    }

    public long getSearchDelayMs() {
        return 6000L;
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        Object element$iv;
        int totalPage;
        List groupValues;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://22ting.com/search.php?page=" + page + "&searchword=" + URLEncoder.encode(keywords, "utf8") + "&searchtype=";
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).headers(MapsKt.mapOf(TuplesKt.to("Cookie", MyExtKt.getCookie("https://22ting.com/")))).get();
        Elements lies = doc.select(".row-b > li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".clearfix > section >.mb5 > a").text();
            String href = li.selectFirst(".clearfix > section >.mb5 > a").absUrl("href");
            String url2 = url;
            String status = ((Element) li.selectFirst(".clearfix > section").select("p").get(1)).text();
            Elements lies2 = lies;
            String img = li.selectFirst(".clearfix > a  > span > img").absUrl("src");
            String author = li.selectFirst(".clearfix > section > .mb5 > .f-gray").text();
            Iterable $this$map$iv2 = $this$map$iv;
            String intro = li.selectFirst(".clearfix > section > .mb5 > .f-12").text();
            int $i$f$map2 = $i$f$map;
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(img, href, title, author, "");
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
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
        }
        List books = (List) destination$iv$iv;
        Iterable select = doc.selectFirst(".mb15 > span").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".mb15 > span\").select(\"a\")");
        Iterable $this$firstOrNull$iv = select;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Element it2 = (Element) element$iv;
                String text = it2.text();
                Intrinsics.checkNotNullExpressionValue(text, "it.text()");
                if (StringsKt.contains$default(text, "尾页", false, 2, (Object) null)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Element element = (Element) element$iv;
        String url22 = element != null ? element.absUrl("href") : null;
        if (url22 == null) {
            url22 = "";
        }
        Regex regex = new Regex("page=(\\d+)");
        MatchResult matchResult = Regex.find$default(regex, url22, 0, 2, (Object) null);
        if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null) {
            String str = (String) groupValues.get(1);
            if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                totalPage = intOrNull.intValue();
                return new Pair<>(books, Integer.valueOf(totalPage));
            }
        }
        totalPage = 1;
        return new Pair<>(books, Integer.valueOf(totalPage));
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewSniffExtractor.setUp$default(AudioUrlWebViewSniffExtractor.INSTANCE, true, (Function1) null, 2, (Object) null);
        return AudioUrlWebViewSniffExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        Connection connect = Jsoup.connect("https://22ting.com/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = ((Element) doc.select(".clearfix ").get(1)).select("li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "lists");
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
        Object element$iv2;
        List groupValues;
        String str;
        Integer intOrNull;
        String text;
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Elements select = doc.select(".mb15 > span > .now-page");
        int currentPage = (select == null || (text = select.text()) == null) ? 1 : Integer.parseInt(text);
        String str2 = "a";
        Iterable select2 = doc.selectFirst(".mb15 > span").select("a");
        Intrinsics.checkNotNullExpressionValue(select2, "doc.selectFirst(\".mb15 > span\").select(\"a\")");
        Iterable $this$firstOrNull$iv = select2;
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
        String url3 = absUrl;
        Regex regex = new Regex("page=(\\d+)");
        MatchResult matchResult = Regex.find$default(regex, url3, 0, 2, (Object) null);
        int totalPage = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 1 : intOrNull.intValue();
        Iterable select3 = doc.selectFirst(".mb15 > span").select("a");
        Intrinsics.checkNotNullExpressionValue(select3, "doc.selectFirst(\".mb15 > span\").select(\"a\")");
        Iterable $this$firstOrNull$iv3 = select3;
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
            if (StringsKt.contains$default(text3, "››", false, 2, (Object) null)) {
                break;
            }
            $i$f$firstOrNull = $i$f$firstOrNull2;
            $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
        }
        Element element2 = (Element) element$iv2;
        String absUrl2 = element2 != null ? element2.absUrl("href") : null;
        String nextUrl = absUrl2 == null ? "" : absUrl2;
        ArrayList list = new ArrayList();
        Elements lies = doc.select(".row-b > li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        for (Iterator it5 = $this$forEach$iv.iterator(); it5.hasNext(); it5 = it5) {
            Object element$iv3 = it5.next();
            Element li = (Element) element$iv3;
            Document doc2 = doc;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String title = li.selectFirst("li > .clearfix > section > .mb5 > a").text();
            String href = li.selectFirst("li > .clearfix > section > .mb5 > a").absUrl("href");
            Elements lies2 = lies;
            String url32 = url3;
            String status = ((Element) li.select("li > .clearfix > section  > p").get(1)).selectFirst(str2).text();
            String str3 = str2;
            String img = li.selectFirst("li > .clearfix > a > .img-box > img").absUrl("src");
            String author = li.selectFirst("li > .clearfix > section > .mb5 > span").text();
            Regex regex2 = regex;
            String intro = li.selectFirst("li > .clearfix > section > p").text();
            int $i$f$forEach2 = $i$f$forEach;
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Book $this$getCategoryList_u24lambda_u247_u24lambda_u246 = new Book(img, href, title, author, "");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setStatus(status);
            list.add($this$getCategoryList_u24lambda_u247_u24lambda_u246);
            doc = doc2;
            lies = lies2;
            $this$forEach$iv = $this$forEach$iv2;
            url3 = url32;
            str2 = str3;
            regex = regex2;
            $i$f$forEach = $i$f$forEach2;
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
            Element ul = doc.getElementById("yuedu");
            Iterable select = ul.select(".clearfix > li");
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
        String intro = ((Element) doc.selectFirst(".pd10 > section").select("p").get(4)).text();
        return new BookDetail(list, intro, (String) null, (String) null, 0, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.contains$default(coverUrl, "22ting.com/", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://22ting.com/");
        return true;
    }
}
