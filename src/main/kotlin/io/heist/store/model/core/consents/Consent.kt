package io.heist.store.model.core.consents

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.parties.Party
import io.heist.store.model.iam.tokens.Token
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.time.OffsetDateTime
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity
data class Consent (

    @Id
    @GeneratedValue(strategy = UuidStrategy::class)
    val id: String? = null,

    @Index
    val ref: String? = null,

    @Index
    val status: String? = null,

    @Property
    val permissions: List<Permission>? = null,

    @Index
    val created: OffsetDateTime? = null,

    @Property
    val updated: OffsetDateTime? = null,

    @Property
    val expired: OffsetDateTime? = null,

    @Property
    val start: OffsetDateTime? = null,

    @Property
    val end: OffsetDateTime? = null,

    @Relationship(type = "IS_CONSENT_BY", direction = Relationship.OUTGOING)
    val party: Party? = null,

    @Relationship(type = "IS_OWNED_BY", direction = Relationship.OUTGOING)
    val account: Account? = null,

    @Relationship(type = "IS_OWNED_BY", direction = Relationship.OUTGOING)
    val token: Token? = null,

) {
    @Property
    val consentStatus = ConsentStatus.fromValue(status!!)
}