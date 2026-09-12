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
import kotlin.random.Random;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: XiaoaiTing2.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020#H\u0016J*\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0019\u0012\u0004\u0012\u00020'0%2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020'H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/github/eprendre/sources_by_shun/XiaoaiTing2;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/ILogin;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "pageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "coverHeaders", "", "coverUrl", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getLoginUrl", "getName", "getSourceId", "getUrl", "isLoginDesktop", "isMultipleEpisodePages", "reset", "", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class XiaoaiTing2 extends TingShu implements ILogin, CoverUrlExtraHeaders {
    public static final XiaoaiTing2 INSTANCE = new XiaoaiTing2();
    private static final ArrayList<String> pageList = new ArrayList<>();

    private XiaoaiTing2() {
    }

    public String getSourceId() {
        return "e30009d5e6714d89a2692666ddf13cbd";
    }

    public String getUrl() {
        return "https://m.itingshu.net/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n不能播放是网站的问题。注意：不能播放就点击一下登陆，注册登陆一下，还不能播放就换下IP。";
    }

    public String getName() {
        return "爱听书";
    }

    public String getLoginUrl() {
        return "https://m.itingshu.net/user/public/login.html";
    }

    public boolean isLoginDesktop() {
        return false;
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        List groupValues;
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://m.itingshu.net/novelsearch/search/result.html";
        Connection connect = Jsoup.connect("https://m.itingshu.net/novelsearch/search/result.html");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, false).data(MapsKt.mapOf(TuplesKt.to("searchword", keywords))).headers(MapsKt.mapOf(TuplesKt.to("referer", "https://m.itingshu.net/"))).post();
        Element pages = doc.selectFirst(".page > .main");
        if (pages != null) {
            Regex regex = new Regex("\\d+/(\\d+)");
            String text = pages.text();
            Intrinsics.checkNotNullExpressionValue(text, "pages.text()");
            MatchResult matchResult = Regex.find$default(regex, text, 0, 2, (Object) null);
            if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null && (str = (String) groupValues.get(1)) != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                intOrNull.intValue();
            }
        }
        Elements lies = doc.selectFirst(".book-ol.book-ol-normal").select("li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        int $i$f$mapTo = 0;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst("a > .book-cell > .book-title > .book-meta-l").text();
            String href = li.selectFirst("a").absUrl("href");
            Document doc2 = doc;
            String status = li.selectFirst("a > .book-cell > .book-title > .book-meta-r > .tag-small-group.origin-right > em").text();
            Elements lies2 = lies;
            String img = li.selectFirst("a > img").absUrl("src");
            Iterable $this$map$iv2 = $this$map$iv;
            String artist = li.select("a > .book-cell > .book-meta > .book-meta-l > .book-author").text();
            int $i$f$map2 = $i$f$map;
            String intro = li.selectFirst("a > .book-cell > .book-desc").text();
            Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(img, href, title, "", artist);
            $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$search_u24lambda_u241_u24lambda_u240.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$search_u24lambda_u241_u24lambda_u240.setStatus(status);
            destination$iv$iv.add($this$search_u24lambda_u241_u24lambda_u240);
            url = url;
            doc = doc2;
            lies = lies2;
            pages = pages;
            $this$map$iv = $this$map$iv2;
            $i$f$map = $i$f$map2;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
            $i$f$mapTo = $i$f$mapTo;
        }
        List books = (List) destination$iv$iv;
        return new Pair<>(books, 1);
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewSniffExtractor.setUp$default(AudioUrlWebViewSniffExtractor.INSTANCE, false, (Function1) null, 2, (Object) null);
        return AudioUrlWebViewSniffExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        Connection connect = Jsoup.connect("https://m.itingshu.net/book/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, false).get();
        Iterable select = doc.getElementsByTag("ol").select("li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "navs");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.selectFirst("a").attr("title");
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
        String pages = doc.selectFirst(".page > .main").text();
        Regex regex1 = new Regex("(\\d+)/");
        Intrinsics.checkNotNullExpressionValue(pages, "pages");
        MatchResult matchResult = Regex.find$default(regex1, pages, 0, 2, (Object) null);
        int currentPage = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = (String) groupValues2.get(1)) == null || (intOrNull2 = StringsKt.toIntOrNull(str2)) == null) ? 0 : intOrNull2.intValue();
        Regex regex2 = new Regex("\\d+/(\\d+)");
        MatchResult matchResult2 = Regex.find$default(regex2, pages, 0, 2, (Object) null);
        int totalPage = (matchResult2 == null || (groupValues = matchResult2.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 0 : intOrNull.intValue();
        String str3 = "a";
        Iterable select = doc.selectFirst(".page  > .right ").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".page  > .right \").select(\"a\")");
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
        Iterable select2 = doc.selectFirst(".book-ol.book-ol-normal").select("li");
        Intrinsics.checkNotNullExpressionValue(select2, "lis");
        Iterable $this$forEach$iv = select2;
        int $i$f$forEach = 0;
        for (Object element$iv2 : $this$forEach$iv) {
            Document doc2 = doc;
            Element li = (Element) element$iv2;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String title = li.selectFirst("a > .book-cell > .book-title > .book-meta-l").text();
            int $i$f$forEach2 = $i$f$forEach;
            String href = li.selectFirst(str3).absUrl("href");
            String pages2 = pages;
            String status = li.selectFirst("a > .book-cell > .book-title > .book-meta-r > .tag-small-group.origin-right > em").text();
            Regex regex12 = regex1;
            String img = li.selectFirst("a > img").absUrl("src");
            Regex regex22 = regex2;
            String artist = li.select("a > .book-cell > .book-meta > .book-meta-l > .book-author").text();
            MatchResult matchResult22 = matchResult2;
            String intro = li.selectFirst("a > .book-cell > .book-desc").text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u245_u24lambda_u244 = new Book(img, href, title, "", artist);
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u245_u24lambda_u244.setStatus(status);
            list.add($this$getCategoryList_u24lambda_u245_u24lambda_u244);
            doc = doc2;
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach2;
            pages = pages2;
            regex1 = regex12;
            matchResult = matchResult;
            regex2 = regex22;
            matchResult2 = matchResult22;
            str3 = str3;
        }
        return new Category(list, currentPage, totalPage, url, nextUrl);
    }

    public boolean isMultipleEpisodePages() {
        return true;
    }

    public void reset() {
        pageList.clear();
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        List groupValues;
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        if (loadEpisodes) {
            Connection connect = Jsoup.connect(bookUrl);
            Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
            Document doc1 = MyExtKt.config(connect, false).get();
            String str2 = "href";
            String url1 = doc1.selectFirst(".novel-header > .novel-header-r > a").absUrl("href");
            Connection connect2 = Jsoup.connect(url1);
            Intrinsics.checkNotNullExpressionValue(connect2, "connect(url1)");
            Document doc2 = MyExtKt.config(connect2, false).get();
            Element page1 = doc2.selectFirst(".pt-dir-sel > ul");
            String url2 = page1.select("a").last().absUrl("href");
            Regex regex = new Regex("page=(\\d+)&sort");
            Intrinsics.checkNotNullExpressionValue(url2, "url2");
            MatchResult matchResult = Regex.find$default(regex, url2, 0, 2, (Object) null);
            int totalPage = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 1 : intOrNull.intValue();
            Elements lis = doc2.selectFirst(".novel-text-list").select("li");
            Intrinsics.checkNotNullExpressionValue(lis, "lis");
            Iterable $this$forEach$iv = (Iterable) lis;
            Iterator it = $this$forEach$iv.iterator();
            while (true) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                Document doc12 = doc1;
                Element li = (Element) element$iv;
                Elements lis2 = lis;
                String title = li.selectFirst("a").text();
                String url12 = url1;
                String href = li.selectFirst("a").absUrl("href");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new Episode(title, href));
                $this$forEach$iv = $this$forEach$iv2;
                doc1 = doc12;
                url1 = url12;
                lis = lis2;
            }
            if (loadFullPages) {
                Iterable select = doc2.selectFirst(".pt-dir-sel > ul").select("a");
                Intrinsics.checkNotNullExpressionValue(select, "doc2.selectFirst(\".pt-dir-sel > ul\").select(\"a\")");
                Iterable $this$map$iv = select;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Iterable $this$map$iv2 = $this$map$iv;
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(it2.absUrl("href"));
                    $this$map$iv = $this$map$iv2;
                }
                List pages = (List) destination$iv$iv;
                int page = 1;
                if (totalPage > 1) {
                    pageList.addAll(CollectionsKt.takeLast(pages, pages.size() - 1));
                    while (pageList.size() > 0) {
                        int page2 = page + 1;
                        String remove = pageList.remove(0);
                        Intrinsics.checkNotNullExpressionValue(remove, "pageList.removeAt(0)");
                        String nextUrl = remove;
                        List pages2 = pages;
                        MyExtKt.notifyLoadingEpisodes(page2 + " / " + totalPage);
                        Connection connect3 = Jsoup.connect(nextUrl);
                        Intrinsics.checkNotNullExpressionValue(connect3, "connect(nextUrl)");
                        Document nextDoc = MyExtKt.config(connect3, false).get();
                        Iterable select2 = nextDoc.selectFirst(".novel-text-list").select("li");
                        Intrinsics.checkNotNullExpressionValue(select2, "lis2");
                        Iterable $this$forEach$iv3 = select2;
                        for (Object element$iv2 : $this$forEach$iv3) {
                            Iterable $this$forEach$iv4 = $this$forEach$iv3;
                            Element li2 = (Element) element$iv2;
                            int page3 = page2;
                            String title2 = li2.selectFirst("a").text();
                            String nextUrl2 = nextUrl;
                            String href2 = li2.selectFirst("a").absUrl(str2);
                            Intrinsics.checkNotNullExpressionValue(title2, "title");
                            Intrinsics.checkNotNullExpressionValue(href2, str2);
                            list.add(new Episode(title2, href2));
                            $this$forEach$iv3 = $this$forEach$iv4;
                            nextUrl = nextUrl2;
                            page2 = page3;
                        }
                        Thread.sleep(Random.Default.nextLong(1000L, 1500L));
                        pages = pages2;
                        str2 = str2;
                        doc2 = doc2;
                        page = page2;
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
        if (!StringsKt.contains$default(coverUrl, "itingshu.net", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://m.itingshu.net/");
        return true;
    }
}
