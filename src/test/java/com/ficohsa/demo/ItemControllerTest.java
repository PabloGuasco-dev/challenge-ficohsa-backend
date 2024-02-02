package com.ficohsa.demo;

import com.ficohsa.demo.Controller.ItemController;
import com.ficohsa.demo.Exception.ItemNotFoundException;
import com.ficohsa.demo.Model.GetItemsByTextResponse;
import com.ficohsa.demo.Service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetItemsByTextSuccess() {
        // Configurar comportamiento del servicio mock
        when(itemService.getItemsByText("text")).thenReturn(new GetItemsByTextResponse(new ArrayList<>(), null));

        // Llamar al método del controlador
        ResponseEntity<GetItemsByTextResponse> responseEntity = itemController.getItemsByText("text");

        // Verificar que se llamó al servicio mock
        verify(itemService, times(1)).getItemsByText("text");

        // Verificar el código de estado y el cuerpo de la respuesta
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetItemsByTextItemNotFoundException() {
        // Configurar comportamiento del servicio mock
        when(itemService.getItemsByText("texto")).thenThrow(new ItemNotFoundException("Item not found"));

        // Llamar al método del controlador
        ResponseEntity<GetItemsByTextResponse> responseEntity = itemController.getItemsByText("texto");

        // Verificar que se llamó al servicio mock
        verify(itemService, times(1)).getItemsByText("texto");

        // Verificar el código de estado y el cuerpo de la respuesta
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

}
