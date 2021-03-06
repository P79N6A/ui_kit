/*
 * Copyright 1999-2101 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.hipac.uikit.feature.callback;

/**
 * @author "weina.mawn<weina.mawn@alibaba-inc.com>"
 * @ClassName: ImageSaveCallback
 * @Description: Callback methods for long click event
 * of view when users wants to save images.
 * @date 2014年10月13日 上午11:58:07
 */

public interface ImageSaveCallback {

    void beforePerformLongClick();

    void afterPerformLongClick();
}
