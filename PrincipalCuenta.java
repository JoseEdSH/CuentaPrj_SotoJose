import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class PrincipalCuenta{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Cuenta> cuentas = new ArrayList<>();
        int actual = -1;
        boolean salir = false;
        
        while(!salir) {
            System.out.println("\nMenú pincipal");
            System.out.println("1) Crear Cuenta");
            System.out.println("2) Conocer la cantidad de cuentas creadas");
            System.out.println("3) Listar Cuentas");
            System.out.println("4) Seleccionar Cuenta actual");
            System.out.println("5) Depositar");
            System.out.println("6) Retirar");
            System.out.println("7) Consultar Saldo");
            System.out.println("8) Consultar estado (toString)");
            System.out.println("0) Salir");
            String op = sc.nextLine().trim();
            
            switch(op) {
                case "1": {
                    System.out.print("Nombre habiente de la cuenta (enter para dejar en blanco): ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Saldo de la cuenta: ");
                    String saldo = sc.nextLine().trim();
                    Cuenta c;
                    // c = new Cuenta(saldo);
                    double p;
                    try {
                        p = Double.parseDouble(saldo);
                    } catch (NumberFormatException e) {
                        System.out.println("Número inválido, se usará 500.0");
                        p = 500.0;
                    }
                    if(nombre.isEmpty()) 
                        c = new Cuenta(p);
                    else{
                        c = new Cuenta(nombre, p);
                    }
                    cuentas.add(c);
                    actual = cuentas.size() -1;
                    System.out.println("Cuenta creada y seleccionada (índice " + actual + ").");
                    break;
                }
                case "2": {
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas creados.");
                        break;
                    }
                    System.out.println(cuentas.get(actual).getCantCuentasCreadas());
                    break;
                }
                case "3": {
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas creadas.");
                    } else {
                        System.out.println("índice | Número de cuenta | Saldo");
                        for(int i = 0; i < cuentas.size(); i++){
                            Cuenta c = cuentas.get(i);
                            System.out.println("  "+i+"  |  "+c.getCodCuenta()+"  |  "+c.getSaldo()+"  ");
                        }
                    }
                    break;
                }
                case "4": {
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas creados.");
                        break;
                    }
                    System.out.print("Indice de la cuenta a seleccionar: ");
                    String indx = sc.nextLine().trim();
                    try {
                        int ind = Integer.parseInt(indx);
                        if(ind >= 0 && ind < cuentas.size()) {
                            actual = ind;
                            System.out.println("Cuenta número " + actual + " seleccionada.");
                        } else 
                            System.out.println("Indice fuera de rango.");
                    } catch(NumberFormatException e) {
                        System.out.println("Indice inválido");
                    }
                    break;
                }
                case "5": {
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear o seleccionar una cuenta primero.");
                        break;
                    } else {
                        System.out.print("Ingrese el monto a depositar :");
                        String depx = sc.nextLine().trim();
                        try {
                            double dep = Double.parseDouble(depx);
                            if(dep<=0) {
                                System.out.println("El monto tiene que ser mayor a cero.");
                                break;
                            }
                            cuentas.get(actual).depositar(dep);
                            System.out.println("El depósito se realizó exitosamente.");
                        } catch(NumberFormatException e) {
                            System.out.println("Monto inválido");
                            break;
                        }
                    }
                    break;
                }
                case "6": {
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear o seleccionar una cuenta primero.");
                        break;
                    } else {
                        System.out.print("Ingrese el monto a retirar :");
                        String retx = sc.nextLine().trim();
                        try {
                            double ret = Double.parseDouble(retx);
                            if(ret<=0) {
                                System.out.println("El monto tiene que ser mayor a cero.");
                                break;
                            }
                            cuentas.get(actual).retirar(ret);
                        } catch(NumberFormatException e) {
                            System.out.println("Monto inválido");
                            break;
                        }
                    }
                    break;
                }
                case "7": {
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear o seleccionar una cuenta primero.");
                        break;
                    }
                    System.out.println(cuentas.get(actual).getSaldo());
                    break;
                }
                case "8": {
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear o seleccionar una cuenta primero.");
                        break;
                    }
                    System.out.println(cuentas.get(actual).toString());
                    break;
                }
                case "0": {
                    salir = true;
                    System.out.println("Gracias por usar este sistema.");
                    break;
                }
                default:
                    System.out.println("Opción inválida. Seleccione nuevamente.");
            }
        }
        sc.close();
    }
}