package com.example.logonrmlocal.revisaoapi.api

import com.example.logonrmlocal.revisaoapi.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonAPI{
    @GET("/v2/api/pokemon/{numero}")
    fun  buscarPokemon(numero: Int) : Call<Pokemon>
}