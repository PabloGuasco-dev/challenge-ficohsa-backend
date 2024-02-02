package com.ficohsa.demo.Controller;

import com.ficohsa.demo.Exception.ItemNotFoundException;
import com.ficohsa.demo.Model.GetItemByIdResponse;
import com.ficohsa.demo.Model.GetItemsByTextResponse;
import com.ficohsa.demo.Service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/items")
@Api(value = "ItemController", description = "Operaciones relacionadas con los items")
public class ItemController {

    private final ItemService itemService;


    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene items por texto", response = GetItemsByTextResponse.class)
    public ResponseEntity<GetItemsByTextResponse> getItemsByText(@RequestParam String texto) {
        try {
            GetItemsByTextResponse response = itemService.getItemsByText(texto);
            return ResponseEntity.ok(response);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GetItemsByTextResponse(null, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GetItemsByTextResponse(null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un item por ID", response = GetItemByIdResponse.class)
    public ResponseEntity<GetItemByIdResponse> getItemById(@PathVariable Long id) {
        try {
            GetItemByIdResponse response = itemService.getItemById(id);
            return ResponseEntity.ok(response);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GetItemByIdResponse(null, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GetItemByIdResponse(null, e.getMessage()));
        }
    }
}
