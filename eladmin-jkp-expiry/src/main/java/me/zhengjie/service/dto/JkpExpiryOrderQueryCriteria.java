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

import me.zhengjie.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
* @website https://el-admin.vip
* @author minliang.jiang
* @date 2021-01-24
**/
public class JkpExpiryOrderQueryCriteria{

    /** 精确 */
    @Query
    private Integer status;

    /** 精确 */
    @Query
    private String orderNo;

    /** 精确 */
    @Query
    private Integer expiryUserId;
    /** BETWEEN */
    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

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

    public List<Timestamp> getCreateTime() {
        return createTime;
    }

    public void setCreateTime(List<Timestamp> createTime) {
        this.createTime = createTime;
    }
}