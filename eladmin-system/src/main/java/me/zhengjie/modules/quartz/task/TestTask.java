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
package me.zhengjie.modules.quartz.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 测试用
 * @author Evil
 * @date 2019-01-08
 */
@Component
public class TestTask {

    private final Logger log = LoggerFactory.getLogger(TestTask.class);

    public void run(){
        log.info("run 执行成功");
    }

    public void run1(String str){
        log.info("run1 执行成功，参数为： {}" + str);
    }

    public void run2(){
        log.info("run2 执行成功");
    }
}
