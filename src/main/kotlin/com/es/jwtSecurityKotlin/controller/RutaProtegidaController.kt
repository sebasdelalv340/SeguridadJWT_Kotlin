package com.es.jwtSecurityKotlin.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rutas_protegidas")
class RutaProtegidaController {


    @GetMapping("/recurso1")
    fun getRecursoProtegidoUno() : String {
        return "Este recurso sólo puede ser accedido por usuarios registrados en la BDD \uD83E\uDD75"
    }

    @PostMapping("/recurso2")
    fun getRecursoProtegidoDos() : String {
        return "Insertado con éxito recurso2"
    }

    @GetMapping("/recurso/{id}")
    fun getRecursoProtegido (@PathVariable id: String) : String {
        return "Este recurso sólo puede ser accedido por su id $id \uD83E\uDD75"
    }

    @DeleteMapping("/recurso/{id}")
    fun deleteRecursoProtegido (@PathVariable id: String) : String {
        return "Este recurso ha sido borrado por su id $id \uD83E\uDD75"
    }

    @GetMapping("/usuario_autenticado")
    fun saludarUsuarioAutenticado(authentication: Authentication) : String {
        return "Hola ${authentication.name}."
    }

    @DeleteMapping("/rutas_protegidas/eliminar/{nombre}")
    fun eliminarUsuario (@PathVariable nombre: String, authentication: Authentication): String {
        return if (authentication.name == nombre || authentication.authorities.any { it.authority == "ROLE_ADMIN"}) "Eliminado usuario $nombre" else "No puede eliminar usuario"
    }




}