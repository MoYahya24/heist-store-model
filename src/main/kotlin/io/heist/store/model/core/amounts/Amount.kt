package io.heist.store.model.core.amounts

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.Index
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.id.UuidStrategy
import java.math.BigDecimal

@NodeEntity
data class Amount (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Index
    val value: BigDecimal? = null,

    @Index
    val currency: String? = null,

    @Property
    val sign: Sign? = null

)