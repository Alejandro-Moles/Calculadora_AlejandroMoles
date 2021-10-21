package com.example.calculadora_alejandromoles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hexadecimal.*
import kotlinx.android.synthetic.main.activity_main.*

class Hexadecimal : AppCompatActivity() {
    private var numero1 = ""
    private var numero2 = ""

    private var operacion: Int = 0
    private var resultado: Int = 0
    private var ope: Int=0 //variable que comprueba si se ha realizado una operacion. Es la que permite que despues de realizar una operacion, al pulsar un boton, se ponga ese numero y no se concatene al resultado
    private var numeroDeci1: Int = 0
    private var numeroDeci2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hexadecimal)


        //hace que al pulsar el Decimal  se cambie de actividad a la Decimal_Binario.kt
        cambio_decimal.setOnClickListener {
            startActivity(Intent(this,Decimal_Binario::class.java))
        }

        /*LLama a la funcion preNum para todas las teclas que hay para pulsar*/
        boton_1.setOnClickListener { presNum("1")}
        boton_2.setOnClickListener { presNum("2")}
        boton_3.setOnClickListener { presNum("3")}
        boton_4.setOnClickListener { presNum("4")}
        boton_5.setOnClickListener { presNum("5")}
        boton_6.setOnClickListener { presNum("6")}
        boton_7.setOnClickListener { presNum("7")}
        boton_8.setOnClickListener { presNum("8")}
        boton_9.setOnClickListener { presNum("9")}
        boton_0.setOnClickListener { presNum("0")}
        botonA.setOnClickListener { presNum("A")}
        botonB.setOnClickListener { presNum("B")}
        botonC.setOnClickListener { presNum("C")}
        botonD.setOnClickListener { presNum("D")}
        botonE.setOnClickListener { presNum("E")}
        botonF.setOnClickListener { presNum("F")}

        /*Llama a las funciones para cada boton restante*/
        ac.setOnClickListener { borrar() }
        boton_sumar.setOnClickListener { sumar() }
        boton_restar.setOnClickListener { restar() }
        boton_multiplicar.setOnClickListener { multiplicar() }
        boton_dividir.setOnClickListener { dividir() }
        boton_igual.setOnClickListener { resultado() }
    }

    /*Funcion que coloca los numeros pulsados en la pantalla*/
    private fun presNum(num: String){
        if(ope == 0){
            pantalla_text.text = "${pantalla_text.text}$num"
        }else{
            pantalla_text.text = ""
            pantalla_text.text = "${pantalla_text.text}$num"
            ope = 0
        }

    }

    /*funcion que borra la pantalla*/
    private fun borrar(){
        pantalla_text.text= ""

    }

    /*Funcion que comprueba si la operacion va a ser de suma*/
    private fun sumar(){
        if (pantalla_text.text == ""){
        }else{
                numero1 = pantalla_text.text.toString()
                pasarDecimalNum1()
                operacion = 1  //pone en la variable operacion el valor 1, que es el que luego hace que se la suma en la funcion resultado
                pantalla_text.text = ""
        }
    }

    /*Funcion que comprueba si la operacion va a ser de resta*/
    private fun restar(){
        if (pantalla_text.text == ""){
        }else{
            numero1 = pantalla_text.text.toString()
            pasarDecimalNum1()
            operacion = 2   //pone en la variable operacion el valor 2, que es el que luego hace que se la resta en la funcion resultado
            pantalla_text.text = ""
        }
    }

    /*Funcion que comprueba si la operacion va a ser de multiplicacion*/
    private fun multiplicar(){
        if (pantalla_text.text == ""){
        }else{
            numero1 = pantalla_text.text.toString()
            pasarDecimalNum1()
            operacion = 3   //pone en la variable operacion el valor 3, que es el que luego hace que se la multiplicacion en la funcion resultado
            pantalla_text.text = ""
        }
    }

    /*Funcion que comprueba si la operacion va a ser de division*/
    private fun dividir(){
        if (pantalla_text.text == ""){
        }else{
            numero1 = pantalla_text.text.toString()
            pasarDecimalNum1()
            operacion = 4   //pone en la variable operacion el valor 4, que es el que luego hace que se la division en la funcion resultado
            pantalla_text.text = ""
        }
    }

    private fun resultado(){
        if(pantalla_text.text == ""){
            /*Comprueba que si no hay nada en la pantalla no se pueda operar*/
            Toast.makeText(this, "Error, no hay numeros con los que operar", Toast.LENGTH_LONG).show();
        }else{
            if(operacion == 1){
                numero2 = pantalla_text.text.toString()
                pasarDecimalNum2() //funcion que convierte el segundo numero que se inserta en decimal
                resultado = numeroDeci1 + numeroDeci2
                pantalla_text.text = Integer.toHexString(resultado).toString() //el resultado que esta en decimal se pasa a hexadecimal
                ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
            }

            if(operacion == 2){
                numero2 = pantalla_text.text.toString()
                pasarDecimalNum2() //funcion que convierte el segundo numero que se inserta en decimal
                resultado = numeroDeci1 - numeroDeci2
                pantalla_text.text = Integer.toHexString(resultado).toString() //el resultado que esta en decimal se pasa a hexadecimal
                ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
            }

            if(operacion == 3){
                numero2 = pantalla_text.text.toString()
                pasarDecimalNum2() //funcion que convierte el segundo numero que se inserta en decimal
                resultado = numeroDeci1 * numeroDeci2
                pantalla_text.text = Integer.toHexString(resultado).toString() //el resultado que esta en decimal se pasa a hexadecimal
                ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
            }

            if(operacion == 4){
                numero2 = pantalla_text.text.toString()
                pasarDecimalNum2() //funcion que convierte el segundo numero que se inserta en decimal
                if(numeroDeci2 == 0){
                    //Comprueba que el numero 2 no sea 0
                    Toast.makeText(this, "Error, no se puede dividir entre cero", Toast.LENGTH_LONG).show();
                    ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
                }else{
                    resultado = numeroDeci1 / numeroDeci2
                    pantalla_text.text = Integer.toHexString(resultado).toString() //el resultado que esta en decimal se pasa a hexadecimal
                    ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
                }
            }

        }

    }
    //funcion que pasa el primer numero que se ha insertado a hexadecimal
    private fun pasarDecimalNum1(){
        var decimal = numero1
        numeroDeci1 = Integer.parseInt(decimal, 16)
    }
    //funcion que pasa el segundo numero que se ha insertado a hexadecimal
    private fun pasarDecimalNum2(){
        var decimal = numero2
        numeroDeci2 = Integer.parseInt(decimal, 16)
    }
}