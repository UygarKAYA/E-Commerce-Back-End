package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailedAddress
{
    private String Country;
    private String City;
    private String Town;
    private int ZipCode;
}
