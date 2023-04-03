package com.laurakovacic.spring6resttemplate.client;

import com.laurakovacic.spring6resttemplate.model.BeerDTO;
import com.laurakovacic.spring6resttemplate.model.BeerStyle;
import org.springframework.data.domain.Page;

public interface BeerClient {
    Page<BeerDTO> listBeers();
    Page<BeerDTO> listBeers(String beerName, Boolean showInventory, Integer pageNumber, Integer pageSize, BeerStyle beerStyle);
}
