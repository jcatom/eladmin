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
package me.zhengjie.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 支付宝配置类
 * @author Evil
 * @date 2018-12-31
 */
@Entity
@Table(name = "tool_alipay_config")
public class AlipayConfig implements Serializable {

    @Id
    @Column(name = "config_id")
    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "应用ID")
    private String appId;

    @NotBlank
    @ApiModelProperty(value = "商户私钥")
    private String privateKey;

    @NotBlank
    @ApiModelProperty(value = "支付宝公钥")
    private String publicKey;

    @ApiModelProperty(value = "签名方式")
    private String signType="RSA2";

    @Column(name = "gateway_url")
    @ApiModelProperty(value = "支付宝开放安全地址", hidden = true)
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    @ApiModelProperty(value = "编码", hidden = true)
    private String charset= "utf-8";

    @NotBlank
    @ApiModelProperty(value = "异步通知地址")
    private String notifyUrl;

    @NotBlank
    @ApiModelProperty(value = "订单完成后返回的页面")
    private String returnUrl;

    @ApiModelProperty(value = "类型")
    private String format="JSON";

    @NotBlank
    @ApiModelProperty(value = "商户号")
    private String sysServiceProviderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSysServiceProviderId() {
        return sysServiceProviderId;
    }

    public void setSysServiceProviderId(String sysServiceProviderId) {
        this.sysServiceProviderId = sysServiceProviderId;
    }
}
