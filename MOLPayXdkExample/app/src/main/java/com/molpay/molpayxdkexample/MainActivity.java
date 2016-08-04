package com.molpay.molpayxdkexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.molpay.molpayxdk.MOLPayActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MOLPayActivity.MOLPayXDK && resultCode == RESULT_OK){
            Log.d(MOLPayActivity.MOLPAY, "MOLPay result = " + data.getStringExtra(MOLPayActivity.MOLPayTransactionResult));
            TextView tw = (TextView)findViewById(R.id.resultTV);
            tw.setText(data.getStringExtra(MOLPayActivity.MOLPayTransactionResult));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HashMap<String, Object> paymentDetails = new HashMap<>();
        paymentDetails.put(MOLPayActivity.mp_amount, "");
        paymentDetails.put(MOLPayActivity.mp_username, "");
        paymentDetails.put(MOLPayActivity.mp_password, "");
        paymentDetails.put(MOLPayActivity.mp_merchant_ID, "");
        paymentDetails.put(MOLPayActivity.mp_app_name, "");
        paymentDetails.put(MOLPayActivity.mp_order_ID, "");
        paymentDetails.put(MOLPayActivity.mp_currency, "MYR");
        paymentDetails.put(MOLPayActivity.mp_country, "MY");
        paymentDetails.put(MOLPayActivity.mp_verification_key, "");
        paymentDetails.put(MOLPayActivity.mp_channel, "");
        paymentDetails.put(MOLPayActivity.mp_bill_description, "");
        paymentDetails.put(MOLPayActivity.mp_bill_name, "");
        paymentDetails.put(MOLPayActivity.mp_bill_email, "");
        paymentDetails.put(MOLPayActivity.mp_bill_mobile, "");
        paymentDetails.put(MOLPayActivity.mp_channel_editing, false);
        paymentDetails.put(MOLPayActivity.mp_editing_enabled, false);
        paymentDetails.put(MOLPayActivity.mp_transaction_id, "");
        paymentDetails.put(MOLPayActivity.mp_request_type, "");
        //String binlock[] = {"123456","234567"};
        //paymentDetails.put(MOLPayActivity.mp_bin_lock, binlock);
        //paymentDetails.put(MOLPayActivity.mp_bin_lock_err_msg, "Wrong BIN format");
        //paymentDetails.put(MOLPayActivity.mp_is_escrow, "");
        //paymentDetails.put(MOLPayActivity.mp_filter, "1");
        //paymentDetails.put(MOLPayActivity.mp_custom_css_url, "file:///android_asset/custom.css");
        //paymentDetails.put(MOLPayActivity.mp_preferred_token, "");
        //paymentDetails.put(MOLPayActivity.mp_tcctype, ""); // SALS // AUTH
        //paymentDetails.put(MOLPayActivity.mp_is_recurring, false);

        Intent intent = new Intent(MainActivity.this, MOLPayActivity.class);
        intent.putExtra(MOLPayActivity.MOLPayPaymentDetails, paymentDetails);
        startActivityForResult(intent, MOLPayActivity.MOLPayXDK);



        // transactionRequest example
//        MOLPayService mpservice = new MOLPayService();
//        mpservice.transactionRequest(paymentDetails, new MOLPayService.Callback() {
//            @Override
//            public void onTransactionRequestCompleted(String result) {
//                Log.d(MOLPayActivity.MOLPAY, "onTransactionRequestCompleted result= " + result);
//            }
//
//            @Override
//            public void onTransactionRequestFailed(String error) {
//                Log.d(MOLPayActivity.MOLPAY, "onTransactionRequestCompleted result= " + error);
//            }
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
