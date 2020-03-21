package mx.edu.ittepic.ladm_u2_practica3_jonathanlopez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //J1
    var iniciadoJ1= false
    var pausaJ1 = true
    //J2
    var iniciadoJ2= false
    var pausaJ2 = true
    //J3
    var iniciadoJ3= false
    var pausaJ3 = true
    //J4
    var iniciadoJ4= false
    var pausaJ4 = true
    //Turno y Jugador
    var r1=false
    var r2=false
    var r3=false
    var r4=false
    var puntosj1=0
    var puntosj2=0
    var puntosj3=0
    var puntosj4=0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            limpiarCampos()
            statusJ1.setText("Esperando Turno")
            statusJ2.setText("Esperando Turno")
            statusJ3.setText("Esperando Turno")
            statusJ4.setText("Esperando Turno")
            r1=true
            pausaJ1=false

            var hilo1= Hilo1(this); hilo1?.start()
            var hilo2= Hilo2(this); hilo2?.start()
            var hilo3= Hilo3(this); hilo3?.start()
            var hilo4= Hilo4(this); hilo4?.start()


        }
    }

    fun limpiarCampos(){
        j1t1d1.setText("-");j1t1d2.setText("-");j1t1t1.setText("0")
        j1t2d1.setText("-");j1t2d2.setText("-");j1t2t2.setText("0")
        j1t3d1.setText("-");j1t3d2.setText("-");j1t3t3.setText("0")
        j1t4d1.setText("-");j1t4d2.setText("-");j1t4t4.setText("0")
        j2t1d1.setText("-");j2t1d2.setText("-");j2t1t1.setText("0")
        j2t2d1.setText("-");j2t2d2.setText("-");j2t2t2.setText("0")
        j2t3d1.setText("-");j2t3d2.setText("-");j2t3t3.setText("0")
        j2t4d1.setText("-");j2t4d2.setText("-");j2t4t4.setText("0")
        j3t1d1.setText("-");j3t1d2.setText("-");j3t1t1.setText("0")
        j3t2d1.setText("-");j3t2d2.setText("-");j3t2t2.setText("0")
        j3t3d1.setText("-");j3t3d2.setText("-");j3t3t3.setText("0")
        j3t4d1.setText("-");j3t4d2.setText("-");j3t4t4.setText("0")
        j4t1d1.setText("-");j4t1d2.setText("-");j4t1t1.setText("0")
        j4t2d1.setText("-");j4t2d2.setText("-");j4t2t2.setText("0")
        j4t3d1.setText("-");j4t3d2.setText("-");j4t3t3.setText("0")
        j4t4d1.setText("-");j4t4d2.setText("-");j4t4t4.setText("0")

        pj1.setText("-")
        pj2.setText("-")
        pj3.setText("-")
        pj4.setText("-")
    }
}


class Hilo1(p:MainActivity) : Thread(){

    var puntero = p


    override fun run() {  //Se ejecuta una sola vez en segundo plano
        super.run()
        puntero.iniciadoJ1 = true
        while (puntero.iniciadoJ1) {

            //RONDA 1
            if (!puntero.pausaJ1 && puntero.r1) {

                puntero.statusJ1.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j1t1d1)
                sleep(1000)
                ponerValor0a6(puntero.j1t1d2)
                sleep(1000)
                total(puntero.j1t1d1, puntero.j1t1d2, puntero.j1t1t1)
                //Pasar turno
                marcador(puntero.j1t1t1,puntero.j1t2t2,puntero.j1t3t3,puntero.j1t4t4,puntero.pj1)
                pausar()
                puntero.pausaJ2=false //despauso hilo 2
            }
            //Ronda2
            if (!puntero.pausaJ1 && puntero.r2) {

                puntero.statusJ1.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j1t2d1)
                sleep(1000)
                ponerValor0a6(puntero.j1t2d2)
                sleep(1000)
                total(puntero.j1t2d1, puntero.j1t2d2, puntero.j1t2t2)
                //Pasar turno
                pausar()
                marcador(puntero.j1t1t1,puntero.j1t2t2,puntero.j1t3t3,puntero.j1t4t4,puntero.pj1)
                puntero.pausaJ2=false //despauso hilo 2
            }
            //Ronda3
            if (!puntero.pausaJ1 && puntero.r3) {

                puntero.statusJ1.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j1t3d1)
                sleep(1000)
                ponerValor0a6(puntero.j1t3d2)
                sleep(1000)
                total(puntero.j1t3d1, puntero.j1t3d2, puntero.j1t3t3)
                //Pasar turno
                marcador(puntero.j1t1t1,puntero.j1t2t2,puntero.j1t3t3,puntero.j1t4t4,puntero.pj1)
                pausar()
                puntero.pausaJ2=false //despauso hilo 2
            }
            //Ronda4
            if (!puntero.pausaJ1 && puntero.r4) {

                puntero.statusJ1.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j1t4d1)
                sleep(1000)
                ponerValor0a6(puntero.j1t4d2)
                sleep(1000)
                total(puntero.j1t4d1, puntero.j1t4d2, puntero.j1t4t4)
                //Pasar turno
                marcador(puntero.j1t1t1,puntero.j1t2t2,puntero.j1t3t3,puntero.j1t4t4,puntero.pj1)
                pausar()
                puntero.pausaJ2=false //despauso hilo 2
            }

        }
    }

    fun pausar() { puntero.pausaJ1 = true  ; puntero.statusJ1.setText("Esperando Turno")}
    fun ponerValor0a6(etiqueta:TextView){  (0..50).forEach{etiqueta.setText((1..6).shuffled().first().toString());sleep(10)}}
    fun total(dado1:TextView,dado2:TextView,EtiquetaTotal:TextView){ var resultado = dado1.text.toString().toInt() + dado2.text.toString().toInt(); EtiquetaTotal.setText(  resultado.toString()) }
    fun marcador(t1:TextView,t2:TextView,t3:TextView,t4:TextView,total:TextView){
        var totalv=t1.text.toString().toInt()+ t2.text.toString().toInt()+
                t3.text.toString().toInt()+
                t4.text.toString().toInt()
        total.setText(totalv.toString())
    }
}

