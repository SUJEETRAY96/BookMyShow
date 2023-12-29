package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Payments extends BaseModel{
    private  int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProviders paymentProvider;
    private Date time;
    private String refId;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;
}
