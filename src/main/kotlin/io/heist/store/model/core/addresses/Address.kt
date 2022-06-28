package io.heist.store.model.core.addresses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Address (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Property
    val type: String? = null,

    @Property
    val department: String? = null,

    @Property
    val subdepartment: String? = null,

    @Index
    val street: String? = null,

    @Property
    val number: String? = null,

    @Index
    val postcode: String? = null,

    @Index
    val city: String? = null,

    @Property
    val region: String? = null,

    @Index
    val country: String? = null,

    @Property
    val lines: List<String>? = null,

)