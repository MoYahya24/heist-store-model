package io.heist.store.model.core.aliases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Alias (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Index
    val name: String? = null,

    @Index
    val scheme: String? = null,

    @Property
    val secondaryId: String? = null

)