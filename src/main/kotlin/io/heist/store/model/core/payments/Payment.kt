/*
 * Copyright (c) 2020. Weird ( The Weird Science Holding B.V. )
 *
 * All rights reserved.
 */
package io.heist.store.model.core.payments

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.extensions.Extension
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.math.BigDecimal
import java.time.Duration
import java.time.OffsetDateTime
import java.time.Period
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Payment (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Relationship(type = "IS_AMOUNT_TO", direction = Relationship.INCOMING)
    val amount: Amount? = null,

    @Relationship(type = "IS_TRANSACTED_FROM", direction = Relationship.INCOMING)
    val from: Alias? = null,

    @Relationship(type = "IS_TRANSACTED_TO", direction = Relationship.INCOMING)
    val to: Alias? = null,

    @JsonIgnore
    @Relationship(type = "IS_PAYMENT_BY", direction = Relationship.INCOMING)
    val account: Account? = null,

    @Relationship(type = "IS_SCHEDULED_BY", direction = Relationship.INCOMING)
    val schedule: Schedule? = null,

    @Relationship(type = "IS_EXTENDED_BY", direction = Relationship.INCOMING)
    val extensions: List<Extension>? = null

)