package com.baoanh.selfpasswordmanagement.response;

import lombok.Data;

@Data
public class MakeResponse {

    private Object data;

    public static MakeResponse makeResponse(Object object) {
        MakeResponse response = new MakeResponse();
        response.setData(object);
        return response;
    }
}
