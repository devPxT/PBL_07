class Ebook extends ItemBibliotecaDigital implements Baixavel {
    public Ebook(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public String descricao() {
        return "Ebook: " + getTitulo() + " - Autor: " + getAutor();
    }

    @Override
    public void baixar() {
        System.out.println("Baixando o ebook: " + getTitulo());
        System.out.println("-----------------------------100%");
        System.out.println("Ebook baixado: " + getTitulo());
    }
}