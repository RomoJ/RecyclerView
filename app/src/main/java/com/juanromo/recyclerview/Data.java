package com.juanromo.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final String sampleName = "Lorem ipsum dolor";
    private static final String sampleDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                                                    "Morbi id pulvinar lorem, ut placerat risus. Nulla facilisi.";

    private Data() {
    }

    public static List<Item> getData() {
        List<Item> itemList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.setId(i);
            item.setName(sampleName);
            item.setDescription(sampleDescription);
            item.setIconResId(getIconResId(i));
            itemList.add(item);
        }

        return itemList;
    }

    private static int getIconResId(int itemId) {
        int resId = itemId % 5;

        switch (resId) {
            case 0:
                return R.drawable.ic_casino_black_24dp;
            case 1:
                return R.drawable.ic_fitness_center_black_24dp;
            case 2:
                return R.drawable.ic_golf_course_black_24dp;
            case 3:
                return R.drawable.ic_pool_black_24dp;
            case 4:
                return R.drawable.ic_spa_black_24dp;
            default:
                return R.drawable.ic_casino_black_24dp;
        }
    }
}
