package com.scaler.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class City {
    private String name;
    private List<Theatre> theatres;
}
