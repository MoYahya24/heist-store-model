package io.heist.store.model.core.payments

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.id.UuidStrategy
import java.time.Duration
import java.time.OffsetDateTime
import java.time.Period

@NodeEntity
data class Schedule (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Property
    val start: OffsetDateTime? = null,

    @Property
    val period: Period? = null,

    @Property
    val duration: Duration? = null

)