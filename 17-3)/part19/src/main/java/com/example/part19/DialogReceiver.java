package com.example.part19;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.TelephonyManager;

public class DialogReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.


        String action = intent.getAction();
        // 발신용도 intent.getStringExtra으로 얻을 수 있다.
        if (action.equals("android.intent.action.NEW_OUTGOING_CALL")) {
            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Intent intent1 = new Intent(context, DialogActivity.class);
            intent1.putExtra("number", phoneNumber);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
        // 수신용도 bundle로 얻을 수 있다.
        else if (action.equals("android.intent.action.PHONE_STATE")) {
            Bundle bundle = intent.getExtras();
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);
            String phoneNumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING) && phoneNumber != null) {
                Intent intent1 = new Intent(context, DialogActivity.class);
                intent1.putExtra("number", phoneNumber);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        }


    }
}