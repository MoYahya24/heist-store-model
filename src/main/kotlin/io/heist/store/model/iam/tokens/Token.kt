/*
 * Copyright (c) 2020. Weird ( The Weird Science Holding B.V. )
 *
 * All rights reserved.
 */
package io.heist.store.model.iam.tokens

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.Index
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property

@NodeEntity
data class Token (
    @Id
    val access_token: String? = null,

    @Index
    val expires_in: Long? = null,

    @Property
    val token_type: String? = null,

    @Property
    val scope: String? = null,

    @Property
    val state: String? = null,

    @Property
    val id_token: String? = null,

    @Property
    val principal: String? = null

)