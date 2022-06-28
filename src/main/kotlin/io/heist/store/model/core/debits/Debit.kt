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
package io.heist.store.model.core.debits

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.amounts.Amount
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*

/**
 * Account to or from which a cash entry is made.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Debit (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Property
    val mandateId: String? = null,

    @Index
    val status: String? = null,

    @Index
    val name: String? = null,

    @Property
    val prev: OffsetDateTime? = null,

    @Property
    val frequency: String? = null,

    @Relationship("IS_ACCOUNT_OF")
    val account: Account? = null,

    @Relationship("IS_AMOUNT_OF")
    val amount: Amount? = null

) {
    @Property
    val debitStatus = DirectDebitStatus.fromValue(status!!)
}