class Hilo2(p:MainActivity) : Thread(){

    var puntero = p

    override fun run() {  //Se ejecuta una sola vez en segundo plano
        super.run()
        puntero.iniciadoJ2 = true
        while (puntero.iniciadoJ2) {

            if (!puntero.pausaJ2 && puntero.r1) {

                puntero.statusJ2.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j2t1d1)
                sleep(1000)
                ponerValor0a6(puntero.j2t1d2)
                sleep(1000)
                total(puntero.j2t1d1, puntero.j2t1d2, puntero.j2t1t1)
                //Pasar turno
                marcador(puntero.j2t1t1,puntero.j2t2t2,puntero.j2t3t3,puntero.j2t4t4,puntero.pj2)
                pausar()
                puntero.pausaJ3=false //despauso hilo 3
            }
            //Ronda2
            if (!puntero.pausaJ2 && puntero.r2) {

                puntero.statusJ2.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j2t2d1)
                sleep(1000)
                ponerValor0a6(puntero.j2t2d2)
                sleep(1000)
                total(puntero.j2t2d1, puntero.j2t2d2, puntero.j2t2t2)
                //Pasar turno
                marcador(puntero.j2t1t1,puntero.j2t2t2,puntero.j2t3t3,puntero.j2t4t4,puntero.pj2)
                pausar()
                puntero.pausaJ3=false //despauso hilo 2
            }
            //Ronda3
            if (!puntero.pausaJ2 && puntero.r3) {

                puntero.statusJ2.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j2t3d1)
                sleep(1000)
                ponerValor0a6(puntero.j2t3d2)
                sleep(1000)
                total(puntero.j2t3d1, puntero.j2t3d2, puntero.j2t3t3)
                //Pasar turno
                marcador(puntero.j2t1t1,puntero.j2t2t2,puntero.j2t3t3,puntero.j2t4t4,puntero.pj2)
                pausar()
                puntero.pausaJ3=false //despauso hilo 2
            }
            if (!puntero.pausaJ2 && puntero.r4) {

                puntero.statusJ2.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j2t4d1)
                sleep(1000)
                ponerValor0a6(puntero.j2t4d2)
                sleep(1000)
                total(puntero.j2t4d1, puntero.j2t4d2, puntero.j2t4t4)
                //Pasar turno
                marcador(puntero.j2t1t1,puntero.j2t2t2,puntero.j2t3t3,puntero.j2t4t4,puntero.pj2)
                pausar()
                puntero.pausaJ3=false //despauso hilo 2
            }
        }
    }
    fun pausar() { puntero.pausaJ2 = true;puntero.statusJ2.setText("Esperando Turno") }
    fun ponerValor0a6(etiqueta:TextView){  (0..50).forEach{etiqueta.setText((1..6).shuffled().first().toString());sleep(10)}}
    fun total(dado1:TextView,dado2:TextView,EtiquetaTotal:TextView){ var resultado = dado1.text.toString().toInt() + dado2.text.toString().toInt(); EtiquetaTotal.setText(  resultado.toString()) }
    fun marcador(t1:TextView,t2:TextView,t3:TextView,t4:TextView,total:TextView){
        var totalv=t1.text.toString().toInt()+ t2.text.toString().toInt()+
                t3.text.toString().toInt()+
                t4.text.toString().toInt()
        total.setText(totalv.toString())
    }
}

