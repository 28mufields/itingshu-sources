package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
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
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.RequestFactory;
import com.github.kittinunf.fuel.json.FuelJson;
import com.github.kittinunf.fuel.json.FuelJsonKt;
import com.github.kittinunf.result.Result;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.ranges.IntRange;
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

/* compiled from: LiuyueTing.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J*\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0018\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020$H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/github/eprendre/sources_by_shun/LiuyueTing;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "pageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "coverHeaders", "", "coverUrl", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "isMultipleEpisodePages", "reset", "", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LiuyueTing extends TingShu implements CoverUrlExtraHeaders {
    public static final LiuyueTing INSTANCE = new LiuyueTing();
    private static final ArrayList<String> pageList = new ArrayList<>();

    private LiuyueTing() {
    }

    public String getSourceId() {
        return "d8fba9f19df2465198425c7bc3861de8";
    }

    public String getUrl() {
        return "http://www.tingshu168.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n资源还行，注意：但不是所有都能播放。";
    }

    public String getName() {
        return "六月听书";
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        String str = "author";
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "http://www.tingshu168.com/search/index/search?content=" + URLEncoder.encode(keywords, "utf8") + "&type=1&pageNum=" + page + "&pageSize=10";
        Triple result = FuelJsonKt.responseJson(RequestFactory.Convenience.DefaultImpls.get$default(Fuel.INSTANCE, url, (List) null, 2, (Object) null).header(MapsKt.mapOf(TuplesKt.to("User-Agent", MyExtKt.getMobileUA()))));
        JSONObject jsonObject = ((FuelJson) ((Result) result.getThird()).get()).obj();
        ArrayList list = new ArrayList();
        JSONObject data1 = jsonObject.getJSONObject("data");
        int totalPage = data1.getInt("totalPages");
        try {
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray l = data.getJSONArray("content");
            Iterable $this$forEach$iv = RangesKt.until(0, l.length());
            IntIterator it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                int element$iv = it.nextInt();
                JSONObject book = l.getJSONObject(element$iv);
                String url2 = url;
                try {
                    String coverUrl = "http://img.tingshu168.com:20001/" + book.getString("coverUrlLocal");
                    String bookUrl = "http://www.tingshu168.com/list/" + book.getString("code");
                    String string = book.getString("name");
                    Intrinsics.checkNotNullExpressionValue(string, "book.getString(\"name\")");
                    String title = StringsKt.replace$default(StringsKt.replace$default(string, "<span style=\"color:red\">", "", false, 4, (Object) null), "</span>", "", false, 4, (Object) null);
                    String artist = book.getString("broadcaster");
                    String author = book.getString(str);
                    String intro = book.getString("descXx");
                    Triple result2 = result;
                    try {
                        JSONObject jsonObject2 = jsonObject;
                        boolean isFinished = book.getInt("state") == 2;
                        try {
                            String statusPrefix = isFinished ? "完结|" : "更新到";
                            int tracksCount = book.getInt("trackTotalCount");
                            JSONObject data2 = data;
                            String status = statusPrefix + tracksCount + "集";
                            Intrinsics.checkNotNullExpressionValue(author, str);
                            String str2 = str;
                            Intrinsics.checkNotNullExpressionValue(artist, "artist");
                            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(coverUrl, bookUrl, title, author, artist);
                            Intrinsics.checkNotNullExpressionValue(intro, "intro");
                            $this$search_u24lambda_u241_u24lambda_u240.setIntro(intro);
                            $this$search_u24lambda_u241_u24lambda_u240.setStatus(status);
                            $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
                            $this$search_u24lambda_u241_u24lambda_u240.setCompleted(isFinished);
                            list.add($this$search_u24lambda_u241_u24lambda_u240);
                            url = url2;
                            result = result2;
                            jsonObject = jsonObject2;
                            data = data2;
                            str = str2;
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
        AudioUrlWebViewExtractor.setUp$default(AudioUrlWebViewExtractor.INSTANCE, false, "document.getElementById(\"myIframe\").contentDocument", new Function1<String, String>() { // from class: com.github.eprendre.sources_by_shun.LiuyueTing$getAudioUrlExtractor$1
            public final String invoke(String html) {
                Intrinsics.checkNotNullParameter(html, "html");
                Document doc = Jsoup.parse(html);
                String audio = doc.getElementById("audio").absUrl("src");
                Intrinsics.checkNotNullExpressionValue(audio, "audio");
                return StringsKt.replace$default(audio, "\"", "", false, 4, (Object) null);
            }
        }, 1, (Object) null);
        return AudioUrlWebViewExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        Connection connect = Jsoup.connect("http://www.tingshu168.com/ys/t1");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = doc.selectFirst(".category-list").select("li");
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
        Regex regex;
        String author;
        List list;
        String text;
        List groupValues;
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Regex regex2 = new Regex("p(\\d+)");
        MatchResult matchResult = Regex.find$default(regex2, url, 0, 2, (Object) null);
        int currentPage = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 1 : intOrNull.intValue();
        String text2 = doc.selectFirst(".pagination > .last").text();
        Intrinsics.checkNotNullExpressionValue(text2, "doc.selectFirst(\".pagination > .last\").text()");
        int totalPage = Integer.parseInt(text2);
        Iterable select = doc.selectFirst(".pagination ").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".pagination \").select(\"a\")");
        Iterable $this$firstOrNull$iv = select;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            Element it2 = (Element) element$iv;
            String text3 = it2.text();
            Intrinsics.checkNotNullExpressionValue(text3, "it.text()");
            Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
            if (StringsKt.contains$default(text3, "下一页", false, 2, (Object) null)) {
                break;
            }
            $this$firstOrNull$iv = $this$firstOrNull$iv2;
        }
        Element element = (Element) element$iv;
        String str2 = "href";
        String absUrl = element != null ? element.absUrl("href") : null;
        String str3 = "";
        String nextUrl = absUrl == null ? "" : absUrl;
        ArrayList list2 = new ArrayList();
        Iterable select2 = doc.select(".album-list > li");
        Intrinsics.checkNotNullExpressionValue(select2, "lies");
        Iterable $this$forEach$iv = select2;
        int $i$f$forEach = 0;
        for (Object element$iv2 : $this$forEach$iv) {
            Element li = (Element) element$iv2;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String str4 = str3;
            String title = li.selectFirst(".book-item-r > .book-item-name > a").text();
            String href = li.selectFirst(".book-item-r > .book-item-name > a").absUrl(str2);
            int $i$f$forEach2 = $i$f$forEach;
            String img = li.selectFirst(".lf > a > img").absUrl("src");
            String status = li.selectFirst(".book-item-r > .book-item-status").text();
            Document doc2 = doc;
            Element selectFirst = li.selectFirst(".book-item-r > .book-item-info > .no-author");
            String zuozhe = selectFirst != null ? selectFirst.text() : null;
            if (zuozhe == null) {
                Element selectFirst2 = li.selectFirst(".book-item-r > .book-item-info > .author");
                String text4 = selectFirst2 != null ? selectFirst2.text() : null;
                regex = regex2;
                if (text4 == null) {
                    author = str4;
                } else {
                    Intrinsics.checkNotNullExpressionValue(text4, "li.selectFirst(\".book-it…> .author\")?.text() ?: \"\"");
                    author = text4;
                }
            } else {
                regex = regex2;
                author = zuozhe;
            }
            Element a = li.selectFirst(".book-item-r> .book-item-info");
            Elements select3 = a != null ? a.select("a") : null;
            if (select3 == null) {
                list = CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(select3, "a?.select(\"a\") ?: emptyList()");
                list = (List) select3;
            }
            List boyin = list;
            MatchResult matchResult2 = matchResult;
            if (boyin.size() > 1) {
                text = ((Element) boyin.get(1)).text();
            } else {
                text = boyin.isEmpty() ^ true ? ((Element) boyin.get(0)).text() : str4;
            }
            String artist = text;
            String intro = li.selectFirst(".book-item-r> .weaken").text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, str2);
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u245_u24lambda_u244 = new Book(img, href, title, author, artist);
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setStatus(status);
            list2.add($this$getCategoryList_u24lambda_u245_u24lambda_u244);
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach2;
            str3 = str4;
            doc = doc2;
            regex2 = regex;
            matchResult = matchResult2;
            str2 = str2;
        }
        return new Category(list2, currentPage, totalPage, url, nextUrl);
    }

    public boolean isMultipleEpisodePages() {
        return true;
    }

    public void reset() {
        pageList.clear();
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Object element$iv;
        String text;
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        if (loadEpisodes) {
            Connection connect = Jsoup.connect(bookUrl);
            Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
            Document doc = MyExtKt.config(connect, true).get();
            Iterable select = doc.select(".pagination > .next");
            Intrinsics.checkNotNullExpressionValue(select, "doc.select(\".pagination > .next\")");
            Iterable $this$firstOrNull$iv = select;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    Element it2 = (Element) element$iv;
                    String text2 = it2.text();
                    Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
                    if (StringsKt.contains$default(text2, "下一页", false, 2, (Object) null)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            Element nextPage = (Element) element$iv;
            Element selectFirst = doc.selectFirst(".pagination > .page.last");
            int totalPage2 = (selectFirst == null || (text = selectFirst.text()) == null) ? 1 : Integer.parseInt(text);
            Element ul = doc.selectFirst(".play-list > ul");
            Iterable select2 = ul.select("li");
            Intrinsics.checkNotNullExpressionValue(select2, "lis");
            Iterable $this$forEach$iv = select2;
            int $i$f$forEach = 0;
            for (Object element$iv2 : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                Element li = (Element) element$iv2;
                int $i$f$forEach2 = $i$f$forEach;
                String title = li.selectFirst("a").text();
                String href = li.selectFirst("a").absUrl("href");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new Episode(title, href));
                $this$forEach$iv = $this$forEach$iv2;
                $i$f$forEach = $i$f$forEach2;
            }
            if (loadFullPages) {
                String url1 = StringsKt.replace$default(StringsKt.replace$default(bookUrl, "/p1", "", false, 4, (Object) null), "/p", "", false, 4, (Object) null);
                Iterable $this$map$iv = new IntRange(1, totalPage2);
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                IntIterator it3 = $this$map$iv.iterator();
                while (it3.hasNext()) {
                    int item$iv$iv = it3.nextInt();
                    destination$iv$iv.add(url1 + "/p" + item$iv$iv);
                    $this$map$iv = $this$map$iv;
                    url1 = url1;
                }
                List pages = (List) destination$iv$iv;
                int page = 1;
                int totalPage = pages.size();
                if (nextPage != null) {
                    pageList.addAll(CollectionsKt.takeLast(pages, pages.size() - 1));
                    while (pageList.size() > 0) {
                        int page2 = page + 1;
                        String remove = pageList.remove(0);
                        Intrinsics.checkNotNullExpressionValue(remove, "pageList.removeAt(0)");
                        String nextUrl = remove;
                        MyExtKt.notifyLoadingEpisodes(page2 + " / " + totalPage);
                        Connection connect2 = Jsoup.connect(nextUrl);
                        Intrinsics.checkNotNullExpressionValue(connect2, "connect(nextUrl)");
                        Document nextDoc = MyExtKt.config(connect2, true).get();
                        Element ul2 = nextDoc.selectFirst(".play-list > ul");
                        List pages2 = pages;
                        Elements lis2 = ul2.select("li");
                        Intrinsics.checkNotNullExpressionValue(lis2, "lis2");
                        Iterable $this$forEach$iv3 = (Iterable) lis2;
                        for (Object element$iv3 : $this$forEach$iv3) {
                            Elements lis22 = lis2;
                            Element li2 = (Element) element$iv3;
                            Iterable $this$forEach$iv4 = $this$forEach$iv3;
                            String title2 = li2.selectFirst("a").text();
                            int totalPage3 = totalPage;
                            String href2 = li2.selectFirst("a").absUrl("href");
                            Intrinsics.checkNotNullExpressionValue(title2, "title");
                            Intrinsics.checkNotNullExpressionValue(href2, "href");
                            list.add(new Episode(title2, href2));
                            lis2 = lis22;
                            totalPage = totalPage3;
                            $this$forEach$iv3 = $this$forEach$iv4;
                        }
                        Thread.sleep(Random.Default.nextLong(500L, 1000L));
                        pages = pages2;
                        page = page2;
                        totalPage = totalPage;
                    }
                }
                MyExtKt.notifyLoadingEpisodes((String) null);
            }
        }
        return new BookDetail(list, (String) null, (String) null, (String) null, 0, (String) null, 62, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.contains$default(coverUrl, "tingshu168.com", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "http://www.tingshu168.com/");
        return true;
    }
}
