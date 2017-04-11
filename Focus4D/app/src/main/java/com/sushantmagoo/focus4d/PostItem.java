package com.sushantmagoo.focus4d;

import java.util.Arrays;

public class PostItem {

    String type; // IMAGE , HORIZONTAL_IMAGE_LIST , CONTENT
    String title;
    Data[] data;

    public PostItem(String type, String title, Data[] data_arr) {
        this.type = type;
        this.title = title;
        this.data = data_arr;
    }

    @Override
    public String toString() {
        return "PostItem{"
                + "type='"
                + type
                + '\''
                + ", title='"
                + title
                + '\''
                + ", data="
                + Arrays.toString(data)
                + '}';
    }

    public boolean isSuggestion() {
        return "HORIZONTAL_IMAGE_LIST".equalsIgnoreCase(type);
    }
}
