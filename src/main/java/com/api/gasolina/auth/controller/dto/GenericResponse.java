package com.api.gasolina.auth.controller.dto;

import com.api.gasolina.auth.dto.ApiResponseDTO;

public class GenericResponse {
    public ApiResponseDTO<?> createSuccessResponse() {
        return new ApiResponseDTO<>(200, "Success");
    }

    public ApiResponseDTO<?> createSuccessResponse(Object payload) {
        return new ApiResponseDTO<>(200, "Success", payload);
    }
}
