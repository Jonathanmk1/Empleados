package d11082022;
//tenemos que generar un arraylist de tipo empleado para guardar todos los registros de los empleados, esto ya que
// la clase empleado es la madre de todas las demas clases y nos guardara estos datos

//preguntar como puedo tener bien lo de los archivos, porque no los abre y tambien 
//si debo hacer un archivo por cada empleado
//tambien, las variables pueden compartirse y por eso las puse debajo del main y no dentro de cada case (solo
//hice esto de las variables que se repetian) o solo debe ir el araylist?
import Empleado.*;
import java.io.IOException;
import java.util.ArrayList;
import utilerias.Archivo;
import utilerias.Busqueda;
import utilerias.Lectura;

public class Menu_Factura {

    public static void main(String[] args) throws IOException {
        int op, id;
        String nom, ape;
        float vt, tc;
        ArrayList<Empleado> emp = new ArrayList();
        do {
            op = Lectura.leerInt("\033[35mMenu----->Que desea vizualizar?:\033[0m\nSeleccione una opcion\n"
                    + "\033[34m1.EmpleadoPorHora\n\033[31m2.EmpleadoPorComision\n"
                    + "\033[32m3.EmpleadoAsalariado\n\033[33m4.EmpleadoBaseMasComision\n\033[36m5.Factura\n\033[35m6.Salir\033[0m");
            switch (op) {
                case 1: {
                    byte opc;
                    int ht;
                    float pg;
                    //ArrayList<Empleado> emp = new ArrayList();
                    do {
                        opc = Lectura.leerbyte("MENU:\n1.Altas\n2.Bajas\n3.Consultar"
                                + "\n4.Modificar\n5.Reportes\n6.Salir");

                        switch (opc) {
                            case 1: {
                                // emp = Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame Id:");
                                nom = Lectura.leerString("Nombre:");
                                ape = Lectura.leerString("Dame apellido:");
                                ht = Lectura.leerInt("Horas trabajadas: ");
                                pg = Lectura.leerfloat("Dame pago por hora: ");
                                emp.add(new EmpleadoPorHora(id, nom, ape, ht, pg));

                                // Archivo.guardar(emp, "empleado.dat");
                            }
                            break;
                            case 2: {
                                int po;
                                //Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame al id a borrar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    emp.remove(po);

                                    //Archivo.guardar(emp, "empleado.dat");
                                    Lectura.imprimirString("El id=" + id + " se borro satisfactoriamente");
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;
                            case 3: {
                                //Archivo.leer("empleado.dat");
                                int po = -1;
                                id = Lectura.leerInt("Dame Id a consultar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    Lectura.imprimirString(((EmpleadoPorHora) emp.get(po)).toString());
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;

                            case 4: {
                                int resp, po;
                                //emp = Archivo.leer("empleado.dat");
                                do {

                                    resp = Lectura.leerInt("Que desea modificar?\n1.Nombre\n2.Apellido\n"
                                            + "3.HorasTrab\n4.PagoHora\n5.Salir\nDame una opcion:");
                                    switch (resp) {
                                        case 1: {
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                nom = Lectura.leerString("Dame el nuevo nombre: ");
                                                ((EmpleadoPorHora) emp.get(po)).setNombre(nom);
                                                //((EmpleadoPorHora)emp.get(po)).setNombre(nom);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("El Nombre de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 2: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                ape = Lectura.leerString("Dame el apellido");
                                                ((EmpleadoPorHora) emp.get(po)).setApellido(ape);
                                                //((EmpleadoPorHora)emp.get(po)).setApellido(ape);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL apellido de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 3: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                ht = Lectura.leerInt("Dame las horas trabajadas");
                                                ((EmpleadoPorHora) emp.get(po)).setHt(ht);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("La ht de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 4: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                pg = Lectura.leerfloat("Ingrese pago por horas");
                                                ((EmpleadoPorHora) emp.get(po)).setPg(pg);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("El pxh de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;

                                    }
                                } while (resp != 5);

                            }
                            break;
                            case 5: {
                                //emp = Archivo.leer("empleado.dat");
                                for (int i = 0; i < emp.size(); i++) {
                                    Lectura.imprimirString(((EmpleadoPorHora) emp.get(i)).toString());
                                    //Lectura.imprimirString(emp.get(i).toString());
                                }

                            }
                            break;

                        }

                    } while (opc != 6);

                }
                break;
                case 2: {
                    byte opc;
                    //float vt, tc;
                    do {
                        opc = Lectura.leerbyte("MENU:\n1.Altas\n2.Bajas\n3.Consultar"
                                + "\n4.Modificar\n5.Reportes\n6.Salir");

                        switch (opc) {
                            case 1: {
                                // emp = Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame Id:");
                                nom = Lectura.leerString("Nombre:");
                                ape = Lectura.leerString("Dame apellido:");
                                vt = Lectura.leerfloat("Dame las ventas_totales");
                                tc = Lectura.leerfloat("Dame la tarida comision");
                                emp.add(new EmpleadoPorComision(id, nom, ape, vt, tc));

                                // Archivo.guardar(emp, "empleado.dat");
                            }
                            break;
                            case 2: {
                                int po;
                                //Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame al id a borrar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    emp.remove(po);

                                    //Archivo.guardar(emp, "empleado.dat");
                                    Lectura.imprimirString("El id=" + id + " se borro satisfactoriamente");
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;
                            case 3: {
                                //Archivo.leer("empleado.dat");
                                int po = -1;
                                id = Lectura.leerInt("Dame Id a consultar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    Lectura.imprimirString(((EmpleadoPorComision) emp.get(po)).toString());
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;

                            case 4: {
                                int resp, po;
                                //emp = Archivo.leer("empleado.dat");
                                do {

                                    resp = Lectura.leerInt("Que desea modificar?\n1.Nombre\n2.Apellido\n"
                                            + "3.VentasTotales\n4.TarifaComision\n5.Salir\nDame una opcion:");
                                    switch (resp) {
                                        case 1: {
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                nom = Lectura.leerString("Dame el nuevo nombre: ");
                                                ((EmpleadoPorComision) emp.get(po)).setNombre(nom);
                                                //((EmpleadoPorHora)emp.get(po)).setNombre(nom);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("El Nombre de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 2: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                ape = Lectura.leerString("Dame el apellido");
                                                ((EmpleadoPorComision) emp.get(po)).setApellido(ape);
                                                //((EmpleadoPorHora)emp.get(po)).setApellido(ape);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL apellido de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 3: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                vt = Lectura.leerfloat("Dame las ventas Totales");
                                                ((EmpleadoPorComision) emp.get(po)).setVentastotal(vt);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("Las vt de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 4: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                tc = Lectura.leerfloat("Ingrese la tarifa x comison");
                                                ((EmpleadoPorComision) emp.get(po)).setTarifasporcomision(tc);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("La tc de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;

                                    }
                                } while (resp != 5);

                            }
                            break;
                            case 5: {
                                //emp = Archivo.leer("empleado.dat");
                                for (int i = 0; i < emp.size(); i++) {
                                    Lectura.imprimirString(((EmpleadoPorComision) emp.get(i)).toString());
                                    //Lectura.imprimirString(emp.get(i).toString());
                                }

                            }
                            break;

                        }

                    } while (opc != 6);

                }

                break;
                case 3: {
                    byte opc;
                    float sal;
                    do {
                        opc = Lectura.leerbyte("MENU:\n1.Altas\n2.Bajas\n3.Consultar"
                                + "\n4.Modificar\n5.Reportes\n6.Salir");

                        switch (opc) {
                            case 1: {
                                // emp = Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame Id:");
                                nom = Lectura.leerString("Nombre:");
                                ape = Lectura.leerString("Dame apellido:");
                                sal = Lectura.leerfloat("Dame el salario");
                                emp.add(new EmpleadoAsalariado(id, nom, ape, sal));

                                // Archivo.guardar(emp, "empleado.dat");
                            }
                            break;
                            case 2: {
                                int po;
                                //Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame al id a borrar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    emp.remove(po);

                                    //Archivo.guardar(emp, "empleado.dat");
                                    Lectura.imprimirString("El id=" + id + " se borro satisfactoriamente");
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;
                            case 3: {
                                //Archivo.leer("empleado.dat");
                                int po = -1;
                                id = Lectura.leerInt("Dame Id a consultar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    Lectura.imprimirString(((EmpleadoAsalariado) emp.get(po)).toString());
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;

                            case 4: {
                                int resp, po;
                                //emp = Archivo.leer("empleado.dat");
                                do {

                                    resp = Lectura.leerInt("Que desea modificar?\n1.Nombre\n2.Apellido\n"
                                            + "3.Salario\n4.Salir\nDame una opcion:");
                                    switch (resp) {
                                        case 1: {
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                nom = Lectura.leerString("Dame el nuevo nombre: ");
                                                ((EmpleadoAsalariado) emp.get(po)).setNombre(nom);
                                                //((EmpleadoPorHora)emp.get(po)).setNombre(nom);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("El Nombre de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 2: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                ape = Lectura.leerString("Dame el apellido");
                                                ((EmpleadoAsalariado) emp.get(po)).setApellido(ape);
                                                //((EmpleadoPorHora)emp.get(po)).setApellido(ape);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL apellido de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 3: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                sal = Lectura.leerfloat("Dame el salario");
                                                ((EmpleadoAsalariado) emp.get(po)).setSalario(sal);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL salario de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                    }
                                } while (resp != 4);

                            }
                            break;
                            case 5: {
                                //emp = Archivo.leer("empleado.dat");
                                for (int i = 0; i < emp.size(); i++) {
                                    Lectura.imprimirString(((EmpleadoAsalariado) emp.get(i)).toString());
                                    //Lectura.imprimirString(emp.get(i).toString());
                                }

                            }
                            break;

                        }

                    } while (opc != 6);

                }
                break;
                case 4: {
                    byte opc;
                    float sb;
                    do {
                        opc = Lectura.leerbyte("MENU:\n1.Altas\n2.Bajas\n3.Consultar"
                                + "\n4.Modificar\n5.Reportes\n6.Salir");

                        switch (opc) {
                            case 1: {
                                // emp = Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame Id:");
                                nom = Lectura.leerString("Nombre:");
                                ape = Lectura.leerString("Dame apellido:");
                                vt = Lectura.leerfloat("Ingrese ventas totales");
                                tc = Lectura.leerfloat("Dame tarifa comision");
                                sb = Lectura.leerfloat("Dame salariobase: ");
                                emp.add(new EmpleadoBasemComision(id, nom, ape, vt, tc, sb));

                                // Archivo.guardar(emp, "empleado.dat");
                            }
                            break;
                            case 2: {
                                int po;
                                //Archivo.leer("empleado.dat");

                                id = Lectura.leerInt("Dame al id a borrar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    emp.remove(po);

                                    //Archivo.guardar(emp, "empleado.dat");
                                    Lectura.imprimirString("El id=" + id + " se borro satisfactoriamente");
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;
                            case 3: {
                                //Archivo.leer("empleado.dat");
                                int po = -1;
                                id = Lectura.leerInt("Dame Id a consultar:");
                                po = Busqueda.buscarIddeArrayList(emp, id);
                                if (po != -1) {
                                    Lectura.imprimirString(((EmpleadoBasemComision) emp.get(po)).toString());
                                } else {
                                    Lectura.imprimirString("El id=" + id + " no existe");
                                }

                            }
                            break;

                            case 4: {
                                int resp, po;
                                //emp = Archivo.leer("empleado.dat");
                                do {

                                    resp = Lectura.leerInt("Que desea modificar?\n1.Nombre\n2.Apellido\n"
                                            + "3.ventastotales\n4.tarifacomision\n5.salariobase\n6.Salir\nDame una opcion:");
                                    switch (resp) {
                                        case 1: {
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                nom = Lectura.leerString("Dame el nuevo nombre: ");
                                                ((EmpleadoBasemComision) emp.get(po)).setNombre(nom);
                                                //((EmpleadoPorHora)emp.get(po)).setNombre(nom);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("El Nombre de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 2: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                ape = Lectura.leerString("Dame el apellido");
                                                ((EmpleadoBasemComision) emp.get(po)).setApellido(ape);
                                                //((EmpleadoPorHora)emp.get(po)).setApellido(ape);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL apellido de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 3: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                vt = Lectura.leerfloat("Dame ventas totales");
                                                ((EmpleadoBasemComision) emp.get(po)).setVentastotal(vt);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL salario de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 4: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                tc = Lectura.leerfloat("Dame tarifa comision");
                                                ((EmpleadoBasemComision) emp.get(po)).setTarifasporcomision(tc);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL salario de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                        case 5: {
                                            //Archivo.leer("empleado.dat");
                                            id = Lectura.leerInt("Dame el id de la persona a modificar");
                                            po = Busqueda.buscarIddeArrayList(emp, id);
                                            if (po != -1) {
                                                sb = Lectura.leerfloat("Dame salario base");
                                                ((EmpleadoBasemComision) emp.get(po)).setSalariobase(sb);
                                                //Archivo.guardar(emp, "empleado.dat");
                                                Lectura.imprimirString("EL salario de = " + id + "se modifico satisfactoriamente");
                                            } else {
                                                Lectura.imprimirString("El id=" + id + "no existe");
                                            }
                                        }
                                        break;
                                    }
                                } while (resp != 6);

                            }
                            break;
                            case 5: {
                                //emp = Archivo.leer("empleado.dat");
                                for (int i = 0; i < emp.size(); i++) {
                                    Lectura.imprimirString(((EmpleadoBasemComision) emp.get(i)).toString());
                                    //Lectura.imprimirString(emp.get(i).toString());
                                }

                            }
                            break;

                        }

                    } while (opc != 6);

                }
                break;
                case 5: {
                    int es, cantidad;
                    String nomprod;
                    float precio;
                    ArrayList<Factura> f = new ArrayList();
                    do {
                        es = Lectura.leerInt("Menu:\n1.Altas\n2.Reportes\n3.Salir");
                        switch (es) {
                            case 1: {
                                id = Lectura.leerInt("Dame id: ");
                                nomprod = Lectura.leerString("Ingrese el nombre del producto");
                                precio = Lectura.leerfloat("Ingrese el precio del producto");
                                cantidad = Lectura.leerInt("Ingrese la cantidad");
                                f.add(new Factura(id, nomprod, precio, cantidad));
                            }
                            break;
                            case 2:{
                                for (int i = 0; i < f.size(); i++) {
                                    Lectura.imprimirString(f.get(i).toString());
                                }
                            }break;
                        }
                    } while (es != 3);
                }
                break;

            }

        } while (op != 6);
    }
}

