package com.d288.cduque10.services;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Data
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;

}
