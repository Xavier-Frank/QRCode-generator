package com.scanners.qrcodes.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;
import com.scanners.qrcodes.dto.QRCodeDto;
import com.scanners.qrcodes.generator.QRCodeGenerator;
import com.scanners.qrcodes.model.QRCode;
import com.scanners.qrcodes.repository.QRCodeRepository;
import com.scanners.qrcodes.services.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class QRCodeServiceImpl implements QRCodeService {
    private final QRCodeRepository qrCodeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public QRCodeDto saveQrCodeInfo(QRCodeDto qrCodeDto) {

        QRCode target = new QRCode();
        BeanUtils.copyProperties(qrCodeDto, target);
        QRCode saved = qrCodeRepository.save(target);

        return getCodeImage(saved);
    }

    @Override
    public QRCodeDto getQrCodeInfoByQuoteCode(Integer quoteCode) {
        QRCode qrCode = qrCodeRepository.findById(quoteCode)
                .orElseThrow(() ->  new RuntimeException("Qr code with" + " " + quoteCode + " " + " does not exist"));
        return getCodeImage(qrCode);
    }

    private QRCodeDto getCodeImage(QRCode saved) {
        QRCodeDto response = new QRCodeDto();
        BeanUtils.copyProperties(saved, response);

        try {
            byte[] qrCodeImage = QRCodeGenerator.getQRCodeImage(objectMapper.writeValueAsString(saved), 300, 300);
            response.setQrCodeImage(qrCodeImage);
        } catch (IOException | WriterException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

}
