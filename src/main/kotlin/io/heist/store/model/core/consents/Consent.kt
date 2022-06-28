package io.heist.store.model.core.consents

import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.parties.Party
import io.heist.store.model.iam.tokens.Token
import org.neo4j.ogm.annotation.*
import org.neo4j.ogm.id.UuidStrategy
import java.time.OffsetDateTime

data class Consent (

    val id: String? = null,

    val ref: String? = null,

    val status: String? = null,

    val permissions: List<Permission>? = null,

    val created: OffsetDateTime? = null,

    val updated: OffsetDateTime? = null,

    val expired: OffsetDateTime? = null,

    val start: OffsetDateTime? = null,

    val end: OffsetDateTime? = null,

    val party: Party? = null,

    val account: Account? = null,

    val token: Token? = null,

) {
    val consentStatus = ConsentStatus.fromValue(status!!)
}