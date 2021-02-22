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
package me.zhengjie.modules.mnt.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author Evil
* @date 2019-08-24
*/
@Entity
@Table(name="mnt_deploy_history")
public class DeployHistory implements Serializable {

    @Id
    @Column(name = "history_id")
	@ApiModelProperty(value = "ID", hidden = true)
    private String id;

    @ApiModelProperty(value = "应用名称")
    private String appName;

	@ApiModelProperty(value = "IP")
    private String ip;

	@CreationTimestamp
	@ApiModelProperty(value = "部署时间")
    private Timestamp deployDate;

	@ApiModelProperty(value = "部署者")
    private String deployUser;

	@ApiModelProperty(value = "部署ID")
	private Long deployId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Timestamp deployDate) {
        this.deployDate = deployDate;
    }

    public String getDeployUser() {
        return deployUser;
    }

    public void setDeployUser(String deployUser) {
        this.deployUser = deployUser;
    }

    public Long getDeployId() {
        return deployId;
    }

    public void setDeployId(Long deployId) {
        this.deployId = deployId;
    }

    public void copy(DeployHistory source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
