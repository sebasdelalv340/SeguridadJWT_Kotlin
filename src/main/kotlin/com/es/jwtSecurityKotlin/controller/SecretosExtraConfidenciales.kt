package com.es.jwtSecurityKotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/secretos_extra_confidenciales")
class SecretosExtraConfidenciales {

    @GetMapping("/ficha1")
    fun getFicha1(): String? {
        return "Has descubierto un secreto"
    }

    @GetMapping("/ficha2")
    fun getFicha2(): String? {
        return "Has descubierto un secreto público"
    }
}