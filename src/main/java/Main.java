import baseX.BaseXManager;
import nitrite.NitriteManager;
import org.basex.core.BaseXException;

import java.util.Scanner;

public class Main {

    public static void main(final String... args) throws BaseXException {
        Scanner read = new Scanner(System.in);
        int option;

        do {

            do {
                System.out.println("\n\n");
                System.out.println("1 | Carregar base de dados XML");
                System.out.println("2 | Carregar base orientada a doxumentos");
                System.out.println("3 | Realizar consulta ");
                System.out.println("4 | Sair");
                System.out.print("Opção: ");

                option = read.nextInt();
            } while (option > 4 && option < 1);

            switch (option) {
                case 1: {
                    System.out.print("\n\nDigite o nome do arquivo XML: ");
                    String file = read.next();

                    if (BaseXManager.getInstance().loadData(file)) {
                        System.out.println("Base carregada com sucesso!");
                    } else {
                        System.out.println("Erro ao carregar a base!");
                    }
                    break;
                }
                case 2: {
                    NitriteManager.getInstance().loadData();
                    break;
                }
                case 3: {
                    int option_;
                    do {
                        System.out.println("\n\n");
                        System.out.println("1 | Consultar Consumidores");
                        System.out.println("2 | Consultar Compras");
                        System.out.println("3 | Voltar");

                        option_ = read.nextInt();
                    } while (option > 3 && option < 1);

                    switch (option_){
                        case 1:{
                            System.out.println("As consultas devem ser do tipo <BANCO>:<ELEMENTO>:<FUNÇÃO>:<VALOR>");
                            System.out.println("Exemplo: XML:CompanyName:contains:Great");
                            System.out.println(" ");
                            System.out.println("Digite sua consulta: ");
                            read.nextLine();
                            String input = read.nextLine();

                            System.out.println(QueryManager.getInstance().queryCustomer(input));
                            break;
                        }
                        case 2:{
                            System.out.println("As consultas devem ser do tipo <BANCO>:<ELEMENTO>:<FUNÇÃO>:<VALOR>");
                            System.out.println("Exemplo: XML:CustomerID:equals:GREAL");
                            System.out.println(" ");
                            System.out.println("Digite sua consulta: ");
                            read.nextLine();
                            String input = read.nextLine();

                            System.out.println(QueryManager.getInstance().queryOrder(input));

                            break;
                        }case 3:{
                            break;
                        }
                    }
                    break;
                }
            }

        }while(option != 4);
    }
}

