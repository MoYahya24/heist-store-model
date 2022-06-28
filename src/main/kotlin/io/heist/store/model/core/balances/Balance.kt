package io.heist.store.model.core.balances

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.heist.store.model.core.amounts.Amount
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Balance (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Property
    val type: String? = null,

    @Index
    val updated: OffsetDateTime? = null,

    @Relationship(type = "IS_AMOUNT_OF", direction = Relationship.INCOMING)
    val amount: Amount? = null,


    @Relationship(type = "IS_CREDITED_TO", direction = Relationship.INCOMING)
    val credits: List<Credit>? = null

) {
    @Property
    val balanceType = BalanceType.fromValue(type!!)
}