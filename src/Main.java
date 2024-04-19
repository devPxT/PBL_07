import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static List<ItemBibliotecaDigital> estoque = new ArrayList<>();
    private static List<ItemBibliotecaDigital> carrinho = new ArrayList<>();
    private static List<ItemBibliotecaDigital> meusItens = new ArrayList<>();
    private static int nextId = 1;

    public static int getNextId() {
        return nextId;
    }

    public static void incrementNextId() {
        nextId++;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Listar Ebooks");
            System.out.println("2. Listar Videos Digitais");
            System.out.println("3. Buscar Item por ID");
            System.out.println("4. Adicionar Item ao Carrinho");
            System.out.println("5. Visualizar Carrinho");
            System.out.println("6. Finalizar Compra");
            System.out.println("7. Seus Itens");
            System.out.println("8. Cadastrar Item");
            System.out.println("0. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        listarEbooks();
                        break;
                    case 2:
                        listarVideoDigital();
                        break;
                    case 3:
                        listarItemPorId(scanner);
                        break;
                    case 4:
                        adicionarItemAoCarrinho(scanner);
                        break;
                    case 5:
                        visualizarCarrinho();
                        break;
                    case 6:
                        finalizarCompra();
                        break;
                    case 7:
                        visualizarMeusItens(scanner);
                        break;
                    case 8:
                        cadastrarItem(scanner);
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.next(); // Limpar o buffer de entrada
                choice = -1; // Define uma opção inválida para continuar o loop
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void listarEbooks() {
        System.out.println("\n=== Ebooks Disponiveis ===");
        if (estoque.isEmpty()) {
            System.out.println("Nenhum Ebook encontrado.");
        } else {
            for (ItemBibliotecaDigital item : estoque) {
                if (item instanceof Ebook) {
                    System.out.println(item.toString());
                }
            }
        }
    }

    private static void listarVideoDigital() {
        System.out.println("\n=== Videos Digitais Disponiveis ===");
        if (estoque.isEmpty()) {
            System.out.println("Nenhum Video Digital encontrado.");
        } else {
            for (ItemBibliotecaDigital item : estoque) {
                if (item instanceof VideoDigital) {
                    System.out.println(item.toString());
                }
            }
        }
    }
    
    private static void listarItemPorId(Scanner scanner) {
        System.out.print("Digite o ID do item: ");
        int id = scanner.nextInt();

        for (ItemBibliotecaDigital item : estoque) {
            if (item.getId() == id) {
                System.out.println("Item encontrado:");
                System.out.println(item.toString());
                return;
            }
        }

        System.out.println("Item não encontrado.");
    }

    private static void adicionarItemAoCarrinho(Scanner scanner) {
        System.out.print("Digite o ID do item que deseja adicionar ao carrinho: ");
        int id = scanner.nextInt();

        for (ItemBibliotecaDigital item : estoque) {
            if (item.getId() == id) {
                carrinho.add(item);
                System.out.println("Item adicionado ao carrinho.");
                return;
            }
        }

        System.out.println("Item não encontrado.");
    }

    private static void visualizarCarrinho() {
        System.out.println("\n=== Carrinho de Compras ===");
        for (ItemBibliotecaDigital item : carrinho) {
            System.out.println(item.toString());
        }
    }

    private static void finalizarCompra() {
        System.out.println("\n=== Finalizando Compra ===");
        for (ItemBibliotecaDigital item : carrinho) {
            meusItens.add(item);
            carrinho.remove(item);
        }

        System.out.println();
        System.out.println("\n=== Compra Finalizada ===");
    }

    private static void visualizarMeusItens(Scanner scanner) {
        System.out.println("\n=== Seus Itens ===");
        for (ItemBibliotecaDigital item : meusItens) {
            System.out.println(item.toString());
        }

        if (meusItens.isEmpty()) {
            System.out.println("Você não possui nenhum item!");
            return;
        }

        System.out.println("\n=== O que deseja fazer? ===");
        System.out.println("Escolha a ação:");
        System.out.println("1. Baixar");
        System.out.println("2. Visualizar");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1:
                baixar(scanner);
                break;
            case 2:
                visualizar(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void baixar(Scanner scanner) {
        System.out.println("\n=== Itens disponiveis para baixar ===");
        for (ItemBibliotecaDigital item : meusItens) {
            System.out.println(item.toString());
        }
        

        System.out.println("\n=== Digite o ID do item para baixar ===");
        System.out.print("ID: ");

        int id = scanner.nextInt();

        for (ItemBibliotecaDigital item : meusItens) {
            if (item.getId() == id) {
                System.out.println("Item encontrado");
                if (item instanceof Ebook) {
                    Ebook ebook = (Ebook) item; //Cast para Ebook para baixar
                    ebook.baixar();
                    return;
                } else if (item instanceof VideoDigital) {
                    VideoDigital videogital = (VideoDigital) item; //Cast para Ebook para baixar
                    videogital.baixar();
                    return;
                }
            }
        }

        System.out.println("Item não encontrado.");
    }

    private static void visualizar(Scanner scanner) {
        System.out.println("\n=== Itens disponiveis para visualizar ===");
        for (ItemBibliotecaDigital item : meusItens) {
            if (item instanceof VideoDigital) {
                System.out.println(item.toString());
            }
        }

        System.out.println("\n=== Digite o ID do item para visualizar ===");
        System.out.print("ID: ");

        int id = scanner.nextInt();

        for (ItemBibliotecaDigital item : meusItens) {
            if (item instanceof VideoDigital) { 
                if (item.getId() == id) {
                    System.out.println("Item encontrado");
                    VideoDigital videoDigital = (VideoDigital) item; //Cast para VideoDigital para visualizar
                    videoDigital.visualizar();
                    return;
                }
            }
        }

        System.out.println("Item não encontrado.");
    }

    public static void cadastrarItem(Scanner scanner) {
        System.out.println("\n=== Cadastro de Item ===");
        System.out.println("Escolha o tipo de item a cadastrar:");
        System.out.println("1. Ebook");
        System.out.println("2. Video Digital");
        System.out.print("Opção: ");
    
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1:
                cadastrarEbook(scanner);
                incrementNextId();
                break;
            case 2:
                cadastrarVideoDigital(scanner);
                incrementNextId();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void cadastrarEbook(Scanner scanner) {
        System.out.print("Informe titulo: ");
        String titulo = scanner.nextLine();
        scanner.nextLine();
    
        System.out.print("Informe autor: ");
        String autor = scanner.nextLine();
    
        ItemBibliotecaDigital i = new Ebook(titulo, autor, getNextId());
        estoque.add(i);
    
        System.out.println("Ebook cadastrado com sucesso.");
    }

    public static void cadastrarVideoDigital(Scanner scanner) {
        System.out.print("Informe titulo: ");
        String titulo = scanner.nextLine();
        scanner.nextLine();
    
        System.out.print("Informe autor: ");
        String autor = scanner.nextLine();
    
        ItemBibliotecaDigital i = new Ebook(titulo, autor, getNextId());
        estoque.add(i);
    
        System.out.println("Video Digital cadastrado com sucesso.");
    }
}