package com.example.bhargavipatel.projectfinal3.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent2 {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;


    public static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content1;
        public final String content2;
        public final String content3;
        public final String content4;
        public final String content5;
        public final String content6;
        public final String content7;
        public  String list_imageview;

        public DummyItem(String id, String content1, String content2, String content3,
                         String content4,String content5,String content6, String content7, String list_imageview) {
            this.id = id;
            this.content1 = content1;
            this.content2 = content2;
            this.content3 = content3;
            this.content4 = content4;
            this.content5 = content5;
            this.content6 = content6;
            this.content7 = content7;
            this.list_imageview = list_imageview;

        }

        @Override
        public String toString() {
            return content1;
        }
    }
}
