package com.ijniclohot.networking.model

import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("Message")
    val message: String,

    @SerializedName("Type")
    val type: Long,

    @SerializedName("MetaData")
    val metaData: MetaData,

    @SerializedName("SponsoredData")
    val sponsoredData: List<Any?>,

    @SerializedName("Data")
    val data: List<CryptoData>,

    @SerializedName("HasWarning")
    val hasWarning: Boolean
)

data class CryptoData(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfo,

    @SerializedName("RAW")
    val raw: Raw,

    @SerializedName("DISPLAY")
    val display: Display
)

data class CoinInfo(
    @SerializedName("Id")
    val id: String,

    @SerializedName("Name")
    val name: String,

    @SerializedName("FullName")
    val fullName: String,

    @SerializedName("Internal")
    val internal: String,

    @SerializedName("ImageUrl")
    val imageURL: String,

    @SerializedName("Url")
    val url: String,

    @SerializedName("Algorithm")
    val algorithm: Algorithm,

    @SerializedName("ProofType")
    val proofType: String,

    @SerializedName("Rating")
    val rating: Rating,

    @SerializedName("NetHashesPerSecond")
    val netHashesPerSecond: Double,

    @SerializedName("BlockNumber")
    val blockNumber: Long,

    @SerializedName("BlockTime")
    val blockTime: Double,

    @SerializedName("BlockReward")
    val blockReward: Double,

    @SerializedName("AssetLaunchDate")
    val assetLaunchDate: String,

    @SerializedName("MaxSupply")
    val maxSupply: Double,

    @SerializedName("Type")
    val type: Long,

    @SerializedName("DocumentType")
    val documentType: DocumentType
)

enum class Algorithm(val value: String) {
    NA("N/A"),
    SHA256("SHA-256");

    companion object {
        public fun fromValue(value: String): Algorithm = when (value) {
            "N/A" -> NA
            "SHA-256" -> SHA256
            else -> throw IllegalArgumentException()
        }
    }
}

enum class DocumentType(val value: String) {
    Webpagecoinp("Webpagecoinp");

    companion object {
        public fun fromValue(value: String): DocumentType = when (value) {
            "Webpagecoinp" -> Webpagecoinp
            else -> throw IllegalArgumentException()
        }
    }
}

data class Rating(
    @SerializedName("Weiss")
    val weiss: Weiss
)

data class Weiss(
    @SerializedName("Rating")
    val rating: String,

    @SerializedName("TechnologyAdoptionRating")
    val technologyAdoptionRating: String,

    @SerializedName("MarketPerformanceRating")
    val marketPerformanceRating: String
)

data class Display(
    @SerializedName("IDR")
    val IDR: DisplayIDR
)

