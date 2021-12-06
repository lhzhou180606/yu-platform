package org.yu.alonelaunch.log.service;

import org.springframework.scheduling.annotation.Async;
import org.yu.alonelaunch.log.domain.LogEndpointDO;
import org.yu.common.querydsl.service.DslBaseService;

/**
 * @author wangxd
 * @date 2021-12-01 22:19
 */
public interface LogEndpointService extends DslBaseService<LogEndpointDO, String> {
    @Async
    void asyncSave(LogEndpointDO logEndpointDO);
}
