package com.scaler.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Payments extends BaseModel{
    private  int amount;
    private PaymentProviders paymentProvider;
    private Date time;
    private String refId;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
}
