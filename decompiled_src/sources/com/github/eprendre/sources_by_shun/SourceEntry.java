package com.github.eprendre.sources_by_shun;

import com.github.eprendre.tingshu.sources.TingShu;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* compiled from: SourceEntry.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/github/eprendre/sources_by_shun/SourceEntry;", "", "()V", "getCategory", "", "getDesc", "getSources", "", "Lcom/github/eprendre/tingshu/sources/TingShu;", "CustomSources"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SourceEntry {
    public static final SourceEntry INSTANCE = new SourceEntry();

    private SourceEntry() {
    }

    @JvmStatic
    public static final String getDesc() {
        return "shun_听书源";
    }

    @JvmStatic
    public static final String getCategory() {
        return "听书";
    }

    @JvmStatic
    public static final List<TingShu> getSources() {
        return CollectionsKt.listOf(new TingShu[]{XiaoaiTing2.INSTANCE, TingZg.INSTANCE, YiyeHuanting.INSTANCE, LetingBa.INSTANCE, QuanMinTsW.INSTANCE, YoutingWang.INSTANCE, QilingTs.INSTANCE, NiantingWang.INSTANCE, RenrenTing.INSTANCE});
    }
}
