package com.ws.dingdingcontacts.search;

import me.yokeyword.indexablerv.IndexableEntity;

/**
 * Created by ws on 2018/1/31.
 */

public class SearchBean implements IndexableEntity {

    private String name;
    private String pinyin;
    private String id;

    public SearchBean() {
    }

    public SearchBean(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public SearchBean(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String getFieldIndexBy() {
        return name;
    }

    @Override
    public void setFieldIndexBy(String indexByField) {
        this.name = indexByField;
    }

    @Override
    public void setFieldPinyinIndexBy(String pinyin) {
        this.pinyin = pinyin;
    }
}
