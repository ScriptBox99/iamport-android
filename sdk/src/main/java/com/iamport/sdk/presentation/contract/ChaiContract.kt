package com.iamport.sdk.presentation.contract

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.orhanobut.logger.Logger.d
import com.orhanobut.logger.Logger.i

/**
 * 차이 앱 요청 및 응답 데이터 규약
 */
class ChaiContract : ActivityResultContract<Pair<String, String>, String>() {

    override fun createIntent(context: Context, input: Pair<String, String>): Intent {
        d("createIntent :: $input")
        val intent = Intent.parseUri(input.first, Intent.URI_INTENT_SCHEME)
        return intent.apply { putExtra("input", input.second) }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            Activity.RESULT_OK -> {
                i("${intent?.getStringExtra("output")}")
                intent?.getStringExtra("output")
            }
            else -> null
        }
    }
}