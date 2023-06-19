package com.scanners.qrcodes.services;

import com.scanners.qrcodes.dto.QRCodeDto;


public interface QRCodeService {
    /**
     *
     * @param qrCodeDto
     * @return
     */
    QRCodeDto saveQrCodeInfo(QRCodeDto qrCodeDto);

    /**
     *
     * @param quoteCode
     * @return
     */
    QRCodeDto getQrCodeInfoByQuoteCode(Integer quoteCode);

}
