package com.laurakovacic.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.laurakovacic.spring6resttemplate.model.BeerDTO;
import com.laurakovacic.spring6resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        // ResponseEntity gives access to everything in the response
        ResponseEntity<BeerDTOPageImpl> response = restTemplate.getForEntity(GET_BEER_PATH, BeerDTOPageImpl.class);

        return response.getBody();
    }
}
