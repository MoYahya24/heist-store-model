package io.heist.store.model.core.accounts

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.balances.Balance
import io.heist.store.model.core.extensions.Extension
import io.heist.store.model.core.institutes.Institute
import io.heist.store.model.core.parties.Party
import io.heist.store.model.core.payments.Payment
import io.heist.store.model.core.transactions.Transaction
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.time.OffsetDateTime


@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Account (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id : String? = null,

    @Index
    val ref : String? = null,

    @Property
    val type: String? = null,

    @Property
    val accSubType : AccountSubType? = null,

    @Property
    val status: String? = null,

    @Index
    val currency: String? = null,

    @Property
    val description: String? = null,

    @Index
    val nickname: String? = null,

    @Index
    val updated: OffsetDateTime? = null,

    @Property
    val opened: OffsetDateTime? = null,

    @Property
    val matures: OffsetDateTime? = null,

    @Relationship(type = "IS_AVAILABLE_TO", direction = Relationship.INCOMING)
    val balance: Balance? = null,

    @Relationship(type = "IS_ALIAS_OF", direction = Relationship.INCOMING)
    val aliases: List<Alias>? = null,

    @Relationship(type = "IS_SERVICED_BY", direction = Relationship.INCOMING)
    val institute: Institute? = null,

    @JsonIgnore
    @Relationship(type = "IS_OWNED_BY", direction = Relationship.OUTGOING)
    val party: Party? = null,

    @Relationship(type = "IS_EXTENDED_BY", direction = Relationship.INCOMING)
    val extensions: List<Extension>? = null,

    @Relationship(type = "IS_TRANSACTED_ON", direction = Relationship.INCOMING)
    val transactions: List<Transaction>? = null,

    @Relationship(type = "IS_PAYMENT_BY", direction = Relationship.INCOMING)
    val payments: List<Payment?>? = null

) {
    @Property
    val accType = AccountType.fromValue(type!!)
}