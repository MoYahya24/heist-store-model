package io.heist.store.model.core.transactions

import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
enum class Auth(val value: String) {
    CONSUMERDEVICE("ConsumerDevice"), CONTACTLESS("Contactless"), NONE("None"), PIN("PIN");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): Auth {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}