package com.doris.odata.common.config;

import com.doris.odata.common.interceptor.UserInfoThreadLocal;
import com.doris.odata.common.model.UserInfo;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author: origindoris
 * @Title: AutoAware
 * @Description:
 * @date: 2022/11/2 11:41
 */
public class AutoAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        UserInfo userInfo = UserInfoThreadLocal.get();
        return Optional.of(userInfo.getEmpId());
    }
}
