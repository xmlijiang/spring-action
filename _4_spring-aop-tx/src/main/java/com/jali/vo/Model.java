package com.jali.vo;

/**
 * @author lijiang
 * @create 2021-03-07 21:45
 */
public class Model {

    private String id_;
    private String name_;
    private String key_;

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getKey_() {
        return key_;
    }

    public void setKey_(String key_) {
        this.key_ = key_;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id_='" + id_ + '\'' +
                ", name_='" + name_ + '\'' +
                ", key_='" + key_ + '\'' +
                '}';
    }
}
