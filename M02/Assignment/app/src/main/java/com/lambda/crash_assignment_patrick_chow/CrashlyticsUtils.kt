package com.lambda.crash_assignment_patrick_chow

import com.crashlytics.android.Crashlytics

fun dropBreadcrumb(className: String, methodName: String, idValue: Long, generalData: String) {
    val breadcrumb = "$className - $methodName - $idValue - $generalData"
    Crashlytics.log(breadcrumb)
}