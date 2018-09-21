package com.example.logonrmlocal.revisaoapi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPesquisar.setOnClickListener{

            val numeroSelecionado = etNumero.text.toString()

            if(numeroSelecionado.isEmpty()){
                Toast.makeText(this, "Informe o número do pokemon", Toast.LENGTH_LONG).show()
            }
            else {
                val numeroPesquisa = numeroSelecionado.toInt()
                if(isPokemonValido(numeroPesquisa)){
                    val resultadoIntent = Intent(this, ResultadoActivity::class.java)
                    resultadoIntent.putExtra("NUMERO", numeroSelecionado.toInt())
                    startActivity(resultadoIntent)
                }
                else {
                    Toast.makeText(this, "Informe um número de pokemon válido", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun isPokemonValido(numero: Int): Boolean{
        return numero > 0 && numero <= 251
    }
}
