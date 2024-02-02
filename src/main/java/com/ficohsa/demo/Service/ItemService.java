package com.ficohsa.demo.Service;

import com.ficohsa.demo.Exception.ItemNotFoundException;
import com.ficohsa.demo.Model.GetItemByIdResponse;
import com.ficohsa.demo.Model.GetItemsByTextResponse;
import com.ficohsa.demo.Model.Item;
import com.ficohsa.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public GetItemsByTextResponse getItemsByText(String text) {
        List<Item> listItems = itemRepository.findByTextContaining(text);
        if (listItems != null && !listItems.isEmpty()) {
            return new GetItemsByTextResponse(listItems, null);
        } else {
            throw new ItemNotFoundException("No se encontraron items");
        }
    }

    public GetItemByIdResponse getItemById(Long searchId) throws Exception {
        Optional<Item> item = itemRepository.findById(searchId);
        if (item.isPresent()) {
            return new GetItemByIdResponse(item, null);
        } else {
            throw new ItemNotFoundException("No se encontró el item");
        }
    }
}


