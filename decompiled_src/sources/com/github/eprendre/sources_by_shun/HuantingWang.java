package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtraHeaders;
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
import java.util.HashMap;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: HuantingWang.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020#H\u0016J*\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0019\u0012\u0004\u0012\u00020'0%2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020'H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/github/eprendre/sources_by_shun/HuantingWang;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtraHeaders;", "()V", "pageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "coverHeaders", "", "coverUrl", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "", "audioUrl", "isMultipleEpisodePages", "reset", "", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HuantingWang extends TingShu implements CoverUrlExtraHeaders, AudioUrlExtraHeaders {
    public static final HuantingWang INSTANCE = new HuantingWang();
    private static final ArrayList<String> pageList = new ArrayList<>();

    private HuantingWang() {
    }

    public String getSourceId() {
        return "4c229e17e7104a90947edbb7f182bd1f";
    }

    public String getUrl() {
        return "https://www.huanting.cc/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n。注意：如果碰到不能播放的，那是网站的问题。";
    }

    public String getName() {
        return "幻听网";
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        Object obj;
        int totalPage;
        String text;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://www.huanting.cc/Ps.php?q=" + URLEncoder.encode(keywords, "utf8") + "&page=" + page;
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Elements lies = doc.selectFirst(".content_left").select(".result");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".title > a").text();
            String href = li.selectFirst(".title > a").absUrl("href");
            String url2 = url;
            String img = li.selectFirst(".image_pic > a > img").absUrl("src");
            String status = ((Element) li.select(".last").get(2)).selectFirst("span").text();
            Iterable $this$map$iv2 = $this$map$iv;
            int $i$f$map2 = $i$f$map;
            String artist = ((Element) li.select(".last").get(0)).selectFirst("span > a").text();
            String intro = ((Element) li.select(".last").get(1)).text();
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
            url = url2;
            lies = lies;
            $this$map$iv = $this$map$iv2;
            $i$f$map = $i$f$map2;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
        }
        List books = (List) destination$iv$iv;
        Element selectFirst = doc.getElementById("page").selectFirst(".current");
        int currentPage = (selectFirst == null || (text = selectFirst.text()) == null) ? 1 : Integer.parseInt(text);
        Iterable select = doc.getElementById("page").select("a");
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
            if (StringsKt.contains$default(text2, "尾页", false, 2, (Object) null)) {
                obj = element$iv;
                break;
            }
        }
        Element lastPage = (Element) obj;
        if (lastPage == null) {
            totalPage = currentPage;
        } else {
            totalPage = currentPage + 1;
        }
        return new Pair<>(books, Integer.valueOf(totalPage));
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewSniffExtractor.INSTANCE.setUp(true, (Function1) null);
        return AudioUrlWebViewSniffExtractor.INSTANCE;
    }

    public Map<String, String> headers(String audioUrl) {
        Intrinsics.checkNotNullParameter(audioUrl, "audioUrl");
        HashMap hashMap = new HashMap();
        if (StringsKt.contains$default(audioUrl, "huanting", false, 2, (Object) null)) {
            hashMap.put("referer", "https://www.huanting.cc/");
            HashMap hashMap2 = hashMap;
            String cookie = MyExtKt.getCookie("https://www.huanting.cc/");
            if (cookie == null) {
                cookie = "";
            }
            hashMap2.put("Cookie", cookie);
        }
        return hashMap;
    }

    public List<CategoryMenu> getCategoryMenus() {
        Connection connect = Jsoup.connect("https://www.huanting.cc/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = doc.select(".mainnav > ul > li");
        ArrayList list = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "lists");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.selectFirst("a").text();
            String href = li.selectFirst("a").absUrl("href");
            if (!Intrinsics.areEqual(title, "听书首页")) {
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
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        String text = doc.selectFirst(".list_box > .page > .current").text();
        Intrinsics.checkNotNullExpressionValue(text, "doc.selectFirst(\".list_b….page > .current\").text()");
        int currentPage = Integer.parseInt(text);
        Elements pages = doc.selectFirst(".list_box > .page ").select("a");
        Intrinsics.checkNotNullExpressionValue(pages, "pages");
        Iterable $this$firstOrNull$iv = (Iterable) pages;
        int $i$f$firstOrNull = 0;
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
            int $i$f$firstOrNull2 = $i$f$firstOrNull;
            if (StringsKt.contains$default(text2, "下一页", false, 2, (Object) null)) {
                break;
            }
            $this$firstOrNull$iv = $this$firstOrNull$iv2;
            $i$f$firstOrNull = $i$f$firstOrNull2;
        }
        Element nextPage = (Element) element$iv;
        if (nextPage == null) {
            totalPage = currentPage;
        } else {
            totalPage = currentPage + 1;
        }
        Iterable select = doc.selectFirst(".list_box > .page ").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".list_box > .page \").select(\"a\")");
        Iterable $this$firstOrNull$iv3 = select;
        int $i$f$firstOrNull3 = 0;
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
            int $i$f$firstOrNull4 = $i$f$firstOrNull3;
            Iterator it5 = it3;
            if (StringsKt.contains$default(text3, "下一页", false, 2, (Object) null)) {
                break;
            }
            it3 = it5;
            $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
            $i$f$firstOrNull3 = $i$f$firstOrNull4;
        }
        Element element = (Element) element$iv2;
        String absUrl = element != null ? element.absUrl("href") : null;
        String nextUrl = absUrl == null ? "" : absUrl;
        ArrayList list = new ArrayList();
        Elements lies = doc.select(".list_box > .book");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$forEach$iv = (Iterable) lies;
        int $i$f$forEach = 0;
        Iterator it6 = $this$forEach$iv.iterator();
        while (it6.hasNext()) {
            Object element$iv3 = it6.next();
            Element bookbox = (Element) element$iv3;
            Document doc2 = doc;
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            String title = bookbox.selectFirst(".left > dt >a").text();
            String href = bookbox.selectFirst(".left > dt >a").absUrl("href");
            int $i$f$forEach2 = $i$f$forEach;
            String status = bookbox.selectFirst(".left > .zt").text();
            Iterator it7 = it6;
            String img = bookbox.selectFirst(".img.left > .lazy").absUrl("data-original");
            Elements pages2 = pages;
            String artist = bookbox.selectFirst(".left > .zb").text();
            Element nextPage2 = nextPage;
            String intro = bookbox.selectFirst(".left > .info > a").text();
            Elements lies2 = lies;
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u247_u24lambda_u246 = new Book(img, href, title, "", artist);
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setIntro(intro);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setStatus(status);
            list.add($this$getCategoryList_u24lambda_u247_u24lambda_u246);
            doc = doc2;
            $i$f$forEach = $i$f$forEach2;
            $this$forEach$iv = $this$forEach$iv2;
            it6 = it7;
            pages = pages2;
            nextPage = nextPage2;
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
        String str;
        List groupValues;
        String str2;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        if (loadEpisodes) {
            Connection connect = Jsoup.connect(bookUrl);
            Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
            Document doc = MyExtKt.config(connect, true).get();
            Element page1 = doc.selectFirst(".list_book > .play_navs");
            String str3 = "a";
            String url = page1.select("a").last().absUrl("href");
            Regex regex = new Regex("p=(\\d+)");
            Intrinsics.checkNotNullExpressionValue(url, "url");
            MatchResult matchResult = Regex.find$default(regex, url, 0, 2, (Object) null);
            int totalPage = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str2 = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? 1 : intOrNull.intValue();
            Element ul = doc.getElementById("vlink");
            Iterable $this$forEach$iv = ul.select("li");
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "lis");
            Iterator it = $this$forEach$iv.iterator();
            while (true) {
                str = "title";
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                Element li = (Element) element$iv;
                Element page12 = page1;
                String title = li.selectFirst("a").text();
                String url2 = url;
                String href = li.selectFirst("a").absUrl("href");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(href, "href");
                list.add(new Episode(title, href));
                url = url2;
                page1 = page12;
            }
            if (loadFullPages) {
                Iterable select = doc.selectFirst(".play_navs").select("a");
                Intrinsics.checkNotNullExpressionValue(select, "doc.selectFirst(\".play_navs\").select(\"a\")");
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
                        MyExtKt.notifyLoadingEpisodes(page2 + " / " + totalPage);
                        Connection connect2 = Jsoup.connect(nextUrl);
                        Intrinsics.checkNotNullExpressionValue(connect2, "connect(nextUrl)");
                        Document nextDoc = MyExtKt.config(connect2, true).get();
                        Element ul2 = nextDoc.getElementById("vlink");
                        List pages2 = pages;
                        Elements lis2 = ul2.select("li");
                        Intrinsics.checkNotNullExpressionValue(lis2, "lis2");
                        Iterable $this$forEach$iv2 = (Iterable) lis2;
                        for (Object element$iv2 : $this$forEach$iv2) {
                            Elements lis22 = lis2;
                            Element li2 = (Element) element$iv2;
                            Iterable $this$forEach$iv3 = $this$forEach$iv2;
                            String title2 = li2.selectFirst(str3).text();
                            int page3 = page2;
                            String href2 = li2.selectFirst(str3).absUrl("href");
                            Intrinsics.checkNotNullExpressionValue(title2, str);
                            Intrinsics.checkNotNullExpressionValue(href2, "href");
                            list.add(new Episode(title2, href2));
                            lis2 = lis22;
                            page2 = page3;
                            $this$forEach$iv2 = $this$forEach$iv3;
                        }
                        Thread.sleep(Random.Default.nextLong(1000L, 1500L));
                        pages = pages2;
                        str = str;
                        str3 = str3;
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
        if (!StringsKt.contains$default(coverUrl, "huanting.cc", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://www.huanting.cc/");
        return true;
    }
}
