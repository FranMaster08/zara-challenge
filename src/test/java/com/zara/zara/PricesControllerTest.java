package com.zara.zara;

import com.zara.zara.controllers.PricesController;
import com.zara.zara.dto.PricesDto;
import com.zara.zara.entities.Brands;
import com.zara.zara.entities.Prices;
import com.zara.zara.entities.Products;
import com.zara.zara.repository.PricesRepository;
import com.zara.zara.responses.PricesResponses;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesControllerTest {

    @InjectMocks
    private PricesController pricesController;

    @Mock
    private PricesRepository pricesRepository;

    @Test
    public void testGetLatestPriceCase1() {
        PricesDto pricesDto = new PricesDto();
        pricesDto.setApplicationDate(LocalDateTime.of(2023, 1, 14, 10, 0));
        pricesDto.setProductId("35455");
        pricesDto.setBrandId(1L);

        Brands mockBrand = new Brands();
        mockBrand.setId(1L); // ID de marca
        mockBrand.setName("BrandName"); // Nombre de marca

        Products mockProduct = new Products();
        mockProduct.setId("35455"); // ID de producto
        mockProduct.setName("ProductName"); // Nombre de producto

        Prices mockPrice = new Prices();
        mockPrice.setPriceListId(1L);
        mockPrice.setPrice(35.1); // Usar BigDecimal para precios
        mockPrice.setStartDate(Timestamp.valueOf("2023-01-14 00:00:00"));
        mockPrice.setEndDate(Timestamp.valueOf("2023-01-14 23:59:59"));
        mockPrice.setBrand(mockBrand); // Asigna la marca al precio
        mockPrice.setProduct(mockProduct); // Asigna el producto al precio

        // Corrección en el formato de la fecha y hora aquí
        when(pricesRepository.findPriceForProduct("2023-01-14T10:00", "35455", 1L))
                .thenReturn(mockPrice);

        PricesResponses response = pricesController.getLatestPrice(pricesDto);

        // Realizar aserciones para verificar que la respuesta sea la esperada
        assertEquals(35.1, response.getFinalPrice());
        // Agregar más aserciones según las propiedades esperadas en la respuesta
    }

    // Otros casos de prueba aquí
}
