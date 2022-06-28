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
package io.heist.store.model.core.parties

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.addresses.Address
import io.heist.store.model.core.contacts.Contact
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Party (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Property
    val number: String? = null,

    @Property
    val type: String? = null,

    @Index
    val name: String? = null,

    @Property
    val legalName: String? = null,

    @Property
    val legalStructure: String? = null,

    @Property
    val beneficial: Boolean? = null,

    @Property
    val role: String? = null,

    @Index
    val email: String? = null,

    @Index
    val phone: String? = null,

    @Property
    val mobile: String? = null,

    @Relationship(type = "IS_ADDRESSED_OF", direction = Relationship.INCOMING)
    val addresses: List<Address>? = null,

    @Relationship(type = "IS_OWNED_BY", direction = Relationship.INCOMING)
    val accounts: List<Account>? = null,

    @Relationship(type = "IS_CONTACT_BY", direction = Relationship.INCOMING)
    val contacts: List<Contact>? = null

) {
    @Property
    val partyType = PartyType.fromValue(type!!)
}

