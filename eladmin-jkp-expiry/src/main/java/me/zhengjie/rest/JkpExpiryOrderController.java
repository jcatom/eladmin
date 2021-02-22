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
package me.zhengjie.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.domain.JkpExpiryOrder;
import me.zhengjie.service.JkpExpiryOrderService;
import me.zhengjie.service.dto.JkpExpiryOrderQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @website https://el-admin.vip
* @author minliang.jiang
* @date 2021-01-24
**/
@RestController
@Api(tags = "即开票订单管理管理")
@RequestMapping("/api/jkpExpiryOrder")
public class JkpExpiryOrderController {

    @Autowired
    private JkpExpiryOrderService jkpExpiryOrderService;

    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('jkpExpiryOrder:list')")
    public void download(HttpServletResponse response, JkpExpiryOrderQueryCriteria criteria) throws IOException {
        jkpExpiryOrderService.download(jkpExpiryOrderService.queryAll(criteria), response);
    }

    @GetMapping
    @ApiOperation("查询即开票订单管理")
    @PreAuthorize("@el.check('jkpExpiryOrder:list')")
    public ResponseEntity<Object> query(JkpExpiryOrderQueryCriteria criteria, Pageable pageable){
        System.out.println("test");
        return new ResponseEntity<>(jkpExpiryOrderService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增即开票订单管理")
    @PreAuthorize("@el.check('jkpExpiryOrder:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody JkpExpiryOrder resources){
        return new ResponseEntity<>(jkpExpiryOrderService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("修改即开票订单管理")
    @PreAuthorize("@el.check('jkpExpiryOrder:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody JkpExpiryOrder resources){
        jkpExpiryOrderService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation("删除即开票订单管理")
    @PreAuthorize("@el.check('jkpExpiryOrder:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        jkpExpiryOrderService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}