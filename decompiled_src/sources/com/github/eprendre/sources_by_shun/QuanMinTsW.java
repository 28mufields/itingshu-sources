package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.extensions.MyExtKt;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlWebViewSniffExtractor;
import com.github.eprendre.tingshu.sources.CoverUrlExtraHeaders;
import com.github.eprendre.tingshu.sources.ISearchVerification;
import com.github.eprendre.tingshu.sources.TingShu;
import com.github.eprendre.tingshu.utils.Book;
import com.github.eprendre.tingshu.utils.BookDetail;
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

/* compiled from: QuanMinTsW.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J*\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0019\u0012\u0004\u0012\u00020'0%2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006)"}, d2 = {"Lcom/github/eprendre/sources_by_shun/QuanMinTsW;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/ISearchVerification;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "coverHeaders", "", "coverUrl", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSearchDelayMs", "", "getSearchVerificationUA", "getSearchVerificationUrl", "keywords", "getSourceId", "getUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class QuanMinTsW extends TingShu implements ISearchVerification, CoverUrlExtraHeaders {
    public static final QuanMinTsW INSTANCE = new QuanMinTsW();
    private static final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("Cookie", MyExtKt.getCookie("https://www.qmtsw.com/")));

    private QuanMinTsW() {
    }

    public boolean isSearchValidated() {
        return ISearchVerification.DefaultImpls.isSearchValidated(this);
    }

    public String getSourceId() {
        return "b21eafb29cbb42fea6a939528c699a23";
    }

    public String getUrl() {
        return "https://www.qmtsw.com/";
    }

    public String getDesc() {
        return "推荐指数:3星 ⭐⭐⭐\n注意：搜索会跳出验证页面，输入验证码然后退出即可。";
    }

    public String getName() {
        return "全民听书网";
    }

    public String getSearchVerificationUrl(String keywords) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        return "https://www.qmtsw.com/search.php?searchword=%E4%BB%99";
    }

    public String getSearchVerificationUA() {
        return MyExtKt.getDesktopUA();
    }

    public long getSearchDelayMs() {
        return 6000L;
    }

    public final Map<String, String> getHeaders() {
        return headers;
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        Object element$iv;
        int totalPage;
        List groupValues;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://www.qmtsw.com/search.php?page=page=" + page + "&searchword=" + URLEncoder.encode(keywords, "utf8") + "&searchtype=";
        Connection connect = Jsoup.connect(url);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).headers(headers).get();
        Element lis = doc.selectFirst(".row3.row-b");
        Elements lies = lis.select("li");
        Intrinsics.checkNotNullExpressionValue(lies, "lies");
        Iterable $this$map$iv = (Iterable) lies;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element li = (Element) item$iv$iv;
            String title = li.selectFirst(".style-img.clearfix > section > h2 > a").text();
            String href = li.selectFirst(".style-img.clearfix > section > h2 > a").absUrl("href");
            Element lis2 = lis;
            String img = li.selectFirst(".style-img.clearfix > .img-80.fl.mr15 > span > img").absUrl("src");
            String author = li.selectFirst(".style-img.clearfix > section > h2 > span").text();
            Elements lies2 = lies;
            String intro = li.selectFirst(".style-img.clearfix > section > .f-gray.mb10.f-12").text();
            Iterable $this$map$iv2 = $this$map$iv;
            Intrinsics.checkNotNullExpressionValue(img, "img");
            Intrinsics.checkNotNullExpressionValue(href, "href");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(author, "author");
            Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(img, href, title, author, "");
            $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
            Intrinsics.checkNotNullExpressionValue(intro, "intro");
            $this$search_u24lambda_u241_u24lambda_u240.setIntro(intro);
            $this$search_u24lambda_u241_u24lambda_u240.setStatus("");
            destination$iv$iv.add($this$search_u24lambda_u241_u24lambda_u240);
            url = url;
            lis = lis2;
            lies = lies2;
            $this$map$iv = $this$map$iv2;
            $i$f$map = $i$f$map;
        }
        List books = (List) destination$iv$iv;
        Iterable select = doc.selectFirst(".pagebar.ta-c.mb15 > span").select("a");
        Intrinsics.checkNotNullExpressionValue(select, "pages");
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
        String url2 = element != null ? element.absUrl("href") : null;
        if (url2 == null) {
            url2 = "";
        }
        Regex regex = new Regex("page=(\\d+)");
        MatchResult matchResult = Regex.find$default(regex, url2, 0, 2, (Object) null);
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
        Connection connect = Jsoup.connect("https://www.leting8.com/");
        Intrinsics.checkNotNullExpressionValue(connect, "connect(url)");
        Document doc = MyExtKt.config(connect, true).get();
        Iterable select = doc.select(".nav.mb10 > ul").select("li");
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d A[LOOP:2: B:41:0x0137->B:43:0x013d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.github.eprendre.tingshu.utils.Category getCategoryList(java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.eprendre.sources_by_shun.QuanMinTsW.getCategoryList(java.lang.String):com.github.eprendre.tingshu.utils.Category");
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        Connection connect = Jsoup.connect(bookUrl);
        Intrinsics.checkNotNullExpressionValue(connect, "connect(bookUrl)");
        Document doc = MyExtKt.config(connect, true).get();
        if (loadEpisodes) {
            Element ul = doc.selectFirst(".ul-36.clearfix");
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
        String intro = ((Element) doc.selectFirst(".style-img.clearfix.pd10 > section").select("p").get(4)).text();
        return new BookDetail(list, intro, (String) null, (String) null, 0, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers2) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        if (!StringsKt.contains$default(coverUrl, "www.qmtsw.com/", false, 2, (Object) null)) {
            return false;
        }
        headers2.put("referer", "https://www.qmtsw.com/");
        return true;
    }
}
