package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.modelo.ItemMenu
import com.example.myfirstapp.modelo.ItemMesa

class MainActivity : AppCompatActivity() {
    /*declaracion de variables*/
    private var etcantidadChoclo: EditText? = null
    private var etcantidadCazuela: EditText? = null
    private var tvSubTotalChoclo: TextView? = null
    private var tvSubTotalCazuela: TextView? = null
    private var tvResultadoComida: TextView? = null
    private var tvResultadoPropina: TextView? = null
    private var tvResultadoTotal: TextView? = null
    private var btnprueba: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*aparear variables con la view*/
        etcantidadChoclo = findViewById<EditText>(R.id.cantidadChoclo)
        etcantidadCazuela = findViewById<EditText>(R.id.cantidadCazuela)
        tvSubTotalChoclo = findViewById<TextView>(R.id.cantidadTotalChoclo)
        tvSubTotalCazuela = findViewById<TextView>(R.id.cantidadTotalCazuela)
        tvResultadoComida = findViewById<TextView>(R.id.resultadoComida)
        tvResultadoPropina = findViewById<TextView>(R.id.resultadoPropina)
        tvResultadoTotal = findViewById<TextView>(R.id.resultadoTotal)
        btnprueba = findViewById<Button>(R.id.btnprueba)
        

        btnprueba?.setOnClickListener{
            /*declarar las variables principales*/
            val pastelDeChoclo = ItemMenu("choclo","12000")
            val cazuela = ItemMenu("cazuela", "10000")
            val mesaChoclo = ItemMesa(pastelDeChoclo, 0)
            val mesaCazuela = ItemMesa(cazuela, 0)
            /*optener las cantidades*/
            val cantidadChoclo = etcantidadChoclo?.text.toString().toIntOrNull() ?: 0
            val cantidadCazuela = etcantidadCazuela?.text.toString().toIntOrNull() ?: 0
            /*calcular los subtotales*/
            val calcularSubtotalChoclo: Int = mesaChoclo.calcularSubtotal(cantidadChoclo)
            val calcularSubtotalCazuela: Int = mesaCazuela.calcularSubtotal(cantidadCazuela)
            /*calcular los totales*/
            val comida = calcularSubtotalChoclo + calcularSubtotalCazuela
            val propina = comida + (0.1 * comida)
            /*mostrar en pantalla*/
            tvSubTotalChoclo?.text = calcularSubtotalChoclo.toString()
            tvSubTotalCazuela?.text = calcularSubtotalCazuela.toString()
            tvResultadoComida?.text = (comida.toString())
            tvResultadoPropina?.text = (propina.toString())
            tvResultadoTotal?.text = ((comida+propina).toString())
        }
    }
}


