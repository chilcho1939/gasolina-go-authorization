package com.api.gasolina.users.controller.dto;

import com.api.gasolina.users.dto.ApiResponseDTO;

public class GenericResponse {
    public ApiResponseDTO<?> createSuccessResponse() {
        return new ApiResponseDTO<>(200, "Success");
    }

    public ApiResponseDTO<?> createSuccessResponse(Object payload) {
        return new ApiResponseDTO<>(200, "Success", payload);
    }
}
