package br.com.itau.warriors.sample.infrastructure.model

enum class Event(val event: String) {
    SAVE_SALE("SAVE_SALE"),
    DELETE_SALE("DELETE_SALE"),
    UPDATE_SALE("UPDATE_SALE")
}