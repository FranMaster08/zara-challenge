package com.zara.zara.controllers;

import com.zara.zara.dto.PricesDto;
import com.zara.zara.entities.Prices;
import com.zara.zara.repository.PricesRepository;
import com.zara.zara.responses.ApplicationDates;
import com.zara.zara.responses.PricesResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final PricesRepository pricesRepository;

    @Autowired
    public PricesController(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    /**
     * Obtiene una lista de todos los precios.
     *
     * @return ResponseEntity con la lista de precios.
     */
    @GetMapping("/get-prices")
    public ResponseEntity<List<Prices>> getPrices() {
        List<Prices> priceList = pricesRepository.findAll();
        return ResponseEntity.ok(priceList);
    }


    @PostMapping("/getLatestPrice")
    public PricesResponses getLatestPrice(
          @RequestBody PricesDto pricesDto
    ) {
        String startDate = pricesDto.getApplicationDate().toString();
        String productId = pricesDto.getProductId();
        long brandId = pricesDto.getBrandId();

        Prices prices = pricesRepository.findPriceForProduct(startDate, productId, brandId);
        PricesResponses responses = new PricesResponses();
        responses.setPriceList(prices.getPriceListId());
        responses.setFinalPrice(prices.getPrice());
        ApplicationDates applicationDates = new ApplicationDates();
        applicationDates.setEndsDate( prices.getEndDate().toLocalDateTime());
        applicationDates.setStartDate(prices.getStartDate().toLocalDateTime());
        responses.setApplicationDates(applicationDates);
        responses.setBrandId(prices.getBrand().getId());
        responses.setProductId(prices.getProduct().getId());
        responses.setCurrency(prices.getCurr());
        responses.setApplicationDate(pricesDto.getApplicationDate());
        // Procesa la lista de resultados como sea necesario
        return responses;
    }
}
