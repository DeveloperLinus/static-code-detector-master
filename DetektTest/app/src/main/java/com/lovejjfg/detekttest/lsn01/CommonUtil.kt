package com.lovejjfg.detekttest.lsn01

import android.content.Context

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author HuQingHui
 * @date 2022/9/1
 */
class CommonUtil {
    private var context: Context? = null

    constructor(context: Context) {
        this.context = context
    }

    companion object {
        private var instance: CommonUtil? = null
        @JvmStatic
        fun getInstance(context: Context): CommonUtil? {
            if (instance == null) {
                instance = CommonUtil(context)
            }
            return instance
        }
    }
}
