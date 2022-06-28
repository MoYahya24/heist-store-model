package io.heist.store.model.core.transactions

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property

@Deprecated("")
@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Category (

    @Id
    val id: String? = null,

    @Property
    val name: String? = null

)