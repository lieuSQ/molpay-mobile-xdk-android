<!--
# license: Copyright © 2011-2016 MOLPay Sdn Bhd. All Rights Reserved. 
-->

# molpay-mobile-xdk-android

This is the complete and functional MOLPay Android payment module that is ready to be implemented into Android Studio through gradle from JCenter/Maven repository as a MOLPayXDK module. An example application project 
(MOLPayXdkExample) is provided for MOLPayXDK framework integration reference.

## Recommended configurations

    - Minimum Android SDK Version: 23 ++

    - Minimum Android API level: 16 ++

    - Minimum Android target version: Android 4.1

## Installation

    Step 1 - Add compile 'com.molpay:molpay-mobile-xdk-android:1.0.4' to dependencies in application build.gradle

    Step 2 - Add import com.molpay.molpayxdk.MOLPayActivity;

    Step 3 - Add the result callback function to get return results when the payment activity ended,
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == MOLPayActivity.MOLPayXDK && resultCode == RESULT_OK){
            Log.d(MOLPayActivity.MOLPAY, "MOLPay result = "+data.getStringExtra(MOLPayActivity.MOLPayTransactionResult));
        }
    }

## Prepare the Payment detail object

    HashMap<String, Object> paymentDetails = new HashMap<>();
        
        // Mandatory String. A value not less than '1.00'
        paymentDetails.put(MOLPayActivity.mp_amount, "1.10"); 
        
        // Mandatory String. Values obtained from MOLPay
        paymentDetails.put(MOLPayActivity.mp_username, "username");
        paymentDetails.put(MOLPayActivity.mp_password, "password");
        paymentDetails.put(MOLPayActivity.mp_merchant_ID, "merchantid");
        paymentDetails.put(MOLPayActivity.mp_app_name, "appname");
        paymentDetails.put(MOLPayActivity.mp_verification_key, "vkey123");
    
        // Mandatory String. Payment values
        paymentDetails.put(MOLPayActivity.mp_order_ID, "orderid123");
        paymentDetails.put(MOLPayActivity.mp_currency, "MYR");
        paymentDetails.put(MOLPayActivity.mp_country, "MY");
        
        // Optional String.
        paymentDetails.put(MOLPayActivity.mp_channel, "multi");
        paymentDetails.put(MOLPayActivity.mp_bill_description, "billdesc");
        paymentDetails.put(MOLPayActivity.mp_bill_name, "billname");
        paymentDetails.put(MOLPayActivity.mp_bill_email, "email@domain.com");
        paymentDetails.put(MOLPayActivity.mp_bill_mobile, "+1234567");
        paymentDetails.put(MOLPayActivity.mp_channel_editing, false);
        paymentDetails.put(MOLPayActivity.mp_editing_enabled, false);
    
        // For transaction request use only, do not use this on payment process
        paymentDetails.put(MOLPayActivity.mp_transaction_id, "");
        paymentDetails.put(MOLPayActivity.mp_request_type, "");

## Start the payment module

    startActivityForResult(intent, MOLPayActivity.MOLPayXDK);

## Transaction request service

    Step 1 - import com.molpay.molpayxdk.MOLPayService

    Step 2 - Prepare the Payment detail object

    Step 3 - MOLPayService mpservice = new MOLPayService();

    Step 4 - 
    mpservice.transactionRequest(paymentDetails, new MOLPayService.Callback() {
            @Override
            public void onTransactionRequestCompleted(String result) {
                // result return in json;
            }
            @Override
            public void onTransactionRequestFailed(String error) {
                // error return in json;
            }
        });

## Support

Submit issue to this repository or email to our support@molpay.com

Merchant Technical Support / Customer Care : support@molpay.com<br>
Sales/Reseller Enquiry : sales@molpay.com<br>
Marketing Campaign : marketing@molpay.com<br>
Channel/Partner Enquiry : channel@molpay.com<br>
Media Contact : media@molpay.com<br>
R&D and Tech-related Suggestion : technical@molpay.com<br>
Abuse Reporting : abuse@molpay.com