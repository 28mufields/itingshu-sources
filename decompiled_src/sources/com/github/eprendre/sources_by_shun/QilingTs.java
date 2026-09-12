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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: QilingTs.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J*\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0018\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020$H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/github/eprendre/sources_by_shun/QilingTs;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "pageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "coverHeaders", "", "coverUrl", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "isMultipleEpisodePages", "reset", "", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class QilingTs extends TingShu implements CoverUrlExtraHeaders {
    public static final QilingTs INSTANCE = new QilingTs();
    private static final ArrayList<String> pageList = new ArrayList<>();

    private QilingTs() {
    }

    public String getSourceId() {
        return "513215a82fb04abfbaf80066fea9e78f";
    }

    public String getUrl() {
        return "https://www.70ts.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n注意：搜索会跳出验证页面，输入验证码然后退出即可。";
    }

    public String getName() {
        return "麒麟听书";
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        Object obj;
        int totalPage;
        String text;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://www.70ts.com/so/search.html?searchtype=name&searchword=" + URLEncoder.encode(keywords, "utf8") + "&page=" + page;
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Elements lies = doc.selectFirst(".list-works").select("li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".list-works-dl > .list-book-dt > a").text();
            String href = li.selectFirst(".list-works-dl > .list-book-dt > a").absUrl("href");
            String url2 = url;
            String img = li.selectFirst(".list-imgbox > a > img").absUrl("src");
            Elements lies2 = lies;
            String status = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(2)).selectFirst("a").text();
            Iterable $this$map$iv2 = $this$map$iv;
            String author = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(0)).text();
            String artist = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(1)).text();
            String intro = li.selectFirst(".list-works-dl > .list-book-des").text();
            int $i$f$map2 = $i$f$map;
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
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
        }
        List books = (List) destination$iv$iv;
        Element last = doc.select(".fanye > strong").last();
        int currentPage = (last == null || (text = last.text()) == null) ? 1 : Integer.parseInt(text);
        Iterable select = doc.select(".fanye > a");
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
        AudioUrlWebViewSniffExtractor.INSTANCE.setUp(true, new Function1<String, Boolean>() { // from class: com.github.eprendre.sources_by_shun.QilingTs$getAudioUrlExtractor$1
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
        Connection connect = Jsoup.connect("https://www.70ts.com/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = doc.select(".nav-ol > li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "navs");
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
        Element last = doc.select(".fanye > strong").last();
        int currentPage = (last == null || (text = last.text()) == null) ? 1 : Integer.parseInt(text);
        Elements pages = doc.select(".fanye > a");
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
        Iterable select = doc.select(".fanye > a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.select(\".fanye > a\")");
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
        Elements lies = doc.select(".list-works  > li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        Iterator it5 = $this$forEach$iv.iterator();
        while (it5.hasNext()) {
            Object element$iv3 = it5.next();
            Element li = (Element) element$iv3;
            Document doc2 = doc;
            String title = li.selectFirst(".list-works-dl > .list-book-dt > a").text();
            String href = li.selectFirst(".list-works-dl > .list-book-dt > a").absUrl("href");
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            int $i$f$forEach2 = $i$f$forEach;
            String img = li.selectFirst(".list-imgbox > a > img").absUrl("src");
            String status = li.selectFirst(".list-works-dl > .list-book-dt > span").text();
            Iterator it6 = it5;
            Elements pages2 = pages;
            String author = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(0)).selectFirst("a").text();
            Elements lies2 = lies;
            String artist = ((Element) li.select(".list-works-dl > .list-book-cs > .book-author").get(1)).selectFirst("a").text();
            String intro = li.selectFirst(".list-works-dl > .list-book-des").text();
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u247_u24lambda_u246 = new Book(img, href, title, author, artist);
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setStatus(status);
            list.add($this$getCategoryList_u24lambda_u247_u24lambda_u246);
            $this$forEach$iv = $this$forEach$iv2;
            doc = doc2;
            $i$f$forEach = $i$f$forEach2;
            it5 = it6;
            pages = pages2;
            lies = lies2;
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
        Object element$iv;
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        if (loadEpisodes) {
            Connection connect = Jsoup.connect(bookUrl);
            Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
            Document doc = MyExtKt.config(connect, true).get();
            Iterable select = doc.select(".jump-list > .pg-next");
            Intrinsics.checkNotNullExpressionValue(select, "doc.select(\".jump-list > .pg-next\")");
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
            Element nextPage = (Element) element$iv;
            String str = "playlist";
            Element ul = doc.getElementById("playlist");
            Iterable $this$forEach$iv = ul.select("li");
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "lis");
            for (Object element$iv2 : $this$forEach$iv) {
                Element li = (Element) element$iv2;
                String title = li.selectFirst("a").text();
                String href = li.selectFirst("a").absUrl("href");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new Episode(title, href));
            }
            if (loadFullPages) {
                Iterable select2 = doc.select(".hd-sel > select > option");
                Intrinsics.checkNotNullExpressionValue(select2, "doc.select(\".hd-sel > select > option\")");
                Iterable $this$map$iv = select2;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Iterable $this$map$iv2 = $this$map$iv;
                    Element it3 = (Element) item$iv$iv;
                    destination$iv$iv.add(it3.absUrl("value"));
                    $this$map$iv = $this$map$iv2;
                    doc = doc;
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
                        Element ul2 = nextDoc.getElementById(str);
                        Iterable select3 = ul2.select("li");
                        List pages2 = pages;
                        Intrinsics.checkNotNullExpressionValue(select3, "lis2");
                        Iterable $this$forEach$iv2 = select3;
                        for (Object element$iv3 : $this$forEach$iv2) {
                            Iterable $this$forEach$iv3 = $this$forEach$iv2;
                            Element li2 = (Element) element$iv3;
                            int page3 = page2;
                            String title2 = li2.selectFirst("a").text();
                            int totalPage2 = totalPage;
                            String href2 = li2.selectFirst("a").absUrl("href");
                            Intrinsics.checkNotNullExpressionValue(title2, "title");
                            Intrinsics.checkNotNullExpressionValue(href2, "href");
                            list.add(new Episode(title2, href2));
                            $this$forEach$iv2 = $this$forEach$iv3;
                            totalPage = totalPage2;
                            page2 = page3;
                        }
                        Thread.sleep(Random.Default.nextLong(100L, 500L));
                        pages = pages2;
                        nextPage = nextPage;
                        str = str;
                        totalPage = totalPage;
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
        if (!StringsKt.contains$default(coverUrl, "www.70ts.com/", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://www.70ts.com/");
        return true;
    }
}
