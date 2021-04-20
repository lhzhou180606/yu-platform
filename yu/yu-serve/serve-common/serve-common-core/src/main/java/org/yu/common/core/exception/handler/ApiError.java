package org.yu.common.core.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author sdses
 * @date 2018-11-23
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiError {

    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private Integer code;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(Integer status,String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public ApiError(Integer status,Integer code,String message) {
        this();
        this.status = status;
        this.code = code;
        this.message = message;
    }
}


