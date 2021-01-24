/*
*  Copyright 2019-2020 Zheng Jie
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

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author minliang.jiang
* @date 2021-01-24
**/
@Data
public class JkpExpiryOrderDto implements Serializable {

    /** 订单ID */
    private Integer id;

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
}