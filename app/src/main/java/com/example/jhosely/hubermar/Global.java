package com.example.jhosely.hubermar;

import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by jhosely on 9/10/19.
 */

public class Global {
    public static String informacion="";
    public static String nombre="";
    public static String clave="";
    public static String usuario="";
    public static String perfil="";
    public static String sucursal="";
    public static int posSucursal=0;
    public static String tercero="";
    public static int posTercero=0;
    public static String reporte="";
    public static int posReporte=0;

    public static String importador="";
    public static int posImportador;

    public static String numeroDo="";
    public static String noPedido="";
    public static String ordenCompra="";
    public static String noAceptacion="";

    public static String aperturaIni="";
    public static String aperturaFin="";
    public static String levanteIni="";
    public static String levanteFin="";
    public static String regimen="";
    public static int posRegimen=0;
    public static String estado="";
    public static int posEstado=0;



    public static void setImportador(String importador) {
        switch (importador){
            case "SAINT - GOBAIN ABRASIVOS COLOMBIA LTDA":
                Global.importador = "46";
                break;
            case "INDUSTRIA NACIONAL DE GASEOSAS S.A.":
                Global.importador = "15";
                break;
            case "SAINT-GOBAIN COLOMBIA S.A.S.":
                Global.importador = "32";
                break;
            default:
                Global.importador = "";
        }
    }

    public static void SpinerTerceros(){
        List<String> datos;
        String[] nombres;
    }

    public static void setReporte(String reporte) {

        switch (reporte){
            case "Dim Reporte Tributario DIM":
                Global.reporte="1";
                break;
            case "Clientes - Archivos Planos Merck":
                Global.reporte="102";
                break;
            case "Clientes - Informe Daimler":
                Global.reporte="67";
                break;
            case "Contables - Movimientos causados por DO's":
                Global.reporte="4";
                break;
            case "Contables - Reporte de Conceptos Facturados":
                Global.reporte="41";
                break;
            case "Dim - Declaraciones Sircoc":
                Global.reporte="50";
                break;
            case "Operaciones - Operaciones en Proceso":
                Global.reporte="2";
                break;
            case "Exportaciones - Informe Exportaciones":
                Global.reporte="69";
                break;
            case "Clientes - Informe ISP Importaciones":
                Global.reporte="78";
                break;
            case "Exportaciones - Estado Motonaves":
                Global.reporte="97";
                break;
            default:
                Global.reporte="";
        }

    }

    public static void setSucursal(String sucursal) {
        switch (sucursal){
            case "Todas":
                Global.sucursal="0";
                break;
            case "Barranquilla":
                Global.sucursal="BQ";
                break;
            case "Bogota":
                Global.sucursal="BG";
                break;
            case "Buenaventura":
                Global.sucursal="BV";
                break;
            case "Cartagena":
                Global.sucursal="CG";
                break;
            case "Medellin":
                Global.sucursal="MD";
                break;
            case "Santa Marta":
                Global.sucursal="SM";
                break;
            default:
                Global.sucursal="";
        }
    }
}
