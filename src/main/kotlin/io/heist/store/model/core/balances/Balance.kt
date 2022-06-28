package io.heist.store.model.core.balances

import io.heist.store.model.core.amounts.Amount
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.time.OffsetDateTime

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