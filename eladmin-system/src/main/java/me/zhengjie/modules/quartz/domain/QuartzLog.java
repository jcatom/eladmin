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
package me.zhengjie.modules.quartz.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Evil
 * @date 2019-01-07
 */
@Entity
@Table(name = "sys_quartz_log")
public class QuartzLog implements Serializable {

    @Id
    @Column(name = "log_id")
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "任务名称", hidden = true)
    private String jobName;

    @ApiModelProperty(value = "bean名称", hidden = true)
    private String beanName;

    @ApiModelProperty(value = "方法名称", hidden = true)
    private String methodName;

    @ApiModelProperty(value = "参数", hidden = true)
    private String params;

    @ApiModelProperty(value = "cron表达式", hidden = true)
    private String cronExpression;

    @ApiModelProperty(value = "状态", hidden = true)
    @Column(name = "is_success")
    private Boolean success;

    @ApiModelProperty(value = "异常详情", hidden = true)
    private String exceptionDetail;

    @ApiModelProperty(value = "执行耗时", hidden = true)
    private Long time;

    @CreationTimestamp
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        success = success;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
