package com.ficohsa.demo.Model;

import java.util.List;

public class GetItemsByTextResponse {
    private List<Item> listItem;
    private String message;

    public GetItemsByTextResponse(List<Item> listItem, String message) {
        this.listItem = listItem;
        this.message = message;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
