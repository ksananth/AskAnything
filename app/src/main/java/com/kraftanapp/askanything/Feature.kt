package com.kraftanapp.askanything

sealed class Feature {
    data class Transfer(val from: String = "", val to: String = "", val amount: String = "") : Feature()
    object STANDING_ORDER : Feature()
    object BENEFICIARY : Feature()
    object DIRECT_DEBIT : Feature()
    object CONTACT : Feature()
    object CARDS : Feature()
}
