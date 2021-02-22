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

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 代码生成配置
 * @author Evil
 * @date 2019-01-03
 */
@Entity
@Table(name = "code_gen_config")
public class GenConfig implements Serializable {

    public GenConfig(String tableName) {
        this.tableName = tableName;
    }

    @Id
    @Column(name = "config_id")
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "接口名称")
    private String apiAlias;

    @NotBlank
    @ApiModelProperty(value = "包路径")
    private String pack;

    @NotBlank
    @ApiModelProperty(value = "模块名")
    private String moduleName;

    @NotBlank
    @ApiModelProperty(value = "前端文件路径")
    private String path;

    @ApiModelProperty(value = "前端文件路径")
    private String apiPath;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "表前缀")
    private String prefix;

    @ApiModelProperty(value = "是否覆盖")
    private Boolean cover = false;

    public GenConfig() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getApiAlias() {
        return apiAlias;
    }

    public void setApiAlias(String apiAlias) {
        this.apiAlias = apiAlias;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }
}
