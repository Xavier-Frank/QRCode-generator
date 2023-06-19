package com.scanners.qrcodes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QRCodeDto {
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
    private byte[] qrCodeImage;
}
