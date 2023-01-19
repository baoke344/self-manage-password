package com.baoanh.selfpasswordmanagement.applistener;

import com.baoanh.selfpasswordmanagement.helper.SecretKeyHelper;
import com.baoanh.selfpasswordmanagement.repository.EncryptKeyService;
import com.baoanh.selfpasswordmanagement.repository.dto.SigningKey;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ApplicationListener implements org.springframework.context.ApplicationListener<ApplicationReadyEvent> {

    private final EncryptKeyService encryptKeyService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Optional<SigningKey> key = encryptKeyService.findById(1);
        SigningKey savedKey = key.orElseThrow();
        SecretKeyHelper secretKeyHelper = new SecretKeyHelper();
        secretKeyHelper.setKey(savedKey.getKey());
    }
}
