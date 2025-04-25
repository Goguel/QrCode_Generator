package com.miguelxavier.qrcode.generator.controller;

import com.miguelxavier.qrcode.generator.dto.QrCodeGenerateRequest;
import com.miguelxavier.qrcode.generator.dto.QrCodeGenerateResponse;
import com.miguelxavier.qrcode.generator.service.QrCodeGenerateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGenerateService qrCodeGenerateService;

    public QrCodeController(QrCodeGenerateService qrCodeGenerateService) {
        this.qrCodeGenerateService = qrCodeGenerateService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request) {
        try {
            QrCodeGenerateResponse response = this.qrCodeGenerateService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
