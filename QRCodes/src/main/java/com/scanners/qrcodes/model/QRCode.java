package com.scanners.qrcodes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QRCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quoteCode;
    private String travelPackage;
    private String typeOfCover;
    private String travellingFrom;
    private String travellingTo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date departureDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date arrivalDate;
    private Integer noOfTravelDays;
    private String clientName;
    private BigDecimal totalPremium;


}
