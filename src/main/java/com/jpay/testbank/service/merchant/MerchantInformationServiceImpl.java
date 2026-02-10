package com.jpay.testbank.service.merchant;
import com.jpay.testbank.repository.merchant.MerchantInformationDao;
import com.jpay.testbank.util.CommonConstant;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jpay.testbank.dto.DynamicQRRequestDto;
import com.jpay.testbank.model.merchant.MerchantInformation;

@Service
public class MerchantInformationServiceImpl implements MerchantInformationService {

    private final MerchantInformationDao merchantInformationDao;

    MerchantInformationServiceImpl(MerchantInformationDao merchantInformationDao) {
        this.merchantInformationDao = merchantInformationDao;
    }

    @Override
    public MerchantInformation save(MerchantInformation merchantInformation){
        return merchantInformationDao.save(merchantInformation);
    }

    @Override
    public byte[] generateMerchantDynamicQRCode(DynamicQRRequestDto dynamicQRRequestDto) {
       // QR encoding hints (good for Myanmar text / unicode too)
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());
        hints.put(EncodeHintType.MARGIN, 1); // quiet zone
        MerchantInformation merchantInformation = merchantInformationDao.findById(dynamicQRRequestDto.getMerchantId()).get(); 
        if(merchantInformation == null){
            throw new RuntimeException("Merchant not found");
        }
        String qrContent = merchantInformation.toQrString()+"AMOUNT:"+dynamicQRRequestDto.getAmount().toString()+"|REFERENCE:"+dynamicQRRequestDto.getReference()+"|DESCRIPTION:"+dynamicQRRequestDto.getDescription();
        try{
            BitMatrix matrix = new MultiFormatWriter().encode(
                qrContent,
                BarcodeFormat.QR_CODE,
                CommonConstant.QR_WIDTH,
                CommonConstant.QR_HEIGHT,
                hints
        );
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "PNG", baos);
        return baos.toByteArray();
        }catch(WriterException | java.io.IOException e){
            throw new RuntimeException("Failed to generate QR code", e);
        }
    }
}