class Hilo3(p:MainActivity) : Thread(){

    var puntero = p

    override fun run() {  //Se ejecuta una sola vez en segundo plano
        super.run()
        puntero.iniciadoJ3 = true
        while (puntero.iniciadoJ3) {

            if (!puntero.pausaJ3 && puntero.r1) {

                puntero.statusJ3.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j3t1d1)
                sleep(1000)
                ponerValor0a6(puntero.j3t1d2)
                sleep(1000)
                total(puntero.j3t1d1, puntero.j3t1d2, puntero.j3t1t1)
                //Pasar turno
                marcador(puntero.j3t1t1,puntero.j3t2t2,puntero.j3t3t3,puntero.j3t4t4,puntero.pj3)
                pausar()
                puntero.pausaJ4=false //despauso hilo 4
            }
            //Ronda2
            if (!puntero.pausaJ3 && puntero.r2) {

                puntero.statusJ3.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j3t2d1)
                sleep(1000)
                ponerValor0a6(puntero.j3t2d2)
                sleep(1000)
                total(puntero.j3t2d1, puntero.j3t2d2, puntero.j3t2t2)
                //Pasar turno
                marcador(puntero.j3t1t1,puntero.j3t2t2,puntero.j3t3t3,puntero.j3t4t4,puntero.pj3)
                pausar()
                puntero.pausaJ4=false //despauso hilo 2
            }
            if (!puntero.pausaJ3 && puntero.r3) {

                puntero.statusJ3.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j3t3d1)
                sleep(1000)
                ponerValor0a6(puntero.j3t3d2)
                sleep(1000)
                total(puntero.j3t3d1, puntero.j3t3d2, puntero.j3t3t3)
                //Pasar turno
                marcador(puntero.j3t1t1,puntero.j3t2t2,puntero.j3t3t3,puntero.j3t4t4,puntero.pj3)
                pausar()
                puntero.pausaJ4=false //despauso hilo 2
            }
            if (!puntero.pausaJ3 && puntero.r4) {

                puntero.statusJ3.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j3t4d1)
                sleep(1000)
                ponerValor0a6(puntero.j3t4d2)
                sleep(1000)
                total(puntero.j3t4d1, puntero.j3t4d2, puntero.j3t4t4)
                //Pasar turno
                marcador(puntero.j3t1t1,puntero.j3t2t2,puntero.j3t3t3,puntero.j3t4t4,puntero.pj3)
                pausar()
                puntero.pausaJ4=false //despauso hilo 2
            }
        }
    }
    fun pausar() { puntero.pausaJ3 = true;  puntero.statusJ3.setText("Esperando Turno") }
    fun ponerValor0a6(etiqueta:TextView){  (0..50).forEach{etiqueta.setText((1..6).shuffled().first().toString());sleep(10)}}
    fun total(dado1:TextView,dado2:TextView,EtiquetaTotal:TextView){ var resultado = dado1.text.toString().toInt() + dado2.text.toString().toInt(); EtiquetaTotal.setText(  resultado.toString()) }
    fun marcador(t1:TextView,t2:TextView,t3:TextView,t4:TextView,total:TextView){
        var totalv=t1.text.toString().toInt()+ t2.text.toString().toInt()+
                t3.text.toString().toInt()+
                t4.text.toString().toInt()
        total.setText(totalv.toString())
    }
}

class Hilo4(p:MainActivity) : Thread(){

    var puntero = p

