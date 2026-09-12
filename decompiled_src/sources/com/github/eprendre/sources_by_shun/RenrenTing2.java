package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.sources.AudioUrlDirectExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RenrenTing2.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J*\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u0015\u0012\u0004\u0012\u00020\u001e0\u001c2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001eH\u0016¨\u0006!"}, d2 = {"Lcom/github/eprendre/sources_by_shun/RenrenTing2;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "coverHeaders", "", "coverUrl", "", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getName", "getSourceId", "getUrl", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenrenTing2 extends TingShu implements CoverUrlExtraHeaders {
    public static final RenrenTing2 INSTANCE = new RenrenTing2();

    private RenrenTing2() {
    }

    public String getSourceId() {
        return "366b8e910c2a43729d02926eee60abd7";
    }

    public String getUrl() {
        return "https://www.baidu.com/";
    }

    public String getDesc() {
        return "推荐指数:4星 ⭐⭐⭐⭐\n注意：资源全，这个源会维护。";
    }

    public String getName() {
        return "众听";
    }

    public Pair<List<Book>, Integer> search(String keywords, int page) {
        String status;
        Triple result;
        JSONObject jsonObject;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        String url = "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=" + URLEncoder.encode(keywords, "utf8") + "&fromLy=title&apiLy=xmly&pageNum=" + page + "&pageSize=15";
        Triple result2 = FuelJsonKt.responseJson(RequestFactory.Convenience.DefaultImpls.get$default(Fuel.INSTANCE, url, (List) null, 2, (Object) null));
        JSONObject jsonObject2 = ((FuelJson) ((Result) result2.getThird()).get()).obj();
        ArrayList list = new ArrayList();
        try {
            JSONArray data = jsonObject2.getJSONArray("data");
            Iterable $this$forEach$iv = RangesKt.until(0, data.length());
            IntIterator it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                int element$iv = it.nextInt();
                JSONObject book = data.getJSONObject(element$iv);
                String coverUrl = book.getString("coverImageUrl");
                JSONArray data2 = data;
                String bookUrl = "https://api.yituwenhua.com/api/json/v1/albums_browse_search?album_id=" + book.getInt("novelId");
                String title = book.getString("novelName");
                String artist = book.getString("presenter");
                String intro = book.getString("description");
                String url2 = url;
                try {
                    status = book.getString("novelStatus");
                    result = result2;
                    try {
                        jsonObject = jsonObject2;
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(artist, "artist");
                    Book $this$search_u24lambda_u241_u24lambda_u240 = new Book(coverUrl, bookUrl, title, "", artist);
                    $this$search_u24lambda_u241_u24lambda_u240.setSourceId(INSTANCE.getSourceId());
                    Intrinsics.checkNotNullExpressionValue(intro, "intro");
                    $this$search_u24lambda_u241_u24lambda_u240.setIntro(intro);
                    Intrinsics.checkNotNullExpressionValue(status, "status");
                    $this$search_u24lambda_u241_u24lambda_u240.setStatus(status);
                    list.add($this$search_u24lambda_u241_u24lambda_u240);
                    data = data2;
                    url = url2;
                    result2 = result;
                    jsonObject2 = jsonObject;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    return new Pair<>(list, 1);
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        return new Pair<>(list, 1);
    }

    public AudioUrlExtractor getAudioUrlExtractor() {
        return AudioUrlDirectExtractor.INSTANCE;
    }

    public List<CategoryMenu> getCategoryMenus() {
        CategoryMenu menu1 = new CategoryMenu("有声书", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("言情", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%A8%80%E6%83%85&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("健身", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%81%A5%E8%BA%AB&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("同人", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%90%8C%E4%BA%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("幻想", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%B9%BB%E6%83%B3&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("网游", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%BD%91%E6%B8%B8&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("都市重生", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%83%BD%E5%B8%82%E9%87%8D%E7%94%9F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("文学名著", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%96%87%E5%AD%A6%E5%90%8D%E8%91%97&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("历史专区", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8E%86%E5%8F%B2%E4%B8%93%E5%8C%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("国家经典", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%9B%BD%E5%AE%B6%E7%BB%8F%E5%85%B8&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("电竞", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%94%B5%E7%AB%9E&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("虚拟现实", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%99%9A%E6%8B%9F%E7%8E%B0%E5%AE%9E&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("历史纵横", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8E%86%E5%8F%B2%E7%BA%B5%E6%A8%AA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("有声漫", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%9C%89%E5%A3%B0%E6%BC%AB&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("看小说", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%9C%8B%E5%B0%8F%E8%AF%B4&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("大家都在追", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%A4%A7%E5%AE%B6%E9%83%BD%E5%9C%A8%E8%BF%BD&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("豪门恋情", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%B1%AA%E9%97%A8%E6%81%8B%E6%83%85&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("古风言情", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%A4%E9%A3%8E%E8%A8%80%E6%83%85&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("宫闱宅斗", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%AE%AB%E9%97%B1%E5%AE%85%E6%96%97&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("传记", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BC%A0%E8%AE%B0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("修真", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BF%AE%E7%9C%9F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("仙侠", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BB%99%E4%BE%A0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("异世大陆", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%BC%82%E4%B8%96%E5%A4%A7%E9%99%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("重生", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%87%8D%E7%94%9F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("扮猪吃虎", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%89%AE%E7%8C%AA%E5%90%83%E8%99%8E&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("创业", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%88%9B%E4%B8%9A&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("赛博朋克", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%B5%9B%E5%8D%9A%E6%9C%8B%E5%85%8B&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("怪谈", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%80%AA%E8%B0%88&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("甜宠", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%94%9C%E5%AE%A0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("总裁", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%80%BB%E8%A3%81&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("霸道", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%9C%B8%E9%81%93&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("古风", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%A4%E9%A3%8E&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("重生", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%87%8D%E7%94%9F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("名人演讲", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%90%8D%E4%BA%BA%E6%BC%94%E8%AE%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("销售", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%94%80%E5%94%AE&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("学习方法", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%AD%A6%E4%B9%A0%E6%96%B9%E6%B3%95&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("思维训练", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%80%9D%E7%BB%B4%E8%AE%AD%E7%BB%83&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("专注力", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%B8%93%E6%B3%A8%E5%8A%9B&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("悬疑", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%82%AC%E7%96%91&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("武侠", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%AD%A6%E4%BE%A0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("都市", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%83%BD%E5%B8%82&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("历史", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8E%86%E5%8F%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("言情女生", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%A8%80%E6%83%85%E5%A5%B3%E7%94%9F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu2 = new CategoryMenu("相声评书", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("单田芳", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8D%95%E7%94%B0%E8%8A%B3&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("青曲社", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%9D%92%E6%9B%B2%E7%A4%BE&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("单口相声", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8D%95%E5%8F%A3%E7%9B%B8%E5%A3%B0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("名家评书", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%90%8D%E5%AE%B6%E8%AF%84%E4%B9%A6&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("新锐笑将", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%96%B0%E9%94%90%E7%AC%91%E5%B0%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("岳云鹏", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%B2%B3%E4%BA%91%E9%B9%8F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("刘兰芳", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%88%98%E5%85%B0%E8%8A%B3&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("王玥波", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%8E%8B%E7%8E%A5%E6%B3%A2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("郭鹤鸣", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%83%AD%E9%B9%A4%E9%B8%A3&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("武启深", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%AD%A6%E5%90%AF%E6%B7%B1&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("武宗亮", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%AD%A6%E5%AE%97%E4%BA%AE&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("郑思杰", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%83%91%E6%80%9D%E6%9D%B0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("张准", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%BC%A0%E5%87%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("雍正剑侠图", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%9B%8D%E6%AD%A3%E5%89%91%E4%BE%A0%E5%9B%BE&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu3 = new CategoryMenu("悬疑推理", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("侦察推理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BE%A6%E5%AF%9F%E6%8E%A8%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("侦探推理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BE%A6%E6%8E%A2%E6%8E%A8%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("罪案调查", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%BD%AA%E6%A1%88%E8%B0%83%E6%9F%A5&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("逻辑推理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%80%BB%E8%BE%91%E6%8E%A8%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("反转推理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%8D%E8%BD%AC%E6%8E%A8%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("刑侦推理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%88%91%E4%BE%A6%E6%8E%A8%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("破案实录", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%A0%B4%E6%A1%88%E5%AE%9E%E5%BD%95&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("民间怪谈", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%B0%91%E9%97%B4%E6%80%AA%E8%B0%88&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("诡异故事", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%AF%A1%E5%BC%82%E6%95%85%E4%BA%8B&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("都市传说", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%83%BD%E5%B8%82%E4%BC%A0%E8%AF%B4&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("侦探小说", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BE%A6%E6%8E%A2%E5%B0%8F%E8%AF%B4&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("刑侦破案", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%88%91%E4%BE%A6%E7%A0%B4%E6%A1%88&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("法医", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%B3%95%E5%8C%BB&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("记者调查", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%AE%B0%E8%80%85%E8%B0%83%E6%9F%A5&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("剧本", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%89%A7%E6%9C%AC&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("平行时空", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%B9%B3%E8%A1%8C%E6%97%B6%E7%A9%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("黑客", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%BB%91%E5%AE%A2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("科技", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%A7%91%E6%8A%80&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("盗墓笔记", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%9B%97%E5%A2%93%E7%AC%94%E8%AE%B0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu4 = new CategoryMenu("历史", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("中国史", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%B8%AD%E5%9B%BD%E5%8F%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("世界史", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%B8%96%E7%95%8C%E5%8F%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("历史人物", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8E%86%E5%8F%B2%E4%BA%BA%E7%89%A9&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("逸闻趣事", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%80%B8%E9%97%BB%E8%B6%A3%E4%BA%8B&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("文物考古", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%96%87%E7%89%A9%E8%80%83%E5%8F%A4&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("兵法史书", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%85%B5%E6%B3%95%E5%8F%B2%E4%B9%A6&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("历史剧场", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8E%86%E5%8F%B2%E5%89%A7%E5%9C%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("历史小说", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8E%86%E5%8F%B2%E5%B0%8F%E8%AF%B4&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("文明史", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%96%87%E6%98%8E%E5%8F%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("军事历史", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%86%9B%E4%BA%8B%E5%8E%86%E5%8F%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("现当代", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%8E%B0%E5%BD%93%E4%BB%A3&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("民国", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%B0%91%E5%9B%BD&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("宋辽金元", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%AE%8B%E8%BE%BD%E9%87%91%E5%85%83&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("隋唐", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%9A%8B%E5%94%90&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("魏晋", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%AD%8F%E6%99%8B&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("南北朝", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8D%97%E5%8C%97%E6%9C%9D&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("五代十国", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BA%94%E4%BB%A3%E5%8D%81%E5%9B%BD&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("先秦", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%85%88%E7%A7%A6&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("明清", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%98%8E%E6%B8%85&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("三国", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%B8%89%E5%9B%BD&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("秦汉", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%A7%A6%E6%B1%89&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("三十六计", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%B8%89%E5%8D%81%E5%85%AD%E8%AE%A1&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("孙子兵法", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%AD%99%E5%AD%90%E5%85%B5%E6%B3%95&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("史记", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%B2%E8%AE%B0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu5 = new CategoryMenu("个人成长", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("职业技能", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%81%8C%E4%B8%9A%E6%8A%80%E8%83%BD&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("人际沟通", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BA%BA%E9%99%85%E6%B2%9F%E9%80%9A&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("心理调节", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%BF%83%E7%90%86%E8%B0%83%E8%8A%82&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("名人演讲", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%90%8D%E4%BA%BA%E6%BC%94%E8%AE%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("高效管理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%AB%98%E6%95%88%E7%AE%A1%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("女性成长", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%A5%B3%E6%80%A7%E6%88%90%E9%95%BF&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("家庭教育", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%AE%B6%E5%BA%AD%E6%95%99%E8%82%B2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("畅销书", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%95%85%E9%94%80%E4%B9%A6&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("名企大咖", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%90%8D%E4%BC%81%E5%A4%A7%E5%92%96&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("成功励志", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%88%90%E5%8A%9F%E5%8A%B1%E5%BF%97&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("时间管理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%97%B6%E9%97%B4%E7%AE%A1%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("自律习惯", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%87%AA%E5%BE%8B%E4%B9%A0%E6%83%AF&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("情商提升", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%83%85%E5%95%86%E6%8F%90%E5%8D%87&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("领导力", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%A2%86%E5%AF%BC%E5%8A%9B&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("职场", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%81%8C%E5%9C%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("心理学", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%BF%83%E7%90%86%E5%AD%A6&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("演讲口才", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%BC%94%E8%AE%B2%E5%8F%A3%E6%89%8D&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("谈判技巧", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%B0%88%E5%88%A4%E6%8A%80%E5%B7%A7&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("社交礼仪", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%A4%BE%E4%BA%A4%E7%A4%BC%E4%BB%AA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("情绪管理", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%83%85%E7%BB%AA%E7%AE%A1%E7%90%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("情感修复", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%83%85%E6%84%9F%E4%BF%AE%E5%A4%8D&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("健康习惯", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%81%A5%E5%BA%B7%E4%B9%A0%E6%83%AF&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("极简生活", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%9E%81%E7%AE%80%E7%94%9F%E6%B4%BB&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("科技创新", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%A7%91%E6%8A%80%E5%88%9B%E6%96%B0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu6 = new CategoryMenu("广播剧", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("现代言情", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%8E%B0%E4%BB%A3%E8%A8%80%E6%83%85&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("古风言情", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%A4%E9%A3%8E%E8%A8%80%E6%83%85&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("有声漫画", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%9C%89%E5%A3%B0%E6%BC%AB%E7%94%BB&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("心动剧场", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%BF%83%E5%8A%A8%E5%89%A7%E5%9C%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("国风剧场", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%9B%BD%E9%A3%8E%E5%89%A7%E5%9C%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("尖声剧场", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%B0%96%E5%A3%B0%E5%89%A7%E5%9C%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu7 = new CategoryMenu("娱乐", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("奇闻怪谈", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%A5%87%E9%97%BB%E6%80%AA%E8%B0%88&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("八卦", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%85%AB%E5%8D%A6&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("脱口秀", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%84%B1%E5%8F%A3%E7%A7%80&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("综艺", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%BB%BC%E8%89%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("刑侦探案", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%88%91%E4%BE%A6%E6%8E%A2%E6%A1%88&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu8 = new CategoryMenu("头条", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("民生", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%B0%91%E7%94%9F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("财经", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%B4%A2%E7%BB%8F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("科技", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%A7%91%E6%8A%80&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("娱乐", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%A8%B1%E4%B9%90&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("传记", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%BC%A0%E8%AE%B0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("足球", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%B6%B3%E7%90%83&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("篮球", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%AF%AE%E7%90%83&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu9 = new CategoryMenu("商业财经", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("大咖评论", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%A4%A7%E5%92%96%E8%AF%84%E8%AE%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("投资理财", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%8A%95%E8%B5%84%E7%90%86%E8%B4%A2&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("证券市场", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%AF%81%E5%88%B8%E5%B8%82%E5%9C%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("创投创业", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%88%9B%E6%8A%95%E5%88%9B%E4%B8%9A&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("商业经管", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%95%86%E4%B8%9A%E7%BB%8F%E7%AE%A1&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu10 = new CategoryMenu("音乐", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("催眠", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%82%AC%E7%9C%A0&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("新歌", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%96%B0%E6%AD%8C&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("经典老歌", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%BB%8F%E5%85%B8%E8%80%81%E6%AD%8C&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("翻唱", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%BF%BB%E5%94%B1&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("古典", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%A4%E5%85%B8&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("古风", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%A4%E9%A3%8E&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("纯音乐", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%BA%AF%E9%9F%B3%E4%B9%90&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("怀旧", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%80%80%E6%97%A7&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("影视", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%BD%B1%E8%A7%86&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("欧美", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%AC%A7%E7%BE%8E&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("民谣", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%B0%91%E8%B0%A3&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("日韩", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%97%A5%E9%9F%A9&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("创作达人", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%88%9B%E4%BD%9C%E8%BE%BE%E4%BA%BA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        CategoryMenu menu11 = new CategoryMenu("健康养生", CollectionsKt.listOf(new CategoryTab[]{new CategoryTab("黄帝内经", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E9%BB%84%E5%B8%9D%E5%86%85%E7%BB%8F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("吃出健康", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%90%83%E5%87%BA%E5%81%A5%E5%BA%B7&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("我要减肥", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E6%88%91%E8%A6%81%E5%87%8F%E8%82%A5&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("十月妈咪", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8D%81%E6%9C%88%E5%A6%88%E5%92%AA&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("两性奥秘", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%B8%A4%E6%80%A7%E5%A5%A5%E7%A7%98&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("运动健身", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%BF%90%E5%8A%A8%E5%81%A5%E8%BA%AB&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("中医养生", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E4%B8%AD%E5%8C%BB%E5%85%BB%E7%94%9F&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("心灵解压", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%BF%83%E7%81%B5%E8%A7%A3%E5%8E%8B&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("古法艾灸", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%8F%A4%E6%B3%95%E8%89%BE%E7%81%B8&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("轻松入睡", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E8%BD%BB%E6%9D%BE%E5%85%A5%E7%9D%A1&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("健康宝宝", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E5%81%A5%E5%BA%B7%E5%AE%9D%E5%AE%9D&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"), new CategoryTab("美丽驻颜", "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=%E7%BE%8E%E4%B8%BD%E9%A9%BB%E9%A2%9C&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15")}));
        return CollectionsKt.listOf(new CategoryMenu[]{menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9, menu10, menu11});
    }

    public Category getCategoryList(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Triple result = FuelJsonKt.responseJson(RequestFactory.Convenience.DefaultImpls.get$default(Fuel.INSTANCE, url, (List) null, 2, (Object) null));
        JSONObject jsonObject = ((FuelJson) ((Result) result.getThird()).get()).obj();
        ArrayList list = new ArrayList();
        try {
            JSONArray data = jsonObject.getJSONArray("data");
            Iterable $this$forEach$iv = RangesKt.until(0, data.length());
            int $i$f$forEach = 0;
            Iterator it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                int element$iv = ((IntIterator) it).nextInt();
                JSONObject book = data.getJSONObject(element$iv);
                String coverUrl = book.getString("coverImageUrl");
                JSONArray data2 = data;
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                int $i$f$forEach2 = $i$f$forEach;
                String bookUrl = "https://api.yituwenhua.com/api/json/v1/albums_browse_search?album_id=" + book.getInt("novelId");
                String title = book.getString("novelName");
                String artist = book.getString("presenter");
                String intro = book.getString("description");
                Iterator it2 = it;
                String status = book.getString("novelStatus");
                Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(artist, "artist");
                Book $this$getCategoryList_u24lambda_u243_u24lambda_u242 = new Book(coverUrl, bookUrl, title, "", artist);
                $this$getCategoryList_u24lambda_u243_u24lambda_u242.setSourceId(INSTANCE.getSourceId());
                Intrinsics.checkNotNullExpressionValue(intro, "intro");
                $this$getCategoryList_u24lambda_u243_u24lambda_u242.setIntro(intro);
                Intrinsics.checkNotNullExpressionValue(status, "status");
                $this$getCategoryList_u24lambda_u243_u24lambda_u242.setStatus(status);
                list.add($this$getCategoryList_u24lambda_u243_u24lambda_u242);
                data = data2;
                $this$forEach$iv = $this$forEach$iv2;
                $i$f$forEach = $i$f$forEach2;
                it = it2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Category(list, 1, 1, url, "");
    }

    public BookDetail getBookDetailInfo(String bookUrl, boolean loadEpisodes, boolean loadFullPages) {
        Intrinsics.checkNotNullParameter(bookUrl, "bookUrl");
        ArrayList list = new ArrayList();
        if (loadEpisodes) {
            Triple result = FuelJsonKt.responseJson(RequestFactory.Convenience.DefaultImpls.get$default(Fuel.INSTANCE, bookUrl, (List) null, 2, (Object) null));
            JSONObject jsonObject = ((FuelJson) ((Result) result.getThird()).get()).obj();
            try {
                JSONArray data = jsonObject.getJSONArray("data");
                Iterable $this$forEach$iv = RangesKt.until(0, data.length());
                IntIterator it = $this$forEach$iv.iterator();
                while (it.hasNext()) {
                    int element$iv = it.nextInt();
                    JSONObject book = data.getJSONObject(element$iv);
                    String title = book.getString("chapterName");
                    String href = book.getString("playUrl");
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(href, "href");
                    list.add(new Episode(title, href));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new BookDetail(list, (String) null, (String) null, (String) null, 0, (String) null, 62, (DefaultConstructorMarker) null);
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.contains$default(coverUrl, "imgopen.xmcdn.com/", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://imgopen.xmcdn.com/");
        return true;
    }
}
