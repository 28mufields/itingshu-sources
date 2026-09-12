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
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.RequestFactory;
import com.github.kittinunf.fuel.json.FuelJson;
import com.github.kittinunf.fuel.json.FuelJsonKt;
import com.github.kittinunf.result.Result;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: LiuyueTingmobile.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J*\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u0018\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020!H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006$"}, d2 = {"Lcom/github/eprendre/sources_by_shun/LiuyueTingmobile;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "coverHeaders", "", "coverUrl", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LiuyueTingmobile extends TingShu implements CoverUrlExtraHeaders {
    public static final LiuyueTingmobile INSTANCE = new LiuyueTingmobile();
    private static final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("referer", "http://m.6yueting.com"), TuplesKt.to("host", "m.6yueting.com"), TuplesKt.to("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Mobile Safari/537.36 Edg/135.0.0.0")});

    private LiuyueTingmobile() {
    }

    public String getSourceId() {
        return "c38b9f44c5374da9bfca4bb90d6ab383";
    }

    public String getUrl() {
        return "http://m.tingshu168.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n资源还行，注意：但不是所有都能播放。";
    }

    public String getName() {
        return "六月听书";
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public Pair<List<Book>, Integer> search(String keywords, int page) {
        String str = "author";
        String str2 = "code";
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "http://m.6yueting.com/search/index/search?content=" + URLEncoder.encode(keywords, "utf8") + "&type=1&pageNum=" + page + "&pageSize=40";
        Triple result = FuelJsonKt.responseJson(RequestFactory.Convenience.DefaultImpls.get$default(Fuel.INSTANCE, url, (List) null, 2, (Object) null).header(MapsKt.mapOf(TuplesKt.to("User-Agent", MyExtKt.getMobileUA()))));
        JSONObject jsonObject = ((FuelJson) ((Result) result.getThird()).get()).obj();
        ArrayList list = new ArrayList();
        int totalPage = 1;
        try {
            double d = jsonObject.getInt("code");
            double d2 = 40;
            Double.isNaN(d);
            Double.isNaN(d2);
            totalPage = (int) Math.ceil(d / d2);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray l = data.getJSONArray("content");
            Iterable $this$forEach$iv = RangesKt.until(0, l.length());
            IntIterator it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                int element$iv = it.nextInt();
                JSONObject book = l.getJSONObject(element$iv);
                String url2 = url;
                try {
                    String coverUrl = "http://img.6yueting.com:20001/" + book.getString("coverUrlLocal");
                    String bookUrl = "http://m.6yueting.com/list/" + book.getString(str2);
                    String string = book.getString("name");
                    Intrinsics.checkNotNullExpressionValue(string, "book.getString(\"name\")");
                    String title = StringsKt.replace$default(StringsKt.replace$default(string, "<span style=\"color:red\">", "", false, 4, (Object) null), "</span>", "", false, 4, (Object) null);
                    String artist = book.getString("broadcaster");
                    String author = book.getString(str);
                    String intro = book.getString("descXx");
                    String str3 = str2;
                    Triple result2 = result;
                    boolean isFinished = book.getInt("state") == 2;
                    try {
                        String statusPrefix = isFinished ? "完结|" : "更新到";
                        int tracksCount = book.getInt("trackTotalCount");
                        JSONObject jsonObject2 = jsonObject;
                        try {
                            String status = statusPrefix + tracksCount + "集";
                            Intrinsics.checkNotNullExpressionValue(author, str);
                            String str4 = str;
                            Intrinsics.checkNotNullExpressionValue(artist, "artist");
                            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(coverUrl, bookUrl, title, author, artist);
                            Intrinsics.checkNotNullExpressionValue(intro, "intro");
                            $this$search_u24lambda_u241_u24lambda_u240.setIntro(intro);
                            $this$search_u24lambda_u241_u24lambda_u240.setStatus(status);
                            $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
                            $this$search_u24lambda_u241_u24lambda_u240.setCompleted(isFinished);
                            list.add($this$search_u24lambda_u241_u24lambda_u240);
                            url = url2;
                            str2 = str3;
                            result = result2;
                            jsonObject = jsonObject2;
                            str = str4;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            return new Pair<>(list, Integer.valueOf(totalPage));
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        return new Pair<>(list, Integer.valueOf(totalPage));
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewSniffExtractor.setUp$default(AudioUrlWebViewSniffExtractor.INSTANCE, false, (Function1) null, 2, (Object) null);
        return AudioUrlWebViewSniffExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        Connection connect = Jsoup.connect("http://m.tingshu168.com/ys");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, false).get();
        Iterable select = doc.select(".type-list > li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "navs");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.selectFirst("a").text();
            String href = li.selectFirst("a").absUrl("href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            list.add(new CategoryTab(title, href));
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
        Document doc = MyExtKt.config(connect, false).get();
        String pages = doc.selectFirst(".all-list > .pagination.page-width > span").text();
        Regex regex = new Regex("(\\d+)/\\d+");
        Intrinsics.checkNotNullExpressionValue(pages, "pages");
        MatchResult matchResult = Regex.find$default(regex, pages, 0, 2, (Object) null);
        int currentPage = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = (String) groupValues2.get(1)) == null || (intOrNull2 = StringsKt.toIntOrNull(str2)) == null) ? 1 : intOrNull2.intValue();
        Regex regex2 = new Regex("\\d+/(\\d+)");
        MatchResult matchResult2 = Regex.find$default(regex2, pages, 0, 2, (Object) null);
        int totalPage = (matchResult2 == null || (groupValues = matchResult2.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 1 : intOrNull.intValue();
        Iterable select = doc.selectFirst(".all-list > .pagination.page-width").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".all-li….page-width\").select(\"a\")");
        Iterable $this$firstOrNull$iv = select;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            Element it2 = (Element) element$iv;
            String text = it2.text();
            Intrinsics.checkNotNullExpressionValue(text, "it.text()");
            Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
            if (StringsKt.contains$default(text, "下一页", false, 2, (Object) null)) {
                break;
            }
            $this$firstOrNull$iv = $this$firstOrNull$iv2;
        }
        Element element = (Element) element$iv;
        String nextUrl = element != null ? element.absUrl("href") : null;
        if (nextUrl == null) {
            nextUrl = "";
        }
        ArrayList list = new ArrayList();
        Elements lies = doc.selectFirst(".list-wrapper > ul").select("a");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        for (Object element$iv2 : $this$forEach$iv) {
            Document doc2 = doc;
            Element a = (Element) element$iv2;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String title = a.selectFirst(".text > .name").text();
            int $i$f$forEach2 = $i$f$forEach;
            String href = a.absUrl("href");
            String pages2 = pages;
            String img = a.selectFirst(".icon > img").absUrl("src");
            MatchResult matchResult3 = matchResult;
            Regex regex22 = regex2;
            String author = a.selectFirst(".item").attr("data-author");
            Element artist1 = a.selectFirst(".text > div > .broadcaster");
            MatchResult matchResult22 = matchResult2;
            Element iconBroad = artist1.select("i.icon-broad").first();
            String node = iconBroad.nextSibling().toString();
            Intrinsics.checkNotNullExpressionValue(node, "iconBroad.nextSibling().toString()");
            String artist = StringsKt.trim(node).toString();
            String intro = a.selectFirst(".text > .desc").text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Book $this$getCategoryList_u24lambda_u245_u24lambda_u244 = new Book(img, href, title, author, artist);
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setSourceId(QilingTs.INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setIntro(intro);
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setStatus("");
            list.add($this$getCategoryList_u24lambda_u245_u24lambda_u244);
            doc = doc2;
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach2;
            pages = pages2;
            regex = regex;
            matchResult = matchResult3;
            regex2 = regex22;
            matchResult2 = matchResult22;
            lies = lies;
        }
        return new Category(list, currentPage, totalPage, url, nextUrl);
    }

    public final Map<String, String> getHeaders() {
        return headers;
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        Connection connect = Jsoup.connect(bookUrl);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
        Document doc = MyExtKt.config(connect, false).headers(headers).get();
        if (loadEpisodes) {
            Element ul = doc.selectFirst(".book-list.clearfix");
            Iterable select = ul.select("a");
            Intrinsics.checkNotNullExpressionValue(select, "lis");
            Iterable $this$forEach$iv = select;
            for (Object element$iv : $this$forEach$iv) {
                Element a = (Element) element$iv;
                String title = a.text();
                String href = a.absUrl("href");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new Episode(title, href));
            }
        }
        String intro = doc.selectFirst(".book-intro.tab-cont").text();
        Thread.sleep(Random.Default.nextLong(1000L, 1500L));
        return new BookDetail(list, intro, (String) null, (String) null, 0, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers2) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        if (!StringsKt.contains$default(coverUrl, "m.6yueting.com/", false, 2, (Object) null)) {
            return false;
        }
        headers2.put("referer", "http://m.6yueting.com/");
        return true;
    }
}
