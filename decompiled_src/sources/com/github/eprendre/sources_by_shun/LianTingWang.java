package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlWebViewExtractor;
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

/* compiled from: LianTingWang.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J*\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0010\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¨\u0006\u001c"}, d2 = {"Lcom/github/eprendre/sources_by_shun/LianTingWang;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "()V", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "", "loadEpisodes", "", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LianTingWang extends TingShu {
    public static final LianTingWang INSTANCE = new LianTingWang();

    private LianTingWang() {
    }

    public String getSourceId() {
        return "5caf7568d5f64406822e3a41364a016c";
    }

    public String getUrl() {
        return "https://m.ting55.com";
    }

    public String getName() {
        return "恋听网";
    }

    public String getDesc() {
        return "推荐指数:5星 ⭐⭐⭐⭐⭐\n部分书籍是收费内容，本 app 不支持播放。";
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        int totalPage;
        Document doc;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String encodedKeywords = URLEncoder.encode(keywords, "utf-8");
        String url = "https://m.ting55.com/search/" + encodedKeywords + "/page/" + page;
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc2 = MyExtKt.config(connect, false).get();
        Element cpage = doc2.selectFirst(".cpage");
        if (cpage != null && cpage.childrenSize() > 0) {
            String text = cpage.selectFirst("span").text();
            Intrinsics.checkNotNullExpressionValue(text, "cpage.selectFirst(\"span\").text()");
            int totalPage2 = Integer.parseInt((String) StringsKt.split$default(StringsKt.replace$default(text, "页次 ", "", false, 4, (Object) null), new String[]{"/"}, false, 0, 6, (Object) null).get(1));
            totalPage = totalPage2;
        } else {
            totalPage = 1;
        }
        ArrayList list = new ArrayList();
        try {
            Elements elementList = doc2.select(".slist > a");
            Intrinsics.checkNotNullExpressionValue(elementList, "elementList");
            Iterable $this$forEach$iv = (Iterable) elementList;
            for (Object element$iv : $this$forEach$iv) {
                Element element = (Element) element$iv;
                String coverUrl = element.selectFirst("dl > dt > img").absUrl("src");
                String bookUrl = element.absUrl("href");
                Elements elementList2 = elementList;
                Elements infos = element.selectFirst("dl > dd").children();
                String title = ((Element) infos.get(0)).text();
                String author = ((Element) infos.get(1)).text();
                String artist = ((Element) infos.get(2)).text();
                String encodedKeywords2 = encodedKeywords;
                try {
                    String status = ((Element) infos.get(3)).text();
                    Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
                    Intrinsics.checkNotNullExpressionValue(bookUrl, "bookUrl");
                    String url2 = url;
                    try {
                        Intrinsics.checkNotNullExpressionValue(title, "title");
                        doc = doc2;
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        Intrinsics.checkNotNullExpressionValue(author, "author");
                        Intrinsics.checkNotNullExpressionValue(artist, "artist");
                        Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(coverUrl, bookUrl, title, author, artist);
                        Intrinsics.checkNotNullExpressionValue(status, "status");
                        $this$search_u24lambda_u241_u24lambda_u240.setStatus(status);
                        $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
                        list.add($this$search_u24lambda_u241_u24lambda_u240);
                        elementList = elementList2;
                        doc2 = doc;
                        encodedKeywords = encodedKeywords2;
                        url = url2;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return new Pair<>(list, Integer.valueOf(totalPage));
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

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        Connection connect = Jsoup.connect(bookUrl);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
        Document doc = MyExtKt.config(connect, false).get();
        Iterable select = doc.select(".plist > a");
        Intrinsics.checkNotNullExpressionValue(select, "doc.select(\".plist > a\")");
        Iterable $this$map$iv = select;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            String text = it.text();
            Intrinsics.checkNotNullExpressionValue(text, "it.text()");
            String absUrl = it.absUrl("href");
            Intrinsics.checkNotNullExpressionValue(absUrl, "it.absUrl(\"href\")");
            Episode $this$getBookDetailInfo_u24lambda_u243_u24lambda_u242 = new Episode(text, absUrl);
            $this$getBookDetailInfo_u24lambda_u243_u24lambda_u242.setFree(it.hasClass("f"));
            destination$iv$iv.add($this$getBookDetailInfo_u24lambda_u243_u24lambda_u242);
        }
        List episodes = (List) destination$iv$iv;
        String intro = doc.selectFirst(".intro").text();
        return new BookDetail(episodes, intro, (String) null, (String) null, 0, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        AudioUrlWebViewExtractor.setUp$default(AudioUrlWebViewExtractor.INSTANCE, false, (String) null, new Function1<String, String>() { // from class: com.github.eprendre.sources_by_shun.LianTingWang$getAudioUrlExtractor$1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "str");
                Document doc = Jsoup.parse(str);
                Element selectFirst = doc.selectFirst("audio");
                if (selectFirst != null) {
                    return selectFirst.attr("src");
                }
                return null;
            }
        }, 2, (Object) null);
        return AudioUrlWebViewExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        CategoryMenu menu1 = new CategoryMenu("有声小说", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("推荐", "https://m.ting55.com/tuijian"), new CategoryTab("玄幻", "https://m.ting55.com/category/1"), new CategoryTab("武侠", "https://m.ting55.com/category/2"), new CategoryTab("都市", "https://m.ting55.com/category/3"), new CategoryTab("言情", "https://m.ting55.com/category/4"), new CategoryTab("穿越", "https://m.ting55.com/category/5"), new CategoryTab("科幻", "https://m.ting55.com/category/6"), new CategoryTab("推理", "https://m.ting55.com/category/7"), new CategoryTab("恐怖", "https://m.ting55.com/category/8"), new CategoryTab("惊悚", "https://m.ting55.com/category/9")}));
        CategoryMenu menu2 = new CategoryMenu("其它", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("历史", "https://m.ting55.com/category/10"), new CategoryTab("经典", "https://m.ting55.com/category/11"), new CategoryTab("相声", "https://m.ting55.com/category/12"), new CategoryTab("评书", "https://m.ting55.com/category/14"), new CategoryTab("百家讲坛", "https://m.ting55.com/category/13")}));
        return CollectionsKt.listOf(new CategoryMenu[]{menu1, menu2});
    }

    public Category getCategoryList(String url) {
        int totalPage;
        int currentPage;
        String str;
        Object element$iv;
        Intrinsics.checkNotNullParameter(url, "url");
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, false).get();
        Element cpage = doc.selectFirst(".cpage");
        String str2 = "";
        String str3 = "href";
        if (cpage == null) {
            totalPage = 1;
            currentPage = 1;
            str = "";
        } else {
            String text = cpage.selectFirst("span").text();
            Intrinsics.checkNotNullExpressionValue(text, "cpage.selectFirst(\"span\").text()");
            List pages = StringsKt.split$default(StringsKt.replace$default(text, "页次 ", "", false, 4, (Object) null), new String[]{"/"}, false, 0, 6, (Object) null);
            int currentPage2 = Integer.parseInt((String) pages.get(0));
            int totalPage2 = Integer.parseInt((String) pages.get(1));
            Iterable select = cpage.select("a");
            Intrinsics.checkNotNullExpressionValue(select, "cpage.select(\"a\")");
            Iterable $this$firstOrNull$iv = select;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    if (Intrinsics.areEqual(((Element) element$iv).text(), "下一页")) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            Element it2 = (Element) element$iv;
            if (it2 != null) {
                String absUrl = it2.absUrl("href");
                Intrinsics.checkNotNullExpressionValue(absUrl, "it.absUrl(\"href\")");
                str2 = absUrl;
            }
            totalPage = totalPage2;
            currentPage = currentPage2;
            str = str2;
        }
        ArrayList list = new ArrayList();
        Iterable select2 = doc.select(".clist > a");
        Intrinsics.checkNotNullExpressionValue(select2, "elementList");
        Iterable $this$forEach$iv = select2;
        int $i$f$forEach = 0;
        Iterator it3 = $this$forEach$iv.iterator();
        while (it3.hasNext()) {
            Object element$iv2 = it3.next();
            Element element = (Element) element$iv2;
            Document doc2 = doc;
            String coverUrl = element.selectFirst("dl > dt > img").absUrl("src");
            String bookUrl = element.absUrl(str3);
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            Elements infos = element.selectFirst("dl > dd").children();
            int $i$f$forEach2 = $i$f$forEach;
            String title = ((Element) infos.get(0)).text();
            Iterator it4 = it3;
            String author = ((Element) infos.get(1)).text();
            String artist = ((Element) infos.get(2)).text();
            String str4 = str3;
            String status = ((Element) infos.get(3)).text();
            Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
            Intrinsics.checkNotNullExpressionValue(bookUrl, "bookUrl");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Book $this$getCategoryList_u24lambda_u247_u24lambda_u246 = new Book(coverUrl, bookUrl, title, author, artist);
            Intrinsics.checkNotNullExpressionValue(status, "status");
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setStatus(status);
            $this$getCategoryList_u24lambda_u247_u24lambda_u246.setSourceId(INSTANCE.getSourceId());
            list.add($this$getCategoryList_u24lambda_u247_u24lambda_u246);
            it3 = it4;
            doc = doc2;
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach2;
            str3 = str4;
        }
        return new Category(list, currentPage, totalPage, url, str);
    }
}
