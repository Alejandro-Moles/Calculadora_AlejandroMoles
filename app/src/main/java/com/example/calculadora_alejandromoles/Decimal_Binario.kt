package com.example.calculadora_alejandromoles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class Decimal_Binario : AppCompatActivity() {
        private var numero1: Double = 0.0
        private var numero2: Double = 0.0

        private var operacion: Int = 0
        private var resultado: Double = 0.0
        private var ope: Int=0 //variable que comprueba si se ha realizado una operacion. Es la que permite que despues de realizar una operacion, al pulsar un boton, se ponga ese numero y no se concatene al resultado.
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*LLama a la funcion preNum para todas las teclas que hay para pulsar*/
        num1.setOnClickListener { presNum("1")}
        num2.setOnClickListener { presNum("2")}
        num3.setOnClickListener { presNum("3")}
        num4.setOnClickListener { presNum("4")}
        num5.setOnClickListener { presNum("5")}
        num6.setOnClickListener { presNum("6")}
        num7.setOnClickListener { presNum("7")}
        num8.setOnClickListener { presNum("8")}
        num9.setOnClickListener { presNum("9")}
        num0.setOnClickListener { presNum("0")}
        decimal.setOnClickListener { presNum(".") }

        /*Llama a las funciones para cada boton restante*/
        AC.setOnClickListener { borrar() }
        sumar.setOnClickListener { sumar() }
        restar.setOnClickListener { restar() }
        multiplicar.setOnClickListener { multiplicar() }
        dividir.setOnClickListener { dividir() }
        igual.setOnClickListener {resultado() }

        //hace que al pulsar el boton rojo id = hexadecimal, se cambie de actividad a la Hexadecimal.kt
        hexadecimal.setOnClickListener {
            startActivity(Intent(this,Hexadecimal::class.java))
        }
    }

    /*Funcion que coloca los numeros pulsados en la pantalla*/
    private fun presNum(num: String){
       if(ope == 0){
           pantalla.text = "${pantalla.text}$num"
       }else{
           pantalla.text = ""
           pantalla.text = "${pantalla.text}$num"
           ope = 0
       }

    }


    /*funcion que borra la pantalla*/
    private fun borrar(){
        pantalla.text= ""
        numero1 = 0.0
        numero2 = 0.0
    }

    /*Funcion que comprueba si la operacion va a ser de suma*/
    private fun sumar(){
        if (pantalla.text == ""){
        }else{
            //comprueba si el boton 2 esta desactivado y si lo esta quiere decir que la calculadora esta en modo binaria
            if(num2.isEnabled){
                numero1 = pantalla.text.toString().toDouble()
                operacion = 1 //pone en la variable operacion el valor 1, que es el que luego hace que se la suma en la funcion resultado
                pantalla.text = ""

            }else{
                var num = pantalla.text.toString().toDouble()
                numero1 = BinarioDecimal(num).toDouble()
                operacion = 1 //pone en la variable operacion el valor 1, que es el que luego hace que se la suma en la funcion resultado
                pantalla.text = ""

            }
        }


    }

    /*Funcion que comprueba si la operacion va a ser de resta*/
    private fun restar(){
        if(pantalla.text == ""){

        }else{
            if(num2.isEnabled){
                numero1 = pantalla.text.toString().toDouble()
                operacion = 2 //pone en la variable operacion el valor 2, que es el que luego hace que se la resta en la funcion resultado
                pantalla.text = ""

            }else{
                var num = pantalla.text.toString().toDouble()
                numero1 = BinarioDecimal(num).toDouble()
                operacion = 2
                pantalla.text = ""

            }
        }
    }

    /*Funcion que comprueba si la operacion va a ser de multiplicacion*/
    private fun multiplicar(){
        if(pantalla.text == ""){

        }else{
            if(num2.isEnabled){
                numero1 = pantalla.text.toString().toDouble()
                operacion = 3 //pone en la variable operacion el valor 3, que es el que luego hace que se la multiplicacion en la funcion resultado
                pantalla.text = ""

            }else{
                var num = pantalla.text.toString().toDouble()
                numero1 = BinarioDecimal(num).toDouble()
                operacion = 3
                pantalla.text = ""

            }
        }

    }

    /*Funcion que comprueba si la operacion va a ser de division*/
    private fun dividir(){
        if(pantalla.text == ""){

        }else{
            if(num2.isEnabled){
                numero1 = pantalla.text.toString().toDouble()
                operacion = 4 //pone en la variable operacion el valor 4, que es el que luego hace que se la division en la funcion resultado
                pantalla.text = ""

            }else{
                var num = pantalla.text.toString().toDouble()
                numero1 = BinarioDecimal(num).toDouble()
                operacion = 4
                pantalla.text = ""

            }
        }

    }

    private fun resultado(){
        if(pantalla.text == "" ){
            pantalla.text = ""

            Toast.makeText(this, "No hay numeros a los que operar", Toast.LENGTH_LONG).show();
        }else{
            //comprueba si la aplicacion esta en modo binario o no, si esta en modo binario hace la funcion BinarioDecimal
            if(num2.isEnabled) {
                numero2 = pantalla.text.toString().toDouble()
            }else{
                numero2 = BinarioDecimal(pantalla.text.toString().toDouble()).toDouble()
            }

            if(operacion == 1){
                resultado = numero1 + numero2
                //vuelve a comprobar si se esta en modo binario o no, dependiendo de como este, se muestran los datos de una manera u otra
                if(num2.isEnabled){
                    pantalla.text = resultado.toString()
                }else{

                    var binario = Integer.toBinaryString(resultado.toInt())
                    pantalla.text = binario
                }

                ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1

            }
            if(operacion ==2){
                resultado = numero1 - numero2
                //vuelve a comprobar si se esta en modo binario o no, dependiendo de como este, se muestran los datos de una manera u otra
                if(num2.isEnabled){
                    pantalla.text = resultado.toString()
                }else{

                    var binario = Integer.toBinaryString(resultado.toInt())
                    pantalla.text = binario
                }
                ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
            }
            if(operacion == 3){
                resultado = numero1 * numero2
                //vuelve a comprobar si se esta en modo binario o no, dependiendo de como este, se muestran los datos de una manera u otra
                if(num2.isEnabled){
                    pantalla.text = resultado.toString()
                }else{

                    var binario = Integer.toBinaryString(resultado.toInt())
                    pantalla.text = binario
                }
                ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
            }
            if(operacion == 4){
                if(numero2 == 0.0){
                    pantalla.setText("0.0")
                    //comprueba que el segundo numero no es 0
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_LONG).show();
                    ope = 1  //pone la variable para comprobar si se ha realizado una operacion a 1
                }else{
                    resultado = numero1 / numero2
                    //vuelve a comprobar si se esta en modo binario o no, dependiendo de como este, se muestran los datos de una manera u otra
                    if(num2.isEnabled){
                        pantalla.text = resultado.toString()
                    }else{

                        var binario = Integer.toBinaryString(resultado.toInt())
                        pantalla.text = binario
                    }
                    ope = 1 //pone la variable para comprobar si se ha realizado una operacion a 1
                }
            }
        }

    }

    //funcion que pasa el numero de la pantalla, que sera un numero binario a un numero entero, que es el numero que retorna
    private fun BinarioDecimal(num: Double): Int{
        var num = num
        var numeroDecimal = 0
        var i = 0
        var remainder: Long

        while(num.toInt() != 0){
            remainder = num.toLong() % 10
            num /=  10
            numeroDecimal += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            i++
        }
        return numeroDecimal
    }
}