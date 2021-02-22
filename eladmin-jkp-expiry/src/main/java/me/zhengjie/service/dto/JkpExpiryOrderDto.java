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
package me.zhengjie.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @website https://el-admin.vip
* @description /
* @author minliang.jiang
* @date 2021-01-24
**/
public class JkpExpiryOrderDto implements Serializable {

    /** 订单ID */
    private Long id;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 即开票图片地址 */
    private String ticketPhotoUrl;

    /** 兑奖状态 */
    private Integer status;

    /** 订单编号 */
    private String orderNo;

    /** 兑奖用户ID */
    private Integer expiryUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getTicketPhotoUrl() {
        return ticketPhotoUrl;
    }

    public void setTicketPhotoUrl(String ticketPhotoUrl) {
        this.ticketPhotoUrl = ticketPhotoUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getExpiryUserId() {
        return expiryUserId;
    }

    public void setExpiryUserId(Integer expiryUserId) {
        this.expiryUserId = expiryUserId;
    }
}