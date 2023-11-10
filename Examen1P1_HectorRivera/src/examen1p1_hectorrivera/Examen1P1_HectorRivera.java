
package examen1p1_hectorrivera;

import java.util.Scanner;
import java.util.Random;

public class Examen1P1_HectorRivera {

    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args) { 
        Random rand=new Random();
        

        System.out.println("------------------Menu------------------");
        System.out.println("1. Ejercicio práctico 1 – Fight or Flight");
        System.out.println("2. Ejercicio práctico 2 – Tri Fuerza ");
        System.out.println("3. Salir");
        int opc=sc.nextInt();
        while(opc>0&&opc<3){
            switch(opc){
                
                case 1:{
                    //variables
                    int HP=25,blt=25,chan,dmg;
                    int dis=rand.nextInt(15)+15;
                    double prob=0;
                    char desc='S';
                    
                    //elecion
                    System.out.println("Ingrese Maestria: ");
                    System.out.println("1. Principiante (+probabilidad de hit extra +0%)");
                    System.out.println("2. Intermedio(+probabilidad de hit extra +5%)");
                    System.out.println("3. Experto (+probabilidad de hit extra +15%)");
                    int opc1=sc.nextInt();
                   
                    
                    
                    switch(opc1){
                        case 1:
                            prob=0.0;
                            break;
                        case 2:
                            prob=0.05;
                            break;
                        case 3:    
                            prob=0.15;
                            break;
                    }//Define la probabilidad
                     
                    while(HP>0 && dis>0&&(desc=='s'||desc=='S')){
                        System.out.println("el zombie se encuentra a "+dis+" metros");
                        System.out.println("");
                        System.out.println("El jugador cuenta con "+blt+" balas");
                        chan=rand.nextInt(100);
                        
                        if( chan<=(65+(100*prob)) ){
                            dmg=rand.nextInt(6)+1;
                            System.out.println("Hit a causado "+dmg+" de daño");
                            HP=HP-dmg;
                            blt-=1;
                        }else{
                            System.out.println();
                            System.out.println("A fallado");
                            dis=dis-(rand.nextInt(2)+3);
                        }//calcular disparo
                        
                        System.out.println();
                        System.out.println();//Espacios para que se vea menos pegado
                        
                        if(HP<=0){
                            HP=0;
                            System.out.println("Vida del zombie: " + HP);
                            System.out.println("El zombie esta a "+ dis +" metros");
                            System.out.println("En hora buena a Ganado");
                            
                        }else if(dis<=0){
                            System.out.println("Vida del zombie: " + HP);
                            System.out.println("El zombie esta a "+ dis +" metros");
                            System.out.println();
                            System.out.println("A fallado el zombie lo mato");
                        }else if(blt==0){
                            System.out.println("Vida del zombie: " + HP);
                            System.out.println("El zombie esta a "+ dis +" metros");
                            System.out.println();
                            System.out.println("A fallado se a quedado sin balas");
                        }else{
                            System.out.println("Vida del zombie: " + HP);
                            System.out.println("El zombie esta a "+ dis +" metros");
                            System.out.println();
                            System.out.println();
                            System.out.println("Listo para la siguente ronda: [s/n]");
                            desc=sc.next().charAt(0);
                            System.out.println();      
                        }//condiciones de victoria/derrota
                         
                    }// fin while juego
                    
                }break;//fin case 1 Fight or Flight    
                
                case 2:
                    triF();
                break;//fin case 2 Tri Fuerza    
                
            }//fin switch
            System.out.println("------------------Menu------------------");
            System.out.println("1. Ejercicio práctico 1 – Fight or Flight");
            System.out.println("2. Ejercicio práctico 2 – Tri Fuerza ");
            System.out.println("3.salir");
            opc=sc.nextInt();
        }//fin while
        
    
    }//fin main
    public static void triF(){
        System.out.println("Ingrese Tamaño: ");
        int tam=sc.nextInt();
        
        while(tam<20 || (tam/2)%2==0){
            System.out.println("Ingrese un numero mayor a 20 y que su residuo de divicion por 2 sea impar");
            tam=sc.nextInt();
        }//fin validacion tamaño
        
        for (int y = 0; y < tam/2+1; y++) {
            for (int x = 0; x < tam+1; x++) {
                
                if(x ==tam/2-y  || x == tam/2+y){//crear forma triangulo
                    System.out.print("*");    
                }else if( (x+1<=y&&x>=tam/2-y) || ( x>=tam-y+1 && x <= tam/2+y) ){//crear y llenar triangulos de abajo
                    System.out.print("*");
                }else if(y<=(tam-1)/4 && (x >=tam/2-y  && x <= tam/2+y)) {//llenar triangulo de arriba
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }//fin X
            System.out.println();
            
        }//fin Y
    }//fin triF
}

