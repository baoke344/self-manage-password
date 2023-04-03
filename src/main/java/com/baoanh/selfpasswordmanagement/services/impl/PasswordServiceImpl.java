package com.baoanh.selfpasswordmanagement.services.impl;

import com.baoanh.selfpasswordmanagement.converter.PasswordConverter;
import com.baoanh.selfpasswordmanagement.repository.PassWordPostGreRepository;
import com.baoanh.selfpasswordmanagement.request.GetListPassWordRequest;
import com.baoanh.selfpasswordmanagement.response.password.PasswordDto;
import com.baoanh.selfpasswordmanagement.services.PasswordService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private final PassWordPostGreRepository passWordPostGreRepository;
    private final PasswordConverter passwordConverter;

    @Override
    public List<PasswordDto> getListPasswords(GetListPassWordRequest request) {
        int pageNumber = request.getPageNo();
        int pageSize = request.getPageSize();
        String userName = request.getUsername();
        if (pageNumber < 0) {
            pageNumber = 1;
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        if (request.getCategoryId() != null && !request.getCategoryId().isEmpty()) {
            return passWordPostGreRepository.findAllByUserNameAndCategoryId(userName, request.getCategoryId(), pageable)
                    .stream()
                    .map(passwordConverter)
                    .toList();
        }
        return passWordPostGreRepository.findAllByUserName(userName, pageable)
                .stream()
                .map(passwordConverter)
                .toList();
    }
}
