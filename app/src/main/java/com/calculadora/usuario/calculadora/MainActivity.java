package com.calculadora.usuario.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private Button button0, button1, button2, button3, button4,button5, button6, button7, button8, button9, buttonDiv, buttonMul, buttonIgual, buttonRes, buttonMas, buttonComa;
    private String pantalla= "";

    private double valorA, valorB;
    private int contMas=0, contMenos=0, contMult=0, div=0, cont=0;
    double aux=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.resultado);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonIgual = (Button) findViewById(R.id.buttonIgual);
        buttonRes = (Button) findViewById(R.id.buttonRes);
        buttonMas = (Button) findViewById(R.id.buttonMas);
        buttonComa = (Button) findViewById(R.id.buttonComa);

    }



    public String numero(Button a){

        return  a.getText().toString();
    }
    public void onclick0(View view){

        pantalla += numero(button0);
        resultado.setText(pantalla);
    }
    public void onclick1(View view){

        pantalla += numero(button1);
        resultado.setText(pantalla);
    }
    public void onclick2(View view){

        pantalla += numero(button2);
        resultado.setText(pantalla);
    }
    public void onclick3(View view){

        pantalla += numero(button3);
        resultado.setText(pantalla);
    }
    public void onclick4(View view){

        pantalla += numero(button4);
        resultado.setText(pantalla);
    }
    public void onclick5(View view){

        pantalla += numero(button5);
        resultado.setText(pantalla);
    }
    public void onclick6(View view){

        pantalla += numero(button6);
        resultado.setText(pantalla);
    }
    public void onclick7(View view){

        pantalla += numero(button7);
        resultado.setText(pantalla);
    }
    public void onclick8(View view){

        pantalla += numero(button8);
        resultado.setText(pantalla);
    }
    public void onclick9(View view){

        pantalla += numero(button9);
        resultado.setText(pantalla);
    }
    public void onclickMas(View view){

        try {
            //si ha hecho otra suma , añadir al valor almacenado y lo mismo con la multiplicacion, sino coger el valor inicial
            if(cont>0) {
                if(contMas>0)
                valorA +=Double.parseDouble(pantalla);
                if(contMult>0)
                    valorA *=Double.parseDouble(pantalla);
            }else{
                valorA = Double.parseDouble(pantalla);}
            pantalla = "";
            cont++;
            contMas++;
            contMult=0;
            resultado.setText(pantalla);
        }catch(Exception e){
            //Toas es para usar notificacion emergente
            Toast.makeText(this,"Introduce valor",Toast.LENGTH_LONG).show();
        }

    }
    public void onclickMenos(View view){

        try{
        valorA -= Double.parseDouble(pantalla);
        pantalla= "";
        contMenos++;
        resultado.setText(pantalla);
        }catch(Exception e){
            //Toas es para usar notificacion emergente
            Toast.makeText(this,"Introduce valor",Toast.LENGTH_LONG).show();
        }

    }
    public void onclickMul(View view){

        try{
            if(cont>0) {
                if(contMult>0)
                    valorA *=Double.parseDouble(pantalla);
                if(contMas>0)
                    valorA +=Double.parseDouble(pantalla);
            }else {valorA = Double.parseDouble(pantalla);}

        pantalla= "";
            cont++;
        contMas=0;
        contMult++;
        resultado.setText(pantalla);
        }catch(Exception e){
            //Toas es para usar notificacion emergente
            Toast.makeText(this,"Introduce valor",Toast.LENGTH_LONG).show();
        }

    }
    public void onclickDiv(View view){
        try{
            if(valorA==0){
        valorA= Double.parseDouble(pantalla);}
            else valorA /= Double.parseDouble(pantalla);
        pantalla= "";
        div=1;
        resultado.setText(pantalla);
        }catch(Exception e){
            //Toas es para usar notificacion emergente
            Toast.makeText(this,"Introduce valor",Toast.LENGTH_LONG).show();
        }


    }
    public void onclickIgual(View view){
        try {
            valorB = Double.parseDouble(pantalla);

            if(contMas>0) {
                aux = valorA + valorB;

            }else if(contMenos>0) {
                aux = valorA - valorB;
                contMenos=0;
            }else if(contMult>0){
                aux = valorA * valorB;

            }else if(div==1){
                aux = valorA / valorB;
                div=0;
            }else aux= Double.parseDouble(pantalla);

            pantalla= Double.toString(aux);
            aux=0;
            contMas=0;
            contMult=0;
            resultado.setText(pantalla);
            pantalla= "";
            cont=0;

        }catch(Exception e){
            resultado.setText("Introduce valor");
            //Toas es para usar notificacion emergente
            Toast.makeText(this,"Introduce valor",Toast.LENGTH_LONG).show();
        }
    }

    public void onclickBorrar( View view){

        resultado.setText("");
        pantalla="";
        valorA=0;
        valorB=0;
    }

    public  void onclickComa(View view){
        if(!pantalla.contains("."))
        pantalla +=".";
        resultado.setText(pantalla);

    }


}

