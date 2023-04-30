package com.example.model

import com.google.gson.annotations.SerializedName

data class Flags (
    @SerializedName("nsfw") val isNsfw: Boolean? = null,
    @SerializedName("religious") val isReligious: Boolean? = null,
    @SerializedName("political") val isPolitical: Boolean? = null,
    @SerializedName("racist") val isRacist: Boolean? = null,
    @SerializedName("sexist") val isSexist: Boolean? = null,
    @SerializedName("explicit") val isExplicit: Boolean? = null
        )
