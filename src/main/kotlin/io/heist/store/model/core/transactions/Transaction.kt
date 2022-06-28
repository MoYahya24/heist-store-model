/*
 * Copyright (c) 2020. Weird ( The Weird Science Holding B.V. )
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.heist.store.model.core.transactions

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.balances.Balance
import io.heist.store.model.core.extensions.Extension
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*

/**
 * Provides further details on an entry in the report.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Transaction (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Property
    val address: String? = null,

    @Property
    val status: String? = null,

    @Index
    val booked: OffsetDateTime? = null,

    @Index
    val valued: OffsetDateTime? = null,

    @Property
    val statements: List<String>? = null,

    @Property
    val info: String? = null,

    @Index
    val code: String? = null,

    @JsonIgnore
    @Relationship(type = "IS_TRANSACTED_ON", direction = Relationship.OUTGOING)
    val account: Account? = null,

    @Relationship(type = "IS_AMOUNT_OF", direction = Relationship.INCOMING)
    val amount: Amount? = null,

    @Relationship(type = "IS_CHARGE_FOR", direction = Relationship.INCOMING)
    val charge: Amount? = null,

    @Relationship(type = "IS_TRANSACTED_FROM", direction = Relationship.INCOMING)
    val from: Alias? = null,

    @Relationship(type = "IS_TRANSACTED_TO", direction = Relationship.INCOMING)
    val to: Alias? = null,

    @Relationship(type = "IS_CATEGORISED_AS", direction = Relationship.INCOMING)
    val category: Category? = null,

    @Relationship(type = "HAS_EXCHANGE_WITH", direction = Relationship.INCOMING)
    val exchange: Exchange? = null,

    @Relationship(type = "HAS_BALANCE_WITH", direction = Relationship.INCOMING)
    val balance: Balance? = null,

    @Relationship(type = "HAS_MERCHANT_WITH", direction = Relationship.INCOMING)
    val merchant: Merchant? = null,

    @Relationship(type = "HAS_CARD_WITH", direction = Relationship.INCOMING)
    val card: Card? = null,

    @Relationship(type = "IS_EXTENDED_BY", direction = Relationship.INCOMING)
    val extensions: List<Extension?>? = null

) {
    @Property
    val transactionStatus = TransactionStatus.fromValue(status!!)
}