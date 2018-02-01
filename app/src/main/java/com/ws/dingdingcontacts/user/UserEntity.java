package com.ws.dingdingcontacts.user;

import me.yokeyword.indexablerv.IndexableEntity;

public class UserEntity implements IndexableEntity {
    private String nick;
    private String avatar;
    private String mobile;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity(String nick, String id) {
        this.nick = nick;
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String name) {
        this.nick = name;
    }

    @Override
    public String getFieldIndexBy() {
        return nick;
    }

    @Override
    public void setFieldIndexBy(String indexField) {
        this.nick = indexField;
    }

    @Override
    public void setFieldPinyinIndexBy(String pinyin) {
        // 需要用到拼音时(比如:搜索), 可增添pinyin字段 this.pinyin  = pinyin
        // 见 CityEntity
    }
}
