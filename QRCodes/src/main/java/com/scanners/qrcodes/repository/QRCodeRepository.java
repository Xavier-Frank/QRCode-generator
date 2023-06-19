package com.scanners.qrcodes.repository;

import com.scanners.qrcodes.model.QRCode;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface QRCodeRepository extends CrudRepository<QRCode, Integer> {
    Optional<QRCode> findById(Integer quoteCode);
}
