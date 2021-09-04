package org.yu.common.core.context;

import lombok.Data;
import org.yu.common.core.dto.LoginUser;

/**
 * @author wangxd
 * @date 2020-11-27 9:40
 */
@Data
public class YuContext {

    private Integer tenantId;

    private String clientId;

    private LoginUser clientUser;

    public Integer getTenantId() {
        return clientUser.getTenantId();
    }

    public String getClientId() {
        return clientUser.getClientId();
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
