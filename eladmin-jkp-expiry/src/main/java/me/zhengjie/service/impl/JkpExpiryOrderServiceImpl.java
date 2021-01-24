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
package me.zhengjie.service.impl;

import me.zhengjie.domain.JkpExpiryOrder;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.repository.JkpExpiryOrderRepository;
import me.zhengjie.service.JkpExpiryOrderService;
import me.zhengjie.service.dto.JkpExpiryOrderDto;
import me.zhengjie.service.dto.JkpExpiryOrderQueryCriteria;
import me.zhengjie.service.mapstruct.JkpExpiryOrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author minliang.jiang
* @date 2021-01-24
**/
@Service
@RequiredArgsConstructor
public class JkpExpiryOrderServiceImpl implements JkpExpiryOrderService {

    private final JkpExpiryOrderRepository jkpExpiryOrderRepository;
    private final JkpExpiryOrderMapper jkpExpiryOrderMapper;

    @Override
    public Map<String,Object> queryAll(JkpExpiryOrderQueryCriteria criteria, Pageable pageable){
        Page<JkpExpiryOrder> page = jkpExpiryOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(jkpExpiryOrderMapper::toDto));
    }

    @Override
    public List<JkpExpiryOrderDto> queryAll(JkpExpiryOrderQueryCriteria criteria){
        return jkpExpiryOrderMapper.toDto(jkpExpiryOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public JkpExpiryOrderDto findById(Integer id) {
        JkpExpiryOrder jkpExpiryOrder = jkpExpiryOrderRepository.findById(id).orElseGet(JkpExpiryOrder::new);
        ValidationUtil.isNull(jkpExpiryOrder.getId(),"JkpExpiryOrder","id",id);
        return jkpExpiryOrderMapper.toDto(jkpExpiryOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JkpExpiryOrderDto create(JkpExpiryOrder resources) {
        return jkpExpiryOrderMapper.toDto(jkpExpiryOrderRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(JkpExpiryOrder resources) {
        JkpExpiryOrder jkpExpiryOrder = jkpExpiryOrderRepository.findById(resources.getId()).orElseGet(JkpExpiryOrder::new);
        ValidationUtil.isNull( jkpExpiryOrder.getId(),"JkpExpiryOrder","id",resources.getId());
        jkpExpiryOrder.copy(resources);
        jkpExpiryOrderRepository.save(jkpExpiryOrder);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            jkpExpiryOrderRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<JkpExpiryOrderDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (JkpExpiryOrderDto jkpExpiryOrder : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("创建时间", jkpExpiryOrder.getCreateTime());
            map.put("更新时间", jkpExpiryOrder.getUpdateTime());
            map.put("即开票图片地址", jkpExpiryOrder.getTicketPhotoUrl());
            map.put("兑奖状态", jkpExpiryOrder.getStatus());
            map.put("订单编号", jkpExpiryOrder.getOrderNo());
            map.put("兑奖用户ID", jkpExpiryOrder.getExpiryUserId());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}