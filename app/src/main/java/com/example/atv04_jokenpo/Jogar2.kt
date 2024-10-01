package com.example.atv04_jokenpo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class Jogar2 : AppCompatActivity() {

    lateinit var botaoVoltar: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jogar2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        botaoVoltar = findViewById(R.id.botaoVoltar3)

        botaoVoltar.setOnClickListener {
            finish()
        }
    }

    fun escolhaPedra(view: View) {
        opcaoEscolhida("pedra")
    }

    fun escolhaPapel(view: View) {
        opcaoEscolhida("papel")
    }

    fun escolhaTesoura(view: View) {
        opcaoEscolhida("tesoura")
    }

    fun escolhaLagarto(view: View) {
        opcaoEscolhida("lagarto")
    }

    fun escolhaSpock(view: View) {
        opcaoEscolhida("spock")
    }

    var vitorias: Int = 0
    var derrotas: Int = 0

    fun opcaoEscolhida(escolhaUsuario: String) {
        val imagemResultado = findViewById<ImageView>(R.id.imagemResultado4)
        val textoResultado = findViewById<TextView>(R.id.textoResultado1)
        val imagemEscolhida = findViewById<ImageView>(R.id.imagemResultado3)

        val opcoes = arrayOf("pedra", "papel", "tesoura", "lagarto", "spock")
        val escolhaApp = opcoes[Random.nextInt(opcoes.size)]

        when (escolhaApp) {
            "pedra" -> imagemResultado.setImageResource(R.drawable.pedracirculo)
            "papel" -> imagemResultado.setImageResource(R.drawable.papelcirculo)
            "tesoura" -> imagemResultado.setImageResource(R.drawable.tesouracirculo)
            "lagarto" -> imagemResultado.setImageResource(R.drawable.lagartocirculo)
            "spock" -> imagemResultado.setImageResource(R.drawable.spockcirculo)
        }

        when (escolhaUsuario) {
            "pedra" -> imagemEscolhida.setImageResource(R.drawable.pedracirculo)
            "papel" -> imagemEscolhida.setImageResource(R.drawable.papelcirculo)
            "tesoura" -> imagemEscolhida.setImageResource(R.drawable.tesouracirculo)
            "lagarto" -> imagemEscolhida.setImageResource(R.drawable.lagartocirculo)
            "spock" -> imagemEscolhida.setImageResource(R.drawable.spockcirculo)
        }



        when {
            escolhaApp == "tesoura" && escolhaUsuario == "papel" || escolhaApp == "tesoura" && escolhaUsuario == "lagarto"
                    || escolhaApp == "papel" && escolhaUsuario == "pedra" || escolhaApp == "pedra" && escolhaUsuario == "lagarto" ||
                    escolhaApp == "spock" && escolhaUsuario == "tesoura" || escolhaApp == "lagarto" && escolhaUsuario == "spock" ||
                    escolhaApp == "lagarto" && escolhaUsuario == "papel" || escolhaApp == "papel" && escolhaUsuario == "spock" ||
                    escolhaApp == "pedra" && escolhaUsuario == "tesoura" || escolhaApp == "spock" && escolhaUsuario == "pedra" -> {
                textoResultado.text = "Você perdeu."
                derrotas += 1
            }


            escolhaUsuario == "tesoura" && escolhaApp == "papel" || escolhaUsuario == "tesoura" && escolhaApp == "lagarto"
                    || escolhaUsuario == "papel" && escolhaApp == "pedra" || escolhaUsuario == "pedra" && escolhaApp == "lagarto" ||
                    escolhaUsuario == "spock" && escolhaApp == "tesoura" || escolhaUsuario == "lagarto" && escolhaApp == "spock" ||
                    escolhaUsuario == "lagarto" && escolhaApp == "papel" || escolhaUsuario == "papel" && escolhaApp == "spock" ||
                    escolhaUsuario == "pedra" && escolhaApp == "tesoura" || escolhaUsuario == "spock" && escolhaApp == "pedra" -> {
                textoResultado.text = "Você GANHOU!"
                vitorias += 1
            }

            else -> textoResultado.text = "Empate..."
        }
        val placar = findViewById<TextView>(R.id.placar1)

        placar.text = "Vitórias: $vitorias | Derrotas: $derrotas"

    }
}