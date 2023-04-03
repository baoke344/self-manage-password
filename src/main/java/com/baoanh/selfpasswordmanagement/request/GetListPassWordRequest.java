package com.baoanh.selfpasswordmanagement.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetListPassWordRequest {

    private String username;
    private String categoryId;
    private int pageNo;
    private int pageSize;
}
