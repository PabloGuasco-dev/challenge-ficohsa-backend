package com.ficohsa.demo.Model;

import java.util.Optional;

public class GetItemByIdResponse {
    private Optional<Item> item;
    private String message;

    public GetItemByIdResponse(Optional<Item> item, String message) {
        this.item = item;
        this.message = message;
    }

    public Optional<Item> getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = Optional.ofNullable(item);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
