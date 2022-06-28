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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import java.math.BigDecimal
import java.time.OffsetDateTime

@Deprecated("")
@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Exchange (

    @Id
    private val id: String? = null,

    @Property
    val source: String? = null,

    @Property
    val target: String? = null,

    @Property
    val unit: String? = null,

    @Property
    val contract: String? = null,

    @Property
    val amount: String? = null,

    @Property
    val currency: String? = null,

    @Property
    val rate: BigDecimal? = null,

    @Property
    val quoted: OffsetDateTime? = null

)