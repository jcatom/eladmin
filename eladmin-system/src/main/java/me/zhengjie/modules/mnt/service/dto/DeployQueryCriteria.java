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
package me.zhengjie.modules.mnt.service.dto;

import me.zhengjie.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
* @author Evil
* @date 2019-08-24
*/
public class DeployQueryCriteria{

	/**
	 * 模糊
	 */
    @Query(type = Query.Type.INNER_LIKE, propName = "name", joinName = "app")
    private String appName;

	@Query(type = Query.Type.BETWEEN)
	private List<Timestamp> createTime;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public List<Timestamp> getCreateTime() {
		return createTime;
	}

	public void setCreateTime(List<Timestamp> createTime) {
		this.createTime = createTime;
	}
}
