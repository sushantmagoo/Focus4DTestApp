package com.sushantmagoo.focus4d;

class Data {

    String name;
    String profile_img_url;
    String question;
    String posted_on;
    String card_img_url;
    String title;
    String followers;
    String img_url;

    public Data(String name, String profile_img_url, String question, String posted_on,
                String title, String followers, String card_img_url, String img_url) {
        this.name = name;
        this.profile_img_url = profile_img_url;
        this.question = question;
        this.posted_on = posted_on;
        this.title = title;
        this.followers = followers;
        this.card_img_url = card_img_url;
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Data{"
                + "name='"
                + name
                + '\''
                + ", profile_img_url='"
                + profile_img_url
                + '\''
                + ", question='"
                + question
                + '\''
                + ", posted_on='"
                + posted_on
                + '\''
                + ", card_img_url='"
                + card_img_url
                + '\''
                + ", title='"
                + title
                + '\''
                + ", followers='"
                + followers
                + '\''
                + ", img_url='"
                + img_url
                + '\''
                + '}';
    }
}
