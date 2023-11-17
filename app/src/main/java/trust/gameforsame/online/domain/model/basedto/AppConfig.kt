package trust.gameforsame.online.domain.model.basedto


import com.google.gson.annotations.SerializedName

data class AppConfig(
    @SerializedName("extra_field_0")
    val showedIconPrimary: String?,
    @SerializedName("extra_field_1")
    val namePrimary: String?,
    @SerializedName("extra_field_2")
    val urlPrimary: String?,
)