    override fun run() {  //Se ejecuta una sola vez en segundo plano
        super.run()
        puntero.iniciadoJ4 = true
        while (puntero.iniciadoJ4) {

            if (!puntero.pausaJ4 && puntero.r1) {

                puntero.statusJ4.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j4t1d1)
                sleep(1000)
                ponerValor0a6(puntero.j4t1d2)
                sleep(1000)
                total(puntero.j4t1d1, puntero.j4t1d2, puntero.j4t1t1)
                //Pasar turno
                marcador(puntero.j4t1t1,puntero.j4t2t2,puntero.j4t3t3,puntero.j4t4t4,puntero.pj4)
                pausar()
                puntero.r1=false
                puntero.r2=true
                puntero.pausaJ1=false //despauso hilo 1
            }
            //Ronda2
            if (!puntero.pausaJ4 && puntero.r2) {

                puntero.statusJ4.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j4t2d1)
                sleep(1000)
                ponerValor0a6(puntero.j4t2d2)
                sleep(1000)
                total(puntero.j4t2d1, puntero.j4t2d2, puntero.j4t2t2)
                //Pasar turno
                marcador(puntero.j4t1t1,puntero.j4t2t2,puntero.j4t3t3,puntero.j4t4t4,puntero.pj4)
                pausar()
                puntero.r2=false
                puntero.r3=true
                puntero.pausaJ1=false //despauso hilo 2
            }
            if (!puntero.pausaJ4 && puntero.r3) {

                puntero.statusJ4.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j4t3d1)
                sleep(1000)
                ponerValor0a6(puntero.j4t3d2)
                sleep(1000)
                total(puntero.j4t3d1, puntero.j4t3d2, puntero.j4t3t3)
                //Pasar turno
                marcador(puntero.j4t1t1,puntero.j4t2t2,puntero.j4t3t3,puntero.j4t4t4,puntero.pj4)
                pausar()
                puntero.r3=false
                puntero.r4=true
                puntero.pausaJ1=false //despauso hilo 2
            }
            if (!puntero.pausaJ4 && puntero.r4) {

                puntero.statusJ4.setText("Está Tirando")
                sleep(1000)
                ponerValor0a6(puntero.j4t4d1)
                sleep(1000)
                ponerValor0a6(puntero.j4t4d2)
                sleep(1000)
                total(puntero.j4t4d1, puntero.j4t4d2, puntero.j4t4t4)
                //Pasar turno
                marcador(puntero.j4t1t1,puntero.j4t2t2,puntero.j4t3t3,puntero.j4t4t4,puntero.pj4)
                pausar()

                puntero.r4=false
                puntero.pausaJ1=true
                puntero.pausaJ2=true
                puntero.pausaJ3=true
                puntero.iniciadoJ1=false
                puntero.iniciadoJ2=false
                puntero.iniciadoJ3=false
                puntero.statusJ1.setText("[Estado]")
                puntero.statusJ2.setText("[Estado]")
                puntero.statusJ3.setText("[Estado]")
                puntero.statusJ4.setText("[Estado]")
                var puntoMarcador = ArrayList<Int>()
                var mayor = 0
                var ganador= ""
                puntoMarcador.add(puntero.pj1.text.toString().toInt())
                puntoMarcador.add(puntero.pj2.text.toString().toInt())
                puntoMarcador.add(puntero.pj3.text.toString().toInt())
                puntoMarcador.add(puntero.pj4.text.toString().toInt())

                mayor=puntoMarcador[0]
                (0..3).forEach{

                    if(mayor<puntoMarcador[it]){mayor=puntoMarcador[it]}
                }
                if(mayor==puntero.pj1.text.toString().toInt()){ganador="Jugador 1"}
                if(mayor==puntero.pj2.text.toString().toInt()){ganador="Jugador 2"}
                if(mayor==puntero.pj3.text.toString().toInt()){ganador="Jugador 3"}
                if(mayor==puntero.pj4.text.toString().toInt()){ganador="Jugador 4"}

                puntero.runOnUiThread {
                    AlertDialog.Builder(puntero)
                            .setMessage("El Juego ha terminado" + "\n\n\n" + "GANADOR: "+ganador+"\n"+"PUNTAJE: "+ mayor)
                            .setTitle("Atención")
                            .setPositiveButton("Ok") { d, i ->
                                puntero.pausaJ4=true
                                puntero.iniciadoJ4 = false
                            }
                            .show()

                }

            }




        }
    }
    fun pausar() { puntero.pausaJ4 = true; puntero.statusJ4.setText("Esperando Turno") }
    fun ponerValor0a6(etiqueta:TextView){  (0..50).forEach{etiqueta.setText((1..6).shuffled().first().toString());sleep(10)}}
    fun total(dado1:TextView,dado2:TextView,EtiquetaTotal:TextView){ var resultado = dado1.text.toString().toInt() + dado2.text.toString().toInt(); EtiquetaTotal.setText(  resultado.toString()) }
    fun marcador(t1:TextView,t2:TextView,t3:TextView,t4:TextView,total:TextView){
        var totalv=t1.text.toString().toInt()+ t2.text.toString().toInt()+
                t3.text.toString().toInt()+
                t4.text.toString().toInt()
        total.setText(totalv.toString())
    }

}

