package com.laurakovacic.spring6resttemplate.client;

import com.laurakovacic.spring6resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;

public class BeerClientImpl implements BeerClient {
    @Override
    public Page<BeerDTO> listBeers() {
        return null;
    }
}
