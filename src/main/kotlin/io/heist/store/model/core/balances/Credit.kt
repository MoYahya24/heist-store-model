package io.heist.store.model.core.balances

import io.heist.store.model.core.amounts.Amount
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Relationship

data class Credit (

    @Id
    val id: String? = null,

    @Property
    val included: Boolean? = null,

    @Property
    val type: String? = null,

    @Relationship(type = "IS_AMOUNT_OF", direction = Relationship.INCOMING)
    val amount: Amount? = null

) {
    @Property
    val creditType = CreditType.fromValue(type!!)
}