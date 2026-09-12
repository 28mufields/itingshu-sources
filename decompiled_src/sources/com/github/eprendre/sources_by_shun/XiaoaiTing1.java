package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlWebViewSniffExtractor;
import com.github.eprendre.tingshu.sources.CoverUrlExtraHeaders;
import com.github.eprendre.tingshu.sources.ILogin;
import com.github.eprendre.tingshu.sources.TingShu;
import com.github.eprendre.tingshu.utils.Book;
import com.github.eprendre.tingshu.utils.BookDetail;
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
import kotlin.text.StringsKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: XiaoaiTing1.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020#H\u0016J*\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0019\u0012\u0004\u0012\u00020'0%2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020'H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/github/eprendre/sources_by_shun/XiaoaiTing1;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/ILogin;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "pageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "coverHeaders", "", "coverUrl", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getLoginUrl", "getName", "getSourceId", "getUrl", "isLoginDesktop", "isMultipleEpisodePages", "reset", "", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class XiaoaiTing1 extends TingShu implements ILogin, CoverUrlExtraHeaders {
    public static final XiaoaiTing1 INSTANCE = new XiaoaiTing1();
    private static final ArrayList<String> pageList = new ArrayList<>();

    private XiaoaiTing1() {
    }

    public String getSourceId() {
        return "3aa11119c74448efbd26cd3d16038bbc";
    }

    public String getUrl() {
        return "https://www.itingshu.net";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n不能播放是网站的问题。注意：不能播放就点击一下登陆，注册登陆一下，还不能播放就换下IP。";
    }

    public String getName() {
        return "爱听书";
    }

    public String getLoginUrl() {
        return "https://www.itingshu.net/user/public/login.html";
    }

    public boolean isLoginDesktop() {
        return true;
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        String text;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://www.itingshu.net/novelsearch/search/result.html";
        Connection connect = Jsoup.connect("https://www.itingshu.net/novelsearch/search/result.html");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).data(MapsKt.mapOf(TuplesKt.to("searchword", keywords))).headers(MapsKt.mapOf(TuplesKt.to("referer", "https://www.itingshu.net/"))).post();
        Elements lies = doc.select(".list-works > li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        int $i$f$mapTo = 0;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".list-works-dl > .list-book-dt > a").text();
            String href = li.selectFirst(".list-works-dl > .list-book-dt > a").absUrl("href");
            String status = li.selectFirst(".list-works-dl > .list-book-dt > span").text();
            String url2 = url;
            Elements lies2 = lies;
            String img = li.selectFirst(".list-imgbox > .thumb > img").absUrl("src");
            String author = li.select(".list-works-dl > .list-book-cs > .book-author > a").text();
            Iterable $this$map$iv2 = $this$map$iv;
            String artist = li.select(".list-works-dl > .list-book-cs > .book-boyin  > a").text();
            int $i$f$map2 = $i$f$map;
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
        Element selectFirst = doc.selectFirst(".fanye > span");
        int totalPage = (selectFirst == null || (text = selectFirst.text()) == null) ? 1 : Integer.parseInt(text);
        return new Pair<>(books, Integer.valueOf(totalPage));
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewSniffExtractor.INSTANCE.setUp(true, new Function1<String, Boolean>() { // from class: com.github.eprendre.sources_by_shun.XiaoaiTing1$getAudioUrlExtractor$1
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
        String url = "https://www.itingshu.net/yousheng/all.html";
        Connection connect = Jsoup.connect("https://www.itingshu.net/yousheng/all.html");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = ((Element) doc.select(".top-ul > li").get(0)).select("dl > dd");
        ArrayList list1 = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select, "navs");
        Iterable $this$forEach$iv = select;
        for (Object element$iv : $this$forEach$iv) {
            Element li = (Element) element$iv;
            String title = li.selectFirst("a").text();
            String href = li.selectFirst("a").absUrl("href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            list1.add(new CategoryTab(title, href));
        }
        Connection connect2 = Jsoup.connect("https://www.itingshu.net/boyin/485/");
        Intrinsics.checkNotNullExpressionValue(connect2, "connect(url2)");
        Document doc2 = MyExtKt.config(connect2, true).get();
        Iterable select2 = doc2.select(".module-tab").select("h3");
        ArrayList list2 = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(select2, "navs2");
        Iterable $this$forEach$iv2 = select2;
        for (Object element$iv2 : $this$forEach$iv2) {
            Element li2 = (Element) element$iv2;
            String url2 = url;
            String title2 = li2.selectFirst("a").text();
            Document doc3 = doc;
            String href2 = li2.selectFirst("a").absUrl("href");
            Intrinsics.checkNotNullExpressionValue(title2, "title");
            Intrinsics.checkNotNullExpressionValue(href2, "href");
            list2.add(new CategoryTab(title2, href2));
            doc = doc3;
            url = url2;
        }
        return CollectionsKt.listOf(new CategoryMenu[]{new CategoryMenu("有声小说", list1), new CategoryMenu("长篇评书", list2)});
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0155 A[LOOP:1: B:12:0x0111->B:20:0x0155, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0160 A[EDGE_INSN: B:21:0x0160->B:22:0x0160 BREAK  A[LOOP:1: B:12:0x0111->B:20:0x0155], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.github.eprendre.tingshu.utils.Category getCategoryList(java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.eprendre.sources_by_shun.XiaoaiTing1.getCategoryList(java.lang.String):com.github.eprendre.tingshu.utils.Category");
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
            Iterable $this$forEach$iv = ul.select("ul > li");
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
                        Iterable select3 = ul2.select("ul > li");
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
        if (!StringsKt.contains$default(coverUrl, "itingshu.net", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://www.itingshu.net");
        return true;
    }
}
