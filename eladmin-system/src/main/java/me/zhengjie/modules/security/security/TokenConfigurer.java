/*
 *  Copyright 2019-2020 Evil
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.zhengjie.modules.security.security;

import me.zhengjie.modules.security.config.bean.SecurityProperties;
import me.zhengjie.modules.security.service.OnlineUserService;
import me.zhengjie.modules.security.service.UserCacheClean;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author /
 */
public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private TokenProvider tokenProvider;
    private SecurityProperties properties;
    private OnlineUserService onlineUserService;
    private UserCacheClean userCacheClean;

    public TokenConfigurer() {
    }

    public TokenConfigurer(TokenProvider tokenProvider, SecurityProperties properties, OnlineUserService onlineUserService, UserCacheClean userCacheClean) {
        this.tokenProvider = tokenProvider;
        this.properties = properties;
        this.onlineUserService = onlineUserService;
        this.userCacheClean = userCacheClean;
    }

    @Override
    public void configure(HttpSecurity http) {
        TokenFilter customFilter = new TokenFilter(tokenProvider, properties, onlineUserService, userCacheClean);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
