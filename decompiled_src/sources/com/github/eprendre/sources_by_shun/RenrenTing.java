package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.sources.AudioUrlCustomExtractor;
import com.github.eprendre.tingshu.sources.AudioUrlExtractor;
import com.github.eprendre.tingshu.sources.CoverUrlExtraHeaders;
import com.github.eprendre.tingshu.sources.TingShu;
import com.github.eprendre.tingshu.utils.Book;
import com.github.eprendre.tingshu.utils.Category;
import com.github.eprendre.tingshu.utils.CategoryMenu;
import com.github.eprendre.tingshu.utils.CategoryTab;
import com.github.eprendre.tingshu.utils.ExternalSourcePrefs;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.RequestFactory;
import com.github.kittinunf.fuel.json.FuelJson;
import com.github.kittinunf.fuel.json.FuelJsonKt;
import com.github.kittinunf.result.Result;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RenrenTing.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\u0016\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005J*\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u0007\u0012\u0004\u0012\u000202002\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000202H\u0016¨\u00065"}, d2 = {"Lcom/github/eprendre/sources_by_shun/RenrenTing;", "Lcom/github/eprendre/tingshu/sources/TingShu;", "Lcom/github/eprendre/tingshu/sources/CoverUrlExtraHeaders;", "()V", "accessToken", "", "buildCategoryTabs", "", "Lcom/github/eprendre/tingshu/utils/CategoryTab;", "list", "coverHeaders", "", "coverUrl", "headers", "", "getAudioUrlExtractor", "Lcom/github/eprendre/tingshu/sources/AudioUrlExtractor;", "getBookDetailInfo", "Lcom/github/eprendre/tingshu/utils/BookDetail;", "bookUrl", "loadEpisodes", "loadFullPages", "getCategoryList", "Lcom/github/eprendre/tingshu/utils/Category;", "url", "getCategoryMenus", "Lcom/github/eprendre/tingshu/utils/CategoryMenu;", "getDesc", "getMyVar", "key", "defaultValue", "getName", "getSig", "word", "getSourceId", "getUrl", "hmacSha1", "", "data", "md5", "input", "playUrl", "trackId", "processAudioRequest", "putMyVar", "", "value", "search", "Lkotlin/Pair;", "Lcom/github/eprendre/tingshu/utils/Book;", "", "keywords", "page", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenrenTing extends TingShu implements CoverUrlExtraHeaders {
    public static final RenrenTing INSTANCE = new RenrenTing();

    private RenrenTing() {
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
            Iterable $this$forEach$iv = RangesKt.until(0, Math.min(50, data.length()));
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
        AudioUrlCustomExtractor.INSTANCE.setUp(new Function1<String, String>() { // from class: com.github.eprendre.sources_by_shun.RenrenTing$getAudioUrlExtractor$1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (StringsKt.contains$default(it, "http", false, 2, (Object) null)) {
                    return it;
                }
                return RenrenTing.INSTANCE.processAudioRequest(it);
            }
        });
        return AudioUrlCustomExtractor.INSTANCE;
    }

    public final List<CategoryTab> buildCategoryTabs(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<String> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(new CategoryTab(it, "https://api.yituwenhua.com/api/json/v1/MultiSearch?keyword=" + URLEncoder.encode(it, "utf-8") + "&fromLy=tag&apiLy=xmly&pageNum=1&pageSize=15"));
        }
        return (List) destination$iv$iv;
    }

    public List<CategoryMenu> getCategoryMenus() {
        List list = CollectionsKt.listOf(new String[]{"言情", "健身", "同人", "幻想", "网游", "都市重生", "文学名著", "历史专区", "国家经典", "电竞", "虚拟现实", "历史纵横", "有声漫", "看小说", "大家都在追", "豪门恋情", "古风言情", "宫闱宅斗", "传记", "修真", "仙侠", "异世大陆", "重生", "扮猪吃虎", "创业", "赛博朋克", "怪谈", "甜宠", "总裁", "霸道", "古风", "重生", "名人演讲", "销售", "学习方法", "思维训练", "专注力", "悬疑", "武侠", "都市", "历史", "言情女生"});
        CategoryMenu menu1 = new CategoryMenu("有声书", buildCategoryTabs(list));
        List list2 = CollectionsKt.listOf(new String[]{"单田芳", "青曲社", "单口相声", "名家评书", "新锐笑将", "岳云鹏", "刘兰芳", "王玥波", "郭鹤鸣", "武启深", "武宗亮", "郑思杰", "张准", "雍正剑侠图"});
        CategoryMenu menu2 = new CategoryMenu("相声评书", buildCategoryTabs(list2));
        List list3 = CollectionsKt.listOf(new String[]{"侦察推理", "侦探推理", "罪案调查", "逻辑推理", "反转推理", "刑侦推理", "破案实录", "民间怪谈", "诡异故事", "都市传说", "侦探小说", "刑侦破案", "法医", "记者调查", "剧本", "平行时空", "黑客", "科技", "盗墓笔记"});
        CategoryMenu menu3 = new CategoryMenu("悬疑推理", buildCategoryTabs(list3));
        List list4 = CollectionsKt.listOf(new String[]{"中国史", "世界史", "历史人物", "逸闻趣事", "文物考古", "兵法史书", "历史剧场", "历史小说", "文明史", "军事历史", "现当代", "民国", "宋辽金元", "隋唐", "魏晋", "南北朝", "五代十国", "先秦", "明清", "三国", "秦汉", "三十六计", "孙子兵法", "史记"});
        CategoryMenu menu4 = new CategoryMenu("历史", buildCategoryTabs(list4));
        List list5 = CollectionsKt.listOf(new String[]{"职业技能", "人际沟通", "心理调节", "名人演讲", "高效管理", "女性成长", "家庭教育", "畅销书", "名企大咖", "成功励志", "时间管理", "自律习惯", "情商提升", "领导力", "职场", "心理学", "演讲口才", "谈判技巧", "社交礼仪", "情绪管理", "情感修复", "健康习惯", "极简生活", "科技创新"});
        CategoryMenu menu5 = new CategoryMenu("个人成长", buildCategoryTabs(list5));
        List list6 = CollectionsKt.listOf(new String[]{"现代言情", "古风言情", "有声漫画", "心动剧场", "国风剧场", "尖声剧场"});
        CategoryMenu menu6 = new CategoryMenu("广播剧", buildCategoryTabs(list6));
        List list7 = CollectionsKt.listOf(new String[]{"奇闻怪谈", "八卦", "脱口秀", "综艺", "刑侦探案"});
        List list8 = buildCategoryTabs(list7);
        CategoryMenu menu7 = new CategoryMenu("娱乐", list8);
        List list82 = CollectionsKt.listOf(new String[]{"民生", "财经", "科技", "娱乐", "传记", "足球", "篮球"});
        List list62 = buildCategoryTabs(list82);
        CategoryMenu menu8 = new CategoryMenu("头条", list62);
        List list9 = CollectionsKt.listOf(new String[]{"大咖评论", "投资理财", "证券市场", "创投创业", "商业经管"});
        List list52 = buildCategoryTabs(list9);
        CategoryMenu menu9 = new CategoryMenu("商业财经", list52);
        List list10 = CollectionsKt.listOf(new String[]{"催眠", "新歌", "经典老歌", "翻唱", "古典", "古风", "纯音乐", "怀旧", "影视", "欧美", "民谣", "日韩", "创作达人"});
        List list42 = buildCategoryTabs(list10);
        CategoryMenu menu10 = new CategoryMenu("音乐", list42);
        List list11 = CollectionsKt.listOf(new String[]{"黄帝内经", "吃出健康", "我要减肥", "十月妈咪", "两性奥秘", "运动健身", "中医养生", "心灵解压", "古法艾灸", "轻松入睡", "健康宝宝", "美丽驻颜"});
        List list22 = buildCategoryTabs(list11);
        CategoryMenu menu11 = new CategoryMenu("健康养生", list22);
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
                Book $this$getCategoryList_u24lambda_u244_u24lambda_u243 = new Book(coverUrl, bookUrl, title, "", artist);
                $this$getCategoryList_u24lambda_u244_u24lambda_u243.setSourceId(INSTANCE.getSourceId());
                Intrinsics.checkNotNullExpressionValue(intro, "intro");
                $this$getCategoryList_u24lambda_u244_u24lambda_u243.setIntro(intro);
                Intrinsics.checkNotNullExpressionValue(status, "status");
                $this$getCategoryList_u24lambda_u244_u24lambda_u243.setStatus(status);
                list.add($this$getCategoryList_u24lambda_u244_u24lambda_u243);
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
    
        if ((r0.length() == 0) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.github.eprendre.tingshu.utils.BookDetail getBookDetailInfo(java.lang.String r19, boolean r20, boolean r21) {
        /*
            r18 = this;
            r1 = r19
            java.lang.String r0 = "bookUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = r0
            if (r20 == 0) goto Lc0
            com.github.kittinunf.fuel.Fuel r0 = com.github.kittinunf.fuel.Fuel.INSTANCE
            com.github.kittinunf.fuel.core.RequestFactory$Convenience r0 = (com.github.kittinunf.fuel.core.RequestFactory.Convenience) r0
            r3 = 2
            r4 = 0
            com.github.kittinunf.fuel.core.Request r0 = com.github.kittinunf.fuel.core.RequestFactory.Convenience.DefaultImpls.get$default(r0, r1, r4, r3, r4)
            kotlin.Triple r0 = com.github.kittinunf.fuel.json.FuelJsonKt.responseJson(r0)
            r3 = r0
            java.lang.Object r0 = r3.getThird()
            com.github.kittinunf.result.Result r0 = (com.github.kittinunf.result.Result) r0
            java.lang.Object r0 = r0.get()
            com.github.kittinunf.fuel.json.FuelJson r0 = (com.github.kittinunf.fuel.json.FuelJson) r0
            org.json.JSONObject r4 = r0.obj()
            java.lang.String r0 = "data"
            org.json.JSONArray r0 = r4.getJSONArray(r0)     // Catch: java.lang.Exception -> Lba
            int r5 = r0.length()     // Catch: java.lang.Exception -> Lba
            r6 = 0
            kotlin.ranges.IntRange r5 = kotlin.ranges.RangesKt.until(r6, r5)     // Catch: java.lang.Exception -> Lba
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Exception -> Lba
            r7 = 0
            java.util.Iterator r8 = r5.iterator()     // Catch: java.lang.Exception -> Lba
        L45:
            boolean r9 = r8.hasNext()     // Catch: java.lang.Exception -> Lba
            if (r9 == 0) goto Lb5
            r9 = r8
            kotlin.collections.IntIterator r9 = (kotlin.collections.IntIterator) r9     // Catch: java.lang.Exception -> Lba
            int r9 = r9.nextInt()     // Catch: java.lang.Exception -> Lba
            r10 = r9
            r11 = 0
            org.json.JSONObject r12 = r0.getJSONObject(r10)     // Catch: java.lang.Exception -> Lba
            java.lang.String r13 = "chapterName"
            java.lang.String r13 = r12.getString(r13)     // Catch: java.lang.Exception -> Lba
            java.lang.String r14 = "chapterId"
            long r14 = r12.getLong(r14)     // Catch: java.lang.Exception -> Lba
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch: java.lang.Exception -> Lba
            java.lang.String r15 = "playUrl"
            java.lang.String r15 = r12.optString(r15)     // Catch: java.lang.Exception -> Lba
            r16 = r15
            java.lang.String r6 = "null"
            r17 = r0
            r0 = r16
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> Lba
            java.lang.String r1 = "episodeUrl"
            if (r6 != 0) goto L94
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L90
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch: java.lang.Exception -> L90
            int r6 = r6.length()     // Catch: java.lang.Exception -> L90
            if (r6 != 0) goto L8c
            r6 = 1
            goto L8d
        L8c:
            r6 = 0
        L8d:
            if (r6 == 0) goto L98
            goto L94
        L90:
            r0 = move-exception
            r16 = r3
            goto Lbd
        L94:
            r16 = r14
            r0 = r16
        L98:
            com.github.eprendre.tingshu.utils.Episode r6 = new com.github.eprendre.tingshu.utils.Episode     // Catch: java.lang.Exception -> Lba
            r16 = r3
            java.lang.String r3 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)     // Catch: java.lang.Exception -> Lb3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> Lb3
            r6.<init>(r13, r0)     // Catch: java.lang.Exception -> Lb3
            r2.add(r6)     // Catch: java.lang.Exception -> Lb3
            r1 = r19
            r3 = r16
            r0 = r17
            r6 = 0
            goto L45
        Lb3:
            r0 = move-exception
            goto Lbd
        Lb5:
            r17 = r0
            r16 = r3
            goto Lc0
        Lba:
            r0 = move-exception
            r16 = r3
        Lbd:
            r0.printStackTrace()
        Lc0:
            com.github.eprendre.tingshu.utils.BookDetail r0 = new com.github.eprendre.tingshu.utils.BookDetail
            r6 = r2
            java.util.List r6 = (java.util.List) r6
            r12 = 62
            r13 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.eprendre.sources_by_shun.RenrenTing.getBookDetailInfo(java.lang.String, boolean, boolean):com.github.eprendre.tingshu.utils.BookDetail");
    }

    public boolean coverHeaders(String coverUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.contains$default(coverUrl, "imgopen.xmcdn.com/", false, 2, (Object) null)) {
            return false;
        }
        headers.put("referer", "https://www.ximalaya.com");
        return true;
    }

    public final String processAudioRequest(String trackId) {
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        try {
            String url = playUrl(trackId);
            return url;
        } catch (Exception e) {
            accessToken();
            String url2 = playUrl(trackId);
            return url2;
        }
    }

    public final String getSig(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = word.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String base64Word = encoder.encodeToString(bytes);
        Intrinsics.checkNotNullExpressionValue(base64Word, "base64Word");
        byte[] hmacResult = hmacSha1(base64Word, "5C859D4BBB59941DF0F5B4C3F4FB632B");
        return md5(hmacResult);
    }

    public final String accessToken() {
        long time = new Date().getTime() / 1000;
        String t13 = String.valueOf(time);
        String sig11 = getSig("app_key=046abd5f15cb438eb4eecceaad8ff430&client_os_type=2&device_id=n81l1b&device_id_type=UUID&mobile=13598659143&nonce=Tq2wJXuz&sn=111123_00_1001123&timestamp=" + t13 + "&version=1.1.2");
        Triple result = FuelJsonKt.responseJson(Fuel.INSTANCE.post("https://api.ximalaya.com/ximalayaos-openapi-xm/bff/oauth2/mobile_user", CollectionsKt.listOf(new Pair[]{TuplesKt.to("app_key", "046abd5f15cb438eb4eecceaad8ff430"), TuplesKt.to("client_os_type", "2"), TuplesKt.to("device_id", "n81l1b"), TuplesKt.to("sn", "111123_00_1001123"), TuplesKt.to("version", "1.1.2"), TuplesKt.to("nonce", "Tq2wJXuz"), TuplesKt.to("timestamp", t13), TuplesKt.to("device_id_type", "UUID"), TuplesKt.to("mobile", "13598659143"), TuplesKt.to("sig", sig11)})));
        String accessToken = ((FuelJson) ((Result) result.getThird()).get()).obj().getJSONObject("data").getString("access_token");
        Intrinsics.checkNotNullExpressionValue(accessToken, "accessToken");
        putMyVar("accesstoken", accessToken);
        return accessToken;
    }

    public final String playUrl(String trackId) {
        Intrinsics.checkNotNullParameter(trackId, "trackId");
        long time = new Date().getTime() / 1000;
        String t13 = String.valueOf(time);
        String currentAccessToken = getMyVar("accesstoken", "ecc624e7a1c45d1951b69988d9d23220");
        String sig12 = getSig("access_token=" + currentAccessToken + "&app_key=046abd5f15cb438eb4eecceaad8ff430&client_os_type=2&device_id=n81l1b&device_id_type=UUID&nonce=Pi1nYEva&should_consider_vip=true&sn=111123_00_1001123&timestamp=" + t13 + "&track_id=" + trackId + "&version=1.1.2");
        String url = "https://api.ximalaya.com/elderly-ximalayaos-api/openapi-fmxos/open_pay/get_play_info?app_key=046abd5f15cb438eb4eecceaad8ff430&client_os_type=2&device_id=n81l1b&sn=111123_00_1001123&version=1.1.2&nonce=Pi1nYEva&timestamp=" + t13 + "&device_id_type=UUID&access_token=" + currentAccessToken + "&should_consider_vip=true&track_id=" + trackId + "&sig=" + sig12;
        JSONObject html12 = ((FuelJson) ((Result) FuelJsonKt.responseJson(RequestFactory.Convenience.DefaultImpls.get$default(Fuel.INSTANCE, url, (List) null, 2, (Object) null)).getThird()).get()).obj();
        String string = html12.getString("play_url_64_mp3");
        Intrinsics.checkNotNullExpressionValue(string, "html12.getString(\"play_url_64_mp3\")");
        return string;
    }

    public final byte[] hmacSha1(String data, String key) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] bytes = key.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeySpec signingKey = new SecretKeySpec(bytes, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        byte[] bytes2 = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] doFinal = mac.doFinal(bytes2);
        Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(data.toByteArray())");
        return doFinal;
    }

    public final String md5(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input);
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        String str = "";
        for (byte element$iv : digest) {
            String str2 = str;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(element$iv)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            str = str2 + format;
        }
        return str;
    }

    public final void putMyVar(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ExternalSourcePrefs.INSTANCE.putString(getSourceId() + "_" + key, value);
    }

    public final String getMyVar(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String string = ExternalSourcePrefs.INSTANCE.getString(getSourceId() + "_" + key, defaultValue);
        return string == null ? "" : string;
    }
}