data class DisplayIDR(
    @SerializedName("FROMSYMBOL")
    val fromsymbol: String,

    @SerializedName("TOSYMBOL")
    val tosymbol: PurpleTOSYMBOL,

    @SerializedName("MARKET")
    val market: PurpleMARKET,

    @SerializedName("PRICE")
    val price: String,

    @SerializedName("LASTUPDATE")
    val lastupdate: Lastupdate,

    @SerializedName("LASTVOLUME")
    val lastvolume: String,

    @SerializedName("LASTVOLUMETO")
    val lastvolumeto: String,

    @SerializedName("LASTTRADEID")
    val lasttradeid: String,

    @SerializedName("VOLUMEDAY")
    val volumeday: String,

    @SerializedName("VOLUMEDAYTO")
    val volumedayto: String,

    @SerializedName("VOLUME24HOUR")
    val volume24Hour: String,

    @SerializedName("VOLUME24HOURTO")
    val volume24Hourto: String,

    @SerializedName("OPENDAY")
    val openday: String,

    @SerializedName("HIGHDAY")
    val highday: String,

    @SerializedName("LOWDAY")
    val lowday: String,

    @SerializedName("OPEN24HOUR")
    val open24Hour: String,

    @SerializedName("HIGH24HOUR")
    val high24Hour: String,

    @SerializedName("LOW24HOUR")
    val low24Hour: String,

    @SerializedName("LASTMARKET")
    val lastmarket: String,

    @SerializedName("VOLUMEHOUR")
    val volumehour: String,

    @SerializedName("VOLUMEHOURTO")
    val volumehourto: String,

    @SerializedName("OPENHOUR")
    val openhour: String,

    @SerializedName("HIGHHOUR")
    val highhour: String,

    @SerializedName("LOWHOUR")
    val lowhour: String,

    @SerializedName("TOPTIERVOLUME24HOUR")
    val toptiervolume24Hour: String,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    val toptiervolume24Hourto: String,

    @SerializedName("CHANGE24HOUR")
    val change24Hour: String,

    @SerializedName("CHANGEPCT24HOUR")
    val changepct24Hour: String,

    @SerializedName("CHANGEDAY")
    val changeday: String,

    @SerializedName("CHANGEPCTDAY")
    val changepctday: String,

    @SerializedName("CHANGEHOUR")
    val changehour: String,

    @SerializedName("CHANGEPCTHOUR")
    val changepcthour: String,

    @SerializedName("CONVERSIONTYPE")
    val conversiontype: Conversiontype,

    @SerializedName("CONVERSIONSYMBOL")
    val conversionsymbol: Conversionsymbol,

    @SerializedName("SUPPLY")
    val supply: String,

    @SerializedName("MKTCAP")
    val mktcap: String,

    @SerializedName("MKTCAPPENALTY")
    val mktcappenalty: Mktcappenalty,

    @SerializedName("TOTALVOLUME24H")
    val totalvolume24H: String,

    @SerializedName("TOTALVOLUME24HTO")
    val totalvolume24Hto: String,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totaltoptiervolume24H: String,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totaltoptiervolume24Hto: String,

    @SerializedName("IMAGEURL")
    val imageurl: String
)

enum class Conversionsymbol(val value: String) {
    Btc("BTC"),
    Empty(""),
    Eth("ETH");

    companion object {
        public fun fromValue(value: String): Conversionsymbol = when (value) {
            "BTC" -> Btc
            "" -> Empty
            "ETH" -> Eth
            else -> throw IllegalArgumentException()
        }
    }
}

enum class Conversiontype(val value: String) {
    Direct("direct"),
    Multiply("multiply");

    companion object {
        public fun fromValue(value: String): Conversiontype = when (value) {
            "direct" -> Direct
            "multiply" -> Multiply
            else -> throw IllegalArgumentException()
        }
    }
}

enum class Lastupdate(val value: String) {
    JustNow("Just now"),
    The4MinAgo("4 min ago");

    companion object {
        public fun fromValue(value: String): Lastupdate = when (value) {
            "Just now" -> JustNow
            "4 min ago" -> The4MinAgo
            else -> throw IllegalArgumentException()
        }
    }
}

enum class PurpleMARKET(val value: String) {
    CryptoCompareIndex("CryptoCompare Index");

    companion object {
        public fun fromValue(value: String): PurpleMARKET = when (value) {
            "CryptoCompare Index" -> CryptoCompareIndex
            else -> throw IllegalArgumentException()
        }
    }
}

enum class Mktcappenalty(val value: String) {
    The0("0 %");

    companion object {
        public fun fromValue(value: String): Mktcappenalty = when (value) {
            "0 %" -> The0
            else -> throw IllegalArgumentException()
        }
    }
}

enum class PurpleTOSYMBOL(val value: String) {
    Empty("\$");

    companion object {
        public fun fromValue(value: String): PurpleTOSYMBOL = when (value) {
            "\$" -> Empty
            else -> throw IllegalArgumentException()
        }
    }
}

data class Raw(
    @SerializedName("IDR")
    val IDR: RawIDR
)

