package com.challenge.webchat.controller.response;

import java.util.ArrayList;
import java.util.List;

public class CustomResponse {

    private List<String> descriptions;

    private ResponseType responseType;

    public CustomResponse(String description, ResponseType responseType) {
        getDescriptions().add(description);
        this.responseType = responseType;
    }

    public List<String> getDescriptions() {
        if (descriptions == null) {
            descriptions = new ArrayList();
        }
        return descriptions;
    }
}
