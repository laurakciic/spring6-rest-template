package com.laurakovacic.spring6resttemplate.client;

import com.laurakovacic.spring6resttemplate.model.BeerDTO;
import com.laurakovacic.spring6resttemplate.model.BeerDTOPageImpl;
import com.laurakovacic.spring6resttemplate.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String GET_BEER_PATH = "/api/v1/beer";
    private static final String GET_BEER_BY_PATH_ID = "/api/v1/beer/{beerId}";

    @Override
    public Page<BeerDTO> listBeers() {
        return this.listBeers(null, null, null, null, null);
    }

    @Override
    public Page<BeerDTO> listBeers(String beerName, Boolean showInventory, Integer pageNumber, Integer pageSize, BeerStyle beerStyle) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if (beerName != null)      uriComponentsBuilder.queryParam("beerName", beerName);
        if (showInventory != null) uriComponentsBuilder.queryParam("showInventory", showInventory);
        if (pageNumber != null)    uriComponentsBuilder.queryParam("pageNumber", pageNumber);
        if (pageSize != null)      uriComponentsBuilder.queryParam("pageSize", pageSize);
        if (beerStyle != null)     uriComponentsBuilder.queryParam("beerStyle", beerStyle);

        // ResponseEntity gives access to everything in the response
        ResponseEntity<BeerDTOPageImpl> response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

        return response.getBody();
    }

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject(GET_BEER_BY_PATH_ID, BeerDTO.class, beerId);
    }
}
