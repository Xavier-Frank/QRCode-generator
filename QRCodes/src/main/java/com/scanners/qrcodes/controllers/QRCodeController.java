package com.scanners.qrcodes.controllers;

import com.google.zxing.WriterException;
import com.scanners.qrcodes.dto.QRCodeDto;
import com.scanners.qrcodes.generator.QRCodeGenerator;
import com.scanners.qrcodes.services.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/qr-codes")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    @GetMapping("/{quoteCode}")
    public ResponseEntity<QRCodeDto> generateQrCode(@PathVariable Integer quoteCode) {
        return ResponseEntity.status(HttpStatus.OK).body(qrCodeService.getQrCodeInfoByQuoteCode(quoteCode));
    }

    @PostMapping("/generate")
    public ResponseEntity<QRCodeDto> generateAndDownloadQRCode(@RequestBody QRCodeDto qrCodeDto){
        return ResponseEntity.ok(qrCodeService.saveQrCodeInfo(qrCodeDto));
    }
}
