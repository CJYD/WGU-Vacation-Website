package com.d288.backendprogramming.services;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import lombok.Data;

@Getter
@Setter
@Data
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;

}
