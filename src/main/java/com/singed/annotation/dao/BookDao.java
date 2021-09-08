package com.singed.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author : Singed
 * @Date : 2021/9/7 20:33
 */
@Repository
public class BookDao {
    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
