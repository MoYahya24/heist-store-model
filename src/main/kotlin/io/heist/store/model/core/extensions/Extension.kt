/*
 * Copyright (c) 2020. Weird ( The Weird Science Holding B.V. )
 *
 * All rights reserved.
 */
package io.heist.store.model.core.extensions

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.annotation.Properties
import org.neo4j.ogm.id.UuidStrategy


@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Extension (
    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Property
    val name: String? = null,

    @Properties
    val properties: Map<String, String>? = null

)