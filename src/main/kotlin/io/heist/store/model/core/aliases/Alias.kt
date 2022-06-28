package io.heist.store.model.core.aliases

import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy

data class Alias (

    val id: String? = null,

    val ref: String? = null,

    val name: String? = null,

    val scheme: String? = null,

    val secondaryId: String? = null

)