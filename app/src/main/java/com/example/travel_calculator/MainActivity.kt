package com.example.travel_calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.travel_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val kmLiter = 12
        val gassPrice = 5.85
        val tollPrice = 10.50

        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.editDistance.text.toString().isNotEmpty() &&
                binding.editKm.text.toString().isNotEmpty() &&
                binding.editTolls.text.toString().isNotEmpty()) {

                val distance = binding.editDistance.text.toString().toDoubleOrNull()
                val km = binding.editKm.text.toString().toDoubleOrNull()
                val tolls = binding.editTolls.text.toString().toDoubleOrNull()

                if (distance != null &&
                    km != null &&
                    tolls != null) {

                    val timeSpent = distance / km
                    val literUsed = distance / kmLiter
                    val fuelCost = literUsed * gassPrice
                    val tollCost = tolls * tollPrice
                    val totalCost = fuelCost + tollCost

                    val result = """
                        Tempo estimado de viagem: %.2f horas
                        Quantidade de litros utilizados: %.2f litros
                        Custo total com combustível: R$ %.2f
                        Custo total com pedágios: R$ %.2f
                        Custo total da viagem: R$ %.2f
                    """.trimIndent().format(timeSpent, literUsed, fuelCost, tollCost, totalCost)

                    binding.textView.text = result

                } else {
                    binding.textView.text = "Valores inválidos"
                }
            } else {
                binding.textView.text = "Preencha todos os campos para efetuar o calculo"
            }
        }
    }
}