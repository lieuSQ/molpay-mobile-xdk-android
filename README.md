<!--
# license: Copyright © 2011-2016 MOLPay Sdn Bhd. All Rights Reserved. 
-->

# molpay-mobile-xdk-android

This is the complete and functional MOLPay Android payment module that is ready to be implemented into Android Studio through gradle from JCenter/Maven repository as a MOLPayXDK module. An example application project 
(MOLPayXdkExample) is provided for MOLPayXDK framework integration reference.

## Recommended configurations

- __Minimum Android API level__: 14 ++

- __Minimum Android target version__: Android 4.0

## Installation

    Step 1 - Add compile 'com.molpay:molpay-mobile-xdk-android:1.0.0' to dependencies in application build.gradle

    Step 2 - Add import com.molpay.molpayxdk.MOLPayActivity;

    Step 3 - Override protected void onActivityResult(int requestCode, int resultCode, Intent data) to get return results when the payment activity ended

## Prepare the Payment detail object

    - Instantiate a new HashMap<String, Object> object and add the required pair key/value(s) listed below to form the payment detail object to be passed to the MOLPayActivity intent MOLPayPaymentDetails variable

    - `mp_amount`: Mandatory _(String)_ value not less than `1.00`

    - `mp_username`: Mandatory _(String)_. Please obtain this from MOLPay support if you're not a registered MOLPay merchant.

    - `mp_password`: Mandatory _(String)_. Please obtain this from MOLPay support if you're not a registered MOLPay merchant.

    - `mp_merchant_ID`: Mandatory _(String)_. Please obtain this from MOLPay support if you're not a registered MOLPay merchant.

    - `mp_app_name`: Mandatory _(String)_. Please obtain this from MOLPay support if you're not a registered MOLPay merchant.

    - `mp_order_ID`: Mandatory _(String)_

    - `mp_currency`: Mandatory _(String)_. Malaysia currency is `MYR`.

    - `mp_country`: Mandatory _(String)_. Malaysia is `MY`.

    - `mp_verification_key`: Mandatory _(String)_. Please obtain this from MOLPay support if you're not a registered MOLPay merchant.

    - `mp_channel`: Optional _(String)_. Defaulted to `multi` if no value provided thus all subscribed channels will be selectable.

    - `mp_bill_description`: Optional _(String)_. `mp_editing_enabled` will be defaulted to 1 if no value provided thus this field
                                                      be editable.

    - `mp_bill_name`: Optional _(String)_. Same as above.

    - `mp_bill_email`: Optional _(String)_. Same as above.

    - `mp_bill_mobile`: Optional _(String)_. Same as above.

    - `mp_channel_editing`: Optional _(int)_. Defaulted to `0` except when `mp_channel` value is `multi` if no value provided thus
                                                  the channel cannot be changed.

    - `mp_editing_enabled`: Optional _(int)_. Defaulted to `0` except any bill information not provided.

    - `mp_transaction_id`: Optional _(String)_. This is MOLPay returned value, set this value to show the `Cash Channel Payment Instruction`
                                                    or during a transaction request process.

    - `mp_request_type`: Optional _(String)_. Set this value as the callback reference id when executing a transaction request. `Receipt` is
                                                  the MOLPay reserved keyword, refrain from using it here.

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
Media Contact : media@molpay.com
R&D and Tech-related Suggestion : technical@molpay.com
Abuse Reporting : abuse@molpay.com