data class RawIDR(
    @SerializedName("TYPE")
    val type: String,

    @SerializedName("MARKET")
    val market: FluffyMARKET,

    @SerializedName("FROMSYMBOL")
    val fromsymbol: String,

    @SerializedName("TOSYMBOL")
    val tosymbol: FluffyTOSYMBOL,

    @SerializedName("FLAGS")
    val flags: String,

    @SerializedName("PRICE")
    val price: Double,

    @SerializedName("LASTUPDATE")
    val lastupdate: Long,

    @SerializedName("MEDIAN")
    val median: Double,

    @SerializedName("LASTVOLUME")
    val lastvolume: Double,

    @SerializedName("LASTVOLUMETO")
    val lastvolumeto: Double,

    @SerializedName("LASTTRADEID")
    val lasttradeid: String,

    @SerializedName("VOLUMEDAY")
    val volumeday: Double,

    @SerializedName("VOLUMEDAYTO")
    val volumedayto: Double,

    @SerializedName("VOLUME24HOUR")
    val volume24Hour: Double,

    @SerializedName("VOLUME24HOURTO")
    val volume24Hourto: Double,

    @SerializedName("OPENDAY")
    val openday: Double,

    @SerializedName("HIGHDAY")
    val highday: Double,

    @SerializedName("LOWDAY")
    val lowday: Double,

    @SerializedName("OPEN24HOUR")
    val open24Hour: Double,

    @SerializedName("HIGH24HOUR")
    val high24Hour: Double,

    @SerializedName("LOW24HOUR")
    val low24Hour: Double,

    @SerializedName("LASTMARKET")
    val lastmarket: String,

    @SerializedName("VOLUMEHOUR")
    val volumehour: Double,

    @SerializedName("VOLUMEHOURTO")
    val volumehourto: Double,

    @SerializedName("OPENHOUR")
    val openhour: Double,

    @SerializedName("HIGHHOUR")
    val highhour: Double,

    @SerializedName("LOWHOUR")
    val lowhour: Double,

    @SerializedName("TOPTIERVOLUME24HOUR")
    val toptiervolume24Hour: Double,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    val toptiervolume24Hourto: Double,

    @SerializedName("CHANGE24HOUR")
    val change24Hour: Double,

    @SerializedName("CHANGEPCT24HOUR")
    val changepct24Hour: Double,

    @SerializedName("CHANGEDAY")
    val changeday: Double,

    @SerializedName("CHANGEPCTDAY")
    val changepctday: Double,

    @SerializedName("CHANGEHOUR")
    val changehour: Double,

    @SerializedName("CHANGEPCTHOUR")
    val changepcthour: Double,

    @SerializedName("CONVERSIONTYPE")
    val conversiontype: Conversiontype,

    @SerializedName("CONVERSIONSYMBOL")
    val conversionsymbol: Conversionsymbol,

    @SerializedName("SUPPLY")
    val supply: Double,

    @SerializedName("MKTCAP")
    val mktcap: Double,

    @SerializedName("MKTCAPPENALTY")
    val mktcappenalty: Long,

    @SerializedName("TOTALVOLUME24H")
    val totalvolume24H: Double,

    @SerializedName("TOTALVOLUME24HTO")
    val totalvolume24Hto: Double,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totaltoptiervolume24H: Double,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totaltoptiervolume24Hto: Double,

    @SerializedName("IMAGEURL")
    val imageurl: String
)

enum class FluffyMARKET(val value: String) {
    Cccagg("CCCAGG");

    companion object {
        public fun fromValue(value: String): FluffyMARKET = when (value) {
            "CCCAGG" -> Cccagg
            else -> throw IllegalArgumentException()
        }
    }
}

enum class FluffyTOSYMBOL(val value: String) {
    IDR("IDR");

    companion object {
        public fun fromValue(value: String): FluffyTOSYMBOL = when (value) {
            "IDR" -> IDR
            else -> throw IllegalArgumentException()
        }
    }
}

data class MetaData(
    @SerializedName("Count")
    val count: Long
)

