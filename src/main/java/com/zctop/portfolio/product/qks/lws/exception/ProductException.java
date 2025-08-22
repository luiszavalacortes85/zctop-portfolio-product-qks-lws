package com.zctop.portfolio.product.qks.lws.exception;

import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

@Slf4j
public class ProductException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3800249988788662091L;

    public ProductException(String description, int code) {
        log.error("{}: {}", code, description);
    }
}
