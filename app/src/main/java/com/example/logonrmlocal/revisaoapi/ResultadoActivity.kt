package com.example.logonrmlocal.revisaoapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.logonrmlocal.revisaoapi.api.PokemonAPI
import com.example.logonrmlocal.revisaoapi.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_resultado.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val numero = intent.getIntExtra("NUMERO", 0)

        val retrofit = Retrofit.Builder()
                .baseUrl("www.pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val pokemonApi = retrofit.create(PokemonAPI::class.java)
        pokemonApi.buscarPokemon(numero)
                .enqueue(object : Callback<Pokemon>{
                    override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {
                        if(response?.isSuccessful!!){
                            val pokemon = response.body()
                            tvPokemon.text = pokemon?.name
                            Picasso.get()
                                    .load(pokemon?.sprites?.frontDefault)
                                    .into(ivPokemon)
                        } else{

                        }
                    }
                })
    }
}
