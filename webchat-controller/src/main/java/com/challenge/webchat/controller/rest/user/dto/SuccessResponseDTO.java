package com.challenge.webchat.controller.rest.user.dto;

public class SuccessResponseDTO {

    private String description;
    private Integer status;

    public SuccessResponseDTO(String description, Integer status) {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
