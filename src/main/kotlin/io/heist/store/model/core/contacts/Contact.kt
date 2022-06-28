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
package io.heist.store.model.core.contacts

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.heist.store.model.core.addresses.Address
import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.extensions.Extension
import io.heist.store.model.core.parties.Party
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Contact (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Property
    val type: String? = null,


    @Index
    val ref: String? = null,

    @Index
    val name: String? = null,

    @Property
    val email: String? = null,

    @Index
    val phone: String? = null,

    @Relationship(type = "IS_ADDRESSED_OF", direction = Relationship.INCOMING)
    val addresses: List<Address>? = null,

    @Relationship(type = "IS_CONTACT_BY", direction = Relationship.OUTGOING)
    val party: Party? = null,

    @Relationship(type = "IS_ACCOUNT_OF", direction = Relationship.INCOMING)
    val alias: Alias? = null,

    @Relationship(type = "IS_EXTENDED_BY", direction = Relationship.INCOMING)
    val extensions: List<Extension?>? = null

) {
    @Property
    val contactType = ContactType.fromValue(type!!)
}