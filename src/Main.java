import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Ebook> ebooks = new ArrayList<>();
        List<VideoDigital> videosDigitais = new ArrayList<>();
        List<ItemBibliotecaDigital> itensEmprestados = new ArrayList<>();

        Ebook ebook1 = new Ebook("Introdução ao Java", "Marina de Lara");
        Ebook ebook2 = new Ebook("Básico de Python", "Oli de Oliveira");
        ebooks.add(ebook1);
        ebooks.add(ebook2);

        VideoDigital video1 = new VideoDigital("Introdução aos Algoritmos", "Alice Smith");
        VideoDigital video2 = new VideoDigital("Fundamentos do Aprendizado de Maquina", "Bob Brown");
        videosDigitais.add(video1);
        videosDigitais.add(video2);

        System.out.println("Ebooks:");
        for (Ebook ebook : ebooks) {
            System.out.println(ebook.descricao());
        }

        System.out.println("\nVídeos Digitais:");
        for (VideoDigital video : videosDigitais) {
            System.out.println(video.descricao());
        }

        ebook1.baixar();
        video1.visualizar();

        itensEmprestados.add(ebook1);
        itensEmprestados.add(video1);

        System.out.println("\nItens emprestados:");
        for (ItemBibliotecaDigital item : itensEmprestados) {
            System.out.println(item.descricao());
        }
    }
}