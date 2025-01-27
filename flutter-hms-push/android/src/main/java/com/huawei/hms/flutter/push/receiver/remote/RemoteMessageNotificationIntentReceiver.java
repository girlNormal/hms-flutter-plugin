/*
    Copyright 2020-2022. Huawei Technologies Co., Ltd. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License")
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.huawei.hms.flutter.push.receiver.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.huawei.hms.flutter.push.constants.PushIntent;

import java.util.Objects;

import io.flutter.plugin.common.EventChannel;

public class RemoteMessageNotificationIntentReceiver extends BroadcastReceiver {
    final EventChannel.EventSink events;

    public RemoteMessageNotificationIntentReceiver(EventChannel.EventSink events) {
        this.events = events;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.requireNonNull(intent.getAction())
                .equals(PushIntent.REMOTE_MESSAGE_NOTIFICATION_INTENT_ACTION.id())) {
            String res = intent.getStringExtra(PushIntent.CUSTOM_INTENT.id());
            this.events.success(res);
        }
    }

}
